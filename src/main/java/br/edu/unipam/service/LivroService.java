package br.edu.unipam.service;
import br.edu.unipam.entity.Tarefa;
import br.edu.unipam.entity.Usuario;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
@Transactional
public class TarefaService {
  @PersistenceContext(name = "pu_todo")
  private EntityManager entityManager;
  
  @Inject
  private EditoraService editoraservice;

  @Inject
  private GeneroService generoservice;


  public Tarefa localizarPorId(Long id) {
    Tarefa tarefaBd = entityManager.find(Tarefa.class, id);
    return tarefaBd;
  }

  public void remover(Long id) {
    Tarefa tarefa  = localizarPorId(id);
    if (tarefa != null) {
      entityManager.remove(tarefa);
    }
  }

  public Tarefa editar(Tarefa tarefa, Long id) {
    Tarefa tarefaBd = localizarPorId(tarefa.getId());
    if (tarefaBd == null)
    {
      return null;
    }
    Usuario userBd = usuarioService.localizarPorId(id);
    if (userBd == null)
    {
      return null;
    }
    tarefa.setUsuario(userBd);
    entityManager.merge(tarefa);
    return tarefa;
  }

  //Listar 
  public List<Tarefa> listar ()
  {
    return entityManager.createQuery("select t from Tarefa t order by t.Descricao", Tarefa.class).getResultList();
  }
  
  //Listar por Usuario
  public List<Tarefa> listarPorUsuario (Long id)
  {
    Usuario user = usuarioService.localizarPorId(id);
    return entityManager.createQuery(
        "select t from Tarefa t where t.usuario = :user", Tarefa.class
      ).setParameter("user", user)
      .getResultList();
  }
}