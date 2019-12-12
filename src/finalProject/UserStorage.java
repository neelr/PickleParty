package finalProject;

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class UserStorage {
	String name;
	int money = 100;
	int pickles = 0;
	int jars = 4;
	int plots = 4;
	int cucumber = 0;
	UserStorage (String username) {
		name = username;
	}
	void save () {
		File saveData = new File(name);
		PrintWriter output;
		try {
			output = new PrintWriter(saveData);
			output.print(money+"\n"+jars+"\n"+plots+"\n"+pickles+"\n"+cucumber);
			output.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	void load (String fileName) {
		try {
			File loadData = new File(fileName);
			Scanner input = new Scanner(loadData);
			money = input.nextInt();
			jars = input.nextInt();
			plots = input.nextInt();
			pickles = input.nextInt();
			cucumber = input.nextInt();
			name = fileName;
			input.close();
		} catch (FileNotFoundException e) {
		} finally {
			
		}
	}
}
