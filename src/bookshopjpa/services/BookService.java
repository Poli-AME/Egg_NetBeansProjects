package bookshopjpa.services;

import bookshopjpa.entities.Book;
import bookshopjpa.persistence.AuthorDAO;
import bookshopjpa.persistence.BookDAO;
import bookshopjpa.persistence.EditorialDAO;
import java.util.Collection;

public class BookService {
    
    private final BookDAO bookDao;
    private final AuthorDAO authorDao;
    private final EditorialDAO edDao;
    
    public BookService() {
        this.bookDao = new BookDAO();
        this.authorDao = new AuthorDAO();
        this.edDao = new EditorialDAO();
    }
    
    public void createBook
        (String title, Integer age, String copy, String barrowCopy, String remainingCopy, Boolean bookUpDown)
        throws Exception{

        try {
            //Validamos
            if (correoElectronico == null || correoElectronico.trim().isEmpty()) {
                throw new Exception("Debe indicar el correo electrónico");
            }
            if (correoElectronico.contains("@") == false) {
                throw new Exception("El correo electrónico es incorrecto");
            }
            if (clave == null || clave.trim().isEmpty()) {
                throw new Exception("Debe indicar la clave");
            }
            if (clave.length() < 6) {
                throw new Exception("La clave no puede tener menos de 6 caracteres");
            }
            

            //Creamos el usuario
            Usuario usuario = new Usuario();

            Direccion nuevaDire = direccionService.crearDireccion(pais, provincia);

            usuario.setCorreoElectronico(correoElectronico);
            usuario.setClave(clave);
            usuario.setDni(dni);
            usuario.setNacimiento(nacimiento);
            usuario.setDireccion(nuevaDire);
            usuario.setRol(Rol.ADMIN);            
            usuario.setId(UUID.randomUUID().toString());//CADENA DE CARACTERES

            //Dejo independiente el SET de cargar mascotas, no obligo q cuando se log cargue su mascota
            
            daoUsuario.guardarUsuario(usuario);
        } catch (Exception e) {
            System.out.println("No se creeo el usuario"+ e.getMessage());
        }
    
    }
    
    public Collection<Book> bookList() throws Exception {
        try {
            Collection<Book> books = bookDao.listBooks();
            return books;
        } catch (Exception e) {
            throw e;
        }
    }
    
}
