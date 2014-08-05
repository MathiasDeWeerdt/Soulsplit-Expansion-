package com.singlecore.soulsplit.api.enums;

import org.parabot.environment.api.utils.Time;
import org.soulsplit.api.methods.Menu;

import com.singlecore.soulsplit.api.Settings;

public enum Prayer {

    THICK_SKIN(5609, 83), 
    BURST_OF_STRENGTH(5610, 84), 
    CLARITY_OF_THOUGHT(5611, 85), 
    SHARP_EYE(19812, 101), 
    MYSTIC_WILL(19814, 102), 
    ROCK_SKIN(5612, 86), 
    SUPERHUMAN_STRENGTH(5613, 87), 
    IMPROVED_REFLEXES(5614, 88), 
    RAPID_RESTORE(5615, 89), 
    RAPID_HEAL(5616, 90), 
    PROTECT_ITEM(5617, 91), 
    HAWK_EYE(19816, 103), 
    MYSTIC_LORE(19818,104), 
    STEEL_SKIN(5618, 92), 
    ULTIMATE_STRENGTH(5619, 93), 
    INCREDIBLE_REFLEXES(5620, 94),
    PROTECT_FROM_SUMMONING(23105, 708),
    PROTECT_FROM_MAGIC(5621, 95), 
    PROTECT_FROM_MISSILES(5622, 96), 
    PROTECT_FROM_MELEE(5623, 97),
    EAGLE_EYE(19821, 105), 
    MYSTIC_MIGHT(19823, 106), 
    RETRIBUTION(683, 98), 
    REDEMPTION(684, 99), 
    SMITE(685, 100), 
    CHIVALRY(19825, 107), 
    RAPID_RENEWAL(23109, 111), 
    PIETY(19827, 109), 
    RIGOUR(23113, 112), 
    AUGURY(23116, 113);

    @Override
    public String toString() {
        return name().charAt(0) + name().substring(1).toLowerCase().replace("_", " ");
    }

    private int action3;
    private int settingId;

    Prayer(int action3, int settingId) {
        this.action3 = action3;
        this.settingId = settingId;
    }

    public void toggle() {
    	Menu.sendAction(169, -1, -1, action3);
    	Time.sleep(250);
    }

    public String getName() {
        return toString();
    }

    public boolean isActive() {
        return Settings.getSetting(settingId) == 1;
    }
    
}