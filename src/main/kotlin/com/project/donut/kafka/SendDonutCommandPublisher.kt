package com.project.donut.kafka

import com.project.donut.kafka.config.KafkaConstants.Companion.SEND_DONUTS_TOPIC
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

@Component
class SendDonutsCommandPublisher(
    val kafkaTemplate: KafkaTemplate<String, String>
) {
    private val topic: String = SEND_DONUTS_TOPIC
    private val logger: Logger = LoggerFactory.getLogger(this::class.java)

    fun sendMessage(message: String, key: String) {
        logger.info("Sending message [$message] to Topic [$topic]")
        kafkaTemplate.send(topic, key, message)
    }
}
