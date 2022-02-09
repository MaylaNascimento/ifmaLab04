package br.edu.ifma.montecastelo.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity(name = "frete")
public class Frete implements EntityBase{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CodigoFrete")
    private Integer codigoFrete;

    @ManyToOne
    @JoinColumn(name = "codigo_cidade", nullable = false)
    private Cidade cidade;
    
    @ManyToOne
    @JoinColumn(name = "codigo_cliente", nullable = false)
    private Cliente cliente;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @Column(name="peso")
    private BigDecimal peso;

    @Column(name = "valor")
    private BigDecimal valor;


    public Integer getCodigoFrete() {
        return codigoFrete;
    }

    public void setCodigoFrete(Integer CodigoFrete) {
        this.codigoFrete = CodigoFrete;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPeso() {
        return peso;
    }

    public void setPeso(BigDecimal peso) {
        this.peso = peso;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    @Override
    public Integer getId() {
        return getCodigoFrete();
    }

    @Override
    public String toString() {
        return "Frete{" +
                "codigoFrete=" + codigoFrete +
                ", cidade=" + cidade.toString() +
                ", cliente=" + cliente.toString() +
                ", descricao='" + descricao + '\'' +
                ", peso=" + peso +
                ", valor=" + valor +
                '}';
    }
}
