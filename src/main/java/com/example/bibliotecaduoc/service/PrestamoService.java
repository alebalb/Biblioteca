package com.example.bibliotecaduoc.service;

import com.example.bibliotecaduoc.model.PrestamoModel;
import com.example.bibliotecaduoc.repository.PrestamoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrestamoService {
    @Autowired
    private PrestamoRepository prestamoRepository;

    public List<PrestamoModel> getPrestamos() {
        return prestamoRepository.obtenerPrestamos();
    }

    public PrestamoModel savePrestamo(PrestamoModel libro) {
        return prestamoRepository.guardar(libro);
    }

    public PrestamoModel getById(int id) {
        return prestamoRepository.buscarPorId(id);
    }

    public PrestamoModel updatePrestamo(PrestamoModel libro) {
        return prestamoRepository.actualizar(libro);
    }

    public String deletePrestamo(int id) {
        prestamoRepository.eliminar(id);
        return "Prestamo eliminado";
    }
}
