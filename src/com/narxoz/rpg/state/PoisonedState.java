package com.narxoz.rpg.state;
import com.narxoz.rpg.combatant.Hero;

public class PoisonedState implements HeroState {
    private int duration = 3; 

    public String getName() { return "Poisoned"; }
    public int modifyOutgoingDamage(int base) { return (int)(base * 0.8); }
    public int modifyIncomingDamage(int raw) { return raw; }

    public void onTurnStart(Hero hero) {
        System.out.println("   [!] " + hero.getName() + "5 HP lost.");
        hero.takeDamage(5);
    }

    public void onTurnEnd(Hero hero) {
        duration--;
        if (duration <= 0) {
            System.out.println("   [*] " + hero.getName() + "The poison spread through his body.");
            hero.setState(new NeutralState());
        }
    }
    public boolean canAct() { return true; }
}