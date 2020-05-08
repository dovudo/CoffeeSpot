package com.coffee.backend.Repository

import com.coffee.backend.Models.Transaction
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.time.LocalDateTime

@Repository
interface TransactionRepository: JpaRepository<Transaction,Int>{

    override fun findAll(): MutableList<Transaction>
    fun findByDateContaining(date: String): MutableList<Transaction>
    fun save(newTransaction: Transaction)
    fun deleteTransactionById(id:Int)
}