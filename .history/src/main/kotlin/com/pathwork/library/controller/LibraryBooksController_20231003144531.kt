packagee com.p
@RestController
class LibraryBookController {
    @GetMapping("/")
    fun index(@RequestParam("name") name: String) = "Hello, $name!"
}