package com.danielchambueta.cliente.clientesapirest.service.implement;

import com.danielchambueta.cliente.clientesapirest.model.dao.ClienteDao;
import com.danielchambueta.cliente.clientesapirest.model.dto.ClienteDto;
import com.danielchambueta.cliente.clientesapirest.model.entity.Cliente;
import com.danielchambueta.cliente.clientesapirest.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Clase que implementa la interfaz ClienteService.
 * Proporciona la implementación de los métodos definidos en la interfaz ClienteService.
 * Utiliza la anotación @Service para indicar que es una clase de servicio en Spring.
 * Utiliza la anotación @Autowired para la inyección de dependencias de la interfaz ClienteDao.
 * Utiliza la anotación @Transactional para la gestión de transacciones en los métodos que modifican la base de datos.
 *
 */
@Service
public class ClienteImplementationService implements ClienteService {

    /**
     * Inyección de dependencias de la interfaz ClienteDao.
     */
    @Autowired
    private ClienteDao clienteDao;

    /**
     * Método para obtener todos los clientes.
     * @return una lista de clientes.
     */
    @Override
    public List<Cliente> listAll() {
        return (List) clienteDao.findAll();
    }

    /**
     * Método para guardar un cliente.
     * @param clienteDto objeto ClienteDto con los datos del cliente a guardar.
     * @return el cliente guardado.
     */
    @Transactional
    public Cliente save(ClienteDto clienteDto) {
        Cliente cliente = Cliente.builder()
                .idCliente(clienteDto.getIdCliente())
                .nombre(clienteDto.getNombre())
                .apellido(clienteDto.getApellido())
                .correo(clienteDto.getCorreo())
                .fechaRegistro(clienteDto.getFechaRegistro())
                .build();
        return clienteDao.save(cliente);
    }

    /**
     * Método para buscar un cliente por su identificador.
     * @param id el identificador del cliente.
     * @return el cliente encontrado.
     */
    @Transactional(readOnly = true)
    @Override
    public Cliente findById(Integer id) {
        return clienteDao.findById(id).orElse(null);
    }

    /**
     * Método para eliminar un cliente.
     * @param cliente el cliente a eliminar.
     */
    @Transactional
    @Override
    public void delete(Cliente cliente) {
        clienteDao.delete(cliente);
    }

    /**
     * Método para verificar si un cliente existe por su identificador.
     * @param id el identificador del cliente.
     * @return verdadero si el cliente existe, falso en caso contrario.
     */
    @Override
    public boolean existsById(Integer id) {
        return clienteDao.existsById(id);
    }
}