package br.edu.unipam.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
public class Usuario extends AbstractEntity implements Serializable{
  @NotNull  
  @Size(min = 5, max = 200)
  @Column(name = "NomeAutor")
  private String NomeAutor;
}