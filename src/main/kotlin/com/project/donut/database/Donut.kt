package com.project.donut.database

import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.ZonedDateTime
import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "donut")
data class Donut(

    @Id
    @Column(name = "id")
    val id: UUID,

    @Column(name = "flavour", length = 100)
    val flavour: String,

    @Column(name = "diameter")
    val diameter: Double,

    @Column(name = "quantity")
    val quantity: Int

) {
    @CreationTimestamp
    @Column(name = "createdAt")
    lateinit var createdAt: ZonedDateTime

    @UpdateTimestamp
    @Column(name = "updatedAt")
    lateinit var updatedAt: ZonedDateTime
}
