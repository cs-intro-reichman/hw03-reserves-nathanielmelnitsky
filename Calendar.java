public class Calendar {
    public static void main(String[] args) {
        int inputYear = Integer.parseInt(args[0]);
        printDay(inputYear);
    }
    public static void printDay(int inputYear){
    //finds what day of week is first day of year
    int dayOfWeek = findDayOfWeekFirstDayOfYear(inputYear);
    //loops through months
        for(int i = 1; i <= 12; i++){
            //gets info for days in current month
            int daysInMonth = nDaysInMonth(i, inputYear);
            //loops through days
            for(int j = 1; j <= daysInMonth; j++){
                dayOfWeek++;
                //tracks the sundays
                if(dayOfWeek == 8){
                    dayOfWeek = 1;
                }
                //sets up string for each day
                String date = j + "/" + i + "/" + inputYear;

                //adds sunday to string if need be
                if(isSunday(dayOfWeek)){
                    date += " Sunday";
                }
                //prints
                System.out.println(date);
            }
        }
    }
    //checks if sunday for adding to string
    public static boolean isSunday(int dayOfWeek){
        if(dayOfWeek == 1){
            return true;
        }
        else{
            return false;
        } 
    }

        //stores info about days in month for caller
        public static int nDaysInMonth(int month, int year) {

            int[] dayArr = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}; //declares array storing day values
            int days;
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

    //used in days per month funciton
	public static boolean isLeapYear(int year) {
		if((year % 100 == 0 && year % 400 == 0) || (year % 4 == 0 && year % 100 != 0)){
			return true;
		}
		return false;
	}
//finds what weekday is the first day of the year
    public static int findDayOfWeekFirstDayOfYear(int year){
        // zellers congruence algorthm
        //basically finds amount of days total that have passed
        // 1/4 of the years are leap so every 4 years substracts 1 day
        //divides by seven to find remainder 
        //the remainder is the day of the week
        int dayOfWeek = (1 + ((year - 1900) * 365) + ((year - 1900 - 1) / 4) - ((year - 1900 - 1) / 100) + ((year - 1600 - 1) / 400)) % 7;
            
        // adjust for cases below 0
        if (dayOfWeek < 0) {
            dayOfWeek += 7;
        }
        return dayOfWeek;
    }  
}
    
    
