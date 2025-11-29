package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.entidad.Venta;
import com.example.demo.model.service.VentaService;

@RestController
@RequestMapping("/api/ventas")
@CrossOrigin(origins = "http://localhost:4200")
public class VentaController {

    private final VentaService service;

    public VentaController(VentaService service) {
        this.service = service;
    }

    @GetMapping("/")
    public ResponseEntity<List<Venta>> cargarVentas() {
        return ResponseEntity.ok(service.listar());
    }

    @PostMapping("/guardar")
    public ResponseEntity<Venta> guardar(@RequestBody Venta venta) {
        Venta nuevaVenta = service.guardar(venta);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaVenta);
    }


    @GetMapping("/buscar/{id}")
    public ResponseEntity<Venta> buscar(@PathVariable Long id) {
        Venta venta = service.buscarPorId(id);

        if (venta == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.ok(venta);
    }
}
