package com.project.donut.controller

import com.project.donut.database.DonutService
import com.project.donut.database.Donuts
import com.project.donut.kafka.SendDonutsCommandPublisher
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping(value = ["/v1/donuts"])
class DonutController(
    val donutService: DonutService,
    val sendDonutsCommandPublisher: SendDonutsCommandPublisher
) {

    @PostMapping(value = ["/send"])
    fun sendDonuts(@RequestParam("message") message: String): String {
        sendDonutsCommandPublisher.sendMessage(message, message)
        return "Send donuts message published successfully"
    }

    @GetMapping(value = ["/all"])
    fun getAllDonuts(): Donuts {
        return Donuts(donutService.getDonuts())
    }

}