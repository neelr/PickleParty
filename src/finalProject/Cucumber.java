package finalProject;

public class Cucumber {
	boolean isPickled = false;
	boolean isJarred = false;
	int points =(int) ((Math.random()*10)/2);
	Cucumber () {
		System.out.print(points);
	}
	void setPickle () {
		isPickled = true;
	}
	void setJarred () {
		isJarred = true;
	}
}
