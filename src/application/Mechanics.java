package application;

import java.util.*;

public class Mechanics {
	static ArrayList<Cucumber> veggies = new ArrayList<Cucumber>();
	static boolean inJar = false;
	static int points = 0;
	static int happy = 0;
	static String name = "";
	static void addPickle() {
		veggies.add(new Cucumber());
	}
	static int getPickleCount() {
		return veggies.size();
	}
	static void addJar() {
		if (getPickleCount() != 0) {
			inJar = true;
			veggies.get(0).setJarred();
		}
	}
	static void takeOutJar (boolean forhappy) {
		if (inJar) {
			if (forhappy) {
				happy += veggies.get(0).points;
			} else {
				points += veggies.get(0).points;
			}
			veggies.remove(0);
		}
	}
}
