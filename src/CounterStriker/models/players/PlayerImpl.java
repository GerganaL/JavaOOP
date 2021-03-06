package CounterStriker.models.players;

import CounterStriker.models.guns.Gun;

import static CounterStriker.common.ExceptionMessages.*;

public class PlayerImpl implements Player{
    private String username;
    private int health;
    private int armor;
    private boolean isAlive;
    private Gun gun;


    protected PlayerImpl(String username, int health, int armor, Gun gun){
       setUsername(username);
        setHealth(health);
        setArmor(armor);
        setGun(gun);
    }


    private void setUsername(String username) {
        if(username == null || username.trim().isEmpty()){
            throw new NullPointerException(INVALID_PLAYER_NAME);
        }
        this.username = username;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    private void setHealth(int health) {
        if(health < 0){
            throw new IllegalArgumentException(INVALID_PLAYER_HEALTH);
        }
        this.health = health;
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    private void setArmor(int armor) {
        if(armor < 0){
            throw  new IllegalArgumentException(INVALID_PLAYER_ARMOR);
        }
        this.armor = armor;
    }

    @Override
    public int getArmor() {
        return this.armor;
    }

    private void setGun(Gun gun) {
        if(gun == null){
            throw new NullPointerException(INVALID_GUN);
        }
        this.gun = gun;
    }

    @Override
    public Gun getGun() {
        return this.gun;
    }

    @Override
    public boolean isAlive() {
        return this.health > 0;
    }

    @Override
    public void takeDamage(int points) {
       /* int damage = points;
        if (damage >= this.getArmor()) {
            damage -= this.getArmor();
            this.armor = 0;
            this.health -= damage;
        } else {
            this.armor -= damage;
        }*/

        int directDamage = points > this.armor ? points - this.armor : 0;
        this.setArmor(Math.max(this.armor - points, 0));
        this.setHealth(Math.max(this.health - directDamage, 0));
    }


    @Override
    public String toString() {
        return String.format("%s: %s%n" +
                "--Health: %d%n" +
                "--Armor: %d%n" +
                "--Gun: %s",getClass().getSimpleName(),getUsername(),getHealth(),getArmor(),getGun().getName());
    }
}
