package com.danielchambueta.cliente.clientesapirest.model.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * Clase que representa un objeto de transferencia de datos (DTO) para la entidad Cliente.
 * Implementa la interfaz Serializable para permitir que los objetos de esta clase se puedan serializar.
 * Utiliza las anotaciones de Lombok (@Data, @ToString, @Builder) para generar automáticamente los métodos getter, setter, toString y un constructor con el patrón Builder.
 */
@Data
@ToString
@Builder
public class ClienteDto implements Serializable {

    private Integer idCliente;
    private String nombre;
    private String apellido;
    private String correo;
    private Date fechaRegistro;

}
