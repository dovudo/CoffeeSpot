package com.coffee.backend.Repository

import com.coffee.backend.Models.Items
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ItemsRepository: CrudRepository<Items,Int> {
    override fun findAll(): List<Items>
    fun findTopById( id:Int): List<Items>
}