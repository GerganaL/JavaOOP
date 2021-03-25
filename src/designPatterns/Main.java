package designPatterns;

import designPatterns.singleton01.SingletonContainer;
import designPatterns.singleton01.SingletonData;

public class Main {
    public static void main(String[] args) {
        SingletonContainer singleton = SingletonData.getInstance();

        singleton.getCounter().put("Sofia",20000000);
        int sofia = singleton.getPopulation(singleton.getCounter(),"Sofia");
        System.out.println(sofia);
    }
}
