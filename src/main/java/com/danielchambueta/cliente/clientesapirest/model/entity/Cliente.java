package com.danielchambueta.cliente.clientesapirest.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

/**
 * Clase que representa la entidad Cliente en la base de datos.
 * Implementa la interfaz Serializable para permitir que los objetos de esta clase se puedan serializar.
 * Utiliza las anotaciones de Lombok (@Data, @AllArgsConstructor, @NoArgsConstructor, @ToString, @Builder) para generar automáticamente los métodos getter, setter, toString, un constructor con todos los argumentos, un constructor sin argumentos y un constructor con el patrón Builder.
 * Utiliza las anotaciones de JPA (@Entity, @Table, @Id, @Column, @GeneratedValue) para mapear la clase con la tabla 'clientes' en la base de datos y sus columnas.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "clientes")
public class Cliente implements Serializable {
    /**
     * Identificador único del cliente.
     * Mapeado con la columna 'id_cliente' en la base de datos.
     * Utiliza la estrategia de generación de identidad para la generación automática del valor.
     */
    @Id
    @Column(name = "id_cliente")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCliente;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "correo")
    private String correo;
    @Column(name = "fecha_registro")
    private Date fechaRegistro;

}
