package zeno.util.calc.variables.functions;

import zeno.util.calc.variables.Function;

/**
 * The {@code Rational} class defines a rational function as a numerator and denominator.
 * 
 * @since Jan 10, 2017
 * @author Zeno
 * 
 * @see Function
 */
public class Rational extends Function
{
	private Polynomial lower, upper, quotient;
	
	/**
	 * Creates a new {@code Rational}.
	 * 
	 * @param numer  a numerator polynomial
	 * @param denom  a denominator polynomial
	 * @see Polynomial
	 */
	public Rational(Polynomial numer, Polynomial denom)
	{
		upper = numer.copy();
		lower = denom.copy();
		
		quotient = new Polynomial();
		while(lower.Degree() <= upper.Degree())
		{
			int degr = upper.Degree();
			int degd = lower.Degree();
			int deg  = degr - degd;

			double valr = upper.Coefficient(degr);
			double vald = lower.Coefficient(degd);
			double val  = valr / vald;
			
			
			Polynomial ply = lower.times(deg, -val);
			quotient = quotient.plus(deg, val);
			upper = upper.plus(ply);
		}
	}
	
	@Override
	public double evaluate(double... args)
	{
		return quotient.evaluate(args) + upper.evaluate(args) / lower.evaluate(args);
	}

	
	/**
	 * Returns the remainder of the {@code Rational}.
	 * 
	 * @return  the rational remainder
	 * @see Polynomial
	 */
	public Polynomial Remainder()
	{
		return upper;
	}
	
	/**
	 * Returns the quotient of the {@code Rational}.
	 * 
	 * @return  the rational quotient
	 * @see Polynomial
	 */
	public Polynomial Quotient()
	{
		return quotient;
	}
	
	/**
	 * Returns the divisor of the {@code Rational}.
	 * 
	 * @return  the rational divisor
	 * @see Polynomial
	 */
	public Polynomial Divisor()
	{
		return lower;
	}
}