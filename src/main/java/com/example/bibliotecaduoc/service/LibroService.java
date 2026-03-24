package com.example.bibliotecaduoc.service;

import com.example.bibliotecaduoc.model.LibroModel;
import com.example.bibliotecaduoc.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroService {
    @Autowired
    private LibroRepository libroRepository;

    public List<LibroModel> getLibros() {
        return libroRepository.obtenerLibros();
    }

    public LibroModel saveLibro(LibroModel libro) {
        return libroRepository.guardar(libro);
    }

    public LibroModel getById(int id) {
        return libroRepository.buscarPorId(id);
    }

    public LibroModel getByIsbn(String isbn) {
        return libroRepository.buscarPorIsbn(isbn);
    }

    public List<LibroModel> getByAutor(String autor) {
        return libroRepository.buscarPorAutor(autor);
    }

    public List<LibroModel> getByYear(int year) {
        return libroRepository.buscarPorAnno(year);
    }

    public LibroModel getByOld() {
        return libroRepository.libroMasAntiguo();
    }

    public LibroModel getByNew() {
        return libroRepository.libroMasNuevo();
    }

    public List<LibroModel> getByOrder(int order) {
        return libroRepository.libroOrdenado(order);
    }

    public LibroModel updateLibro(LibroModel libro) {
        return libroRepository.actualizar(libro);
    }

    public String deleteLibro(int id) {
        libroRepository.eliminar(id);
        return "Libro eliminado";
    }

    //Esta es la forma correcta para respetar la funcion de cada capa
    public int totalLibrosV1() {
        return libroRepository.obtenerLibros().size();
    }

    public int totalLibrosV2() {
        return libroRepository.totalLibros();
    }
}
