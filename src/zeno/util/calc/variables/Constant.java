package zeno.util.calc.variables;

import zeno.util.calc.Variable;

/**
 * The {@code Constant} class defines a variable with a constant value.
 * 
 * @since Jan 9, 2017
 * @author Zeno
 * 
 * @see Variable
 */
public class Constant implements Variable
{
	private double val;
	
	/**
	 * Creates a new {@code Constant}.
	 * 
	 * @param val  a constant value
	 */
	public Constant(double val)
	{
		this.val = val;
	}
	
	@Override
	public double evaluate(double... args)
	{
		return val;
	}
}
