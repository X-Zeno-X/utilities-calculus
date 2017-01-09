package zeno.util.calc;

import zeno.util.calc.variables.Argument;
import zeno.util.calc.variables.Constant;
import zeno.util.calc.variables.Function;

/**
 * The {@code Variable} interface defines an object with real-valued variables.
 * 
 * @since Jan 7, 2017
 * @author Zeno
 */
@FunctionalInterface
public interface Variable
{
	/**
	 * Evaluates the {@code Variable} for specific values.
	 * 
	 * @param args  an list of arguments
	 * @return  the evaluated result
	 */
	public abstract double evaluate(double... args);

	
	/**
	 * Returns a multiplication {@code Function}.
	 * 
	 * @param var  a variable to multiply
	 * @return  a multiply function
	 */
	public default Function times(Variable var)
	{
		return Functions.Multiply(this, var);
	}

	/**
	 * Returns a subtraction {@code Function}.
	 * 
	 * @param var  a variable to subtract
	 * @return  a subtract function
	 */
	public default Function minus(Variable var)
	{
		return Functions.Subtract(this, var);
	}
	
	/**
	 * Returns an addition {@code Function}.
	 * 
	 * @param var  a variable to add
	 * @return  an add function
	 */
	public default Function plus(Variable var)
	{
		return Functions.Add(this, var);
	}

	/**
	 * Returns a division {@code Function}.
	 * 
	 * @param var  a variable to divide
	 * @return  a division function
	 */
	public default Function over(Variable var)
	{
		return Functions.Divide(this, var);
	}
		
	
	/**
	 * Returns a multiplication {@code Function}.
	 * 
	 * @param arg  an argument to multiply
	 * @return  a multiply function
	 */
	public default Function times(String arg)
	{
		return times(Argument.from(arg));
	}

	/**
	 * Returns a subtraction {@code Function}.
	 * 
	 * @param arg  an argument to subtract
	 * @return  a subtract function
	 */
	public default Function minus(String arg)
	{
		return minus(Argument.from(arg));
	}
	
	/**
	 * Returns an addition {@code Function}.
	 * 
	 * @param arg  an argument to add
	 * @return  an add function
	 */
	public default Function plus(String arg)
	{
		return plus(Argument.from(arg));
	}

	/**
	 * Returns a division {@code Function}.
	 * 
	 * @param arg  an argument to divide
	 * @return  a division function
	 */
	public default Function over(String arg)
	{
		return over(Argument.from(arg));
	}

	
	/**
	 * Returns a multiplication {@code Function}.
	 * 
	 * @param val  a value to multiply
	 * @return  a multiply function
	 */
	public default Function times(double val)
	{
		return times(Constant.from(val));
	}

	/**
	 * Returns a subtraction {@code Function}.
	 * 
	 * @param val  a value to subtract
	 * @return  a subtract function
	 */
	public default Function minus(double val)
	{
		return minus(Constant.from(val));
	}
	
	/**
	 * Returns an addition {@code Function}.
	 * 
	 * @param val  a value to add
	 * @return  an add function
	 */
	public default Function plus(double val)
	{
		return plus(Constant.from(val));
	}

	/**
	 * Returns a division {@code Function}.
	 * 
	 * @param val  a value to divide
	 * @return  a division function
	 */
	public default Function over(double val)
	{
		return over(Constant.from(val));
	}
}