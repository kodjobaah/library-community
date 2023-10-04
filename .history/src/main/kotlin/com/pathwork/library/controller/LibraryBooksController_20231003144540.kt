packagee com.pathwork.LibraryBookController
@RestController
class LibraryBookController {
    @GetMapping("/")
    fun index(@RequestParam("name") name: String) = "Hello, $name!"
}