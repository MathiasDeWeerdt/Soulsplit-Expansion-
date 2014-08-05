package com.singlecore.soulsplit.api;

import com.singlecore.soulsplit.api.utils.Reflection;

public class Skills {

	private static final String[] CURRENT_LEVEL_HOOK = { "o/b", "aF" };

	public static final int[] getCurrentStats() {
		return (int[]) Reflection.getFieldValue(CURRENT_LEVEL_HOOK, "[I");
	}

	public static final int getCurrentLevel(int index) {
		if (getCurrentStats() != null) {
			return getCurrentStats()[index];
		}
		return 0;
	}

}