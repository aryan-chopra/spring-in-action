package com.example.taco_cloud.repository;

import com.example.taco_cloud.domain.Taco;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TacoRepository extends CrudRepository<Taco, Long> {

    List<Taco> findAll(Pageable pageRequest);
}
