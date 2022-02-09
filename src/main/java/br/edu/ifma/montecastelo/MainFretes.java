package br.edu.ifma.montecastelo;

import br.edu.ifma.montecastelo.model.Cidade;
import br.edu.ifma.montecastelo.model.Cliente;
import br.edu.ifma.montecastelo.model.Frete;
import br.edu.ifma.montecastelo.service.CidadeServico;
import br.edu.ifma.montecastelo.service.ClienteServico;
import br.edu.ifma.montecastelo.service.FreteServico;

import java.math.BigDecimal;

/**
 * Hello world!
 *
 */
public class MainFretes
{
    public static void main( String[] args )
    {
        FreteServico servico = new FreteServico();
        ClienteServico clienteServico = new ClienteServico();
        CidadeServico cidadeServico = new CidadeServico();

        Cliente cliente = clienteServico.buscaPorId(1);
        Cidade cidade = cidadeServico.bucapPorId(1);

        Frete frete = new Frete();
        frete.setCidade(cidade);
        frete.setCliente(cliente);
        frete.setDescricao("Bicicleta aro 12, Caloy");
        frete.setPeso(BigDecimal.valueOf(100));
        frete.setValor(BigDecimal.valueOf(120));

        frete = servico.salva(frete);

        System.out.println(frete);
    }
}
