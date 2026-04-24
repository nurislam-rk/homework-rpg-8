package com.narxoz.rpg;

import com.narxoz.rpg.combatant.Hero;
import com.narxoz.rpg.floor.*;
import com.narxoz.rpg.state.*;
import com.narxoz.rpg.tower.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Hero knight = new Hero("Knight", 120, 15, 10);
        Hero mage = new Hero("Mage", 80, 25, 5);
        
        mage.setState(new PoisonedState());
        
        List<Hero> party = new ArrayList<>();
        party.add(knight);
        party.add(mage);

        List<TowerFloor> tower = List.of(
            new BattleFloor(),
            new RestFloor(),
            new BattleFloor(),
            new BossFloor()
        );

        TowerRunner runner = new TowerRunner();
        TowerRunResult finalResult = runner.run(party, tower);

        System.out.println("\n==========================");
        System.out.println("FINAL REPORT");
        System.out.println("Floors Cleared: " + finalResult.getFloorsCleared());
        System.out.println("Survivors: " + finalResult.getHeroesSurviving());
        System.out.println("Reached Top: " + (finalResult.isReachedTop() ? "YES" : "NO"));
        System.out.println("==========================");
    }
}