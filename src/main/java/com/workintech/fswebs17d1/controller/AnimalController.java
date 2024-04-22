package com.workintech.fswebs17d1.controller;

import com.workintech.fswebs17d1.entity.Animal;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/workintech/animal")
public class AnimalController {
    Map<Integer, Animal> animals;

    @Value("${project.developer.fullanme}")
    private String fullName;

    @Value("${course.name}")
    private String courseName;

    //Uygulama çalışırken animal ekleme.
    @PostConstruct
    public void loadAll(){
        this.animals = new HashMap<>();
        this.animals.put(1,new Animal(1,"maymun"));
    }


    //1.[GET]/workintech/animal => tüm animal mapinin value değerlerini List olarak döner.
    @GetMapping
    public List<Animal> getAnimals(){
        return new ArrayList<>(this.animals.values());
    }

    //2.[GET]/workintech/animal/{id} => ilgili id deki animal mapte varsa value değerini döner.
    @GetMapping("{id}")
    public Animal getAnimal(@PathVariable("id") int id){
        return this.animals.get(id);
    }

    //[POST]/workintech/animal => integer id ve String name değerlerini alır ve animals mapine ekler.
    @PostMapping
    public void addAnimal(@RequestBody Animal animal){
        this.animals.put(animal.getId(),animal);
    }

    //[PUT]/workintech/animal/{id} => İlgili id deki map değerini Request Body içerisinden aldığı id değeri ile günceller.
    @PutMapping("{id}")
    public Animal update(@PathVariable("id") int id,@RequestBody Animal newAnimal){
        this.animals.replace(id,newAnimal);
        return this.animals.get(id);
    }

    //[DELETE]/workintech/animal/{id} => İlgili id değerini mapten siler.
    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        this.animals.remove(id);
     }
    }

