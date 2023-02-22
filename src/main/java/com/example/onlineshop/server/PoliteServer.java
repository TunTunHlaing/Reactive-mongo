package com.example.onlineshop.server;

import com.example.onlineshop.ds.Dish;
import com.example.onlineshop.service.KitchenService;
import reactor.core.publisher.Flux;

public class PoliteServer {

    private final KitchenService kitchenService;

    public PoliteServer(KitchenService kitchenService) {
        this.kitchenService = kitchenService;
    }

    public Flux<Dish> doingMyJob(){
        return this.kitchenService.getDishes()
                .doOnNext(dish -> System.out.println("Thank you for " + dish + " !"))
                .doOnError(error -> System.out.println("So sorry about " + error.getMessage()))
                .doOnComplete(() -> System.out.println("Thanks For All OF Your Hard Work!"))
                .map(Dish::deliver);
    }
}
