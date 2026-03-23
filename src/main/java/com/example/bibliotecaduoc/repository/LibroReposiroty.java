package com.example.bibliotecaduoc.repository;

import com.example.bibliotecaduoc.model.LibroModel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Repository
public class LibroReposiroty {
    private List<LibroModel> listaLibros = new ArrayList<>();

    public LibroReposiroty() {
        listaLibros.add(new LibroModel(1, "9789569646638", "Fuego y Sangre", "Penguin Random House Grupo Editorial", 2018, "George R. R. Martin"));
        listaLibros.add(new LibroModel(2, "9789563494150", "Quique Hache: El Mall Embrujado y Otras Historias", "Sm Ediciones", 2014, "Sergio Gomez"));
        listaLibros.add(new LibroModel(3, "9781484256251", "Spring Boot Persistence Best Practices", "Apress", 2020, "Anghel Leonard"));
        listaLibros.add(new LibroModel(4, "9789566075752", "Harry Potter y la piedra filosofal", "Salamandra", 2024, "J. K. Rowling"));
        listaLibros.add(new LibroModel(5, "9780439139601", "Harry Potter y el prisionero de Azkaban", "Scholastic", 1999, "J. K. Rowling"));
        listaLibros.add(new LibroModel(6, "9780439136365", "Harry Potter y el cáliz de fuego", "Scholastic", 2000, "J. K. Rowling"));
        listaLibros.add(new LibroModel(7, "9780321127426", "Effective Java", "Addison Wesley", 2008, "Joshua Bloch"));
        listaLibros.add(new LibroModel(8, "9780134685991", "Clean Architecture", "Prentice Hall", 2017, "Robert C. Martin"));
        listaLibros.add(new LibroModel(9, "9780201633610", "Design Patterns", "Addison Wesley", 1994, "Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides"));
        listaLibros.add(new LibroModel(10, "9780132350884", "Clean Code", "Prentice Hall", 2008, "Robert C. Martin"));
    }

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

    public List<LibroModel> buscarPorAutor(String autor) {
        List<LibroModel> librosAutor = new ArrayList<>();
        for (LibroModel libro : listaLibros) {
            if (libro.getAutor().equals(autor)) {
                librosAutor.add(libro);
            }
        }
        return librosAutor;
    }

    public List<LibroModel> buscarPorAnno(int anno) {
        List<LibroModel> librosAnno = new ArrayList<>();
        for (LibroModel libro : listaLibros) {
            if (libro.getFechaPublicacion() == anno) {
                librosAnno.add(libro);
            }
        }
        return librosAnno;
    }

    public LibroModel libroMasAntiguo() {
        LibroModel libro = new LibroModel();
        for (LibroModel libro1 : listaLibros) {
            libro = listaLibros.get(0);
            if (libro1.getFechaPublicacion() < libro.getFechaPublicacion()) {
                libro = libro1;
            }
        }
        return libro;
    }

    public LibroModel libroMasNuevo() {
        LibroModel libro = new LibroModel();
        for (LibroModel libro1 : listaLibros) {
            libro = listaLibros.get(0);
            if (libro1.getFechaPublicacion() > libro.getFechaPublicacion()) {
                libro = libro1;
            }
        }
        return libro;
    }

    //Consultar si este condicional va acá o en la capa de Service
    public List<LibroModel> libroOrdenado(int orden) {
        List<LibroModel> ordenado = new ArrayList<>();
        if (orden == 0) {
            listaLibros.sort(Comparator.comparing(LibroModel::getFechaPublicacion));
        } else if (orden == 1) {
            listaLibros.sort(Comparator.comparing(LibroModel::getFechaPublicacion).reversed());
        }
        return listaLibros;
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

    public int totalLibros() {
        return listaLibros.size();
    }
}
