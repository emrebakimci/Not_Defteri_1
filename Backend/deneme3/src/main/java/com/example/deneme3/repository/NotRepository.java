package com.example.deneme3.repository;

import com.example.deneme3.model.Not;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NotRepository extends MongoRepository<Not, String> {
}
