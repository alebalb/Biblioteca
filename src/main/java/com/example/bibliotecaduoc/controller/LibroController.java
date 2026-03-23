package com.example.bibliotecaduoc.controller;

import com.example.bibliotecaduoc.model.LibroModel;
import com.example.bibliotecaduoc.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/libros")
public class LibroController {
    @Autowired
    private LibroService libroService;

    @GetMapping
    public List<LibroModel> listarLibros() {
        return libroService.getLibros();
    }

    @GetMapping("{id}")
    public LibroModel buscarLibro(@PathVariable int id) {
        return libroService.getById(id);
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
}
