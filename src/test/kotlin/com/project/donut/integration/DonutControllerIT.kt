package com.project.donut.integration

import com.project.donut.database.Donut
import com.project.donut.database.DonutRepository
import com.project.donut.database.Donuts
import com.project.donut.integration.setup.AbstractIntegration
import com.project.donut.integration.setup.IntegrationTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpEntity
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import java.time.ZonedDateTime.now
import java.util.*
import kotlin.test.assertNotNull

@IntegrationTest
class DonutControllerIT(
    @Autowired val donutRepository: DonutRepository
) : AbstractIntegration() {

    private val apiVersion = "v1"
    private val sendDonutsEndpoint = "/$apiVersion/donuts/send"
    private val getAllDonutsEndpoint = "/$apiVersion/donuts/all"

    @Test
    fun `sendDonuts should receive request and return correct string message`() {
        val message = "Hello World"
        val response = callSendDonuts(message)
        assertThat(response.body).isEqualTo("Send donuts message published successfully")
        assertThat(response.statusCode).isEqualTo(HttpStatus.OK)
    }

    @Test
    fun `sendDonuts should publish kafka message from http request`() {
        val message1 = "Hello World"
        val message2 = "Hello World Two"
        callSendDonuts(message2)

        val publishedMessage2 = sendDonutsTopicConsumer.getMessageByKey(message2)
        assertNotNull(publishedMessage2)
        assertThat(publishedMessage2).isEqualTo(message2)

        val publishedMessage1 = sendDonutsTopicConsumer.getMessageByKey(message1)
        assertNotNull(publishedMessage1)
        assertThat(publishedMessage1).isEqualTo(message1)
    }

    @Test
    fun `getAllDonuts should fetch all donuts`() {
        givenTwoTypesOfDonutsInInventory()
        val response = getAllDonuts()
        assertThat(response.donuts.size).isEqualTo(2)
    }

    private fun callSendDonuts(message: String): ResponseEntity<String> {
        val request = HttpEntity("String")
        return testRestTemplate!!.postForEntity(
            "http://localhost:$port$sendDonutsEndpoint?message=$message",
            request,
            String::class.java
        )
    }

    private fun getAllDonuts(): Donuts {
        return testRestTemplate!!.getForObject(
            "http://localhost:$port$getAllDonutsEndpoint",
            Donuts::class.java
        )
    }

    @Transactional
    private fun givenTwoTypesOfDonutsInInventory() {
        donutRepository.save(
            Donut(
                id = UUID.randomUUID(),
                flavour = "sugar-glazed",
                diameter = 16.3,
                quantity = 3,
                createdAt = now(),
                updatedAt = now()
            )
        )

        donutRepository.save(
            Donut(
                id = UUID.randomUUID(),
                flavour = "sugar-glazed",
                diameter = 16.3,
                quantity = 3,
                createdAt = now(),
                updatedAt = now()
            )
        )
    }
}