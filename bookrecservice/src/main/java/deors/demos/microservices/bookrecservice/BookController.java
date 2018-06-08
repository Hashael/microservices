@RestController
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @RequestMapping("/bookrec")
    public Book getBookRecommendation() {
        return bookRepository.getBooksRandomOrder().get(0);
    }
}