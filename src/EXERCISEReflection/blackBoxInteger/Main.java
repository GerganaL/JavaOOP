package EXERCISEReflection.blackBoxInteger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class Main {
    public static void main(String[] args) throws IOException {

        Class<BlackBoxInt> clazz = BlackBoxInt.class;
        BlackBoxInt blackBoxInt;

        try {
            Constructor<BlackBoxInt> constructor = clazz.getDeclaredConstructor(int.class);
            constructor.setAccessible(true);
            blackBoxInt = constructor.newInstance(0);
            System.out.println();
        } catch (NoSuchMethodException
                | IllegalAccessException
                | InstantiationException
                | InvocationTargetException e) {
            throw new IllegalStateException(e);
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));



        String input = reader.readLine();
        while (!input.equals("END")) {
            String[] tokens = input.split("_");
            String methodName = tokens[0];
            int parameter = Integer.parseInt(tokens[1]);

            try {
                Method method = clazz.getDeclaredMethod(methodName, int.class);
                method.setAccessible(true);
                method.invoke(blackBoxInt,parameter);

                Field field = clazz.getDeclaredField("innerValue");
                field.setAccessible(true);
                System.out.println(field.get(blackBoxInt));


            } catch (NoSuchMethodException
                    | IllegalAccessException
                    | InvocationTargetException
                    | NoSuchFieldException e) {
                throw new IllegalStateException(e);
            }

            input = reader.readLine();
        }
    }
}
