/*
6) Crear los métodos para persistir entidades en la base de datos librería.
7) Crear los métodos para dar de alta/bajo o editar dichas entidades.
8) Búsqueda de un Autor por nombre.
9) Búsqueda de un libro por ISBN.
10) Búsqueda de un libro por Título.
11) Búsqueda de un libro/s por nombre de Autor.
12) Búsqueda de un libro/s por nombre de Editorial.
13) Agregar las siguientes validaciones a todas las funcionalidades de la aplicación:
• Validar campos obligatorios.
• No ingresar datos duplicados.
*/

package bookshopjpa;

import bookshopjpa.menu.Menu;

public class BookshopJPA {

    public static void main(String[] args) throws Exception {

        Menu menu = new Menu();
        menu.showMenu();

    }
    
}
