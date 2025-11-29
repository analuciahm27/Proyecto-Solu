package com.example.demo.model.service;

import java.util.List;

import com.example.demo.model.entidad.Venta;

public interface VentaService {
    List<Venta> listar();
    Venta guardar(Venta venta);
    Venta buscarPorId(Long id);
}
