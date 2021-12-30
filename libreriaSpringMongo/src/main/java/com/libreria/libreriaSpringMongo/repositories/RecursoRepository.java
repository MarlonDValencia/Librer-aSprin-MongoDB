package com.libreria.libreriaSpringMongo.repositories;

import com.libreria.libreriaSpringMongo.collections.Recurso;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RecursoRepository extends MongoRepository<Recurso, String> {
    Recurso findByName(String name);
}
