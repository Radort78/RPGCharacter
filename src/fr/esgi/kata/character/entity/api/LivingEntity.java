package fr.esgi.kata.character.entity.api;

import fr.esgi.kata.character.entity.faction.Faction;

public interface LivingEntity {

    byte getHealth();

    void applyDamage(byte damage);

    Faction getFaction();

}
