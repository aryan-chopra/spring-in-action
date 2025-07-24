package com.example.taco_cloud.repository;

import com.example.taco_cloud.domain.Taco;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface TacoRepository extends CrudRepository<Taco, UUID> {
}
