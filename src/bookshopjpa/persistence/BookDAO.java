package bookshopjpa.persistence;

import bookshopjpa.entities.Book;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BookDAO {
    
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("LibreriaJPAPU");
    private final EntityManager em = emf.createEntityManager();
    
    public List<Book> listBooks() throws Exception {
        List<Book> books = em.createQuery("SELECT b FROM Book b").getResultList();
        return books;
    }
    
}
