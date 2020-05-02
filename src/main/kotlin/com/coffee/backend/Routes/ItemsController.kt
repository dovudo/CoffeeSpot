package com.coffee.backend.Routes

import com.coffee.backend.Models.ItemType
import com.coffee.backend.Models.Items
import com.coffee.backend.Models.OkResponse
import com.coffee.backend.Repository.ItemsRepository
import com.google.gson.Gson
import com.google.gson.JsonObject
import javassist.NotFoundException
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationContext
import org.springframework.core.io.ResourceLoader
import org.springframework.data.crossstore.ChangeSetPersister
import org.springframework.web.bind.annotation.*
import javax.transaction.Transactional

@RestController
class ItemsController(@Autowired val itemRepo: ItemsRepository,
                      @Autowired val resource:ResourceLoader,
                      @Autowired val context:ApplicationContext ) {

    val LOG = LoggerFactory.getLogger("Items")

    @GetMapping("/api/item")
    fun getItems(): List<Items> {
        return itemRepo.findAll()
    }

    @PostMapping("/api/item")
    fun saveItem(@RequestBody jsonItem: String): OkResponse {
        val ss = Gson().fromJson<JsonObject>(jsonItem, JsonObject::class.java)
            val item = Items(-1,
                    ss.get("name").asString,
                    ss.get("description").asString,
                    ItemType.valueOf(ss.get("type").asString),
                    ss.get("price").asInt,
                    ss.get("pic").asString)
        LOG.info("Save new item $item")
        itemRepo.save(item)
        return OkResponse("Item was successfully added")
    }

    @DeleteMapping("/api/item")
    @Transactional
    fun deleteItem(@RequestParam("id") id:Int):OkResponse {
        if(itemRepo.findById(id).isEmpty)
            throw IllegalStateException("Id not found")
        itemRepo.deleteItemsById(id)
        LOG.info("Item id: $id was deleted")
        return OkResponse("Item was successfully deleted")
    }
}