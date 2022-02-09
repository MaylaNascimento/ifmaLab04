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
public class MainRecuperaFrete
{
    public static void main( String[] args )
    {
        FreteServico servico = new FreteServico();
        Frete frete = servico.buscaPorId(1);

        System.out.println(servico.recuperarValorFrete(frete));
    }
}
