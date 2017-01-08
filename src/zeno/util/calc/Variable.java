package zeno.util.calc;

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
}
