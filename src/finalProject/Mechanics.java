package finalProject;

import java.util.*;

public class Mechanics {
	static int pickles = 0;
	static int cucumber = 0;
	static int money = 100;
	static void add () {
		money -= 10;
		System.out.print("PICKLE" +cucumber);
		cucumber+=1;
	}
	static void pickle() {
		cucumber-=1;
		pickles+=1;
	}
	static void redeem () {
		pickles-=1;
		money +=20;
	}
}
