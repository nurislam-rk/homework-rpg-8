package com.narxoz.rpg.tower;
import com.narxoz.rpg.combatant.Hero;
import com.narxoz.rpg.floor.*;
import java.util.List;

public class TowerRunner {
    public TowerRunResult run(List<Hero> party, List<TowerFloor> floors) {
        int cleared = 0;
        for (TowerFloor floor : floors) {
            System.out.println("\n--- Current Floor Status ---");
            for (Hero h : party) {
                h.getState().onTurnStart(h);
                System.out.println(h.getName() + " [HP: " + h.getHp() + "] State: " + h.getState().getName());
            }

            FloorResult res = floor.explore(party);
            System.out.println("Result: " + res.getSummary());

            if (!res.isCleared()) break;
            cleared++;

            for (Hero h : party) h.getState().onTurnEnd(h);
            if (party.stream().noneMatch(Hero::isAlive)) break;
        }
        long aliveCount = party.stream().filter(Hero::isAlive).count();
        return new TowerRunResult(cleared, (int)aliveCount, cleared == floors.size());
    }
}