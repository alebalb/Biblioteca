package com.example.bibliotecaduoc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //Genera Getters, Setters, ToString, equals, hashcode y un constructor con los argumentos requeridos.
@AllArgsConstructor //Genera un constructor con todos los argumentos.
@NoArgsConstructor //Genera un constructor vacio.
public class LibroModel {
    private int id;
    private String isbn;
    private String titulo;
    private String editorial;
    private int fechaPublicacion;
    private String autor;
}
