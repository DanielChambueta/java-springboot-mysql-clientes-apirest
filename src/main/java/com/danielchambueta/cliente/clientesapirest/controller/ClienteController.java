package com.danielchambueta.cliente.clientesapirest.controller;

import com.danielchambueta.cliente.clientesapirest.model.dto.ClienteDto;
import com.danielchambueta.cliente.clientesapirest.model.entity.Cliente;
import com.danielchambueta.cliente.clientesapirest.model.payload.MensajeResponse;
import com.danielchambueta.cliente.clientesapirest.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    // Metodo para listar todos los clientes
    // Primero, se obtiene una lista de todos los clientes a través del servicio clienteService.
    // Si la lista obtenida es nula, lo que significa que no hay clientes en la base de datos,
    // se devuelve una respuesta con el mensaje "No hay registros" y un estado HTTP 200 (OK).
    // Si la lista no es nula, se devuelve una respuesta con la lista de clientes y un estado HTTP 200 (OK).

    @GetMapping("clientes")
    public ResponseEntity<?> showAll() {
        List<Cliente> getList = clienteService.listAll();
        if (getList == null) {
            return new ResponseEntity<>(
                    MensajeResponse.builder()
                            .mensaje("No hay registros")
                            .object(null)
                            .build()
                    , HttpStatus.OK);
        }

        return new ResponseEntity<>(
                MensajeResponse.builder()
                        .mensaje("")
                        .object(getList)
                        .build()
                , HttpStatus.OK);
    }

    // Metodo para crear un cliente
    // Primero, se obtiene una lista de todos los clientes a través del servicio clienteService.
    // Si la lista obtenida es nula, lo que significa que no hay clientes en la base de datos,
    // se devuelve una respuesta con el mensaje "No hay registros" y un estado HTTP 200 (OK).
    // Si la lista no es nula, se devuelve una respuesta con la lista de clientes y un estado HTTP 200 (OK).
    @PostMapping("cliente")
    public ResponseEntity<?> create(@RequestBody ClienteDto clienteDto) {
        Cliente clienteSave = null;
        try {
            clienteSave = clienteService.save(clienteDto);
            return new ResponseEntity<>(MensajeResponse.builder()
                    .mensaje("Guardado correctamente")
                    .object(ClienteDto.builder()
                            .idCliente(clienteSave.getIdCliente())
                            .nombre(clienteSave.getNombre() )
                            .apellido(clienteSave.getApellido())
                            .correo(clienteSave.getCorreo())
                            .fechaRegistro(clienteSave.getFechaRegistro())
                            .build())
                    .build()
                    , HttpStatus.CREATED);
        } catch (DataAccessException exDt) {
            return new ResponseEntity<>(
                    MensajeResponse.builder()
                            .mensaje(exDt.getMessage())
                            .object(null)
                            .build()
                    , HttpStatus.METHOD_NOT_ALLOWED);
        }
    }

    // Metodo para actualizar un cliente
    // Primero, verifica si el cliente con el ID proporcionado existe en la base de datos.
    // Si el cliente existe, se actualiza el cliente con los datos proporcionados en el objeto clienteDto y se guarda en la base de datos.
    // Luego, se devuelve una respuesta con el mensaje "Guardado correctamente", el objeto ClienteDto construido a partir del cliente actualizado y un estado HTTP 201 (CREATED).
    // Si el cliente no existe, se devuelve una respuesta con el mensaje "El registro que intenta actualizar no se encuentra en la base de datos." y un estado HTTP 404 (NOT FOUND).
    // Si ocurre una excepción de tipo DataAccessException durante el proceso de actualización, se devuelve una respuesta con el mensaje de la excepción y un estado HTTP 405 (METHOD NOT ALLOWED).

    @PutMapping("cliente/{id}")
    public ResponseEntity<?> update(@RequestBody ClienteDto clienteDto, @PathVariable Integer id) {
        Cliente clienteUpdate = null;
        try {
            if (clienteService.existsById(id)) {
                clienteDto.setIdCliente(id);
                clienteUpdate = clienteService.save(clienteDto);
                return new ResponseEntity<>(MensajeResponse.builder()
                        .mensaje("Guardado correctamente")
                        .object(ClienteDto.builder()
                                .idCliente(clienteUpdate.getIdCliente())
                                .nombre(clienteUpdate.getNombre())
                                .apellido(clienteUpdate.getApellido())
                                .correo(clienteUpdate.getCorreo())
                                .fechaRegistro(clienteUpdate.getFechaRegistro())
                                .build())
                        .build()
                        , HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(
                        MensajeResponse.builder()
                                .mensaje("El registro que intenta actualizar no se encuentra en la base de datos.")
                                .object(null)
                                .build()
                        , HttpStatus.NOT_FOUND);
            }
        } catch (DataAccessException exDt) {
            return new ResponseEntity<>(
                    MensajeResponse.builder()
                            .mensaje(exDt.getMessage())
                            .object(null)
                            .build()
                    , HttpStatus.METHOD_NOT_ALLOWED);
        }
    }

    // Metodo para eliminar un cliente
    // Primero, verifica si el cliente con el ID proporcionado existe en la base de datos.
    // Si el cliente existe, se elimina el cliente de la base de datos.
    // Luego, se devuelve una respuesta con el cliente eliminado y un estado HTTP 204 (NO CONTENT).
    // Si el cliente no existe, se devuelve una respuesta con el mensaje "El registro que intenta eliminar no se encuentra en la base de datos." y un estado HTTP 404 (NOT FOUND).
    // Si ocurre una excepción de tipo DataAccessException durante el proceso de eliminación, se devuelve una respuesta con el mensaje de la excepción y un estado HTTP 405 (METHOD NOT ALLOWED).
    @DeleteMapping("cliente/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        try {
            Cliente clienteDelete = clienteService.findById(id);
            clienteService.delete(clienteDelete);
            return new ResponseEntity<>(clienteDelete, HttpStatus.NO_CONTENT);
        } catch (DataAccessException exDt) {
            return new ResponseEntity<>(
                    MensajeResponse.builder()
                            .mensaje(exDt.getMessage())
                            .object(null)
                            .build()
                    , HttpStatus.METHOD_NOT_ALLOWED);
        }
    }

    //Metodo para buscar un cliente por id
    // Primero, verifica si el cliente con el ID proporcionado existe en la base de datos.
    // Si el cliente existe, se devuelve una respuesta con el cliente encontrado y un estado HTTP 200 (OK).
    // Si el cliente no existe, se devuelve una respuesta con el mensaje "El registro que intenta buscar, no existe!!" y un estado HTTP 404 (NOT FOUND).
    @GetMapping("cliente/{id}")
    public ResponseEntity<?> showById(@PathVariable Integer id) {
        Cliente cliente = clienteService.findById(id);

        if (cliente == null) {
            return new ResponseEntity<>(
                    MensajeResponse.builder()
                            .mensaje("El registro que intenta buscar, no existe!!")
                            .object(null)
                            .build()
                    , HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(
                MensajeResponse.builder()
                        .mensaje("")
                        .object(ClienteDto.builder()
                                .idCliente(cliente.getIdCliente())
                                .nombre(cliente.getNombre())
                                .apellido(cliente.getApellido())
                                .correo(cliente.getCorreo())
                                .fechaRegistro(cliente.getFechaRegistro())
                                .build())
                        .build()
                , HttpStatus.OK);
    }

}
