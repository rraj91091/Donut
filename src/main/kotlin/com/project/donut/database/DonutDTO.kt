package com.project.donut.database

import javax.persistence.Column

data class DonutDTO(

    @Column(name = "flavour", length = 100)
    val flavour: String,

    @Column(name = "diameter")
    val diameter: Double,

    @Column(name = "quantity")
    val quantity: Int,

)
