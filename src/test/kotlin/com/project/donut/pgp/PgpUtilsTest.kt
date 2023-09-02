package com.project.donut.pgp

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import java.io.ByteArrayInputStream

class PgpUtilsTest {

    private val userId = "helloWorld"
    private val passphrase = "passphrase"
    private val plaintext = "PLAINTEXT"

    @Disabled("takes a long time to create keys, therefore disabled by default")
    @Test
    fun generatePgpKeys() {
        val secretKeyRing = PgpUtils.generateKeys(userId,passphrase)
        val publicKeyRing = PgpUtils.getPublicKeyRing(secretKeyRing)

        val encrypted = PgpUtils.encrypt(plaintext.byteInputStream(), publicKeyRing)
        val toDecrypt = ByteArrayInputStream(encrypted.toByteArray())
        val decrypted = PgpUtils.decrypt(toDecrypt, secretKeyRing, passphrase)

        println("encrypted:\n $encrypted")
        println("decrypted: $decrypted")

        assertEquals(plaintext, decrypted)
    }
}