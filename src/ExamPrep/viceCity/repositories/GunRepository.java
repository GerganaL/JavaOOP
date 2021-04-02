package ExamPrep.viceCity.repositories;

import ExamPrep.viceCity.models.guns.Gun;
import ExamPrep.viceCity.repositories.interfaces.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;


public class GunRepository implements Repository {
    private Collection<Gun> models;

    public GunRepository() {
        this.models = new ArrayList<Gun>();
    }


    @Override
    public Collection getModels() {
        return Collections.unmodifiableCollection(this.models);
    }

    @Override
    public void add(Object model) {
        if (!this.models.contains(model)) {
            this.models.add((Gun) model);
        }
    }

    @Override
    public boolean remove(Object model) {
        return this.models.remove(model);
    }

    @Override
    public Object find(String name) {
        return this.models.stream().filter(e -> e.getName().equals(name)).findFirst().orElse(null);
    }


}
