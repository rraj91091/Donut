package com.project.donut.kafka

import com.project.donut.kafka.config.KafkaConstants.Companion.GROUP_ID
import com.project.donut.kafka.config.KafkaConstants.Companion.RECEIVE_DONUTS_TOPIC
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
class DonutsConsumer {

    @KafkaListener(
        topics = [RECEIVE_DONUTS_TOPIC],
        groupId = GROUP_ID
    )
    fun consumeDonutCommand(message: String) {
        println("Received message in group [$GROUP_ID] : [$message]")
    }
}