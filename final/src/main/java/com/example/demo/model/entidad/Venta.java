package com.example.demo.model.entidad;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "venta")
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "metodo_pago")
    private String metodoPago;

    @Column(name = "monto_total")
    private Double montoTotal;

    @OneToMany(mappedBy = "venta", cascade = CascadeType.ALL)
    private List<DetalleVenta> detalles;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getMetodoPago() {
        return metodoPago;
    }
    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public Double getMontoTotal() {
        return montoTotal;
    }
    public void setMontoTotal(Double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public List<DetalleVenta> getDetalles() {
        return detalles;
    }
    public void setDetalles(List<DetalleVenta> detalles) {
        this.detalles = detalles;
    }
}
