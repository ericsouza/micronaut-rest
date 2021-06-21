package com.github.ericsouza.fruit;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;
import io.reactivex.Single;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Controller("/fruit")
public class FruitController {
    private final FruitRepository fruitRepository;

    public FruitController(fruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

     // tag::create[]
    @Post("/")
    Single<Fruit> create(@Valid Fruit Fruit) {
        return Single.fromPublisher(fruitRepository.save(Fruit));
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
    // end::read[]

    // tag::update[]
    @Put("/{id}")
    Single<Fruit> update(@NotNull Long id, @Valid Fruit Fruit) {
        return Single.fromPublisher(fruitRepository.update(Fruit));
    }
    // end::update[]

    // tag::delete[]
    @Delete("/{id}")
    Single<HttpResponse<?>> delete(@NotNull Long id) {
        return Single.fromPublisher(fruitRepository.deleteById(id))
                .map(deleted -> deleted > 0 ? HttpResponse.noContent() : HttpResponse.notFound());
    }
    // end::delete[]
}