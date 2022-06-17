package com.ceiba.planta.modelo.entidad;

public enum CategoriaPlanta {

    CACTUSYSUCULENTAS("Cactus y suculentas", "Plantas muy pequeñas para interiores"),
    PLANTASINTERIOR("Plantas interior", "Plantas medianas para tener dentro de casa"),
    PLANTASDEFLOR("Plantas de flor", "Plantas que producen flor de diversos colores"),
    PALMAS("Palmas", "Plantas de gran tamaño para exteriores"),
    AROMATICASYMEDICINALES("Aromaticas y medicinales", "Plantas pequeñas usadas para infusiones");

    private final String nombreCategoria;

    private final String descripcion;

    CategoriaPlanta(String nombreCategoria, String descripcion) {
        this.nombreCategoria = nombreCategoria;
        this.descripcion = descripcion;
    }
}
