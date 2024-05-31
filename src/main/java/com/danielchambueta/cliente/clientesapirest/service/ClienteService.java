package com.danielchambueta.cliente.clientesapirest.service;

import com.danielchambueta.cliente.clientesapirest.model.dto.ClienteDto;
import com.danielchambueta.cliente.clientesapirest.model.entity.Cliente;

import java.util.List;

public interface ClienteService {

    List<Cliente> listAll();
    Cliente save(ClienteDto cliente);
    Cliente findById(Integer id);
    void delete(Cliente cliente);
    boolean existsById(Integer id);

}
