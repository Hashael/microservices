@RestController
public class BookController {

    @Autowired
    RestTemplate restTemplate;

    @Value("${defaultBookId}") private long defaultBookId;
    @Value("${defaultBookTitle}") private String defaultBookTitle;
    @Value("${defaultBookAuthor}") private String defaultBookAuthor;

    @RequestMapping("/bookrecedge")
    @com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand(fallbackMethod = "getDefaultBook")
    public Book getBookRecommendation() {
        return restTemplate.getForObject("http://bookrecservice/bookrec", Book.class);
    }

    public Book getDefaultBook() {
        return new Book(defaultBookId, defaultBookTitle, defaultBookAuthor);
    }
}