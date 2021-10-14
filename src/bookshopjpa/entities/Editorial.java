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
public class Editorial {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer edId;
    
    private String edName;
    private Boolean edUpDown;

    public Editorial() {
    }

    public Editorial(Integer edId, String edName, Boolean edUpDown) {
        this.edId = edId;
        this.edName = edName;
        this.edUpDown = edUpDown;
    }

    public Integer getEdId() {
        return edId;
    }

    public void setEdId(Integer edId) {
        this.edId = edId;
    }

    public String getEdName() {
        return edName;
    }

    public void setEdName(String edName) {
        this.edName = edName;
    }

    public Boolean getEdMembership() {
        return edUpDown;
    }

    public void setEdMembership(Boolean edUpDown) {
        this.edUpDown = edUpDown;
    }

//    @Override
//    public String toString() {
//        return "Editorial{" + "edId=" + edId + ", edName=" + edName + ", edUpDown=" + edUpDown + '}';
//    }
    
}
