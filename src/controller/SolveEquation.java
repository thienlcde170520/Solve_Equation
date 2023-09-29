package controller;

import common.Library;
import java.util.ArrayList;
import java.util.List;
import model.EquationModel;

import view.Menu;

public class SolveEquation extends Menu<String>{
    static String[] mc = {"Calculate Superlative Equation", "Calculate Quadratic Equation","Exit"};
    
    private final Library library;
    private final EquationModel equationModel;

    public SolveEquation(EquationModel equationModel) {
        super("========= Equation Program =========", mc);
        library = new Library();
        this.equationModel = equationModel;
    }
    
    @Override
    public void execute(int n) {
        switch (n) {
            case 1: 
                solveSuperlative();
                break;
            case 2: 
                solveQuadratic();
                break;
            case 3: 
                System.out.println("Exit the program successfully!");
                System.exit(0);
                
        }
    }       
    
    public void solveSuperlative(){
        System.out.println("Enter a:");
        float a = library.inputFloat();
        System.out.println("Enter b:");
        float b = library.inputFloat();
        List<Float> input = new ArrayList<>();
        input.add(a);
        input.add(b);
        List<Float> results = equationModel.calculateSuperlative(a, b);
        displayResults(results,input);
    }
    
    public void solveQuadratic(){
        System.out.println("Enter a:");
        float a = library.inputFloat();
        System.out.println("Enter b:");
        float b = library.inputFloat();
        System.out.println("Enter c:");
        float c = library.inputFloat();
        List<Float> input = new ArrayList<>();
        input.add(a);
        input.add(b);
        input.add(c);
        List<Float> results = equationModel.calculateQuadratic(a, b, c);
        displayResults(results,input);
    }
    
    public void displayResults(List<Float> results,List<Float>input) {
        if (results.isEmpty()) {
            System.out.println("The equation has no solution!");
            
        } else {
            System.out.println("Solution:");
            for (Float result : results) {
                if (result != null) {
                    System.out.println("x = " + result);
                }
            }
            results.addAll(input);
            System.out.print("Number is Odd:");
            
            for (Float result : results) {
                if (result % 2 != 0) {
                    System.out.print(" |" + result);
                }
            }
            System.out.println();

            System.out.print("Number is Even:");
            for (Float result : results) {
                if (result != null && result % 2 == 0) {
                    System.out.print(" |" + result);
                }
            }
            System.out.println();

            System.out.print("Number is Perfect Square:");
            for (Float result : results) {
                if (result != null && isPerfectSquare(result)) {
                    System.out.print(" |" + result);
                }
            }
            System.out.println();
        }
    }

    private boolean isPerfectSquare(float number) {
        float sqrt = (float) Math.sqrt(number);
        return (sqrt - Math.floor(sqrt)) == 0;
    }
    
    
}
