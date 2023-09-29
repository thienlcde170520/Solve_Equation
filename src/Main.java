import controller.SolveEquation;
import model.EquationModel;

public class Main {
    public static void main(String[] args) {
        EquationModel equationModel = new EquationModel();
        
        new SolveEquation(equationModel).run();
    }
    
}