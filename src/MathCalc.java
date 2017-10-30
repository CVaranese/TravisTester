import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;

public class MathCalc extends Application{
	
	TextField numEntry1, numEntry2;
	Button addButton, subButton, mulButton, divButton, clearButton;
	Label ans;
	
	@Override
	public void start(Stage primaryStage){
		numEntry1 = new TextField();
		numEntry2 = new TextField();
		addButton = new Button("+");
		subButton = new Button("-");
		mulButton = new Button("x");
		divButton = new Button("/");
		clearButton = new Button("Clear");
		ans = new Label("Answer");
		ans.setAlignment(Pos.CENTER);
		
		GridPane root = new GridPane();
        root.setHgap(10);
        root.setVgap(10);
        
		root.setAlignment(Pos.CENTER);
		root.add(addButton, 0, 1);
		root.add(subButton, 1, 1);
		root.add(mulButton, 0, 2);
		root.add(divButton, 1, 2);
		root.add(numEntry1, 0, 0);
		root.add(numEntry2, 1, 0);
		root.add(ans, 0, 3, 2, 1);
		root.add(clearButton, 0, 4, 2, 1);
		
		setWidths();
		
		attachCode();
		
		Scene newScene = new Scene(root, 300, 250);
		primaryStage.setTitle("Maths!");
		primaryStage.setScene(newScene);
		primaryStage.show();
	}
	
	public void setWidths() {
		 numEntry1.setPrefWidth(70);
	     numEntry2.setPrefWidth(70);
	     addButton.setPrefWidth(70);
	     subButton.setPrefWidth(70);
	     mulButton.setPrefWidth(70);
	     divButton.setPrefWidth(70);
	     clearButton.setPrefWidth(150);
	     ans.setPrefWidth(150);
		
	}
	
    public void attachCode()
    {
        addButton.setOnAction(e -> {
        	buttonFunction("ADDITION");
        });
        subButton.setOnAction(e -> {
        	buttonFunction("SUBTRACTION");
        });
        mulButton.setOnAction(e -> {
        	buttonFunction("MULTIPLICATION");
        });
        divButton.setOnAction(e -> {
        	buttonFunction("DIVISION");
        });
        clearButton.setOnAction(e -> {
            numEntry1.setText("");
            numEntry2.setText("");
            ans.setText("Answer");
            numEntry1.requestFocus();
            return;
        });
    }
    
    public void buttonFunction(String op) {
    	int num1 = Integer.parseInt(numEntry1.getText());
    	int num2 = Integer.parseInt(numEntry2.getText());
    	double answer = doCalculation(num1, num2, op);
    	ans.setText("" + answer);
    }
	
    public double doCalculation(int arg1, int arg2, String operation) {
    	OpFactory fact = new OpFactory();
    	Operation op = fact.getOperation(operation);
    	double answer = op.calculate(arg1, arg2);
    	return answer;
    }
    
	public static void main(String[] args) {
		Application.launch(args);
	}
}
