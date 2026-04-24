package com.narxoz.rpg.floor;
import com.narxoz.rpg.combatant.*;
import com.narxoz.rpg.state.StunnedState;
import java.util.List;

public class BossFloor extends TowerFloor {
    private Monster boss;

    protected String getFloorName() { return "The Dark Throne"; }
    protected void setup(List<Hero> party) {
        boss = new Monster("Shadow King", 100, 25);
    }

    protected FloorResult resolveChallenge(List<Hero> party) {
        int damageTaken = 0;
        for (Hero h : party) {
            if (h.isAlive() && h.getState().canAct()) {
                boss.takeDamage(h.getAttackPower());
            }
            if (boss.isAlive() && h.isAlive()) {
                int b = h.getHp();
                boss.attack(h);
                damageTaken += (b - h.getHp());
                if (Math.random() > 0.7) h.setState(new StunnedState()); // Босс есеңгірете алады
            }
        }
        return new FloorResult(!boss.isAlive(), damageTaken, boss.isAlive() ? "Wiped out!" : "Tower Cleared!");
    }

    protected void awardLoot(List<Hero> party, FloorResult result) {
        if (result.isCleared()) System.out.println("   >> Loot: Legendary Sword found!");
    }
}