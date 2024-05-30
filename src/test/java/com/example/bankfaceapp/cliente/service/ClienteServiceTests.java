package com.example.bankfaceapp.cliente.service;


import com.example.bankfaceapp.dto.ClienteDTO;
import com.example.bankfaceapp.service.cliente.IClienteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ClienteServiceTests {

    public ClienteDTO reqValida;
    public ClienteDTO reqInvalida;
    public Integer idValido;

    @Mock
    public IClienteService serviceMock;

    @BeforeEach
    public void setup(){
        reqValida = new ClienteDTO("nomeValido","cpfValido","emailValido","telefoneValido","senhaValido");
        reqInvalida = new ClienteDTO("nome",null,null,null,null);
        idValido = 1;

        when(serviceMock.cadastrarCliente(reqValida)).thenReturn(idValido);
        when(serviceMock.cadastrarCliente(reqInvalida)).thenReturn(null);
    }


    @Test
    public void deveCadastrarClienteValido(){
        assertEquals(serviceMock.cadastrarCliente(reqValida),idValido);
    }

    @Test
    public void deveRejeitarClienteInvalido(){
        assertEquals(serviceMock.cadastrarCliente(reqInvalida),null);
    }

}
