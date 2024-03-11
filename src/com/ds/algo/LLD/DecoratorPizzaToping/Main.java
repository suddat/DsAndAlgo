package com.ds.algo.LLD.DecoratorPizzaToping;

import com.ds.algo.LLD.DecoratorPizzaToping.Model.BasePizza;
import com.ds.algo.LLD.DecoratorPizzaToping.Model.ExtraCheese;
import com.ds.algo.LLD.DecoratorPizzaToping.Model.FarmHousePizza;
import com.ds.algo.LLD.DecoratorPizzaToping.Model.Mushrooms;

public class Main {
    public static void main(String[] args) {
        BasePizza farmHouse = new FarmHousePizza();
        BasePizza pizza = new Mushrooms(new ExtraCheese(new FarmHousePizza()));

        System.out.println(pizza.cost());
    }
}
