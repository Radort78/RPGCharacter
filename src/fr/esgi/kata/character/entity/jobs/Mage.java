package fr.esgi.kata.character.entity.jobs;

import fr.esgi.kata.character.entity.api.LivingEntity;
import fr.esgi.kata.character.entity.character.Character;

import java.security.SecureRandom;

public class Mage extends Character {

    public Mage(String name) {
        super(name);
    }

    @Override
    public boolean attack(LivingEntity target) {
        return super.attack(target);
    }

    @Override
    public boolean heal(LivingEntity target) {
        if (!this.equals(target) && super.heal(target)) {
            target.applyDamage((byte) -new SecureRandom()
                    .ints(5, 10).findAny().orElse(5));
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Mage - " + super.toString();
    }
}
