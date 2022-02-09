package br.edu.ifma.montecastelo.service;

import br.edu.ifma.montecastelo.model.Cliente;
import br.edu.ifma.montecastelo.repository.ClienteRepository;

import java.util.Objects;

public class ClienteServico {

    private final ClienteRepository repository;

    public ClienteServico() {
        this.repository = new ClienteRepository();
    }

    public Cliente salva(Cliente cliente)  {
        Objects.requireNonNull(cliente.getEndereco(), "Endereço não pode ser nulo");
        Objects.requireNonNull(cliente.getTelefone(), "Telefone não pode ser nulo");

        repository.getManager().getTransaction().begin();
        Cliente clienteSalvo = repository.cadastraOuAtualiza(cliente);
        repository.getManager().getTransaction().commit();

        return clienteSalvo;
    }

    public Cliente buscaPorId(Integer clienteId) {
        return repository.buscaPorId(clienteId);
    }





}
