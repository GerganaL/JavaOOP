package LABPolymorphism.animal;

public class Cat extends Animal{
    protected Cat(String name, String favouriteFood) {
        super(name, favouriteFood);
    }

    @Override
    protected String explainSelf() {
        return String.format ("%s%nMEEOW",super.explainSelf ());
    }
}
