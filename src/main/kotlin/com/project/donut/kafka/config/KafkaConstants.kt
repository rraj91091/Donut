package com.project.donut.kafka.config

class KafkaConstants {

    companion object {
        const val SEND_DONUTS_TOPIC: String = "kafka.topic.send-donuts.command"
        const val RECEIVE_DONUTS_TOPIC: String = "kafka.topic.receive-donuts.command"
        const val GROUP_ID: String = "donuts"
    }

}