package barracksWars.models;

public class Horseman extends AbstractUnit{
    private static final int GUNNER_HEALTH = 50;
    private static final int GUNNER_DAMAGE = 10;
    public Horseman() {
        super(GUNNER_HEALTH, GUNNER_DAMAGE);
    }
}
