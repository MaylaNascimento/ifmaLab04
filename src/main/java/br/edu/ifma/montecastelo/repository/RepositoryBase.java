package br.edu.ifma.montecastelo.repository;

import br.edu.ifma.montecastelo.config.EMFactory;
import br.edu.ifma.montecastelo.model.EntityBase;

import javax.persistence.EntityManager;

@FunctionalInterface
public interface RepositoryBase {
    EntityManager factoryEntity();
}
