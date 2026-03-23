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

    public LibroModel getByIsbn(String isbn) {
        return libroReposiroty.buscarPorIsbn(isbn);
    }

    public List<LibroModel> getByAutor(String autor) {
        return libroReposiroty.buscarPorAutor(autor);
    }

    public List<LibroModel> getByYear(int year) {
        return libroReposiroty.buscarPorAnno(year);
    }

    public LibroModel getByOld() {
        return libroReposiroty.libroMasAntiguo();
    }

    public LibroModel getByNew() {
        return libroReposiroty.libroMasNuevo();
    }

    public List<LibroModel> getByOrder(int order) {
        return libroReposiroty.libroOrdenado(order);
    }

    public LibroModel updateLibro(LibroModel libro) {
        return libroReposiroty.actualizar(libro);
    }

    public String deleteLibro(int id) {
        libroReposiroty.eliminar(id);
        return "Libro eliminado";
    }

    //Esta es la forma correcta para respetar la funcion de cada capa
    public int totalLibrosV1() {
        return libroReposiroty.obtenerLibros().size();
    }

    public int totalLibrosV2() {
        return libroReposiroty.totalLibros();
    }
}
