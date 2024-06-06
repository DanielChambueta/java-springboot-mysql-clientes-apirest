package com.danielchambueta.cliente.clientesapirest.service;

import com.danielchambueta.cliente.clientesapirest.model.dto.ClienteDto;
import com.danielchambueta.cliente.clientesapirest.model.entity.Cliente;

import java.util.List;

/**
 * Interfaz para el servicio de la entidad Cliente.
 * Define los métodos para el manejo de la entidad Cliente en la capa de servicio.
 */
public interface ClienteService {

    List<Cliente> listAll();
    Cliente save(ClienteDto cliente);
    Cliente findById(Integer id);
    void delete(Cliente cliente);
    boolean existsById(Integer id);

}
