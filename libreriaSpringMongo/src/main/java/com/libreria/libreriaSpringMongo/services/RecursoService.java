package com.libreria.libreriaSpringMongo.services;

import com.libreria.libreriaSpringMongo.DTOs.RecursoDTO;
import com.libreria.libreriaSpringMongo.collections.Recurso;
import com.libreria.libreriaSpringMongo.mappers.RecursoMapper;
import com.libreria.libreriaSpringMongo.repositories.RecursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;

@Service
public class RecursoService {
    @Autowired
    RecursoRepository repository;
    RecursoMapper mapper = new RecursoMapper();

    public List<RecursoDTO> obtenerTodosLosRecursos() {
        List<Recurso> empleados = (List<Recurso>) repository.findAll();
        return mapper.fromCollectionList(empleados);
    }

    public String consultarDisponibilidadPorId(String id) {
        Recurso recurso = repository.findById(id).orElseThrow(() -> new RuntimeException("Ese recurso no se encuentra en el inventario"));
        if(recurso.isPrestado()){
            return "Dicho recurso se encuentra prestado";
        }return "Dicho recurso se encuentra disponible";
    }

    public List<RecursoDTO> obtenerTodosRecursos(){
        List<Recurso> recursos = (List<Recurso>) repository.findAll();
        return mapper.fromCollectionList(recursos);
    }

    public RecursoDTO obtenerPorId(String id){
        Objects.requireNonNull(id);
        Recurso recurso = repository.findById(id).orElseThrow(() -> new RuntimeException("Recurso no encontrado"));
        return mapper.fromCollection(recurso);
    }

    public RecursoDTO obtenerPorName(String name){
        Objects.requireNonNull(name);
        Recurso recurso = repository.findByName(name);
        return mapper.fromCollection(recurso);
    }


    public RecursoDTO crearRecurso(RecursoDTO recursoDTO){
        Recurso recurso = mapper.fromDTO(recursoDTO);
        //recurso.setEnPrestamo(false);
        return mapper.fromCollection(repository.save(recurso));
    }

    public RecursoDTO editarRecurso(RecursoDTO recursoDTO){
        Recurso recurso = mapper.fromDTO(recursoDTO);
        repository.findById(recurso.getIdRecurso()).orElseThrow(() -> new RuntimeException("Recurso no encontrado"));
        return mapper.fromCollection(repository.save(recurso));
    }

    public String borrarRecurso(String id){
        repository.deleteById(id);
        return "El recurso ha sido eliminado satisfactoriamente";
    }

    public String devolverRecurso(String id) {
        Recurso recurso = repository.findById(id).orElseThrow(() -> new RuntimeException("Ese recurso no se encuentra en el inventario"));
        if(recurso.isPrestado()){
            recurso.setPrestado(false);
            recurso.setFechaPrestamo("");
            repository.save(recurso);
            return "Se ha devuelto el recurso";
        }return "Ese recurso no se encuentra prestado";
    }

    public String prestarRecurso(String id){
        Recurso recurso = repository.findById(id).orElseThrow(() -> new RuntimeException("Ese recurso no se encuentra en el inventario"));
        if(!recurso.isPrestado()){
            recurso.setPrestado(true);
            LocalDate date = LocalDate.now();
            DateTimeFormatter formatters = DateTimeFormatter.ofPattern("d/MM/uuuu");
            String text = date.format(formatters);
            recurso.setFechaPrestamo(text);
            repository.save(recurso);
            return "Se ha prestado el recurso exitosamente";
        }
        return "El recurso consultado ya se encuentra prestado";
    }

}
