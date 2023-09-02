package com.project.donut.testUtils

import com.project.donut.database.Donut
import java.time.ZonedDateTime
import java.util.*

class TestData {

    companion object {
        fun donuts() = listOf(
            Donut(
                id = UUID.randomUUID(),
                flavour = "chocolate",
                diameter = 16.3,
                quantity = 4,
                createdAt = ZonedDateTime.now(),
                updatedAt = ZonedDateTime.now()
            ),
            Donut(
                id = UUID.randomUUID(),
                flavour = "sugar-glazed",
                diameter = 16.0,
                quantity = 3,
                createdAt = ZonedDateTime.now(),
                updatedAt = ZonedDateTime.now()
            )
        )
    }
}