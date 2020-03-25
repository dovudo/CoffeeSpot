package com.coffee.backend.Routes

import com.coffee.backend.Models.ItemType
import com.coffee.backend.Models.Items
import com.coffee.backend.Models.OkResponse
import com.coffee.backend.Repository.ItemsRepository
import com.google.gson.Gson
import com.google.gson.JsonObject
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationContext
import org.springframework.core.io.ResourceLoader
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class ItemController(@Autowired val itemRepo: ItemsRepository,
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
}