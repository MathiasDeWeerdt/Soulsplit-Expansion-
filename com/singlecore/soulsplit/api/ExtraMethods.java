package com.singlecore.soulsplit.api;

import com.singlecore.soulsplit.api.utils.Reflection;

public class ExtraMethods {

	public static boolean isRunEnabled() {
		return Settings.getSetting(173) == 1;
	}

	public static boolean isAutoRetaliateEnabled() {
		return Settings.getSetting(172) == 1;
	}

	public static int getAttackStyle() {
		return Settings.getSetting(43);
	}

	private static final String[] WALKING_HOOK = { "T.a", "iu" };

	public static int isMoving() {
		return (int) Reflection.fieldValue(WALKING_HOOK, "int");
	}

}
