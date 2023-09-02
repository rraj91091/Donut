package com.project.donut.utils

import org.springframework.util.Assert
import java.io.BufferedReader

import java.io.IOException

import java.io.InputStream
import java.io.InputStreamReader
import java.lang.StringBuilder

/**
 * TODO
 */
class FileUtils {

    companion object {
        fun readFile(fileName: String): String {
            val inputStream = this::class.java.classLoader.getResourceAsStream(fileName)
            Assert.notNull(inputStream, "File Not Found!")
            return readFromInputStream(inputStream!!)
        }

        @Throws(IOException::class)
        private fun readFromInputStream(inputStream: InputStream): String {
            val resultStringBuilder = StringBuilder()
            BufferedReader(InputStreamReader(inputStream)).use { br ->
                var line: String?
                while (br.readLine().also { line = it } != null) {
                    resultStringBuilder.append(line).append("\n")
                }
            }
            return resultStringBuilder.toString()
        }
    }
}
