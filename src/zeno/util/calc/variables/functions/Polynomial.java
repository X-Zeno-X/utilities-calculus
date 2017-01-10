package zeno.util.calc.variables.functions;

import java.util.TreeMap;
import java.util.Map.Entry;

import zeno.util.algebra.tensors.vectors.complex.Complex;
import zeno.util.calc.variables.Function;
import zeno.util.calc.variables.algorithms.RootFinder;
import zeno.util.tools.generic.properties.Copyable;
import zeno.util.tools.primitives.Doubles;
import zeno.util.tools.primitives.Integers;

/**
 * The {@code Polynomial} class defines a univariate (having only one variable) polynomial.
 * <br> The polynomial is of the form {@code a.x^n + b.x^(n-1) + ... + c.x^2 + d.x + e}.
 * 
 * @since Oct 27, 2014
 * @author Zeno
 * 
 * @see Copyable
 * @see Function
 */
public class Polynomial extends Function implements Copyable<Polynomial>
{
	private static RootFinder roots = new RootFinder();
	
	
	private TreeMap<Integer, Double> terms;
	
	/**
	 * Creates a new {@code Polynomial}.
	 * Each term is formatted as c, cx, or cx^p.
	 * Each character represents the following:
	 * <ul>
	 * 	<li> The character 'c' represents a decimal coëfficient. </li>
	 *  <li> The character 'x' represents the variable name. 	 </li>
	 *  <li> The character 'p' represents the term's power. 	 </li>
	 * </ul>
	 * 
	 * @param var   the variable name
	 * @param text  the polynomial string
	 */
	public Polynomial(String var, String text)
	{
		this();
		
		// Normalize the polynomial string.
		String standard = text.replaceAll(" ", "");
		standard = standard.replaceAll("-", "+-");
				
		// Iterate each polynomial term.
		String[] terms = standard.split("\\+");
		for(int i = 0; i < terms.length; i++)
		{
			String term = terms[i];
			
			// Separate term into value and degree.
			String[] split = new String[2];
			if(term.contains(var))
			{
				if(term.contains("^"))
					split = term.split(var + "\\^");
				else
				{
					split[0] = term.replace(var, "");
					split[1] = "1";
				}
			}
			else
			{
				split[0] = term;
				split[1] = "0";
			}
			
			// Parse the value.
			double val = 1.0;
			if(!split[0].isEmpty())
			{
				if(!split[0].equals("-"))
					val = Doubles.parse(split[0].trim());
				else
					val = -1.0;
			}
			
			// Parse the degree.
			int deg = Integers.parse(split[1].trim());
			
			// Add the parsed term.
			add(deg, val);
		}
	}
	
	/**
	 * Creates a new {@code Polynomial}.
	 * Its coëfficients are defined from the highest degree to the lowest.
	 * 
	 * @param vals  the polynomial's coëfficients
	 */
	public Polynomial(double... vals)
	{
		terms = new TreeMap<>();
		for(int i = 0; i < vals.length; i++)
		{
			set(vals.length - i - 1, vals[i]);
		}
	}
		
	/**
	 * Creates a new {@code Polynomial}.
	 */
	public Polynomial()
	{
		this(0);
	}
	
	
	/**
	 * Multiplies the {@code Polynomial} with a term {@code Polynomial}.
	 * 
	 * @param deg  the term's degree
	 * @param val  the term's coëfficient
	 * @return  the polynomial result
	 */
	public Polynomial times(int deg, double val)
	{
		Polynomial result = new Polynomial();
		for(int degree : terms.navigableKeySet())
		{
			double value = val * Coefficient(degree);
			result.set(deg + degree, value);
		}
		
		return result;
	}
	
	/**
	 * Calculates the addition with a single term {@code Polynomial}.
	 * 
	 * @param deg  the term's degree
	 * @param val  the term's coëfficient
	 * @return  the polynomial result
	 */
	public Polynomial plus(int deg, double val)
	{
		Polynomial result = copy();
		result.add(deg, val);
		return result;
	}
	
	/**
	 * Multiplies the {@code Polynomial} with a {@code Polynomial}.
	 * 
	 * @param poly  a polynomial to multiply with
	 * @return  a polynomial result
	 */
	public Polynomial times(Polynomial poly)
	{
		double value = 0;
		
		Polynomial result = new Polynomial();
		for(int deg1 : poly.terms.navigableKeySet())
		{
			for(int deg2 : terms.navigableKeySet())
			{
				value = Coefficient(deg2);
				value *= poly.Coefficient(deg1);	
				result.add(deg1 + deg2, value);
			}
		}
		
		return result;
	}
	
	/**
	 * Calculates the subtraction with another {@code Polynomial}.
	 * 
	 * @param poly  a polynomial to subtract
	 * @return  the polynomial result
	 */
	public Polynomial minus(Polynomial poly)
	{
		Polynomial copy = copy();
		for(int deg : poly.terms.navigableKeySet())
		{
			copy.add(deg, -poly.Coefficient(deg));
		}
		
		return copy;
	}
		
	/**
	 * Calculates the addition with another {@code Polynomial}.
	 * 
	 * @param poly  a polynomial to add
	 * @return  the polynomial result
	 */
	public Polynomial plus(Polynomial poly)
	{
		Polynomial copy = copy();
		for(int deg : poly.terms.navigableKeySet())
		{
			copy.add(deg, poly.Coefficient(deg));
		}
		
		return copy;
	}
	
	/**
	 * Calculates the division with another {@code Polynomial}.
	 * 
	 * @param poly  a polynomial to add
	 * @return  the polynomial result
	 */
	public Rational over(Polynomial poly)
	{
		return new Rational(this, poly);
	}
	
	/**
	 * Returns a single term of the {@code Polynomial}.
	 * 
	 * @param deg  the term's degree
	 * @return  a term polynomial
	 */
	public Polynomial Term(int deg)
	{
		Polynomial result = new Polynomial();
		result.set(deg, Coefficient(deg));
		return result;
	}
	
	
	/**
	 * Returns a term coëfficient of the {@code Polynomial}.
	 * 
	 * @param deg  the term's degree
	 * @return  the term's coëfficient
	 */
	public double Coefficient(int deg)
	{
		Double val = terms.get(deg);
		if(val != null)
		{
			return val;
		}
		
		return 0;
	}
	
	/**
	 * Returns the complex roots of the {@code Polynomial}.
	 * 
	 * @return  an array of real roots
	 * @see Complex
	 */
	public Complex[] ComplexRoots()
	{
		return roots.findComplexRoots(this);
	}

	/**
	 * Returns the coëfficients of the {@code Polynomial}.
	 * 
	 * @return  the polynomial's coefficients
	 */
	public double[] Coefficients()
	{
		double[] coef = new double[Degree() + 1];
		for(int deg : terms.keySet())
		{
			coef[deg] = Coefficient(deg);
		}
		
		return coef;
	}
	
	/**
	 * Returns the real roots of the {@code Polynomial}.
	 * 
	 * @return  an array of real roots
	 */
	public float[] RealRoots()
	{
		return roots.findRealRoots(this);
	}
	
	/**
	 * Returns the degree of the {@code Polynomial}.
	 * 
	 * @return  the polynomial's degree
	 */
	public int Degree()
	{
		if(!terms.isEmpty())
			return terms.lastKey();
		return -1;
	}
	
	
	private void add(int deg, double val)
	{
		Double curr = terms.get(deg);
		if(curr != null)
			set(deg, curr + val);
		else
			set(deg, val);
	}

	private void set(int deg, double val)
	{
		if(val != 0)
			terms.put(deg, val);
		else if(deg != 0)
			terms.remove(deg);
		else
			terms.put(0, 0d);
	}
	
	
	@Override
	public double evaluate(double... args)
	{
		double result = 0; int deg = Degree();
		for(int cur : terms.descendingKeySet())
		{
			double pow = Doubles.pow(args[0], deg - cur);
			double cff = terms.get(cur);
			
			result *= pow;
			result += cff;
			
			deg = cur;
		}
	
		return result;
	}

	@Override
	public Polynomial times(double val)
	{
		Polynomial copy = copy();
		for(int deg : terms.navigableKeySet())
		{
			copy.set(deg, Coefficient(deg) * val);
		}
		
		return copy;
	}

	@Override
	public Polynomial minus(double val)
	{
		Polynomial copy = copy();
		copy.set(0, Coefficient(0) - val);
		return copy;
	}
	
	@Override
	public Polynomial plus(double val)
	{
		Polynomial copy = copy();
		copy.set(0, Coefficient(0) + val);
		return copy;
	}

	@Override
	public Polynomial over(double val)
	{
		Polynomial copy = copy();
		for(int deg : terms.navigableKeySet())
		{
			copy.set(deg, Coefficient(deg) / val);
		}
		
		return copy;
	}
	
	@Override
	public Polynomial instance()
	{
		return new Polynomial();
	}
	
	@Override
	public Polynomial copy()
	{
		Polynomial copy = Copyable.super.copy();
		for(Entry<Integer, Double> entry : terms.entrySet())
		{
			copy.set(entry.getKey(), entry.getValue());
		}
		
		return copy;
	}
	
	@Override
	public String toString()
	{
		String poly = "";
		
		boolean isFirst = true;
		for(int deg : terms.descendingKeySet())
		{
			double val = terms.get(deg);
			double abs = Doubles.abs(val);
			
			if(val != 0)
			{
				poly += (val < 0 ? " - " : (isFirst ? "" : " + "));
				poly += (abs != 1 || deg == 0 ? abs + " " : "");
				poly += (deg != 0 ? "x" + (deg != 1 ? "^" + deg : "") : "");
				isFirst = false;
				continue;
			}
			
			if(deg == 0)
			{
				if(poly.equals(""))
				{
					poly += (val < 0 ? "-" : "") + abs;
				}	
			}			
		}
		
		return poly;
	}
}