package com.patchwork.controller

import org.springframework.web.bind.annotation.*

@RestController
class LibraryBookController {
    @GetMapping("/")
    fun index(@RequestParam("name") name: String) = "Hello, $name!"
}