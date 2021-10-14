package bookshopjpa.menu;

import bookshopjpa.services.AuthorService;
import bookshopjpa.services.BookService;
import bookshopjpa.services.EditorialService;
import java.util.Scanner;

public class Menu {
    
    private final Scanner sc;
    private final Integer ans;
    private final Integer exit;
    private final String ansStyle;
    
    private final BookService bookService;
    private final AuthorService authorService;
    private final EditorialService editorialService;

    public Menu() {
        this.sc = new Scanner(System.in).useDelimiter("\n");
        this.ans = 0;
        this.exit = 0;
        this.ansStyle = "number"; //letter
        
        this.bookService = new BookService();
        this.authorService = new AuthorService();
        this.editorialService = new EditorialService();
    }

    public void showMenu() throws Exception{
        do {
            try {

                System.out.println("Please choose an option. Please type the " + ansStyle + " corresponding.");
                System.out.println("----------------------------MENU----------------------------\n+"
                        + "1. Register a book.\n"
                        + "2. Delete a book.\n"
                        + "3. Edit a book.\n"
                        + "4. Register an author.\n"
                        + "5. Delete an author.\n"
                        + "6. Edit an author.\n"
                        + "7. Register an editorial.\n"
                        + "8. Delete an editorial.\n"
                        + "9. Edit an editorial.\n"
                        + "10. Search author by name.\n"
                        + "11. Search book by ISBN.\n"
                        + "12. Search book by title.\n"
                        + "13. Search book by author name.\n"
                        + "14. Search books by editorial name.\n"
                        + "15. Search books by author name.\n"
                        + "16. Search books by editorial name.\n"
                        + "0. Exit.");

                ans = sc.nextInt();
                
                switch (ans) {
                    case 1:
                        bookService.createBook(cargarCorreo(), cargarClave(), cargarDni(), cargarFecha(), "PAIS", "PROVINCIA");
                        break;
                    default:
                        throw new AssertionError();
                }

            } catch () {

            }
        }
    }
    
    
    
}