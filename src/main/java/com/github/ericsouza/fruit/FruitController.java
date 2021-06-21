package com.github.ericsouza.fruit;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.transaction.Transactional;

@Controller("/fruit")
public class FruitController {
    private final FruitRepository fruitRepository;

    public FruitController(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

     // tag::create[]
    @Post("/")
    @Transactional
    Mono<Fruit> create(@Valid Fruit Fruit) {
        return fruitRepository.save(Fruit);
    }
    // end::create[]

    // tag::read[]
    @Get("/")
    Flux<Fruit> all() {
        return fruitRepository.findAll(); // <1>
    }

    @Get("/{id}")
    Mono<Fruit> show(Long id) {
        return fruitRepository.findById(id); // <2>
    }
}