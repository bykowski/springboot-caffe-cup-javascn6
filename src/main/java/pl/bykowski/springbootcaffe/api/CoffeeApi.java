package pl.bykowski.springbootcaffe.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.*;
import pl.bykowski.springbootcaffe.entity.Cafeteria;
import pl.bykowski.springbootcaffe.entity.Coffee;
import pl.bykowski.springbootcaffe.entity.Cup;
import pl.bykowski.springbootcaffe.entity.Size;
import pl.bykowski.springbootcaffe.repository.CafeteriaRepo;
import pl.bykowski.springbootcaffe.repository.CoffeeRepo;
import pl.bykowski.springbootcaffe.repository.CupRepo;

import java.util.Arrays;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api")
public class CoffeeApi {

    private CoffeeRepo coffeeRepo;
    private CupRepo cupRepo;
    private CafeteriaRepo cafeteriaRepo;

    @Autowired
    public CoffeeApi(CoffeeRepo coffeeRepo, CupRepo cupRepo, CafeteriaRepo cafeteriaRepo) {
        this.coffeeRepo = coffeeRepo;
        this.cupRepo = cupRepo;
        this.cafeteriaRepo = cafeteriaRepo;
    }

    @GetMapping
    public Iterable<Coffee> getCoffes() {
        return coffeeRepo.findAll();
    }

    @PostMapping
    public void addCoffee(@RequestBody Coffee coffee)
    {
        coffeeRepo.save(coffee);
    }

    @DeleteMapping
    public void removeCoffe(@RequestParam Long id) {
        coffeeRepo.deleteById(id);
    }

    @PutMapping
    public void putCoffee(@RequestBody Coffee coffee)
    {
        Optional<Coffee> element = coffeeRepo.findById(coffee.getId());
        if(element.isPresent())
        {
            coffeeRepo.save(coffee);
        }
    }

    @EventListener(ApplicationReadyEvent.class)
    public void get() {

        // save cup
        Cup cupBig = new Cup(Size.BIG);
        Cup cupSmall = new Cup(Size.SMALL);
        cupRepo.save(cupBig);
        cupRepo.save(cupSmall);

        // save cafeteriaRepo
        Cafeteria cafeteria = new Cafeteria();
        cafeteria.setAdress("Kolumba 86");
        cafeteria.setName("Ceglanka");
        cafeteriaRepo.save(cafeteria);

        // save coffe
        Coffee coffeePrima = new Coffee("Prima", "Black");
        Coffee coffeeInka = new Coffee("Inka", "Cereal coffee");
        coffeePrima.setCup(cupBig);
        coffeePrima.setCafeteria(cafeteria);
        coffeeInka.setCup(cupSmall);
        coffeeInka.setCafeteria(cafeteria);
        coffeeRepo.save(coffeePrima);
        coffeeRepo.save(coffeeInka);
    }
}
