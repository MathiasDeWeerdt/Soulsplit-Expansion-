package com.singlecore.soulsplit.api.enums;

import org.parabot.environment.api.utils.Time;
import org.soulsplit.api.methods.Inventory;
import org.soulsplit.api.methods.Menu;
import org.soulsplit.api.methods.Skill;
import org.soulsplit.api.wrappers.Item;

import com.singlecore.soulsplit.api.Skills;

public enum Potions {
	
	SUPER_ATTACK(new int[] {2437, 146, 148, 150}, Skill.ATTACK),
	SUPER_STRENGTH(new int[] {2441, 158, 160, 162}, Skill.STRENGTH),
	SUPER_DEFENSE(new int[] {2443, 164, 166, 168}, Skill.DEFENSE),
	PRAYER_POTION(new int[] {2435, 140, 142, 144}, Skill.PRAYER),
	PRAYER_RENEWAL(new int[] {21631, 21633, 21635, 21637}, Skill.PRAYER),
	RANGING_POTION(new int[] {2445, 170, 172, 174}, Skill.RANGE),
	MAGIC_POTION(new int[] {3041, 3043, 3045, 3047}, Skill.MAGIC);
	
	@Override
    public String toString() {
        return name().charAt(0) + name().substring(1).toLowerCase().replace("_", " ");
    }
	
	private int[] potIds;
	private Skill skill;
	
	Potions(int[] potIds, Skill skill) {
		this.potIds = potIds;
		this.skill = skill;
	}
	
	public boolean hasRequiredPotion() {
		return Inventory.getItems(potIds).length > 0;
	}
	
	public boolean needToPot() {
		if (skill == Skill.PRAYER)
			return Skills.getCurrentLevel(skill.getIndex()) < 10;
		
		return Skills.getCurrentLevel(skill.getIndex()) <= skill.getRealLevel() + 3;
	}
	
	public String getName() {
		return toString();
	}
	
	public void drinkPotion() {
		Item[] potions = Inventory.getItems(potIds);
		
		if (potions.length > 0) {
			Menu.sendAction(74, (int)potions[0].getId() - 1, potions[0].getSlot(), 3214);
			Time.sleep(500);
		}
		
	}
	
}