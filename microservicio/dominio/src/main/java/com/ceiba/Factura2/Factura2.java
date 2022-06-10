package com.ceiba.Factura2;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table
public class Factura2 {
    @Id
    private int idFactura;
    //private LocalDate fechaActual;
    private int total;
    private BigDecimal totalAPagar;

    public Factura2() {
    }
}