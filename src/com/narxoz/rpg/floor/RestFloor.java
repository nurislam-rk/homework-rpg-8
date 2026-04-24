package com.narxoz.rpg.floor;
import com.narxoz.rpg.combatant.Hero;
import java.util.List;

public class RestFloor extends TowerFloor {
    protected String getFloorName() { return "Safe Campfire"; }
    protected void setup(List<Hero> party) {}

    protected FloorResult resolveChallenge(List<Hero> party) {
        for (Hero h : party) h.heal(30);
        return new FloorResult(true, 0, "Heroes rested and recovered HP.");
    }

    @Override
    protected boolean shouldAwardLoot(FloorResult result) {
        return false; // Демалыста олжа (loot) берілмейді
    }

    protected void awardLoot(List<Hero> party, FloorResult result) {}
}