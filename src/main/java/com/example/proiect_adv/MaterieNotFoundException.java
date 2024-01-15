package com.example.proiect_adv;
public class MaterieNotFoundException extends RuntimeException{
     MaterieNotFoundException (Long id){
        super("could not find materie" + id);
    }
}

