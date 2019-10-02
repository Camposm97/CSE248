package p02_Temperature_Conversion;

/**
 * The TemperatureConversion Java Application:
 * Prints a table converting Celcius to Fahrenheit degrees.  
 * @see <A HREF="../TemperatureConversion.java"> Java Source Code </A>"
 * 
 * @author Camposm97 <A HREF="mailto: campm47@mail.sunysuffolk.edu"> campm47@mail.sunysuffolk.edu </A>
 * 
 * @version October 02, 2019
 * 
 */
public class TemperatureConversion {
	
	/**
	 * The main method prints a Celcius to Fahrenheit conversion table.
	 * The bounds of the table range from -50C to +50C in 10-degress increment.
	 * @param args, not used in this application
	 */
	public static void main(String[] args) {
		final double TABLE_BEGIN = -50.0;
		final double TABLE_END = 50.0;
		final double TABLE_STEP = 10.0;
		double celcius;
		double fahrenheit;
		String line = "--------------------------------------------------";
		System.out.println("TEMPERATURE CONVERSION");
		System.out.println(line);
		System.out.println("Celcius\t\t\tFahrenheit");
		
		for (celcius = TABLE_BEGIN; celcius < TABLE_END; celcius += TABLE_STEP) {
			fahrenheit = celciusToFahrenheit(celcius);
			System.out.printf("%6.2fC", celcius);
			System.out.printf("%6.2fF", fahrenheit);
		}
		System.out.println(line);
	}

	/**
	 * Converts a temperature from Celsius degrees to Fahrenheit degrees.
	 * @param c 
	 * 			A temperature in Celcius degrees
	 * @return
	 * 			The temperature c converted to Fahrenheit
	 * @throws java.lang.IllegalArgumentException Indicates that
	 * c is less than the smallest Celsius temperature
	 * 
	 * @campos.precondition
	 * 	c >= -273.16
	 * @campos.postCondition
	 * 	The temperature in Fahrenheit
	 */
	public static double celciusToFahrenheit(double c) {
		final double MININUM_CELCIUS = -273.16;
		if (c < MININUM_CELCIUS)
			throw new IllegalArgumentException("Argument " + c + " is too small");
		return (1.8 * c) + 32;
	}
}
