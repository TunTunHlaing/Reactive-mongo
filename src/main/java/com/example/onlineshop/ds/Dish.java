package com.example.onlineshop.ds;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
public class Dish {

    private String name;
    private String description;
    private boolean delivered =false;


    public Dish(String description) {
        this.description = description;
    }

    public static Dish deliver(Dish dish){
        Dish deliveredDish = new Dish(dish.description);
        deliveredDish.delivered = true;
        return deliveredDish;
    }
}
