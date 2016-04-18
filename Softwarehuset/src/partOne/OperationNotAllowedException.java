package partOne;

public class OperationNotAllowedException extends Exception {

	public OperationNotAllowedException(String msg) {
		super(msg);
	}

	public String getOperation() {
		if(this.getMessage().contains("Create activity")) {
			return "Create activity";
		} else if(this.getMessage().contains("Register user")) {
			return "Register user";
		}
		return null;
	}
	
}
