package me.egois.calculator;

import java.text.DecimalFormat;

/**
 * Calculator operation class
 * 
 * @author chz <chazzuka@gmail.com>
 */
public class MathOperation {

    private String leftOperand = "";
    private String rightOperand = "";
    private String mathSymbol = "";
    private boolean isAfterCalculation = false;
    
    /**
     * Add operand (left or right)
     * 
     * @param op the number operand
     */
    public void operand(String op)
    {
        if (isAfterCalculation) {
            leftOperand = "";
            isAfterCalculation = false;
        }
        
        if (mathSymbol.isEmpty()) {
            if (leftOperand.isEmpty() && op.equals(".")) {
                leftOperand = "0";
            }
            leftOperand = leftOperand.concat(op);
            return;
        }
        
        rightOperand = rightOperand.concat(op);
    }
    
	/**
	 * Change polarization of number operand
	 */
    public void polarize()
    {
		if (mathSymbol.isEmpty()) {
			if (!leftOperand.isEmpty() && leftOperand.startsWith("-")) {
				leftOperand = leftOperand.replace("-","");
			} else {
				leftOperand = "-".concat(leftOperand);
			}
		} else {
			if (!rightOperand.isEmpty() && rightOperand.startsWith("-")) {
				rightOperand = rightOperand.replace("-","");
			} else {
				rightOperand = "-".concat(rightOperand);
			}
		}
    }
    
    /**
     * Add math symbol
     * 
     * @param op the math operation symbol
     */
    public void math(String op)
    {
        if (leftOperand.isEmpty() || leftOperand.equals("-")) {
            return;
        }
        
        if (!mathSymbol.isEmpty()) {
            try {
                this.calculate();
            } catch (Exception e) {}
        }
        
        mathSymbol = op;
        isAfterCalculation = false;
    }
    
    /**
     * Perform evaluation statement
     * 
     * @throws Exception
     */
    public void calculate() throws Exception
    {
        if(leftOperand.isEmpty() || leftOperand.equals("-") || mathSymbol.isEmpty() || rightOperand.isEmpty() || rightOperand.equals("-")) {
            //this.reset();
            return;
        }
        
        double r;
        double first = Double.valueOf(leftOperand);
        double second = Double.valueOf(rightOperand);
        
        if (mathSymbol.equals("+")) {
        	r = first + second;
        } else if (mathSymbol.equals("-")) {
        	r = first - second;
        } else if (mathSymbol.equals("*")) {
        	r = first * second;
        } else if (mathSymbol.equals(":")) {
        	r = first/second;
        } else {
        	throw new Exception("unsupported math operand");
        }
        
        this.reset();
        leftOperand = (new DecimalFormat("#.##")).format(r);
        isAfterCalculation = true;
    }
    
    /**
     * Reset all operands
     */
    public void reset()
    {
        leftOperand = "";
        rightOperand = "";
        mathSymbol = "";
    }

    /**
     * Getter for left operand
     * 
     * @return string
     */
    public String leftOperand() {
        return leftOperand;
    }

    /**
     * Getter for right operand
     * 
     * @return string
     */
    public String rightOperand() {
        return rightOperand;
    }

    /**
     * Getter for math operation symbol
     * 
     * @return string
     */
    public String mathSymbol() {
        return mathSymbol;
    }
	
}
