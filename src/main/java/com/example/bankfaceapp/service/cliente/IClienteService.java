package com.example.bankfaceapp.service.cliente;

import com.example.bankfaceapp.dto.ClienteDTO;

public interface IClienteService {

    public Integer cadastrarCliente(ClienteDTO novo);
    public Integer alterarDados(ClienteDTO cliente);
}
