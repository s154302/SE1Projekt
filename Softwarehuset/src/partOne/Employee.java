package partOne;

import java.util.List;

public class Employee {
	private String name;
	
	public List<Activity> activityList;
	
	public Employee(String name){
		this.name = name;
	}

	public boolean isAvailable() {
		if (activityList.size() < 20) {
			return true;
		}
		return false;
	}

}

