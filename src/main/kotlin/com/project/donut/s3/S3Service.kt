package com.project.donut.s3

import org.springframework.stereotype.Service

@Service
class S3Service {

    fun listFiles(bucket: String): List<String> {
        return listOf("")
    }

    fun getFile(fileName: String): String {
        return ""
    }

    fun uploadFile(fileContent: String, fileName: String) {

    }

}

