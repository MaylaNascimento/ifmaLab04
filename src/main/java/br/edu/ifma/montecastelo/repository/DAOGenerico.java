package br.edu.ifma.montecastelo.repository;

import br.edu.ifma.montecastelo.model.EntityBase;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.Objects;

public class DAOGenerico<T extends EntityBase> {

    private final EntityManager manager;

    DAOGenerico(EntityManager manager) {
        this.manager = manager;
    }

    List<?> buscaTodos(Class<T> clazz) {
        Query query = manager.createQuery("Select c FROM " + clazz.getName() + " c");
        return query.getResultList();
    }

    T buscaPorId(Class<T> clazz, Integer id) {
        return manager.find(clazz, id);
    }

    T salvaOuAtualiza(T t) {
        if (Objects.isNull(t.getId()))
            this.manager.persist(t);
        else
            t = this.manager.merge(t);
        return t;
    }

    void remove(T t) {
        manager.remove(t);
        manager.flush();
    }

    EntityManager getManager() {return manager;}
}
