package com.narxoz.rpg.floor;
import com.narxoz.rpg.combatant.*;
import java.util.List;

public class BattleFloor extends TowerFloor {
    private Monster enemy;

    protected String getFloorName() { return "Monster Den"; }
    
    protected void setup(List<Hero> party) {
        enemy = new Monster("Orc Warrior", 45, 12);
    }

    protected FloorResult resolveChallenge(List<Hero> party) {
        int damageTaken = 0;
        for (Hero h : party) {
            if (h.isAlive() && h.getState().canAct()) {
                enemy.takeDamage(h.getState().modifyOutgoingDamage(h.getAttackPower()));
            }
            if (enemy.isAlive() && h.isAlive()) {
                int before = h.getHp();
                enemy.attack(h);
                damageTaken += (before - h.getHp());
            }
        }
        return new FloorResult(!enemy.isAlive(), damageTaken, 
            enemy.isAlive() ? "Party retreated!" : "Monster defeated!");
    }

    protected void awardLoot(List<Hero> party, FloorResult result) {
        if (result.isCleared()) System.out.println("   >> Loot: Found 50 gold!");
    }
}