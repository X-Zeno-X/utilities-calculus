package zeno.util.calc;

import zeno.util.calc.variables.Argument;
import zeno.util.calc.variables.Function;
import zeno.util.calc.variables.functions.Constant;
import zeno.util.tools.primitives.Doubles;

/**
 * The {@code Functions} class defines functions for all standard {@link Doubles} methods.
 * 
 * @since Jan 7, 2017
 * @author Zeno
 */
public final class Functions
{
	// Arithmetic
	
	/**
	 * Returns the multiplication function.
	 * 
	 * @param x  the first variable
	 * @param y  the second variable
	 * @return  the multiply function
	 */
	public static Function Multiply(Variable x, Variable y)
	{
		return new Function()
		{
			@Override
			public double evaluate(double... args)
			{
				return x.evaluate(args[0])
					 * y.evaluate(args[1]);
			}
		};
	}
		
	/**
	 * Returns the subtraction function.
	 * 
	 * @param x  the first variable
	 * @param y  the second variable
	 * @return  the subtract function
	 */
	public static Function Subtract(Variable x, Variable y)
	{
		return new Function()
		{
			@Override
			public double evaluate(double... args)
			{
				return x.evaluate(args[0])
					 - y.evaluate(args[1]);
			}
		};
	}
	
	/**
	 * Returns the division function.
	 * 
	 * @param x  the first variable
	 * @param y  the second variable
	 * @return  the division function
	 */
	public static Function Divide(Variable x, Variable y)
	{
		return new Function()
		{
			@Override
			public double evaluate(double... args)
			{
				return x.evaluate(args[0])
					 / y.evaluate(args[1]);
			}
		};
	}
		
	/**
	 * Returns the addition function.
	 * 
	 * @param x  the first variable
	 * @param y  the second variable
	 * @return  the addition function
	 */
	public static Function Add(Variable x, Variable y)
	{
		return new Function()
		{
			@Override
			public double evaluate(double... args)
			{
				return x.evaluate(args[0])
					 + y.evaluate(args[1]);
			}
		};
	}
	
		
	
	// Exponential
	
	/**
	 * Returns the {@link Doubles#pow} function.
	 * 
	 * @param x  the power's base
	 * @param p  the power's exponent
	 * @return   the power function
	 */
	public static Function Pow(Variable x, Variable p)
	{
		return new Function()
		{
			@Override
			public double evaluate(double... args)
			{
				return Doubles.pow
				(
					x.evaluate(args[0]),
					p.evaluate(args[1])
				);
			}
		};
	}
	
	/**
	 * Returns the {@link Doubles#pow} function.
	 * 
	 * @param x  the power's base
	 * @param p  the power's exponent value
	 * @return   the power function
	 */
	public static Function Pow(Variable x, double p)
	{
		return Pow(x, Constant.from(p));
	}
	
	/**
	 * Returns the {@link Doubles#pow} function.
	 * 
	 * @param x  the power's base value
	 * @param p  the power's exponent
	 * @return   the power function
	 */
	public static Function Pow(double x, Variable p)
	{
		return Pow(Constant.from(x), p);
	}
	
	/**
	 * Returns the {@link Doubles#exp} function.
	 * 
	 * @param var  a variable to use
	 * @return  the exp function
	 */
	public static Function Exp(Variable var)
	{
		return new Function()
		{
			@Override
			public double evaluate(double... args)
			{
				return Doubles.exp
				(
					var.evaluate(args[0])
				);
			}
		};
	}

	
	/**
	 * Returns the {@link Doubles#pow} function.
	 * 
	 * @param x  the power's base argument
	 * @param p  the power's exponent argument
	 * @return   the power function
	 */
	public static Function Pow(String x, String p)
	{
		return Pow(Argument.from(x), Argument.from(p));
	}
	
	/**
	 * Returns the {@link Doubles#pow} function.
	 * 
	 * @param x  the power's base argument
	 * @param p  the power's exponent value
	 * @return   the power function
	 */
	public static Function Pow(String x, double p)
	{
		return Pow(Argument.from(x), Constant.from(p));
	}
	
	/**
	 * Returns the {@link Doubles#pow} function.
	 * 
	 * @param x  the power's base value
	 * @param p  the power's exponent argument
	 * @return   the power function
	 */
	public static Function Pow(double x, String p)
	{
		return Pow(Constant.from(x), Argument.from(p));
	}
	
	/**
	 * Returns the {@link Doubles#exp} function.
	 * 
	 * @param arg  an argument to use
	 * @return  the exponent function
	 */
	public static Function Exp(String arg)
	{
		return Exp(Argument.from(arg));
	}

	
	
	// Extremes
		
	/**
	 * Returns the {@link Doubles#min} function.
	 * 
	 * @param vars  a list of variables
	 * @return  the minimum function
	 */
	public static Function Min(Variable... vars)
	{
		return new Function()
		{
			@Override
			public double evaluate(double... args)
			{
				return Doubles.min
				(
					eval(vars, args)
				);
			}
		};
	}
		
	/**
	 * Returns the {@link Doubles#max} function.
	 * 
	 * @param vars  a list of variables
	 * @return  the maximum function
	 */
	public static Function Max(Variable... vars)
	{
		return new Function()
		{
			@Override
			public double evaluate(double... args)
			{
				return Doubles.max
				(
					eval(vars, args)
				);
			}
		};
	}
		
	/**
	 * Returns the {@link Doubles#sign} function.
	 * 
	 * @param var  a variable to use
	 * @return  the sign function
	 */
	public static Function Sign(Variable var)
	{
		return new Function()
		{
			@Override
			public double evaluate(double... args)
			{
				return Doubles.sign
				(
					var.evaluate(args[0])
				);
			}
		};
	}

	/**
	 * Returns the {@link Doubles#abs} function.
	 * 
	 * @param var  a variable to use
	 * @return  the abs function
	 */
	public static Function Abs(Variable var)
	{
		return new Function()
		{
			@Override
			public double evaluate(double... args)
			{
				return Doubles.abs
				(
					var.evaluate(args[0])
				);
			}
		};
	}
	
	
	/**
	 * Returns the {@link Doubles#min} function.
	 * 
	 * @param args  a list of arguments
	 * @return  the minimum function
	 */
	public static Function Min(String... args)
	{
		return Min(Argument.from(args));
	}
		
	/**
	 * Returns the {@link Doubles#max} function.
	 * 
	 * @param args  a list of arguments
	 * @return  the maximum function
	 */
	public static Function Max(String... args)
	{
		return Max(Argument.from(args));
	}
	
	/**
	 * Returns the {@link Doubles#sign} function.
	 * 
	 * @param arg  an argument to use
	 * @return  the sign function
	 */
	public static Function Sign(String arg)
	{
		return Sign(Argument.from(arg));
	}
	
	/**
	 * Returns the {@link Doubles#abs} function.
	 * 
	 * @param arg  an argument to use
	 * @return  the abs function
	 */
	public static Function Abs(String arg)
	{
		return Abs(Argument.from(arg));
	}

	
	
	// Logarithms
	
	/**
	 * Returns the {@link Doubles#log} function.
	 * 
	 * @param var  a variable to use
	 * @param base  a base to use
	 * @return  the log function
	 */
	public static Function Log(Variable var, Variable base)
	{
		return new Function()
		{
			@Override
			public double evaluate(double... args)
			{
				return Doubles.log
				(
					 var.evaluate(args[0]),
					base.evaluate(args[1])
				);
			}
		};
	}
		
	/**
	 * Returns the {@link Doubles#log} function.
	 * 
	 * @param var  a variable to use
	 * @param base  a base value to use
	 * @return  the log function
	 */
	public static Function Log(Variable var, double base)
	{
		return Log(var, Constant.from(base));
	}
	
	/**
	 * Returns the {@link Doubles#log} function.
	 * 
	 * @param var  a value to use
	 * @param base  a base to use
	 * @return  the log function
	 */
	public static Function Log(double var, Variable base)
	{
		return Log(Constant.from(var), base);
	}
	
	/**
	 * Returns the {@link Doubles#log10} function.
	 * 
	 * @param var  a variable to use
	 * @return   the log10 function
	 */
	public static Function Log10(Variable var)
	{
		return new Function()
		{
			@Override
			public double evaluate(double... args)
			{
				return Doubles.log10
				(
					var.evaluate(args[0])
				);
			}
		};
	}
					
	/**
	 * Returns the {@link Doubles#ln} function.
	 * 
	 * @param var  a variable to use
	 * @return  the ln function
	 */
	public static Function Ln(Variable var)
	{
		return new Function()
		{
			@Override
			public double evaluate(double... args)
			{
				return Doubles.ln
				(
					var.evaluate(args[0])
				);
			}
		};
	}
	
	
	/**
	 * Returns the {@link Doubles#log} function.
	 * 
	 * @param arg  an argument to use
	 * @param base  a base to use
	 * @return  the log function
	 */
	public static Function Log(String arg, String base)
	{
		return Log(Argument.from(arg), Argument.from(base));
	}
	
	/**
	 * Returns the {@link Doubles#log} function.
	 * 
	 * @param arg  an argument to use
	 * @param base  a base value to use
	 * @return  the log function
	 */
	public static Function Log(String arg, double base)
	{
		return Log(Argument.from(arg), Constant.from(base));
	}
	
	/**
	 * Returns the {@link Doubles#log} function.
	 * 
	 * @param var  a value to use
	 * @param base  a base argument to use
	 * @return  the log function
	 */
	public static Function Log(double var, String base)
	{
		return Log(Constant.from(var), Argument.from(base));
	}
	
	/**
	 * Returns the {@link Doubles#log10} function.
	 * 
	 * @param arg  an argument to use
	 * @return   the log10 function
	 */
	public static Function Log10(String arg)
	{
		return Log10(Argument.from(arg));
	}
	
	/**
	 * Returns the {@link Doubles#ln} function.
	 * 
	 * @param arg  an argument to use
	 * @return  the ln function
	 */
	public static Function Ln(String arg)
	{
		return Ln(Argument.from(arg));
	}
	
	
	
	// Roots
		
	/**
	 * Returns the {@link Doubles#cbrt} function.
	 * 
	 * @param var  a variable to use
	 * @return  the cube root function
	 */
	public static Function Cbrt(Variable var)
	{
		return new Function()
		{
			@Override
			public double evaluate(double... args)
			{
				return Doubles.cbrt
				(
					var.evaluate(args[0])
				);
			}
		};
	}
	
	/**
	 * Returns the {@link Doubles#sqrt} function.
	 * 
	 * @param var  a variable to use
	 * @return  the square root function
	 */
	public static Function Sqrt(Variable var)
	{
		return new Function()
		{
			@Override
			public double evaluate(double... args)
			{
				return Doubles.sqrt
				(
					var.evaluate(args[0])
				);
			}
		};
	}
	
	
	/**
	 * Returns the {@link Doubles#cbrt} function.
	 * 
	 * @param arg  an argument to use
	 * @return  the cube root function
	 */
	public static Function Cbrt(String arg)
	{
		return Cbrt(Argument.from(arg));
	}
	
	/**
	 * Returns the {@link Doubles#sqrt} function.
	 * 
	 * @param arg  an argument to use
	 * @return  the cube root function
	 */
	public static Function Sqrt(String arg)
	{
		return Sqrt(Argument.from(arg));
	}
	
	
	
	// Rounding

	/**
	 * Returns the {@link Doubles#clamp} function.
	 * 
	 * @param var  a variable to clamp
	 * @param min  the variable's minimum
	 * @param max  the variable's maximum
	 * @return  the clamp function
	 */
	public static Function Clamp(Variable var, Variable min, Variable max)
	{
		return new Function()
		{
			@Override
			public double evaluate(double... args)
			{
				return Doubles.clamp
				(
					var.evaluate(args[0]),
					min.evaluate(args[1]),
					max.evaluate(args[2])
				);
			}
		};
	}
			
	/**
	 * Returns the {@link Doubles#clamp} function.
	 * 
	 * @param var  a variable to clamp
	 * @param min  the argument's minimum
	 * @param max  the argument's maximum
	 * @return  the clamp function
	 */
	public static Function Clamp(Variable var, double min, double max)
	{
		return Clamp(var, Constant.from(min), Constant.from(max));
	}
	
	/**
	 * Returns the {@link Doubles#clamp} function.
	 * 
	 * @param arg  an argument to clamp
	 * @param min  the argument's minimum
	 * @param max  the argument's maximum
	 * @return  the clamp function
	 */
	public static Function Clamp(String arg, String min, String max)
	{
		return Clamp(Argument.from(arg), Argument.from(min), Argument.from(max));
	}
	
	/**
	 * Returns the {@link Doubles#clamp} function.
	 * 
	 * @param arg  an argument to clamp
	 * @param min  the argument's minimum
	 * @param max  the argument's maximum
	 * @return  the clamp function
	 */
	public static Function Clamp(String arg, double min, double max)
	{
		return Clamp(Argument.from(arg), Constant.from(min), Constant.from(max));
	}
	
	
	/**
	 * Returns the {@link Doubles#round} function.
	 * 
	 * @param var  a variable to round
	 * @param dec  a decimal count
	 * @return  the round function
	 */
	public static Function Round(Variable var, int dec)
	{		
		return new Function()
		{
			@Override
			public double evaluate(double... args)
			{
				return Doubles.round
				(
					var.evaluate(args[0]),
					dec
				);
			}
		};
	}
				
	/**
	 * Returns the {@link Doubles#round} function.
	 * 
	 * @param var  a variable to use
	 * @return  a rounded value
	 */
	public static Function Round(Variable var)
	{
		return new Function()
		{
			@Override
			public double evaluate(double... args)
			{
				return Doubles.round
				(
					var.evaluate(args[0])
				);
			}
		};
	}
	
	/**
	 * Returns the lower integer closest to a value.
	 * 
	 * @param var  a variable to use
	 * @return  a rounded value
	 */
	public static Function Floor(Variable var)
	{
		return new Function()
		{
			@Override
			public double evaluate(double... args)
			{
				return Doubles.floor
				(
					var.evaluate(args[0])
				);
			}
		};
	}

	/**
	 * Returns the higher integer closest to a value.
	 * 
	 * @param var  a variable to use
	 * @return  a rounded value
	 */
	public static Function Ceil(Variable var)
	{
		return new Function()
		{
			@Override
			public double evaluate(double... args)
			{
				return Doubles.ceil
				(
					var.evaluate(args[0])
				);
			}
		};
	}
	
		
	/**
	 * Returns the {@link Doubles#round} function.
	 * 
	 * @param arg  an argument to round
	 * @param dec  a decimal count
	 * @return  the round function
	 */
	public static Function Round(String arg, int dec)
	{		
		return Round(Argument.from(arg), dec);
	}
	
	/**
	 * Returns the {@link Doubles#round} function.
	 * 
	 * @param arg  an argument to use
	 * @return  a rounded value
	 */
	public static Function Round(String arg)
	{
		return Round(Argument.from(arg));
	}
	
	/**
	 * Returns the {@link Doubles#floor} function.
	 * 
	 * @param arg  an argument to use
	 * @return  a rounded value
	 */
	public static Function Floor(String arg)
	{
		return Floor(Argument.from(arg));
	}

	/**
	 * Returns the {@link Doubles#ceil} function.
	 * 
	 * @param arg  an argument to use
	 * @return  a rounded value
	 */
	public static Function Ceil(String arg)
	{
		return Ceil(Argument.from(arg));
	}
	
	
	
	// Trigonometry
	
	/**
	 * Returns the {@link Doubles#atan2} function.
	 * 
	 * @param x  the x-co�rdinate variable
	 * @param y  the y-co�rdinate variable
	 * @return  the atan2 function
	 */
	public static Function Atan2(Variable x, Variable y)
	{
		return new Function()
		{
			@Override
			public double evaluate(double... args)
			{
				return Doubles.atan2
				(
					x.evaluate(args[0]),
					y.evaluate(args[1])
				);
			}
		};
	}
	
	/**
	 * Returns the {@link Doubles#atan2} function.
	 * 
	 * @param x  the x-co�rdinate argument
	 * @param y  the y-co�rdinate argument
	 * @return  the atan2 function
	 */
	public static Function Atan2(String x, String y)
	{
		return Atan2(Argument.from(x), Argument.from(y));
	}
		
	
	/**
	 * Returns the {@link Doubles#sin} function.
	 * 
	 * @param var  an angle variable
	 * @return  the sin function
	 */
	public static Function Sin(Variable var)
	{
		return new Function()
		{
			@Override
			public double evaluate(double... args)
			{
				return Doubles.sin
				(
					var.evaluate(args[0])
				);
			}
		};
	}
	
	/**
	 * Returns the {@link Doubles#cos} function.
	 * 
	 * @param var  an angle variable
	 * @return  the cos function
	 */
	public static Function Cos(Variable var)
	{
		return new Function()
		{
			@Override
			public double evaluate(double... args)
			{
				return Doubles.cos
				(
					var.evaluate(args[0])
				);
			}
		};
	}
	
	/**
	 * Returns the {@link Doubles#tan} function.
	 * 
	 * @param var  an angle variable
	 * @return  the tan function
	 */
	public static Function Tan(Variable var)
	{
		return new Function()
		{
			@Override
			public double evaluate(double... args)
			{
				return Doubles.tan
				(
					var.evaluate(args[0])
				);
			}
		};
	}
	
	/**
	 * Returns the {@link Doubles#sin} function.
	 * 
	 * @param arg  an angle argument
	 * @return  the sin function
	 */
	public static Function Sin(String arg)
	{
		return Sin(Argument.from(arg));
	}
	
	/**
	 * Returns the {@link Doubles#cos} function.
	 * 
	 * @param arg  an angle argument
	 * @return  the cos function
	 */
	public static Function Cos(String arg)
	{
		return Cos(Argument.from(arg));
	}
	
	/**
	 * Returns the {@link Doubles#tan} function.
	 * 
	 * @param arg  an angle argument
	 * @return  the tan function
	 */
	public static Function Tan(String arg)
	{
		return Tan(Argument.from(arg));
	}
	
	
	/**
	 * Returns the {@link Doubles#cosh} function.
	 * 
	 * @param var  a variable to use
	 * @return  the cosh function
	 */
	public static Function Cosh(Variable var)
	{
		return new Function()
		{
			@Override
			public double evaluate(double... args)
			{
				return Doubles.cosh
				(
					var.evaluate(args[0])
				);
			}
		};
	}

	/**
	 * Returns the {@link Doubles#sinh} function.
	 * 
	 * @param var  a variable to use
	 * @return  the sinh function
	 */
	public static Function Sinh(Variable var)
	{
		return new Function()
		{
			@Override
			public double evaluate(double... args)
			{
				return Doubles.sinh
				(
					var.evaluate(args[0])
				);
			}
		};
	}
		
	/**
	 * Returns the {@link Doubles#tanh} function.
	 * 
	 * @param var  a variable to use
	 * @return  the tanh function
	 */
	public static Function Tanh(Variable var)
	{
		return new Function()
		{
			@Override
			public double evaluate(double... args)
			{
				return Doubles.tanh
				(
					var.evaluate(args[0])
				);
			}
		};
	}
	
	/**
	 * Returns the {@link Doubles#cosh} function.
	 * 
	 * @param arg  an argument to use
	 * @return  the cosh function
	 */
	public static Function Cosh(String arg)
	{
		return Cosh(Argument.from(arg));
	}

	/**
	 * Returns the {@link Doubles#sinh} function.
	 * 
	 * @param arg  an argument to use
	 * @return  the sinh function
	 */
	public static Function Sinh(String arg)
	{
		return Sinh(Argument.from(arg));
	}
		
	/**
	 * Returns the {@link Doubles#tanh} function.
	 * 
	 * @param arg  an argument to use
	 * @return  the tanh function
	 */
	public static Function Tanh(String arg)
	{
		return Tanh(Argument.from(arg));
	}
	
	
	/**
	 * Returns the {@link Doubles#acos} function.
	 * 
	 * @param var  a variable to use
	 * @return  the arccos function
	 */
	public static Function Acos(Variable var)
	{
		return new Function()
		{
			@Override
			public double evaluate(double... args)
			{
				return Doubles.acos
				(
					var.evaluate(args[0])
				);
			}
		};
	}

	/**
	 * Returns the {@link Doubles#asin} function.
	 * 
	 * @param var  a variable to use
	 * @return  the arcsin function
	 */
	public static Function ASin(Variable var)
	{
		return new Function()
		{
			@Override
			public double evaluate(double... args)
			{
				return Doubles.asin
				(
					var.evaluate(args[0])
				);
			}
		};
	}
		
	/**
	 * Returns the {@link Doubles#atan} function.
	 * 
	 * @param var  a variable to use
	 * @return  the arctan function
	 */
	public static Function ATan(Variable var)
	{
		return new Function()
		{
			@Override
			public double evaluate(double... args)
			{
				return Doubles.atan
				(
					var.evaluate(args[0])
				);
			}
		};
	}

	/**
	 * Returns the {@link Doubles#acos} function.
	 * 
	 * @param arg  an argument to use
	 * @return  the arccos function
	 */
	public static Function Acos(String arg)
	{
		return Acos(Argument.from(arg));
	}

	/**
	 * Returns the {@link Doubles#asin} function.
	 * 
	 * @param arg  an argument to use
	 * @return  the arcsin function
	 */
	public static Function ASin(String arg)
	{
		return ASin(Argument.from(arg));
	}
		
	/**
	 * Returns the {@link Doubles#atan} function.
	 * 
	 * @param arg  an argument to use
	 * @return  the arctan function
	 */
	public static Function ATan(String arg)
	{
		return ATan(Argument.from(arg));
	}

	
	
	static double[] eval(Variable[] vars, double[] vals)
	{
		double[] result = new double[vars.length];
		for(int i = 0; i < vars.length; i++)
		{
			result[i] = vars[i].evaluate(vals[i]);
		}
		
		return result;
	}
		
 	private Functions()
	{
		// NOT APPLICABLE
	}
}