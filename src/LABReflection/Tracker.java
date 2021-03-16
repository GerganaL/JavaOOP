package LABReflection;

import java.lang.reflect.Method;
import java.util.*;

public class Tracker {
    @Author(name = "Gigi")
    public static void printMethodsByAuthor(Class<?> clazz){
        Map<String, List<String>> methodsByAuthor = new HashMap<>();
        Method[] methods = clazz.getDeclaredMethods();


        for (Method method : methods) {
            Author annotation = method.getAnnotation(Author.class);
            if(annotation != null){
                methodsByAuthor.putIfAbsent(annotation.name(), new ArrayList<>());
                methodsByAuthor.get(annotation.name()).add(method.getName() + "()");
            }
        }

        methodsByAuthor.forEach((key, value) -> System.out.println(key + " " + value.toString()));

    }

}
