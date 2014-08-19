
public final class Valuator {
	
	
	static final int KMS_PER_YEAR = 22000;
	double value;
	
	
	public Valuator(int price, int new_value, int current_kms, int year, boolean has_leather, double fuel_econ, int max_kms) {
		
		int leather;
		
		if (has_leather) leather = 500;
		else leather = 0;
		
		
		int kms_remaining = max_kms - current_kms;
		double years_remaining = kms_remaining / KMS_PER_YEAR;
		
		if(years_remaining >= 1) 
			value = ((price - (resale_val(new_value, year, years_remaining )) - leather + (kms_remaining * fuel_econ)) / (kms_remaining)) * 100;
		
		else value = 0;
	}
	
	public double resale_val (int new_val, int v_year, double years_rem) {
		double val;
		double rem;
		
		rem = Math.floor((years_rem + 2014) - v_year);
		
		val = new_val * .7;
		
		while(rem > 1){
			
			val *= .88;
			rem--;
		}		
		
		return val;
	}
}
