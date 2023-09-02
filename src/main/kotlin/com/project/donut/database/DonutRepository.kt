package com.project.donut.database

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface DonutRepository: CrudRepository<Donut, UUID> {

    fun findByFlavour(flavour: String)

}