package com.patchwork.controller

import org.springframework.web.bind.annotation.*
import com.patchwork.library.service.BookService
@RestController
class LibraryBookController {

    @Autowired
	lateinit var bookService: BookService

    @RequestMapping("/findbyAuthor/{author}")
	fun findById(@PathVariable author: String)
			= bookService.findByAuthor(id)

    @GetMapping("/")
    fun index(@RequestParam("name") name: String) = "Hello, $name!"
}