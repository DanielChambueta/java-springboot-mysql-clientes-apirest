package com.danielchambueta.cliente.clientesapirest.model.dao;

import com.danielchambueta.cliente.clientesapirest.model.entity.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteDao extends CrudRepository<Cliente, Integer> {
}
