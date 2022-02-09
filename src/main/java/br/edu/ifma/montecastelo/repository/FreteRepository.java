package br.edu.ifma.montecastelo.repository;

import br.edu.ifma.montecastelo.config.EMFactory;
import br.edu.ifma.montecastelo.model.Frete;

import javax.persistence.EntityManager;
import java.util.Objects;

public class FreteRepository implements RepositoryBase {

    private final DAOGenerico<Frete> daoFrete;

    public FreteRepository() {
        daoFrete = new DAOGenerico<Frete>(factoryEntity());
    }

    public Frete buscaPorId(Integer id) {
        Objects.requireNonNull(id, "parametro id näo pode ser nulo");
        return daoFrete.buscaPorId(Frete.class, id);
    }

    public Frete cadastraOuAtualiza(Frete Frete) {
        Objects.requireNonNull(Frete, "Frete näo pode ser nulo");
        return daoFrete.salvaOuAtualiza(Frete);
    }

    public void remove(Frete Frete) {
        Objects.requireNonNull(Frete, "Frete näo pode ser nulo");
        daoFrete.remove(Frete);
    }


    public EntityManager getManager() {return daoFrete.getManager();}

    @Override
    public EntityManager factoryEntity() {
        return new EMFactory().getEntityManager();
    }
}

