package com.singlecore.soulsplit.api;

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

}
