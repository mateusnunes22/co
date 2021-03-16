package entidade;
// Generated 21/09/2013 16:52:20 by Hibernate Tools 3.2.1.GA


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * UsuarioHasMateriaId generated by hbm2java
 */
@Embeddable
public class UsuarioHasMateriaId  implements java.io.Serializable {


     private int usuarioIdUsuario;
     private int materiaIdMateria;

    public UsuarioHasMateriaId() {
    }

    public UsuarioHasMateriaId(int usuarioIdUsuario, int materiaIdMateria) {
       this.usuarioIdUsuario = usuarioIdUsuario;
       this.materiaIdMateria = materiaIdMateria;
    }
   

    @Column(name="Usuario_idUsuario", nullable=false)
    public int getUsuarioIdUsuario() {
        return this.usuarioIdUsuario;
    }
    
    public void setUsuarioIdUsuario(int usuarioIdUsuario) {
        this.usuarioIdUsuario = usuarioIdUsuario;
    }

    @Column(name="Materia_idMateria", nullable=false)
    public int getMateriaIdMateria() {
        return this.materiaIdMateria;
    }
    
    public void setMateriaIdMateria(int materiaIdMateria) {
        this.materiaIdMateria = materiaIdMateria;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof UsuarioHasMateriaId) ) return false;
		 UsuarioHasMateriaId castOther = ( UsuarioHasMateriaId ) other; 
         
		 return (this.getUsuarioIdUsuario()==castOther.getUsuarioIdUsuario())
 && (this.getMateriaIdMateria()==castOther.getMateriaIdMateria());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getUsuarioIdUsuario();
         result = 37 * result + this.getMateriaIdMateria();
         return result;
   }   


}

