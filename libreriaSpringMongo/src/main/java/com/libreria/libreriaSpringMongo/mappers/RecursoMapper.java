package com.libreria.libreriaSpringMongo.mappers;

import com.libreria.libreriaSpringMongo.DTOs.RecursoDTO;
import com.libreria.libreriaSpringMongo.collections.Recurso;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RecursoMapper {
    public Recurso fromDTO(RecursoDTO dto) {
        Recurso recurso = new Recurso();
        recurso.setIdRecurso(dto.getIdRecurso());
        recurso.setNombreRecurso(dto.getNombreRecurso());
        recurso.setEstadoRecurso(dto.getEstadoRecurso());
        recurso.setFechaPrestamo(dto.getFechaPrestamo());
        return recurso;
    }

    public RecursoDTO fromCollection(Recurso collection){
        RecursoDTO recursoDTO = new RecursoDTO();
        recursoDTO.setIdRecurso(collection.getIdRecurso());
        recursoDTO.setNombreRecurso(collection.getNombreRecurso());
        recursoDTO.setEstadoRecurso(collection.getEstadoRecurso());
        recursoDTO.setFechaPrestamo(collection.getFechaPrestamo());
        return recursoDTO;
    }

    public List<RecursoDTO> fromCollectionList(List<Recurso> collection) {
        if (collection == null) {
            return null;

        }
        List<RecursoDTO> list = new ArrayList(collection.size());

        for (Recurso recurso : collection) {
            list.add(fromCollection(recurso));
        }

        return list;
    }
}
