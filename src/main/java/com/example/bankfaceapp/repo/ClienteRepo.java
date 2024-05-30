package com.example.bankfaceapp.repo;

import com.example.bankfaceapp.model.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRepo extends CrudRepository<Cliente,Integer> {
    public Cliente findByEmailOrCpfOrTelefone(
            String nome,
            String cpf,
            String email,
            String telefone,
            String senha);
}
