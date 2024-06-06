package com.danielchambueta.cliente.clientesapirest.model.payload;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
/**
 * Clase que representa un objeto de respuesta de mensaje para la API.
 * Implementa la interfaz Serializable para permitir que los objetos de esta clase se puedan serializar.
 * Utiliza las anotaciones de Lombok (@Data, @ToString, @Builder) para generar automáticamente los métodos getter, setter, toString y un constructor con el patrón Builder.
 */
@Data
@ToString
@Builder
public class MensajeResponse implements Serializable {
    private String mensaje;
    private Object object;
}
