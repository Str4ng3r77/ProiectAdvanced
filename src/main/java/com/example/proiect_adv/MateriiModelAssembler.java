package com.example.proiect_adv;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
class MateriiModelAssembler implements RepresentationModelAssembler<Materie, EntityModel<Materie>> {

    @Override
    public EntityModel<Materie> toModel(Materie materie) {

        return EntityModel.of(materie, //
                linkTo(methodOn(MatterieController.class).one(materie.getId())).withSelfRel(),
                linkTo(methodOn(MatterieController.class).all()).withRel("materii"));
    }
}