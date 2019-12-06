package application;

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class UserStorage {
	String name;
	int money = 0;
	int happy = 0;
	int pickles = 0;
	int cucumber = 0;
	UserStorage (String username) {
		name = username;
	}
	void save () throws FileNotFoundException {
		File saveData = new File(name);
		PrintWriter output = new PrintWriter(saveData);
		output.print(money+"\n"+happy+"\n"+pickles+"\n"+cucumber);
		output.close();
	}
	void load (String fileName) throws FileNotFoundException {
		File loadData = new File(fileName);
		Scanner input = new Scanner(loadData);
		money = input.nextInt();
		happy = input.nextInt();
		pickles = input.nextInt();
		cucumber = input.nextInt();
		name = fileName;
		input.close();
	}
}
