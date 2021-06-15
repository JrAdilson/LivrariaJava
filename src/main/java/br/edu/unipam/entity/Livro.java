package br.edu.unipam.entity;
import java.time.LocalDate;
import javax.persistence.Entity;
import java.io.Serializable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class Livro extends AbstractEntity implements Serializable{
  @NotNull  
  @Size(min = 5, max = 200)
  @Column(name = "DescricaoLivro")
  private String NomeLivro;

  @NotNull  
  @Size(min = 5, max = 50)
  @Column(name = "DescricaoLivro")
  private String Resumo;

  @NotNull 
  private int Qtd;

  @NotNull
  private Date Lancamento;

  @NotNull
  private int Isbn;
  
  @NotNull
  @OneToMany
  @NotNull
  private Collection<Genero> generos;

  @NotNull
  @ManyToOne
  @NotNull
  private Collection<Editora> editoras;

  public Genero getGenero() {
    return generos;
  }

  public void setGenero(Usuario generos) {
    this.generos = generos;
  }

  public Editora getEditora() {
    return editoras;
  }

  public void setEditora(Usuario editoras) {
    this.editoras = editoras;
  }

  public String getResumo() {
    return Resumo;
  }

  public void setResumo(String Resumo) {
    this.Resumo = Resumo;
  }

  public int getQtd() {
    return Qtd;
  }

  public void setQtd(int Qtd) {
    this.Qtd = Qtd;
  }

  public int getIsbn() {
    return  Isbn;
  }

  public void setIsbn(int Isbn) {
    this.Isbn = Isbn;
  }

  public Date getLancamento() {
    return Lancamento;
  }

  public void setLancamento(Date Lancamento) {
    this.Lancamento = Lancamento;
  }
}