package com.example.bibliotecaduoc.repository;

import com.example.bibliotecaduoc.model.LibroModel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LibroReposiroty {
    private List<LibroModel> listaLibros = new ArrayList<>();

    public List<LibroModel> obtenerLibros() {
        return listaLibros;
    }

    public LibroModel buscarPorId(int id) {
        for (LibroModel libro : listaLibros) {
            if (libro.getId() == id) {
                return libro;
            }
        }
        return null;
    }

    public LibroModel buscarPorIsbn(String isbn) {
        for (LibroModel libro : listaLibros) {
            if (libro.getIsbn().equals(isbn)) {
                return libro;
            }
        }
        return null;
    }

    public LibroModel guardar(LibroModel libro) {
        this.listaLibros.add(libro);
        return libro;
    }

    public LibroModel actualizar(LibroModel libro) {
        int id = 0;
        int idPosicion = 0;

        for (int i = 0; i < listaLibros.size(); i++) {
            if (listaLibros.get(i).getId() == libro.getId()) {
                id = libro.getId();
                idPosicion = i;
            }
        }
        LibroModel lib = new LibroModel();
        lib.setId(id);
        lib.setTitulo(libro.getTitulo());
        lib.setAutor(libro.getAutor());
        lib.setFechaPublicacion(libro.getFechaPublicacion());
        lib.setEditorial(libro.getEditorial());
        lib.setIsbn(libro.getIsbn());

        listaLibros.set(idPosicion, lib);
        return lib;
    }

    public void eliminar(int id) {
        LibroModel lib = buscarPorId(id);
        if (lib != null) {
            listaLibros.remove(lib);
        }
    }
}
