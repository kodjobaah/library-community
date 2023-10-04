package com.patchwork.controller


import org.springframework.web.bind.annotation.*

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