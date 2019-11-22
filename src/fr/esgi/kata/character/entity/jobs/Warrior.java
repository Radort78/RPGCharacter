package fr.esgi.kata.character.entity.jobs;

import fr.esgi.kata.character.entity.api.LivingEntity;
import fr.esgi.kata.character.entity.character.Character;

import java.security.SecureRandom;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name);
    }

    @Override
    public boolean attack(LivingEntity target) {
        if (super.attack(target)) {
            target.applyDamage((byte) new SecureRandom().nextInt(9));
            return true;
        }
        return false;
    }

    @Override
    public boolean heal(LivingEntity target) {
        if (this.equals(target) && super.heal(target)) {
            target.applyDamage((byte) -1);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Warrior - " + super.toString();
    }
}
