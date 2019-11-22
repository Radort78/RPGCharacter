package fr.esgi.kata.character.entity.character;

import fr.esgi.kata.character.entity.api.LivingEntity;
import fr.esgi.kata.character.entity.faction.Faction;

import java.util.Objects;

public abstract class Character implements LivingEntity {

    private String name;
    private byte health;
    private Faction faction;

    protected Character(String name) {
        this.name = name;
        this.health = 100;
    }

    public boolean isDead() {
        return health <= 0; // in theory == 0
    }

    public boolean isAlive() {
        return !isDead();
    }

    @Override
    public void applyDamage(byte damage) {
        if (isAlive())
            this.health = (byte) Math.max(0, Math.min(100, this.health - damage));
    }

    @Override
    public Faction getFaction() {
        return faction;
    }

    @Override
    public byte getHealth() {
        return this.health;
    }

    public boolean attack(LivingEntity target) {
        return faction == null || !(faction.contains(target) || faction.isAlly(target.getFaction()));
    }

    public boolean heal(LivingEntity target) {
        return faction == null || (faction.contains(target) || faction.isAlly(target.getFaction()));
    }

    public void joinFaction(Faction faction) {
        this.faction = faction;
        faction.add(this);
    }

    public void leaveFaction() {
        if (this.faction != null) {
            this.faction.remove(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Character character = (Character) o;
        return health == character.health &&
                character.name.equals(name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, health);
    }

    @Override
    public String toString() {
        return String.format("%s : [health: %s]\n", name, health);
    }
}
