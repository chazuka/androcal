package me.egois.calculator;

import android.widget.TextView;

/**
 * Math operation class
 * 
 * @author chz <chazzuka@gmail.com>
 */
public class Calculator {

	protected MathOperation mOperation;
	protected TextView mDisplay;

	/**
	 * Calculator class constructor
	 * 
	 * @param mOperation instance of MathOperation
	 * @param mDisplay reference of TextView where the statement displayed
	 */
	public Calculator(MathOperation mOperation, TextView mDisplay) {

		this.mOperation = mOperation;
		this.mDisplay = mDisplay;
	}

	/**
	 * Reset operands and displays
	 */
	public void reset() {
		this.mOperation.reset();
		this.updateDisplay();
	}

	/**
	 * Add number operand and update displays
	 * 
	 * @param op added operand to statement
	 */
	public void setOperand(String op) {
		this.mOperation.setOperand(op);
		this.updateDisplay();
	}

	/**
	 * Add math symbol to statement and update displays
	 * 
	 * @param m math symbol added to statement
	 */
	public void setMath(String m) {
		this.mOperation.setMath(m);
		this.updateDisplay();
	}

	/**
	 * Explicitly evaluate math statement and update displays
	 */
	public void calculate() {
		try {
			this.mOperation.calculate();
		} catch (Exception e) {
		}
		this.updateDisplay();
	}
	
	/**
	 * Check if current statement has left operand
	 * 
	 * @return boolean
	 */
	public boolean hasLeftOperand()
	{
		return !this.mOperation.getLeftOperand().isEmpty();
	}
	
	/**
	 * Check if current statement has right operand
	 * 
	 * @return boolean
	 */
	public boolean hasRightOperand()
	{
		return !this.mOperation.getRightOperand().isEmpty();
	}
	
	/**
	 * Check if current statement has math operand
	 * 
	 * @return boolean
	 */
	public boolean hasMathOperand()
	{
		return !this.mOperation.getMathSymbol().isEmpty();
	}

	/**
	 * Update displays with current statement
	 */
	protected void updateDisplay() {
		String d = (new StringBuilder())
				.append(this.mOperation.getLeftOperand())
				.append(this.mOperation.getMathSymbol())
				.append(this.mOperation.getRightOperand()).toString();
		this.mDisplay.setText(d);
	}
}
