//Nota: En este proyecto vamos a eliminar entidades, pero no es considerado una
//buena practica. Por esto, además de eliminar nuestras entidades, vamos a practicar
//que nuestras entidades estén dados de alta o de baja. Por lo que las entidades
//tendrán un atributo alta booleano, que estará en true al momento de crearlas y en
//false cuando las demos de baja, que sería cuando se quiere eliminar esa entidad.

package bookshopjpa.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Author {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer authorId;
    
    private String authorName;
    private Boolean authorUpDown;

    public Author() {
    }

    public Author(Integer authorId, String authorName, Boolean authorUpDown) {
        this.authorId = authorId;
        this.authorName = authorName;
        this.authorUpDown = authorUpDown;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Boolean getAuthorMembership() {
        return authorUpDown;
    }

    public void setAuthorMembership(Boolean authorUpDown) {
        this.authorUpDown = authorUpDown;
    }

//    @Override
//    public String toString() {
//        return "Author{" + "authorId=" + authorId + ", authorName=" + authorName + ", authorUpDown=" + authorUpDown + '}';
//    }
    
}
