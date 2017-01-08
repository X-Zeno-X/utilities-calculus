package zeno.util.calc.variables;

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
	/**
	 * Creates an array of {@code Arguments} from names.
	 * 
	 * @param args  an argument name array
	 * @return  an array of arguments
	 */
	public static Argument[] from(String... args)
	{
		Argument[] result = new Argument[args.length];
		for(int i = 0; i < args.length; i++)
		{
			result[i] = from(args[i]);
		}
		
		return result;
	}
	
	/**
	 * Creates an {@code Argument} from a name.
	 * 
	 * @param arg  an argument name
	 * @return  an argument
	 */
	public static Argument from(String arg)
	{
		return new Argument(arg);
	}
	
	
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