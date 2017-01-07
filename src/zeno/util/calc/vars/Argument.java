package zeno.util.calc.vars;

import zeno.util.calc.Variable;
import zeno.util.tools.generic.properties.Discernible;

/**
 * An argument defines a {@code Variable} that maps directly to a value.
 * 
 * @since Jan 7, 2017
 * @author Zeno
 * 
 * @see Discernible
 * @see Variable
 */
public class Argument implements Discernible, Variable
{	
	private String name;
	
	/**
	 * Creates a new {@code Argument}.
	 * 
	 * @param name  an argument name
	 * @see String
	 */
	public Argument(String name)
	{
		this.name = name;
	}
	
	
	@Override
	public double evaluate(double... args)
	{
		return args[0];
	}
	
	@Override
	public String toString()
	{
		return name;
	}
	
	@Override
	public int getID()
	{
		return name.hashCode();
	}
}