package br.edu.ifma.montecastelo.model;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity(name = "cliente")
public class Cliente implements EntityBase {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_cliente")
    private Integer codigoCliente;

    @OneToMany(mappedBy = "cliente")
    Set<Frete> fretes = new LinkedHashSet<>();

    @Column(name = "nome", nullable = false)
    private String name;

    @Column(name="endereco")
    private String endereco;

    @Column(name = "telefone")
    private String telefone;


    public Integer getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(Integer codigo_cliente) {
        this.codigoCliente = codigo_cliente;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Set<Frete> getFretes() {
        return fretes;
    }

    public void setFretes(Set<Frete> fretes) {
        this.fretes = fretes;
    }

    @Override
    public Integer getId() {
        return getCodigoCliente();
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "codigoCliente=" + codigoCliente +
                ", fretes=" + fretes.stream()
                    .map(Frete::getId)
                    .map(String::valueOf)
                    .collect(Collectors.joining(", ")) +
                ", name='" + name + '\'' +
                ", endereco='" + endereco + '\'' +
                ", telefone='" + telefone + '\'' +
                '}';
    }
}
