package com.singlecore.soulsplit.api.utils;

import java.lang.reflect.Field;

import org.parabot.core.Context;
import org.soulsplit.accessors.Client;
import org.soulsplit.accessors.Character;
import org.soulsplit.api.methods.Players;
import org.soulsplit.api.wrappers.Player;

public class Reflection {

	private static Class<?> client;

	private static Class<?> getClient(String str) {
		client = loadClass(str);
		return client;
	}

	private static Client getInstance() {
		return (Client) Context.getInstance().getClient();
	}

	private static Class<?> loadClass(String str) {
		try {
			return Context.getInstance().getASMClassLoader().loadClass(str);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	private static Field[] getDeclaredFields(String str) {
		return getClient(str).getFields();
	}

	private static Field getField(String[] fieldName, String fieldType) {
		System.out.println("fields: " + getDeclaredFields(fieldName[0]).length);
		for (Field f : getDeclaredFields(fieldName[0])) {
			f.setAccessible(true);
			if (f.getName().equals(fieldName[1])
					&& f.getType().toString().contains(fieldType)) {
				System.out.println("Found Field: " + f.getName() + ", " + f.getType());
				return f;
			}
		}
		return null;
	}

	public static Object getFieldValue(String[] fieldName, String type) {
		try {
			Field f = getField(fieldName, type);
			if (f != null) {
				return f.get(getInstance());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static Object fieldValue(String[] fieldName, String type) {
		try {
			Field f = getField(fieldName, type);
			if (f != null) {
				System.out.println("Getting Value of field");
				return f.get(getCharacterInstance());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Character getCharacterInstance() {
		try {
			Field f = Player.class.getSuperclass().getDeclaredField("long");
			f.setAccessible(true);
			
			System.out.println("Returning Character Instance");
			return (Character) f.get(Players.getMyPlayer());
		} catch (Exception e) {
			System.out.println("Invalid Character Instance");
		}
		return null;
	}

}
