package com.example.demo.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.entidad.Producto;
import com.example.demo.model.repository.ProductoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductoServiceImpl implements ProductoService {
    private final ProductoRepository productoRepository;

    @Override
    public List<Producto> listarProductos() {
        return productoRepository.findAll();
    }

}
