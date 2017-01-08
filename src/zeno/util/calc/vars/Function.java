package zeno.util.calc.vars;

import zeno.util.calc.Functions;
import zeno.util.calc.Variable;

/**
 * The {@code Function} class defines a generic function in one or more variables.
 * <br> This class implements the variable class to allow function chaining.
 * 
 * @since Jan 7, 2017
 * @author Zeno
 * 
 * @see Variable
 */
public abstract class Function implements Variable
{	
	/**
	 * Returns a multiplication {@code Function}.
	 * 
	 * @param var  a variable to multiply
	 * @return  a multiply function
	 */
	public Function times(Variable var)
	{
		return Functions.Multiply(this, var);
	}

	/**
	 * Returns a subtraction {@code Function}.
	 * 
	 * @param var  a variable to subtract
	 * @return  a subtract function
	 */
	public Function minus(Variable var)
	{
		return Functions.Subtract(this, var);
	}
	
	/**
	 * Returns an addition {@code Function}.
	 * 
	 * @param var  a variable to add
	 * @return  an add function
	 */
	public Function plus(Variable var)
	{
		return Functions.Add(this, var);
	}

	/**
	 * Returns a division {@code Function}.
	 * 
	 * @param var  a variable to divide
	 * @return  a division function
	 */
	public Function over(Variable var)
	{
		return Functions.Divide(this, var);
	}
}