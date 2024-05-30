package com.example.bankfaceapp.service.cliente;

import com.example.bankfaceapp.dto.ClienteDTO;
import com.example.bankfaceapp.model.Cliente;
import com.example.bankfaceapp.repo.ClienteRepo;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements IClienteService {

    @Autowired
    ClienteRepo repository;

    @Override
    public Integer cadastrarCliente(@Valid ClienteDTO dto) {
        Cliente teste = repository.findByEmailOrCpfOrTelefone(dto.nome(),dto.email(),dto.cpf(),dto.telefone(), dto.senha());
        return null;
    }

    @Override
    public Integer alterarDados(ClienteDTO cliente) {
        return null;
    }
}
