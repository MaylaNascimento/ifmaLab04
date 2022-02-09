package br.edu.ifma.montecastelo.service;

import br.edu.ifma.montecastelo.model.Cliente;
import br.edu.ifma.montecastelo.model.Frete;
import br.edu.ifma.montecastelo.repository.FreteRepository;
import br.edu.ifma.montecastelo.repository.FreteRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class FreteServico {

    private final FreteRepository repository;
    

    public FreteServico() {
        this.repository = new FreteRepository();
    }

    public Frete salva(Frete Frete){
        Objects.requireNonNull(Frete.getDescricao(), "Descrição não pode ser nulo");
        Objects.requireNonNull(Frete.getPeso(), "Peso não pode ser nulo");
        Objects.requireNonNull(Frete.getCidade(), "Cidade não pode ser nulo");
        Objects.requireNonNull(Frete.getCliente(), "Cliente não pode ser nulo");

        repository.getManager().getTransaction().begin();
        Frete FreteSalvo = repository.cadastraOuAtualiza(Frete);
        repository.getManager().getTransaction().commit();

        return FreteSalvo;
    }

    public BigDecimal recuperarValorFrete(Frete frete) {
        BigDecimal taxaEntregaCidade = frete.getCidade().getTaxa();

        return frete.getPeso().multiply(frete.getValor()).add(taxaEntregaCidade);
    }

    public List<Frete> recuperaTodosFrestesPorCliente(Cliente cliente) {
        return new ArrayList<>(cliente.getFretes());
    }

    public Frete buscaPorId(Integer i) {
        return repository.buscaPorId(i);
    }
}
