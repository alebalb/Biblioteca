package com.example.bibliotecaduoc.controller;

import com.example.bibliotecaduoc.model.LibroModel;
import com.example.bibliotecaduoc.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/libros")
@Validated
public class LibroController {
    @Autowired
    private LibroService libroService;

    @GetMapping
    public List<LibroModel> listarLibros() {
        return libroService.getLibros();
    }

    @GetMapping("{id}")
    public LibroModel buscarLibro(@PathVariable @Positive int id) {
        return libroService.getById(id);
    }

    @GetMapping("/buscar/isbn")
    public LibroModel buscarLibroIsbn(@RequestParam @NotBlank String isbn) {
        return libroService.getByIsbn(isbn);
    }

    @GetMapping("/buscar/autor")
    public List<LibroModel> buscarLibroAutor(@RequestParam @NotBlank String autor) {
        return libroService.getByAutor(autor);
    }

    @GetMapping(params = "year")
    public List<LibroModel> listarLibros(@RequestParam @Min(1900) @Max(2100) int year) {
        return libroService.getByYear(year);
    }

    @GetMapping("/viejo")
    public LibroModel buscarLibroAntiguo() {
        return libroService.getByOld();
    }

    @GetMapping("/nuevo")
    public LibroModel buscarLibroNuevo() {
        return libroService.getByNew();
    }

    @GetMapping("/buscar/ordenado")
    public List<LibroModel> buscarLibroOrdenado(@RequestParam int orden) {
        return libroService.getByOrder(orden);
    }

    @PostMapping
    public LibroModel agregarLibro(@RequestBody LibroModel libro) {
        return libroService.saveLibro(libro);
    }

    @PutMapping("{id}")
    public LibroModel actualizarLibro(@PathVariable int id, @RequestBody LibroModel libro) {
        //mas adelante
        return libroService.updateLibro(libro);
    }

    @DeleteMapping("{id}")
    public String eliminarLibro(@PathVariable int id) {
        return libroService.deleteLibro(id);
    }

    @GetMapping("/total")
    public int totalLibrosV2() {
        return libroService.totalLibrosV2();
    }
}
