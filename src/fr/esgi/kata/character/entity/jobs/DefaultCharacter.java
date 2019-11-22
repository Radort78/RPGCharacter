package fr.esgi.kata.character.entity.jobs;

import fr.esgi.kata.character.entity.api.LivingEntity;
import fr.esgi.kata.character.entity.character.Character;

public class DefaultCharacter extends Character {

    public DefaultCharacter(String name) {
        super(name);
    }

    @Override
    public boolean attack(LivingEntity target) {
        if (!this.equals(target) && super.attack(target)) {
            target.applyDamage((byte) 1);
            return true;
        }
        return false;
    }

    @Override
    public boolean heal(LivingEntity target) {
        if (super.heal(target)) {
            target.applyDamage((byte) -1);
            return true;
        }
        return false;
    }
}
