package br.edu.ifma.montecastelo;

import br.edu.ifma.montecastelo.model.Cidade;
import br.edu.ifma.montecastelo.service.CidadeServico;

import java.math.BigDecimal;

/**
 * Hello world!
 *
 */
public class MainCidades
{
    public static void main( String[] args )
    {
        CidadeServico servico = new CidadeServico();
        Cidade cidade = new Cidade();

        cidade.setNome("Campo Bom");
        cidade.setUf("Rio Grande do Sul");
        cidade.setTaxa(BigDecimal.valueOf(12.5));

        cidade = servico.salva(cidade);

        System.out.println(cidade);
    }
}
