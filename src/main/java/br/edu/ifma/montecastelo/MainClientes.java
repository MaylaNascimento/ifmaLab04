package br.edu.ifma.montecastelo;

import br.edu.ifma.montecastelo.model.Cliente;
import br.edu.ifma.montecastelo.service.ClienteServico;

/**
 * Hello world!
 *
 */
public class MainClientes
{
    public static void main( String[] args )
    {
        ClienteServico servico = new ClienteServico();
        Cliente cliente = new Cliente();

        cliente.setName("Mayla");
        cliente.setTelefone("999999999");
        cliente.setEndereco("Rua das Horas S/N Centro");

        cliente = servico.salva(cliente);

        System.out.println(cliente);
    }
}
