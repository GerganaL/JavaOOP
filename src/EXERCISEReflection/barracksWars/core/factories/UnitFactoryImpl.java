package EXERCISEReflection.barracksWars.core.factories;

import EXERCISEReflection.barracksWars.interfaces.Unit;
import EXERCISEReflection.barracksWars.interfaces.UnitFactory;

import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

	private static final String UNITS_PACKAGE_NAME =
			"barracksWars.models.";

	@Override
	public Unit createUnit(String unitType){

		Unit unit;
		try {
			Class<?> clazz = Class.forName(UNITS_PACKAGE_NAME + unitType);

			unit = (Unit)clazz.getDeclaredConstructor().newInstance();
		} catch (ClassNotFoundException
				| NoSuchMethodException
				| IllegalAccessException
				| InstantiationException
				| InvocationTargetException e) {
			throw  new IllegalStateException(e);
		}

		return unit;
	}
}
