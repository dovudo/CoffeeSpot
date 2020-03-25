package com.coffee.backend.Routes

import com.coffee.backend.Models.Items
import com.coffee.backend.Models.OkResponse
import com.coffee.backend.Models.Transaction
import com.coffee.backend.Repository.ItemsRepository
import com.coffee.backend.Repository.TransactionRepository
import com.google.gson.Gson
import com.google.gson.JsonObject
import com.google.gson.reflect.TypeToken
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class TransactionController( @Autowired val transactionRepository: TransactionRepository,
                             @Autowired val itemsRepository: ItemsRepository) {

    private val GSON = Gson()
    private val LOG = LoggerFactory.getLogger("Transaction")
    private val setTypeObject = object: TypeToken<Set<Int>>(){}.type

    @GetMapping("/api/transaction")
    fun getAllTransaction(): MutableList<Transaction>{
        return transactionRepository.findAll()
    }

    @PostMapping("/api/transaction")
    fun saveTransaction(@RequestBody data: String): OkResponse {
        val transactionJsonObject = GSON.fromJson<JsonObject>(data, JsonObject::class.java)
        val items = mutableListOf<Items>()
        val date = transactionJsonObject.get("date").asString
        val payment = transactionJsonObject.get("payment").asInt
        GSON.fromJson<Set<Int>>(transactionJsonObject.get("items"), setTypeObject).forEach {
            val item_tmp = itemsRepository.getTopById(it)
            items.add(item_tmp)
        }
        val transaction = Transaction(1, items, date, payment)
        LOG.info("saving transaction $transaction")
        transactionRepository.save(transaction)
        return OkResponse("New transaction successfully added")
    }
}