package com.example.bankfaceapp.cliente.service;


import com.example.bankfaceapp.dto.ClienteDTO;
import com.example.bankfaceapp.service.cliente.IClienteService;
import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ClienteServiceTests {

    private ClienteDTO reqValida;
    private ClienteDTO reqInvalida;
    private ClienteDTO reqCPFDupl;
    private ClienteDTO reqEmailDupl;
    private ClienteDTO reqTelefonelDupl;
    private Integer idValido;

    @Mock
    private IClienteService serviceMock;

    @BeforeEach
    public void setup(){
        reqValida = new ClienteDTO("clienteValido","cliente@email.com","123.456.789-10","(21)91111-1111","senhaValida");
        reqInvalida = new ClienteDTO("clienteInvalido",null,null,null,null);
        reqCPFDupl = new ClienteDTO("clienteCPFDuplicado","a.mail@mail.com","123.456.789-10","2191111-1110","abc");
        reqEmailDupl = new ClienteDTO("clienteEmailDuplicado","b.mail@email.com","123.456.789-11","2191111-1112","abd");
        reqTelefonelDupl = new ClienteDTO("clienteTelDuplicado","c.mail@email.com","123.456.789-12","(21)91111-1113","abe");
        idValido = 1;

        when(serviceMock.cadastrarCliente(reqValida)).thenReturn(idValido);
        when(serviceMock.cadastrarCliente(reqInvalida)).thenThrow(new ConstraintViolationException(null));
        when(serviceMock.cadastrarCliente(reqCPFDupl)).thenReturn(null);
        when(serviceMock.cadastrarCliente(reqEmailDupl)).thenReturn(null);
        when(serviceMock.cadastrarCliente(reqTelefonelDupl)).thenReturn(null);
    }


    @Test
    public void deveCadastrarClienteValido(){
        assertEquals(serviceMock.cadastrarCliente(reqValida),idValido);
    }

    @Test
    public void deveRejeitarClienteInvalido(){
        assertThrows(ConstraintViolationException.class,() -> {
            serviceMock.cadastrarCliente(reqInvalida);
        });
    }

    @Test
    public void deveRejeitarClienteComCPFDuplicado() {
        assertEquals(serviceMock.cadastrarCliente(reqCPFDupl),null);
    }

    @Test
    public void deveRejeitarClienteComEmailDuplicado(){
        assertEquals(serviceMock.cadastrarCliente(reqEmailDupl),null);
    }

    @Test
    public void deveRejeitarClienteComTelefoneDuplicado(){
        assertEquals(serviceMock.cadastrarCliente(reqTelefonelDupl), null);
    }

}
