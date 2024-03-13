/** 
 * Prints the calendars of all the years in the 20th century.
 */
public class Calendar1 {	
    // Starting the calendar on 1/1/1900
	static int dayOfMonth = 1;   
	static int month = 1; //figure out how to access the first element of array with 1
	static int year = 1900;
	static int dayOfWeek = 2;     // 1.1.1900 was a Monday
	static int nDaysInMonth = 31; // Number of days in January
	static int sundayCounter = 0; //counts sundays in genera;
	static int SpeacialSundayCounter = 0;
	static int n = -1; //debuggint loop n times
	static String daysofWeek[] = {"", "sun", "mon", "tus", "wed", "thru", "fri", "shab"};
	
	/** 
	 * Prints the calendars of all the years in the 20th century. Also prints the  
	 * number of Sundays that occured on the first day of the month during this period.
	 */
	public static void main(String args[]) {
		// Advances the date and the day-of-the-week from 1/1/1900 till 31/12/1999, inclusive.
	    // Prints each date dd/mm/yyyy in a separate line. If the day is a Sunday, prints "Sunday".
	    // The following variable, used for debugging purposes, counts how many days were advanced so far.
		int debugDaysCounter = 1; 

	    //increments the day until the date array reaches 31.12.99 and friday
	 	while (dayOfMonth != 31 && month != 12 && year != 1999) { 
			//prints date
			System.out.println(dayOfMonth + "/" + month + "/" + year); 
			System.out.println("today is; " + daysofWeek[dayOfWeek]);
			System.out.println(debugDaysCounter);

			//counts sundays that are first day of the month
			if(dayOfWeek == 1 && dayOfMonth == 1){
				SpeacialSundayCounter += 1;
			}

			//steps date by one keeping track of other stats
	 		advance();
		
	
	 		//// If you want to stop the loop after n days, replace the condition of the
	 		//// if statement with the condition (debugDaysCounter == n)
	 		debugDaysCounter++;
	 		 if (debugDaysCounter == n) { 
	 			break;
	 		} 
        }
	 	//// Write the necessary ending code here
		System.out.println("During the 20th century " + SpeacialSundayCounter + " Sundays fell on the first day of the month");
	 }
	
	 // Advances the date (day, month, year) and the day-of-the-week.
	 // If the month changes, sets the number of days in this month.
	 // Side effects: changes the static variables dayOfMonth, month, year, dayOfWeek, nDaysInMonth.
	 private static void advance() {
		//advances by day and day of week
		dayOfMonth += 1;
		dayOfWeek += 1;
		//if() that resets weekday at end of week and logs that sunday occured
		if(dayOfWeek == 7){
			dayOfWeek = 1;
			sundayCounter += 1; //adds to the sunday counter
			}

		//if that steps the year after and resets months and day of month
		if(month > 12 && dayOfMonth > nDaysInMonth(month, year)){
			year += 1;
			month = 1;
			dayOfMonth = 1;
			}
			
		
		//if that steps the month after advance() and resets the day count
		if(dayOfMonth - 1 > nDaysInMonth(month, year)){
			month += 1;
			dayOfMonth = 1;
			}
		

		
		
			
	 }
		 
    // Returns true if the given year is a leap year, false otherwise.
	private static boolean isLeapYear(int year) {

		if((year % 100 == 0 && year % 400 == 0) || (year % 4 == 0 && year % 100 != 0)){
			return true;
		}
		return false;

	}

	//takes month and year and returns days in the given month
	private static int nDaysInMonth(int month, int year) {

		int[] dayArr = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}; //declares array storing day values
		int days;

		//returns days in a given month if leap year modifies the day counter to 29 for feb.
		if(isLeapYear(year)){
			dayArr[2] = 29;
			days = dayArr[month];


		}
		else{
			dayArr[2] = 28;
			days = dayArr[month];
		}

		return days;
	}

}