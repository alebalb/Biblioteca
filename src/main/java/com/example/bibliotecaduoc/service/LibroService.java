package com.example.bibliotecaduoc.service;

import com.example.bibliotecaduoc.model.LibroModel;
import com.example.bibliotecaduoc.repository.LibroReposiroty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroService {
    @Autowired
    private LibroReposiroty libroReposiroty;

    public List<LibroModel> getLibros() {
        return libroReposiroty.obtenerLibros();
    }

    public LibroModel saveLibro(LibroModel libro) {
        return libroReposiroty.guardar(libro);
    }

    public LibroModel getById(int id) {
        return libroReposiroty.buscarPorId(id);
    }

    public LibroModel updateLibro(LibroModel libro) {
        return libroReposiroty.actualizar(libro);
    }

    public String deleteLibro(int id) {
        libroReposiroty.eliminar(id);
        return "Libro eliminado";
    }
}
