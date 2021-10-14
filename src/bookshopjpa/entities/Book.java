//Nota: En este proyecto vamos a eliminar entidades, pero no es considerado una
//buena practica. Por esto, además de eliminar nuestras entidades, vamos a practicar
//que nuestras entidades estén dados de alta o de baja. Por lo que las entidades
//tendrán un atributo alta booleano, que estará en true al momento de crearlas y en
//false cuando las demos de baja, que sería cuando se quiere eliminar esa entidad.

package bookshopjpa.entities;

import bookshopjpa.services.BookService;
import java.util.Collection;
import java.util.Scanner;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Book {
    
    private final Scanner sc ;
    private final BookService bookService ;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //    JPA cuando persista la entidad no enviará este valor, pues asumirá que
    //    la columna es autogenerada. Esto provoca que el contador de la columna incremente en 1
    //    cada vez que un nuevo objeto es insertado.
    private long isbn;
    
    //    @NotNull vs @Column(nullable=false)
    //    (https://thorben-janssen.com/hibernate-tips-whats-the-difference-between-column-nullable-false-and-notnull/)
    //    (https://www.it-swarm-es.com/es/java/por-que-deberia-especificar-column-nullable-false/1070816108/)
    
    //    @NotNull is a JSR 303 BeanValidation annotation. It has nothing to do with database constraints itself.
    //    This annotation is intended for validation.
    //    @Column(nullable = false) is the way of declaring a column to be not-null.
    //    This last annotation is intended for indicating database schema details    
    //    so @NotNull is better, but it throws error
    @Column(unique=true, nullable=false)
    private String title;
    private Integer age; //U otro tipo de dato q ocupe menos sería mejor?cuál?
    private String copy;
    private String barrowCopy;
    private String remainingCopy;
    private Boolean bookUpDown;
    
    @OneToOne(cascade = CascadeType.REMOVE) //si elimino libro se elimina autor
    private Author author;
    @OneToOne(cascade = CascadeType.REMOVE) //si elimino libro se elimina editorial
    private Editorial editorial;

    public Book() {

//pero si pongo acá
//this.sc = new Scanner(System.in).useDelimiter("\n");
//this.bookService = new BookService();
//para q se inicialicen sí o sí voy a tener q llamar a este constructor, cdo sé q voy a llamar al q sigue

        this.sc = new Scanner(System.in).useDelimiter("\n");
        this.bookService = new BookService();
    }

    public Book(long isbn, String title, Integer age, String copy, String barrowCopy, String remainingCopy, Boolean bookUpDown, Author author, Editorial editorial) {
        
        this.sc = new Scanner(System.in).useDelimiter("\n");
        this.bookService = new BookService();
        
        this.isbn = isbn;
        this.title = title;
        this.age = age;
        this.copy = copy;
        this.barrowCopy = barrowCopy;
        this.remainingCopy = remainingCopy;
        this.bookUpDown = bookUpDown;
        this.author = author;
        this.editorial = editorial;   
    }

    public long getIsbn() {
        return isbn;
    }

    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCopy() {
        return copy;
    }

    public void setCopy(String copy) {
        this.copy = copy;
    }

    public String getBarrowCopy() {
        return barrowCopy;
    }

    public void setBarrowCopy(String barrowCopy) {
        this.barrowCopy = barrowCopy;
    }

    public String getRemainingCopy() {
        return remainingCopy;
    }

    public void setRemainingCopy(String remainingCopy) {
        this.remainingCopy = remainingCopy;
    }

    public Boolean getMembership() {
        return bookUpDown;
    }

    public void setMembership(Boolean bookUpDown) {
        this.bookUpDown = bookUpDown;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Editorial getEditorial() {
        return editorial;
    }

    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }
    
    public String titleLoad() throws Exception {        
        System.out.println("Please, enter the book title.");
        title = sc.next();
        try {
            if (titleValidation(title)) {
                System.out.println("Title entered (valid) NOT registered in advance. Please continue with the registration.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            titleLoad();
        }
        return title;
    }
    
    public boolean titleValidation(String title) throws Exception {
        boolean validation = false;
        try {
            Collection<Book> books = bookService.bookList();
            for (Book b : books) {
                if (b.getTitle().equalsIgnoreCase(title)) {
                    throw new Exception("Title already registered, enter another (valid) title.");
                }
            }
            validation = true;
        } catch (Exception e) {
            throw e;
        }
        return validation;
    }

//    @Override
//    public String toString() {
//        return "Book{" + "isbn=" + isbn + ", title=" + title + ", age=" + age + ", copy=" + copy + ", barrowCopy=" + barrowCopy + ", remainingCopy=" + remainingCopy + ", bookUpDown=" + bookUpDown + ", author=" + author + ", editorial=" + editorial + '}';
//    }
    
}
