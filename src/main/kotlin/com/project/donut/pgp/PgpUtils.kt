package com.project.donut.pgp

import org.bouncycastle.openpgp.PGPPublicKeyRing
import org.bouncycastle.openpgp.PGPSecretKeyRing
import org.bouncycastle.util.io.Streams
import org.pgpainless.PGPainless
import org.pgpainless.algorithm.CompressionAlgorithm
import org.pgpainless.algorithm.KeyFlag
import org.pgpainless.decryption_verification.ConsumerOptions
import org.pgpainless.encryption_signing.EncryptionOptions
import org.pgpainless.encryption_signing.ProducerOptions
import org.pgpainless.encryption_signing.SigningOptions
import org.pgpainless.key.generation.KeySpec
import org.pgpainless.key.generation.type.ecc.EllipticCurve
import org.pgpainless.key.generation.type.ecc.ecdh.ECDH
import org.pgpainless.key.generation.type.ecc.ecdsa.ECDSA
import org.pgpainless.key.generation.type.rsa.RSA
import org.pgpainless.key.generation.type.rsa.RsaLength
import org.pgpainless.key.protection.SecretKeyRingProtector
import org.pgpainless.util.Passphrase
import java.io.ByteArrayOutputStream
import java.io.InputStream

/**
 * PGP utils wrapper class for PGP encryption and decryption.
 * To be used only by the PgpService class for PGP encryption/decryption.
 */
class PgpUtils {

    companion object {
        fun getSecretKeyRing(asciiArmoredSecretKey: String): PGPSecretKeyRing {
            return PGPainless.readKeyRing().secretKeyRing(asciiArmoredSecretKey)
        }

        fun getPublicKeyRing(asciiArmoredPublicKey: String): PGPPublicKeyRing {
            return PGPainless.readKeyRing().publicKeyRing(asciiArmoredPublicKey)
        }

        fun getPublicKeyRing(secretKeyRing: PGPSecretKeyRing): PGPPublicKeyRing {
            return PGPainless.extractCertificate(secretKeyRing);
        }

        fun generateKeys(userId: String, secretKeyPassphrase: String): PGPSecretKeyRing {
            return PGPainless.buildKeyRing()
                .setPrimaryKey(KeySpec.getBuilder(
                    RSA.withLength(RsaLength._8192),
                    KeyFlag.SIGN_DATA, KeyFlag.CERTIFY_OTHER))
                .addSubkey(
                    KeySpec.getBuilder(ECDSA.fromCurve(EllipticCurve._P256), KeyFlag.SIGN_DATA)
                        .overridePreferredCompressionAlgorithms(CompressionAlgorithm.ZLIB)
                ).addSubkey(
                    KeySpec.getBuilder(
                        ECDH.fromCurve(EllipticCurve._P256),
                        KeyFlag.ENCRYPT_COMMS, KeyFlag.ENCRYPT_STORAGE)
                )
                .addUserId(userId)
                .setPassphrase(Passphrase.fromPassword(secretKeyPassphrase))
                .build()
        }

        fun encrypt(
            plaintextInputStream: InputStream,
            publicKey: PGPPublicKeyRing
        ): ByteArrayOutputStream {
            val cipherTextOutputStream = ByteArrayOutputStream()
            val encryptionStream = PGPainless.encryptAndOrSign()
                .onOutputStream(cipherTextOutputStream)
                .withOptions(
                    ProducerOptions.signAndEncrypt(
                        EncryptionOptions()
                            .addRecipient(publicKey),
                        SigningOptions()
                    ).setAsciiArmor(true)
                )

            Streams.pipeAll(plaintextInputStream, encryptionStream)
            encryptionStream.close()

            return cipherTextOutputStream
        }

        fun decrypt(
            encryptedInputStream: InputStream,
            secretKey: PGPSecretKeyRing,
            secretKeyPassphrase: String
        ): ByteArrayOutputStream {
            val plaintextOutputStream = ByteArrayOutputStream()
            val decryptionStream = PGPainless.decryptAndOrVerify()
                .onInputStream(encryptedInputStream)
                .withOptions(
                    ConsumerOptions()
                        .addDecryptionKey(
                            secretKey,
                            SecretKeyRingProtector.unlockAnyKeyWith(Passphrase.fromPassword(secretKeyPassphrase))
                        )
                )

            Streams.pipeAll(decryptionStream, plaintextOutputStream)
            decryptionStream.close()

            return plaintextOutputStream
        }
    }
}
