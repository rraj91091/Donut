package com.project.donut.pgp

import java.io.ByteArrayInputStream

/**
 * Class providing PGP encryption/decryption capabilities.
 */
class PgpService{

    fun encrypt(plaintext: String, pgpPublicKey: String): String {
        val ciphertext = PgpUtils.encrypt(
            ByteArrayInputStream(plaintext.toByteArray()),
            PgpUtils.getPublicKeyRing(pgpPublicKey)
        )
        return String(ciphertext.toByteArray())
    }

    fun decrypt(ciphertext: String, pgpPrivateKey: String, pgpPrivateKeyPassphrase: String): String {
        val plaintext = PgpUtils.decrypt(
            ByteArrayInputStream(ciphertext.toByteArray()),
            PgpUtils.getSecretKeyRing(pgpPrivateKey),
            pgpPrivateKeyPassphrase
        )
        return String(plaintext.toByteArray())
    }
}
