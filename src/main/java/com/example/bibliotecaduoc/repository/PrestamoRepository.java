package com.example.bibliotecaduoc.repository;

import com.example.bibliotecaduoc.model.PrestamoModel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PrestamoRepository {
    private List<PrestamoModel> listaPrestamos = new ArrayList<>();


    public List<PrestamoModel> obtenerPrestamos() {
        return listaPrestamos;
    }

    public PrestamoModel buscarPorId(int id) {
        for (PrestamoModel prestamo : listaPrestamos) {
            if (prestamo.getIdPrestamo() == id) {
                return prestamo;
            }
        }
        return null;
    }

    public PrestamoModel guardar(PrestamoModel prestamo) {
        this.listaPrestamos.add(prestamo);
        return prestamo;
    }

    public PrestamoModel actualizar(PrestamoModel prestamo) {
        int id = 0;
        int idPosicion = 0;

        for (int i = 0; i < listaPrestamos.size(); i++) {
            if (listaPrestamos.get(i).getIdPrestamo() == prestamo.getIdPrestamo()) {
                id = prestamo.getIdPrestamo();
                idPosicion = i;
            }
        }
        PrestamoModel pres = new PrestamoModel();
        pres.setIdPrestamo(id);
        pres.setIdLibro(prestamo.getIdLibro());
        pres.setRunSolicitante(prestamo.getRunSolicitante());
        pres.setFechaSolicitud(prestamo.getFechaSolicitud());
        pres.setFechaEntrega(prestamo.getFechaEntrega());
        pres.setCantidadDias(prestamo.getCantidadDias());
        pres.setMultas(prestamo.getMultas());

        listaPrestamos.set(idPosicion, pres);
        return pres;
    }

    public void eliminar(int id) {
        PrestamoModel pre = buscarPorId(id);
        if (pre != null) {
            listaPrestamos.remove(pre);
        }
    }
}
