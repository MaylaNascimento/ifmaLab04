package br.edu.ifma.montecastelo.repository;

import br.edu.ifma.montecastelo.config.EMFactory;
import br.edu.ifma.montecastelo.model.Cidade;

import javax.persistence.EntityManager;
import java.util.Objects;

public class CidadeRepository implements RepositoryBase {

    private final DAOGenerico<Cidade> daoCidade;

    public CidadeRepository() {
        daoCidade = new DAOGenerico<Cidade>(factoryEntity());
    }

    public Cidade buscaPorId(Integer id) {
        Objects.requireNonNull(id, "parametro id näo pode ser nulo");
        return daoCidade.buscaPorId(Cidade.class, id);
    }

    public Cidade cadastraOuAtualiza(Cidade Cidade) {
        Objects.requireNonNull(Cidade, "Cidade näo pode ser nulo");
        return daoCidade.salvaOuAtualiza(Cidade);
    }

    public void remove(Cidade Cidade) {
        Objects.requireNonNull(Cidade, "Cidade näo pode ser nulo");
        daoCidade.remove(Cidade);
    }


    public EntityManager getManager() {return daoCidade.getManager();}

    @Override
    public EntityManager factoryEntity() {
        return new EMFactory().getEntityManager();
    }


}
