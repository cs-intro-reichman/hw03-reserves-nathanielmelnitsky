/*
 * Checks if a given year is a leap year or a common year,
 * and computes the number of days in a given month and a given year. 
 */
public class Calendar0 {	
	
	// Gets a year (command-line argument), and tests the functions isLeapYear and nDaysInMonth.
	public static void main(String args[]) {
		int year = Integer.parseInt(args[0]);
		isLeapYearTest(year);
		nDaysInMonthTest(year);
	}
		 
	// Tests the isLeapYear function.
	private static void isLeapYearTest(int year) {
		String commonOrLeap = "common";
		if (isLeapYear(year)) {
			commonOrLeap = "leap";
		}
		System.out.println(year + " is a " + commonOrLeap + " year");  
	}

	// Tests the nDaysInMonth function.
	private static void nDaysInMonthTest(int year) {
				
		String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		for(int i = 0; i < 12; i++){
			int days = nDaysInMonth(i, year);
			System.out.println("in year: " + year + " in the month of: " + months[i] + " there are " + days + " days");
		}

	}

	// Returns true if the given year is a leap year, false otherwise.
	public static boolean isLeapYear(int year) {
		if((year % 100 == 0 && year % 400 == 0) || (year % 4 == 0 && year % 100 != 0)){
			return true;
		}
			return false;
	}
	 
	// Returns the number of days in the given month and year.
	// April, June, September, and November have 30 days each.
	// February has 28 days in a common year, and 29 days in a leap year.
	// All the other months have 31 days.
	public static int nDaysInMonth(int month, int year) {

		int[] dayArr = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}; //declares array storing day values
		int days;
		if(isLeapYear(year)){
			dayArr[1] = 29;
			days = dayArr[month];


		}
		else{
			dayArr[1] = 28;
			days = dayArr[month];

		}

		return days;
	}
}
