package com.singlecore.soulsplit.api;

import com.singlecore.soulsplit.api.utils.Reflection;

public class Settings {

	private static final String[] SETTINGS_HOOK = { "com/soulsplit/h", "K" };

	public static final int getSetting(int index) {
		int[] settings = getSettings();
		if (settings != null && index < settings.length) {
			return settings[index];
		}
		return -1;
	}

	public static final int[] getSettings() {
		return (int[]) Reflection.getFieldValue(SETTINGS_HOOK, "[I");
	}

}
