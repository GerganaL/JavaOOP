package designPatterns.singleton01;

import java.util.Map;

public interface SingletonContainer {
    int getPopulation(Map<String, Integer> populations, String name);
    Map<String, Integer> getCounter();
}
