//package com.example.taco_cloud.controller;
//
//import com.example.taco_cloud.domain.Taco;
//import com.example.taco_cloud.repository.TacoRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PatchMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseStatus;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.Optional;
//
//@RestController
//@RequestMapping(path = "/api/tacos",
//        produces = "application/json")
//@CrossOrigin(origins = "http://tacocloud:8080")
//public class TacoController {
//
//    private TacoRepository tacoRepository;
//
//    @Autowired
//    public TacoController(TacoRepository tacoRepository) {
//        this.tacoRepository = tacoRepository;
//    }
//
//    @GetMapping(params = "recent")
//    public Iterable<Taco> recentTacos() {
//        Pageable pageRequest = PageRequest.of(
//                0, 2, Sort.by("createdAt").descending()
//        );
//
//        return tacoRepository.findAll(pageRequest);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Taco> tacoById(@PathVariable Long id) {
//        Optional<Taco> taco = tacoRepository.findById(id);
//
//        if (taco.isPresent()) {
//            return new ResponseEntity<>(
//                    taco.get(),
//                    HttpStatus.OK
//            );
//        }
//
//        return new ResponseEntity<>(
//                null,
//                HttpStatus.NOT_FOUND
//        );
//    }
//
//    @PostMapping(consumes = "application/json")
//    @ResponseStatus(HttpStatus.CREATED)
//    public Taco postTaco(
//            @RequestBody Taco taco
//    ) {
//        return tacoRepository.save(taco);
//    }
//}
