package com.patchwork.controller

import org.springframework.web.bind.annotation.*

@RestController
class LibraryBookController {

    @RequestMapping("/findbyAuthor/{author}")
	fun findById(@PathVariable author: Long)
			= repository.findOne(id)

    @GetMapping("/")
    fun index(@RequestParam("name") name: String) = "Hello, $name!"
}