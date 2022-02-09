package br.edu.ifma.montecastelo.repository;

import br.edu.ifma.montecastelo.config.EMFactory;
import br.edu.ifma.montecastelo.model.Cliente;
import br.edu.ifma.montecastelo.model.EntityBase;

import javax.persistence.EntityManager;
import java.util.Objects;

public class ClienteRepository implements RepositoryBase {

    private final DAOGenerico<Cliente> daoCliente;

    public ClienteRepository() {
        daoCliente = new DAOGenerico<Cliente>(factoryEntity());
    }

    public Cliente buscaPorId(Integer id) {
        Objects.requireNonNull(id, "parametro id näo pode ser nulo");
        return daoCliente.buscaPorId(Cliente.class, id);
    }

    public Cliente cadastraOuAtualiza(Cliente cliente) {
        Objects.requireNonNull(cliente, "Cliente näo pode ser nulo");
        return daoCliente.salvaOuAtualiza(cliente);
    }

    public void remove(Cliente cliente) {
        Objects.requireNonNull(cliente, "Cliente näo pode ser nulo");
        daoCliente.remove(cliente);
    }

    public EntityManager getManager() {return daoCliente.getManager();}

    @Override
    public EntityManager factoryEntity() {
        return new EMFactory().getEntityManager();
    }


}
