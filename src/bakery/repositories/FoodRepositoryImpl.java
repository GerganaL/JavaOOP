package bakery.repositories;

import bakery.entities.bakedFoods.interfaces.BakedFood;
import bakery.repositories.interfaces.FoodRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class FoodRepositoryImpl implements FoodRepository<BakedFood> {

    private Collection<BakedFood> models;

    public FoodRepositoryImpl() {
        this.models = new ArrayList<>();
    }

    @Override
    public BakedFood getByName(String name) {
        for (BakedFood model : models) {
            if(model.getName().equals(name)){
                return model;
            }
        }
        return null;
    }

    @Override
    public Collection<BakedFood> getAll() {
        return this.models;
    }

    @Override
    public void add(BakedFood bakedFood) {
        if(bakedFood != null) {
            models.add(bakedFood);
        }
    }

}
