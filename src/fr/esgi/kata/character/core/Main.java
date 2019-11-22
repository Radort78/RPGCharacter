package fr.esgi.kata.character.core;

import fr.esgi.kata.character.entity.character.Character;
import fr.esgi.kata.character.entity.faction.Faction;
import fr.esgi.kata.character.entity.jobs.DefaultCharacter;
import fr.esgi.kata.character.entity.jobs.Mage;
import fr.esgi.kata.character.entity.jobs.Warrior;

public class Main {

    public static void main(String[] args) {

        Faction teamESGI = new Faction();

        Character botan = new Warrior("Botan");
        Character goran = new DefaultCharacter("Goran");
        Character mage = new Mage("Mage");

        botan.joinFaction(teamESGI);
        goran.joinFaction(teamESGI);

        botan.attack(goran);
        botan.attack(goran);
        botan.attack(goran);

        System.out.println(botan);
        System.out.println(goran);

        goran.heal(botan);
        botan.heal(goran);

        mage.heal(goran);

        System.out.println(botan);
        System.out.println(goran);
    }

}
