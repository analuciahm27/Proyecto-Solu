package com.example.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.entidad.Producto;
import com.example.demo.model.service.ProductoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/productos")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class ProductoController {
private final ProductoService service;

@GetMapping("/")
    public ResponseEntity<List<Producto>> cargarVentas() {
        return ResponseEntity.ok(service.listarProductos());
    }
}
