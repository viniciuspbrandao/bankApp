package com.example.bankfaceapp.model;


import jakarta.persistence.*;

@Entity
@Table(name = "tbl_cliente")
public class Cliente{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Integer idCliente;

    @Column(name = "nome_cliente", nullable = false, length = 150)
    private String nome;

    @Column(name = "cpf_cliente", nullable = false, unique = true, length = 11)
    private String cpf;

    @Column(name = "email_cliente", nullable = false, unique = true, length = 100)
    private String email;

    @Column(name = "telefone_cliente", nullable = false, unique = true, length = 20)
    private String telefone;

    @Column(name = "senha_cliente", nullable = false, unique = true, length = 250)
    private String senha;



    public Integer getIdCliente() {
        return idCliente;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getSenha() {
        return senha;
    }


    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
