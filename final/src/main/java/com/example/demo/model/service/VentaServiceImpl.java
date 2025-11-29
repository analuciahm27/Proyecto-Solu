package com.example.demo.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.entidad.DetalleVenta;
import com.example.demo.model.entidad.Producto;
import com.example.demo.model.entidad.Venta;
import com.example.demo.model.repository.ProductoRepository;
import com.example.demo.model.repository.VentaRepository;

@Service
public class VentaServiceImpl implements VentaService {

    private final VentaRepository ventaRepo;
    private final ProductoRepository productoRepo;

    public VentaServiceImpl(VentaRepository ventaRepo, ProductoRepository productoRepo) {
        this.ventaRepo = ventaRepo;
        this.productoRepo = productoRepo;
    }

    @Override
    public List<Venta> listar() {
        return ventaRepo.findAll();
    }

    @Override
    public Venta guardar(Venta venta) {

        double total = 0.0;

        if (venta.getDetalles() != null) {
            for (DetalleVenta det : venta.getDetalles()) {

                Producto productoBD = productoRepo.findById(det.getProducto().getId())
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con id: " + det.getProducto().getId()));
                det.setProducto(productoBD);
                double sub = productoBD.getPrecio() * det.getCantidad();
                det.setSubtotal(sub);
                det.setVenta(venta);

                total += sub;
            }
        }

        venta.setMontoTotal(total);

        return ventaRepo.save(venta);
    }

    @Override
    public Venta buscarPorId(Long id) {
        return ventaRepo.findById(id).orElse(null);
    }
}
