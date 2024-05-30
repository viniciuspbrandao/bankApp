package com.example.bankfaceapp.dto;


import com.example.bankfaceapp.model.Cliente;

public record ClienteDTO(String nome, String cpf, String email, String telefone, String senha) {

    public Cliente toCliente(){
        Cliente cliente = new Cliente();
        cliente.setNome (nome);
        cliente.setCpf (cpf);
        cliente.setEmail (email);
        cliente.setTelefone (telefone);
        cliente.setSenha (senha);
        return cliente;
    }

}
