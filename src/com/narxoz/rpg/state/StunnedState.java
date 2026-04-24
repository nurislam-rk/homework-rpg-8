package com.narxoz.rpg.state;
import com.narxoz.rpg.combatant.Hero;

public class StunnedState implements HeroState {
    public String getName() { return "Stunned"; }
    public int modifyOutgoingDamage(int base) { return 0; }
    public int modifyIncomingDamage(int raw) { return (int)(raw * 1.5); } 

    public void onTurnStart(Hero hero) {
        System.out.println("   [!] " + hero.getName() + " He is dazed and can’t move!");
    }

    public void onTurnEnd(Hero hero) {
        hero.setState(new NeutralState());
    }
    public boolean canAct() { return false; }
}