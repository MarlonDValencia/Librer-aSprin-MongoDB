package com.libreria.libreriaSpringMongo.DTOs;

public class RecursoDTO {
    private String idRecurso;
    private String nombreRecurso;
    private String estadoRecurso;
    private String fechaPrestamo;
    private final String[] tipoDeRecurso = {"Libro", "Revista", "Novela Visual"};
    private final String[] TematicaDelRecurso = {"Literatura", "Ciencia Ficcion", "Arte", "Cine", "Historia", "Comedia","Divulgacion cientifica"};

    public String getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(String fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public String getIdRecurso() {
        return idRecurso;
    }

    public void setIdRecurso(String idRecurso) {
        this.idRecurso = idRecurso;
    }

    public String getNombreRecurso() {
        return nombreRecurso;
    }

    public void setNombreRecurso(String nombreRecurso) {
        this.nombreRecurso = nombreRecurso;
    }

    public String getEstadoRecurso() {
        return estadoRecurso;
    }

    public void setEstadoRecurso(String estadoRecurso) {
        this.estadoRecurso = estadoRecurso;
    }

    public String[] getTipoDeRecurso() {
        return tipoDeRecurso;
    }

    public String[] getTematicaDelRecurso() {
        return TematicaDelRecurso;
    }
}
