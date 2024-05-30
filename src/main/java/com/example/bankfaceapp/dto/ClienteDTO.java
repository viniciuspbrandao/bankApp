package com.example.bankfaceapp.dto;


import com.example.bankfaceapp.model.Cliente;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record ClienteDTO(@NotNull String nome,
                         @NotNull String email,
                         @NotNull @Email String cpf,
                         @NotNull @Min(11) String telefone,
                         @NotNull @Min(8) String senha) {

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
