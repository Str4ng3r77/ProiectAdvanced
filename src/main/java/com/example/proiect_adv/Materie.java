package com.example.proiect_adv;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Materie {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private int diff;
    private boolean obligatoriu;
    private Dificultate difficulty;
    private int time;

    public Materie() {
    }

    public Materie(long id, String name, int diff, boolean obligatoriu, Dificultate difficulty, int time) {
        this.id = id;
        this.name = name;
        this.diff = diff;
        this.obligatoriu = obligatoriu;
        this.difficulty = difficulty;
        this.time = time;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDiff() {
        return diff;
    }

    public void setDiff(int diff) {
        this.diff = diff;
    }

    public boolean isObligatoriu() {
        return obligatoriu;
    }

    public void setObligatoriu(boolean obligatoriu) {
        this.obligatoriu = obligatoriu;
    }

    public Dificultate getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Dificultate difficulty) {
        this.difficulty = difficulty;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Materie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", diff=" + diff +
                ", obligatoriu=" + obligatoriu +
                ", difficulty=" + difficulty +
                ", time=" + time +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Materie materie = (Materie) o;
        return id == materie.id && diff == materie.diff && obligatoriu == materie.obligatoriu && time == materie.time && Objects.equals(name, materie.name) && difficulty == materie.difficulty;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, diff, obligatoriu, difficulty, time);
    }
}
