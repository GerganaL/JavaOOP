package EXERCISEReflection.harvestingFields;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;

public class Main {
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		/*String path = System.getProperty("user.dir") + "\\src\\harvestingFields";

		File dir = new File(path);

		File[] files = dir.listFiles();*/

		/*for (File file : files) {
			if(!file.getName().contains("Main")){
				Class<?> clazz = Class.forName("harvestingFields." + file.getName().replace(".java",""));

				System.out.println(clazz.getSimpleName());
			}
		}*/

		Class<?> clazz = RichSoilLand.class;


		List<Field> fields = Arrays.asList(clazz.getDeclaredFields());


		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		String input = reader.readLine();

		StringBuilder output = new StringBuilder();

		while (!input.equals("HARVEST")){

			String modifier = input;
			fields.stream()
					.filter(f -> Modifier.toString(f.getModifiers()).equals(modifier)
					|| modifier.equals("all"))
					.forEach(f -> output.append(String.format("%s %s %s%n",
							Modifier.toString(f.getModifiers()),
							f.getType().getSimpleName(),
							f.getName()
							)));


			input = reader.readLine();
		}

		System.out.print(output.toString());
	}
}
