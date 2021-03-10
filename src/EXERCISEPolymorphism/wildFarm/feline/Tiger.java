package EXERCISEPolymorphism.wildFarm.feline;

import EXERCISEPolymorphism.wildFarm.food.Food;
import EXERCISEPolymorphism.wildFarm.food.Vegetable;

public class Tiger extends  Felime{

    public Tiger(String animalName, String animalType, Double animalWeight, String animalRegion) {
        super (animalName, animalType, animalWeight, animalRegion);
    }

    @Override
    protected
    void makeSound () {
        System.out.println ("ROAAR!!!");
    }

    @Override
    protected
    void eat (Food food) {
        if (food instanceof Vegetable) {
            throw new IllegalArgumentException(
                    "Tigers are not eating that type of food!");
        }
        super.eat(food);
    }
}
