<<<<<<< HEAD:Softwarehuset/src/partOne/OperationNotAllowedException.java
package partOne;

public class OperationNotAllowedException extends Exception {

	public OperationNotAllowedException(String msg) {
		super(msg);
	}

	public String getOperation() {
		if(this.getMessage().contains("Create activity")) {
			return "Create activity";
		} else if(this.getMessage().contains("")) {
			return "";
		}
		return null;
	}
	
}
=======
package code;

public class OperationNotAllowedException extends Exception {

	public OperationNotAllowedException(String msg) {
		super(msg);
	}

	public String getOperation() {
		if(this.getMessage().contains("Create activity")) {
			return "Create activity";
		} else if(this.getMessage().contains("")) {
			return "";
		}
		return null;
	}
	
}
>>>>>>> master:Softwarehuset/src/code/OperationNotAllowedException.java
