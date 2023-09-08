package com.project.donut.database

import org.springframework.stereotype.Service
import java.util.*

@Service
class DonutService(
    val donutRepository: DonutRepository
) {

    fun createDonut(donut: DonutDTO): Donut {
        return donutRepository.save(
            Donut(
                id = UUID.randomUUID(),
                flavour = donut.flavour,
                diameter = donut.diameter,
                quantity = donut.quantity
            )
        )
    }

    fun getDonuts(): List<Donut> {
        return donutRepository.findAll().toList<Donut>()
    }
}