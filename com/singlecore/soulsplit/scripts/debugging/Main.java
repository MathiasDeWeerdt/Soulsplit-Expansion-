package com.singlecore.soulsplit.scripts.debugging;

import java.awt.Color;
import java.awt.Graphics;

import org.parabot.environment.api.interfaces.Paintable;
import org.parabot.environment.input.Mouse;
import org.parabot.environment.scripts.Category;
import org.parabot.environment.scripts.Script;
import org.parabot.environment.scripts.ScriptManifest;
import org.parabot.environment.scripts.framework.LoopTask;

import com.singlecore.soulsplit.api.ExtraMethods;
import com.singlecore.soulsplit.api.Skills;

@ScriptManifest(author = "SingleCore", category = Category.OTHER, description = "Help", name = "Debugging", servers = { "Soulsplit" }, version = 0)
public class Main extends Script implements LoopTask, Paintable {

	private final int x = 10;
	private int y = 73;
	
	@Override
	public int loop() {
		System.out.println("RUNNING");
		return 100;
	}

	@Override
	public void paint(Graphics g) {
		g.setColor(Color.GREEN);
		
		addDebugLine(g, "Mouse: " + Mouse.getInstance().getPoint());
		addDebugLine(g, "isRunEnabled(): " + ExtraMethods.isRunEnabled());
		addDebugLine(g, "isAutoRetaliateEnabled(): " + ExtraMethods.isAutoRetaliateEnabled());
		addDebugLine(g, "getAttackStyle(): " + ExtraMethods.getAttackStyle());
		addDebugLine(g, "0 CurrentLevel:  " + Skills.getCurrentLevel(0));
		addDebugLine(g, "1 CurrentLevel: " + Skills.getCurrentLevel(1));
		addDebugLine(g, "2 CurrentLevel: " + Skills.getCurrentLevel(2));
		addDebugLine(g, "3 CurrentLevel: " + Skills.getCurrentLevel(3));
		addDebugLine(g, "isMoving(): " + ExtraMethods.isMoving());
		
		moveDebugLine();
	}

	private void addDebugLine(Graphics g, String s) {
		g.drawString(s, x, y);
		y += 15;
	}
	
	private void moveDebugLine() {
		y = 73;
	}

}
