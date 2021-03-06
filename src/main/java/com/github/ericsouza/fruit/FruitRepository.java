package com.github.ericsouza.fruit;

import io.micronaut.core.annotation.NonNull;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.r2dbc.annotation.R2dbcRepository;
import io.micronaut.data.repository.reactive.ReactiveStreamsCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@R2dbcRepository(dialect = Dialect.POSTGRES) // <1>
public interface FruitRepository extends ReactiveStreamsCrudRepository<Fruit, Long> {
    @NonNull
    @Override
    Mono<Fruit> findById(@NonNull @NotNull Long id); // <2>

    @NonNull
    @Override
    Flux<Fruit> findAll();

    // tag::mandatory[]
    @NonNull
    @Override
    @Transactional(Transactional.TxType.MANDATORY)
    <S extends Fruit> Mono<S> save(@NonNull @Valid @NotNull S entity);
}