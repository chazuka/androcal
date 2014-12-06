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
    public void setOperand(String op)
    {
        if (this.isAfterCalculation) {
            this.leftOperand = "";
            this.isAfterCalculation = false;
        }
        
        if (this.mathSymbol.isEmpty()) {
            if (this.leftOperand.isEmpty() && op.equals(".")) {
                this.leftOperand = "0";
            }
            this.leftOperand = this.leftOperand.concat(op);
            return;
        }
        
        this.rightOperand = this.rightOperand.concat(op);
    }
    
    /**
     * Add math symbol
     * 
     * @param op the math operation symbol
     */
    public void setMath(String op)
    {
        if (this.leftOperand.isEmpty()) {
            return;
        }
        
        if (!this.mathSymbol.isEmpty()) {
            try {
                this.calculate();
            } catch (Exception e) {}
        }
        
        this.mathSymbol = op;
        this.isAfterCalculation = false;
    }
    
    /**
     * Perform evaluation statement
     * 
     * @throws Exception
     */
    public void calculate() throws Exception
    {
        if(this.leftOperand.isEmpty() || this.mathSymbol.isEmpty() || this.rightOperand.isEmpty()) {
            //this.reset();
            return;
        }
        
        double r;
        double first = Double.valueOf(this.leftOperand);
        double second = Double.valueOf(this.rightOperand);
        
        if (this.mathSymbol.equals("+")) {
        	r = first + second;
        } else if (this.mathSymbol.equals("-")) {
        	r = first - second;
        } else if (this.mathSymbol.equals("*")) {
        	r = first * second;
        } else if (this.mathSymbol.equals(":")) {
        	r = first/second;
        } else {
        	throw new Exception("unsupported math operand");
        }
        
        this.reset();
        this.leftOperand = (new DecimalFormat("#.##")).format(r);
        this.isAfterCalculation = true;
    }
    
    /**
     * Reset all operands
     */
    public void reset()
    {
        this.leftOperand = "";
        this.rightOperand = "";
        this.mathSymbol = "";
    }

    /**
     * Getter for left operand
     * 
     * @return string
     */
    public String getLeftOperand() {
        return leftOperand;
    }

    /**
     * Getter for right operand
     * 
     * @return string
     */
    public String getRightOperand() {
        return rightOperand;
    }

    /**
     * Getter for math operation symbol
     * 
     * @return string
     */
    public String getMathSymbol() {
        return mathSymbol;
    }
	
}
