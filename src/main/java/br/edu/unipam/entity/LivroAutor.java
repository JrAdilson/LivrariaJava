package br.edu.unipam.entity;
import java.time.LocalDate;
import javax.persistence.Entity;
import java.io.Serializable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class LivroAutor extends AbstractEntity implements Serializable{
  @NotNull  
  @Size(min = 5, max = 200)
  @Column(name = "DescricaoLivro")
  private String NomeLivro; 

  @NotNull
  private int AutorId;


  public int getAutorId() {
    return AutorId;
  }

  public void setAutorId(int AutorId) {
    this.AutorId = AutorId;
  }

}