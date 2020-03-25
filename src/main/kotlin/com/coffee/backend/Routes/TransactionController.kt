package com.coffee.backend.Routes

import com.coffee.backend.Models.Transaction
import com.coffee.backend.Repository.ItemsRepository
import com.coffee.backend.Repository.TransactionRepository
import com.google.gson.JsonObject
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime

@RestController
class TransactionController( @Autowired val transactionRepository: TransactionRepository,
                             @Autowired val itemsRepository: ItemsRepository) {

    //val log = LoggerFactory.getLogger(this.javaClass)

    @GetMapping("/api/transaction")
    fun getAllTransaction(): MutableList<Transaction>{
        return transactionRepository.findAll()
    }

    @PostMapping("/api/transaction")
    fun saveTransaction(@RequestBody transactionJsonObject: JsonObject) {
        try{
            val itemObject = mutableSetOf<Int>(transactionJsonObject.get("items").asInt)
            val date = transactionJsonObject.get("date") as LocalDateTime
            val payment = transactionJsonObject.get("payment").asInt
            //val transaction = Transaction(-1, itemObject, date, payment)
        }
        finally {

        }

    }
}