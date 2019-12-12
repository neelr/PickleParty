package finalProject;

import java.util.*;

public class Mechanics {
	static int pickles = 0;
	static int cucumber = 0;
	static UserStorage user;
	static int money = 100;
	static int plots = 4;
	static int jars = 4;
	static void setUser (UserStorage person) {
		user = person;
		pickles = user.pickles;
		cucumber = user.cucumber;
		plots = user.plots;
		jars = user.jars;
		money = user.money;
	}
	static void add () {
		System.out.print("PICKLE" +cucumber);
		cucumber+=100;
		user.cucumber += 100;
		user.save();
	}
	static void money (int num)  {
		money += num;
		user.money+=num;
		user.save();
		System.out.println("Money is: "+money);
	}
	static void sell (int num) {
		pickles += num;
		user.pickles+=num;
		user.save();
	}
	static void pickle() {
		cucumber-=100;
		user.cucumber-=100;
		user.save();
	}
	static void redeem () {
		pickles+=100;
		user.pickles+=100;
		user.save();
	}
	static void addJar () {
		jars+=1;
		user.jars+=1;
		user.save();
		System.out.println("Jars is: "+jars);
	}
	static void addPlot () {
		plots+=1;
		user.plots+=1;
		user.save();
		System.out.println("Plots is: "+plots);
	}
}