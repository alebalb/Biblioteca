package com.example.bibliotecaduoc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrestamoModel {
    public int idPrestamo;
    public int idLibro;
    public String runSolicitante;
    public Date fechaSolicitud;
    public Date fechaEntrega;
    public int cantidadDias;
    public int multas;
}
