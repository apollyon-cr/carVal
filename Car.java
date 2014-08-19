import java.text.DecimalFormat;


public class Car {

	String location;
	String color;
	String type;
	double value;
	int price;
	int current_kms;
	int year;
	boolean leather;
	int new_val;
	double fuel_econ;
	
	static final int MAX_KMS = 250000;
	
	public Car(String t, int p, int k, int y, boolean l, String c, String loc ) {
		
		type = t;
		price = p;
		current_kms = k;
		year = y;
		leather = l;
		color = c;
		location = loc;
		
		
		switch (t) {
			case "accord":	new_val = 34000;
							fuel_econ = (9.4 / 100);
							break;
							
			case "camry":	new_val = 32750;
							fuel_econ = (9.0 / 100);
							break;
							
			case "civic":	new_val = 22704;
							fuel_econ = (8.1 / 100);
							break;
							
			case "corolla":	new_val = 24156;
							fuel_econ = (8.1 / 100);
							break;
							
			case "mazda3":	new_val = 24809;
							fuel_econ = (9.4 / 100);
							break;
							
			case "jetta":	new_val = 22690;
							fuel_econ = (9.4 / 100);
							break;
							
			case "passat":	new_val = 31647;
							fuel_econ = (9.4 / 100);
							break;
							
			case "crv":		new_val = 34000;
							fuel_econ = (10.2 / 100);
							
			case "legacy":	new_val = 35500;
							fuel_econ = (10.2 / 100);
							
							
			default: break;
		
		}
		
		value = new Valuator(price, new_val, current_kms, year, leather, fuel_econ, MAX_KMS).value;
		
		
	}
	
	public String toString() {
		String str;
		DecimalFormat df = new DecimalFormat("#.##");
		df.format(value);
		
		str = year + ", " + type + ", " + color + ", " + String.valueOf(df.format(value)) + ", " + location;
		
		return str;
	}
}
