package todo.api.support;

public class TaskListValidator {

	private static final int NAME_MIN_LENGTH = 3; 
	private static final int NAME_MAX_LENGTH = 30; // Max database varchar length 
	
	public static boolean validateName(String name) {
		if(name == null || name.equals(""))
			return false;
		if(name.length() > NAME_MIN_LENGTH && name.length() < NAME_MAX_LENGTH)
			return true;
		else
			return false;
	}

}
