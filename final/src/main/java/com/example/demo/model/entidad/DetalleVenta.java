package com.example.demo.model.entidad;

import jakarta.persistence.*;

@Entity
@Table(name = "detalle_venta")
public class DetalleVenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer cantidad;

    private Double subtotal;

    @ManyToOne()
    @JoinColumn(name = "id_venta", nullable = false)
    private Venta venta;

    @ManyToOne()
    @JoinColumn(name = "id_producto", nullable = false)
    private Producto producto;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getSubtotal() {
        return subtotal;
    }
    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Venta getVenta() {
        return venta;
    }
    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public Producto getProducto() {
        return producto;
    }
    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}
