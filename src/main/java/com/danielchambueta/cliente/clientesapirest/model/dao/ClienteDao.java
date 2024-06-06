package com.danielchambueta.cliente.clientesapirest.model.dao;

import com.danielchambueta.cliente.clientesapirest.model.entity.Cliente;
import org.springframework.data.repository.CrudRepository;

/**
 * Interfaz para el acceso a datos de la entidad Cliente.
 * Extiende de CrudRepository para proporcionar operaciones CRUD para la entidad Cliente.
 */
public interface ClienteDao extends CrudRepository<Cliente, Integer> {
}
