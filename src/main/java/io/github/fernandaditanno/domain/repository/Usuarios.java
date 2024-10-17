package io.github.fernandaditanno.domain.repository;

import io.github.fernandaditanno.domain.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Usuarios extends JpaRepository<Usuario, Long> {

//    @Autowired
//    private EntityManager entityManager;
//
//    @Transactional
//    public Usuario salvar(Usuario usuario) {
//        entityManager.persist(usuario);
//        return usuario;
//    }
//
//    @Transactional
//    public void excluir(Usuario usuario) {
//        if (!entityManager.contains(usuario)) {
//           usuario = entityManager.merge(usuario);
//        }
//        entityManager.remove(usuario);
//    }
//
//    @Transactional
//    public Usuario atualizar(Usuario usuario) {
//        entityManager.merge(usuario);
//        return usuario;
//    }
//
//    @Transactional(readOnly = true)
//    public List<Usuario> obterTodos() {
//        return entityManager.createQuery("from Usuario", Usuario.class).getResultList();
//    }
//
//    @Transactional(readOnly = true)
//    public Usuario obterPorId(Long id) {
//        return entityManager.find(Usuario.class, id);
//    }
//
//    @Transactional(readOnly = true)
//    public Usuario obterPorNome(String nome) {
//        String jpql = "select u from Usuario u where u.nome like :nome";
//        TypedQuery<Usuario> query = entityManager.createQuery(jpql, Usuario.class);
//        return query.setParameter("nome", "%" + nome + "%").getSingleResult();
//    }

}
