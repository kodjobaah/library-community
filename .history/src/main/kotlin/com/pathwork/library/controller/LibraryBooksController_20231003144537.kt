packagee com.pathwork.libr
@RestController
class LibraryBookController {
    @GetMapping("/")
    fun index(@RequestParam("name") name: String) = "Hello, $name!"
}