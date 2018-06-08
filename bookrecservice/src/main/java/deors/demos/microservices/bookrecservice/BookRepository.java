@RepositoryRestResource
public interface BookRepository extends CrudRepository<Book, Long> {

    @Query("select b from Book b order by RAND()")
    List<Book> getBooksRandomOrder();
}