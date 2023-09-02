package com.project.donut

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class DonutsApplication

fun main(args: Array<String>) {
    runApplication<DonutsApplication>(*args)
}
