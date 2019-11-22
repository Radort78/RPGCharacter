package fr.esgi.kata.character.entity.faction;

import fr.esgi.kata.character.entity.api.LivingEntity;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Faction extends CopyOnWriteArrayList<LivingEntity> {

    private List<Faction> allies;

    public Faction() {
        this.allies = new CopyOnWriteArrayList<>();
    }

    public void addAlly(Faction faction) {
        this.allies.add(faction);
    }

    public void removeAlly(Faction faction) {
        this.allies.remove(faction);
    }

    public boolean isAlly(Faction faction) {
        return this.allies.contains(faction);
    }
}
