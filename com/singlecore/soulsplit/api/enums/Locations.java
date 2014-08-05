package com.singlecore.soulsplit.api.enums;

import org.parabot.environment.api.utils.Time;
import org.soulsplit.api.methods.Menu;

public enum Locations {
	
	HOME_TELEPORT(0, 19210, 0, 0, 0),
	VARROCK(1164, 2494, 0, 0, 0), 
	EDGEVILLE(1164, 2495, 0, 0, 0), 
	LUMBRIDGE(1164, 2496, 0, 0, 0), 
	ARDOUGNE(1164, 2497, 0, 0, 0),
	DRAYNOR(1164, 2494, 2498, 0, 0), 
	YANILLE(1164, 2495, 2498, 0, 0), 
	CAMELOT(1164, 2496, 2498, 0, 0), 
	FALADOR(1164, 2497, 2498, 0, 0),
	KARAMJA(1164, 2494, 2498, 2498, 0), 
	SHILO_VILLAGE(1164, 2495, 2498, 2498, 0), 
	ENTRANA(1164, 2496, 2498, 2498, 0), 
	SOPHANEM(1164, 2497, 2498, 2498, 0),
	TREE_GNOME_VILLAGE(1164, 2461, 2498, 2498, 2498),
	KING_BLACK_DRAGON(1167, 2494, 0, 0, 0),
	SPIRIT_DUNGEON(1167, 2495, 0, 0, 0),
	WATERBIRTH_DUNGEON(1167, 2496, 0, 0, 0),
	GODWARS(1167, 2497, 0, 0, 0),
	SLAYER_DUNGEON(1167, 2494, 2498, 0, 0), 
	DWARVEN_MINES(1167, 2495, 2498, 0, 0), 
	NEX_LAIR(1167, 2496, 2498, 0, 0), 
	GLACOR_LAIR(1167, 2497, 2498, 0, 0),
	FORBIDDEN_LAIR(1167, 2494, 2498, 2498, 0), 
	CORPOREAL_BEAST(1167, 2495, 2498, 2498, 0), 
	STRYKEWYRM_CAVE(1167, 2496, 2498, 2498, 0), 
	VOTING_LAIR(1167, 2497, 2498, 2498, 0),
	PEST_QUEEN(1167, 2471, 2498, 2498, 2498),
	TAVERLY_DUNGEON(1167, 2472, 2498, 2498, 2498),
	VARROCK_WILDERNESS(1170, 2494, 0, 0, 0), 
	EDGEVILLE_COFFINS(1170, 2495, 0, 0, 0), 
	WEST_HYBRIDDING(1170, 2496, 0, 0, 0), 
	EAST_HYBRIDDING(1170, 2497, 0, 0, 0),
	CASTLE_WARS(1174, 2494, 0, 0, 0), 
	PEST_CONTROL(1174, 2495, 0, 0, 0), 
	TZHAAR_CAVES(1174, 2496, 0, 0, 0), 
	DUAL_ARENA_ENTRANCE(1174, 2497, 0, 0, 0),
	DUAL_ARENA_LOBBY(1174, 2482, 2498, 0, 0), 
	BARROWS(1174, 2483, 2498, 0, 0), 
	SOUL_WARS(1174, 2484, 2498, 0, 0),
	CLAN_WARS_PURPLE_PORTAL(1540, 2471, 0, 0, 0), 
	CLAN_WARS_WHITE_PORTAL(1540, 2472, 0, 0, 0), 
	BARBARIAN_OUTPOST_AGILITY(1541, 2494, 0, 0, 0), 
	TREE_GNOME_VILLAGE_AGILITY(1541, 2495, 0, 0, 0), 
	NEITIZNOT_SOUTH(1541, 2496, 0, 0, 0), 
	NEITIZNOT_NORTH(1541, 2497, 0, 0, 0),
	CATHERBY_SKILLING(1541, 2461, 2498, 0, 0),
	FREMENNIK_PROVINCE_ROCK_CRABS(7455, 2494, 0, 0, 0), 
	EXPERIMENTS(7455, 2495, 0, 0, 0), 
	SLAYER_TOWER(7455, 2496, 0, 0, 0), 
	SAGES_SAFE_TRAINING(7455, 2497, 0, 0, 0),
	BANDITS(7455, 2461, 2498, 0, 0), 
	APE_ATOLL(0, 18470, 0, 0, 0);
	
	@Override
    public String toString() {
        return name().charAt(0) + name().substring(1).toLowerCase().replace("_", " ");
    }

	private int teleport;
	private int teleportId;
	private int listId1;
	private int listId2;
	private int listId3;

	Locations(int teleport, int teleportId, int listId1, int listId2, int listId3) {
		this.teleport = teleport;
		this.teleportId = teleportId;
		this.listId1 = listId1;
		this.listId2 = listId2;
		this.listId3 = listId3;
	}
	
	public String getName() {
		return toString();
	}

	public void teleport() {
		Menu.sendAction(315, -1, -1, (teleport != 0) ? teleport : 0);
		Menu.sendAction(315, -1, -1, (listId1 != 0) ? listId1 : 0);
		Menu.sendAction(315, -1, -1, (listId2 != 0) ? listId2 : 0);
		Menu.sendAction(315, -1, -1, (listId3 != 0) ? listId3 : 0);
		Menu.sendAction(315, -1, -1, (teleportId != 0) ? teleportId : 0);
		Time.sleep(1200);
	}
}
