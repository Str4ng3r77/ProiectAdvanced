package com.example.proiect_adv;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class MatterieController {

    private final MaterieRpository repository;
    private final MateriiModelAssembler assembler;

    MatterieController(MaterieRpository repository, MateriiModelAssembler assembler) {
        this.repository = repository;

        this.assembler = assembler;
    }


    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/materii")
    CollectionModel<EntityModel<Materie>> all() {

        List<EntityModel<Materie>> materii = repository.findAll().stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(materii, linkTo(methodOn(MatterieController.class).all()).withSelfRel());
    }
    // end::get-aggregate-root[]

    @PostMapping("/materii")
    Materie NewMaterie(@RequestBody Materie NewMaterie) {
        return repository.save(NewMaterie);
    }

    // Single item

    @GetMapping("/materii/{id}")
    EntityModel<Materie> one(@PathVariable Long id) {

        Materie materie = repository.findById(id) //
                .orElseThrow(() -> new MaterieNotFoundException(id));

        return assembler.toModel(materie);
    }

    @PutMapping("/materii/{id}")
    Materie replacematerie(@RequestBody Materie newMaterie, @PathVariable Long id) {

        return repository.findById(id)
                .map(materie -> {
                    materie.setName(newMaterie.getName());
                    materie.setDiff(newMaterie.getDiff());
                    return repository.save(materie);
                })
                .orElseGet(() -> {
                    newMaterie.setId(id);
                    return repository.save(newMaterie);
                });
    }

    @DeleteMapping("/materii/{id}")
    void deleteMaterie(@PathVariable Long id) {
        repository.deleteById(id);
    }
}