package br.edu.ifma.montecastelo;

import br.edu.ifma.montecastelo.model.Cliente;
import br.edu.ifma.montecastelo.model.Frete;
import br.edu.ifma.montecastelo.service.ClienteServico;
import br.edu.ifma.montecastelo.service.FreteServico;

import java.util.List;

/**
 * Hello world!
 *
 */
public class MainRecuperaFretePorCliente
{
    public static void main( String[] args )
    {
        FreteServico servico = new FreteServico();
        ClienteServico servicoCliente = new ClienteServico();

        Cliente cliente = servicoCliente.buscaPorId(1);
        List<Frete> frete = servico.recuperaTodosFrestesPorCliente(cliente);

        System.out.println(frete);
    }
}
