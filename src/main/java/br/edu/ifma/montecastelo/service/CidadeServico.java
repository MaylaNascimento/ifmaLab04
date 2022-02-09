package br.edu.ifma.montecastelo.service;

import br.edu.ifma.montecastelo.model.Cidade;
import br.edu.ifma.montecastelo.repository.CidadeRepository;

import java.util.Objects;

public class CidadeServico {
    private final CidadeRepository repository;

    public CidadeServico() {
        this.repository = new CidadeRepository();
    }

    public Cidade salva(Cidade cidade) {
        Objects.requireNonNull(cidade.getUf(), "Estado não pode ser nulo");
        Objects.requireNonNull(cidade.getTaxa(), "Taxa não pode ser nulo");

        repository.getManager().getTransaction().begin();
        Cidade CidadeSalvo = repository.cadastraOuAtualiza(cidade);
        repository.getManager().getTransaction().commit();

        return CidadeSalvo;
    }


    public Cidade bucapPorId(Integer i) {
        return repository.buscaPorId(i);
    }
}
