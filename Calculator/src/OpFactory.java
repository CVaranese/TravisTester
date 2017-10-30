
public class OpFactory {
	public Operation getOperation(String op) {
		Operation newOp = null;
		
		if (op == null) {
		}
		if (op.equalsIgnoreCase("ADDITION")) {
			newOp = new Addition();
		}
		if (op.equalsIgnoreCase("SUBTRACTION")) {
			newOp = new Subtraction();
		}
		if (op.equalsIgnoreCase("MULTIPLICATION")) {
			newOp = new Multiplication();
		}
		if (op.equalsIgnoreCase("DIVISION")) {
			newOp = new Division();
		}
		return newOp;
	}
}
