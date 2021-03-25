package designPatterns.singleton01;

import java.util.HashMap;
import java.util.Map;

public class SingletonData implements SingletonContainer{
    private static SingletonData instance;
    private Map<String,Integer> counter;

    private SingletonData(){
        try {
            System.out.println("Simulate heavy work");
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.counter = new HashMap<>();
    }

    public static SingletonContainer getInstance(){
        if(instance == null){
            instance = new SingletonData();
        }
        return instance;
    }

    @Override
    public Map<String, Integer> getCounter() {
        return counter;
    }

    @Override
    public int getPopulation(Map<String, Integer> populations, String name) {
        return populations.get(name);
    }
}
