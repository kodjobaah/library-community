package com.patchwork.controller

import org.springframework.web.bind.annotation.*
import com.pat
@RestController
class LibraryBookController {

    @Autowired
	lateinit var bookService: CustomerRepository

    @RequestMapping("/findbyAuthor/{author}")
	fun findById(@PathVariable author: String)
			= repository.findOne(id)

    @GetMapping("/")
    fun index(@RequestParam("name") name: String) = "Hello, $name!"
}