package com.project.donut.database

import org.springframework.stereotype.Service

@Service
class DonutService(
    val donutRepository: DonutRepository
) {

    fun getDonuts(): List<Donut> {
        return donutRepository.findAll().toList<Donut>()
    }
}