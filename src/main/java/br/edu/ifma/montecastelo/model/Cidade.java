package br.edu.ifma.montecastelo.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Entity(name = "cidade")
public class Cidade implements EntityBase {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_cidade")
    private Integer codigoCidade;

    @OneToMany(mappedBy = "cidade")
    Set<Frete> fretes = new LinkedHashSet<>();

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "UF")
    private String Uf;

    @Column(name = "taxa")
    private BigDecimal taxa;

    public Integer getCodigoCidade() {
        return codigoCidade;
    }

    public void setCodigoCidade(Integer codigoCidade) {
        this.codigoCidade = codigoCidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUf() {
        return Uf;
    }

    public void setUf(String uf) {
        Uf = uf;
    }

    public BigDecimal getTaxa() {
        return taxa;
    }

    public void setTaxa(BigDecimal taxa) {
        this.taxa = taxa;
    }

    public Set<Frete> getFretes() {
        return fretes;
    }

    public void setFretes(Set<Frete> fretes) {
        this.fretes = fretes;
    }

    @Override
    public Integer getId() {
        return getCodigoCidade();
    }

    @Override
    public String toString() {
        return "Cidade{" +
                "codigoCidade=" + codigoCidade +
                ", fretes=" + fretes.stream()
                    .map(Frete::getId)
                    .map(String::valueOf)
                    .collect(Collectors.joining(", ")) +
                ", nome='" + nome + '\'' +
                ", Uf='" + Uf + '\'' +
                ", taxa=" + taxa +
                '}';
    }
}
