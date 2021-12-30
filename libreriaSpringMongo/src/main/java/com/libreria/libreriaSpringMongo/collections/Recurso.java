package com.libreria.libreriaSpringMongo.collections;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Recurso {
    @Id
    private String idRecurso;
    private String nombreRecurso;
    private boolean isPrestado;
    private String fechaPrestamo;
    private final String[] tipoDeRecurso = {"Libro", "Revista", "Novela Visual"};
    private final String[] TematicaDelRecurso = {"Literatura", "Ciencia Ficcion", "Arte", "Cine", "Historia", "Comedia","Divulgacion cientifica"};


    public String getIdRecurso() {
        return idRecurso;
    }

    public void setIdRecurso(String idRecurso) {
        this.idRecurso = idRecurso;
    }

    public String getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(String fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public String getNombreRecurso() {
        return nombreRecurso;
    }

    public void setNombreRecurso(String nombreRecurso) {
        this.nombreRecurso = nombreRecurso;
    }

    public boolean isPrestado() {
        return isPrestado;
    }

    public void setPrestado(boolean prestado) {
        isPrestado = prestado;
    }

    public String[] getTipoDeRecurso() {
        return tipoDeRecurso;
    }

    public String[] getTematicaDelRecurso() {
        return TematicaDelRecurso;
    }
}
