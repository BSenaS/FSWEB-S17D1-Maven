package com.workintech.fswebs17d1.controller;

import com.workintech.fswebs17d1.entity.Animal;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class AnimalController {
    Map<Integer, Animal> animals = new HashMap<>();


    //1.Get isteği
    @GetMapping("/workintech/animal")
    public List<Animal> getAnimals(){
        return animals.values().stream().toList();
    }

    @GetMapping("/workintech/animal/{id}")
    public Animal getAnimalById(@PathVariable int id){
        if(animals.containsKey(id)){
            return animals.get(id);
        } else {
            return null;
        }
    }

    @PutMapping("/workintech/animal/{id}")
    public Animal update(@PathVariable int id,@RequestBody Animal animal){
        animals.put(id,new Animal(id,animal.getName()));
        return animal;
    }

    @DeleteMapping("/workintech/animal/{id}")
    public Animal delete(@PathVariable int id){
        Animal animal=animals.get(id);
        animals.remove(id,animal);
        return animal;
     }
    }

