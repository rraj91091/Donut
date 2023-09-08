package com.project.donut.controller

import com.project.donut.database.Donut
import com.project.donut.database.DonutDTO
import com.project.donut.database.DonutService
import com.project.donut.database.Donuts
import com.project.donut.kafka.SendDonutsCommandPublisher
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(value = ["/v1/donuts"])
class DonutController(
    val donutService: DonutService,
    val sendDonutsCommandPublisher: SendDonutsCommandPublisher
) {

    @PostMapping(value = ["/create"])
    @ResponseStatus(value = HttpStatus.CREATED)
    fun createDonut(@RequestBody donut: DonutDTO): Donut {
        return donutService.createDonut(donut)
    }

    @PostMapping(value = ["/send"])
    @ResponseStatus(value = HttpStatus.OK)
    fun sendDonuts(@RequestParam("message") message: String): String {
        sendDonutsCommandPublisher.sendMessage(message, message)
        return "Send donuts message published successfully"
    }

    @GetMapping(value = ["/all"])
    @ResponseStatus(value = HttpStatus.OK)
    fun getAllDonuts(): Donuts {
        return Donuts(donutService.getDonuts())
    }

}