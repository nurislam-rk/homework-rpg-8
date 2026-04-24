package com.narxoz.rpg.state;
import com.narxoz.rpg.combatant.Hero;

public class NeutralState implements HeroState {
    public String getName() { return "Normal"; }
    public int modifyOutgoingDamage(int base) { return base; }
    public int modifyIncomingDamage(int raw) { return raw; }
    public void onTurnStart(Hero hero) {}
    public void onTurnEnd(Hero hero) {}
    public boolean canAct() { return true; }
}