package com.example.bibliotecaduoc.controller;

import com.example.bibliotecaduoc.model.PrestamoModel;
import com.example.bibliotecaduoc.repository.PrestamoRepository;
import com.example.bibliotecaduoc.service.PrestamoService;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/prestamos")
@Validated
public class PrestamoController {
    @Autowired
    private PrestamoService prestamoService;

    @GetMapping
    public List<PrestamoModel> listarPrestamos() {
        return prestamoService.getPrestamos();
    }

    @GetMapping("{id}")
    public PrestamoModel buscarPrestamo(@PathVariable @Positive int id) {
        return prestamoService.getById(id);
    }
    @PostMapping
    public PrestamoModel agregarPrestamo(@RequestBody PrestamoModel prestamo) {
        return prestamoService.savePrestamo(prestamo);
    }

    @PutMapping("{id}")
    public PrestamoModel actualizarPrestamo(@PathVariable int id, @RequestBody PrestamoModel prestamo) {
        //mas adelante
        return prestamoService.updatePrestamo(prestamo);
    }

    @DeleteMapping("{id}")
    public String eliminarPrestamo(@PathVariable int id) {
        return prestamoService.deletePrestamo(id);
    }
}
