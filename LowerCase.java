/** String processing exercise 1. */
public class LowerCase {
    public static void main(String[] args) {  
        String str = args[0];
        System.out.println(lowerCase(str));
    }

   /**
    * Returns a string which is identical to the original string, 
    * except that all the upper-case letters are converted to lower-case letters.
    * Non-letter characters are left as is.
    */
    public static String lowerCase(String str) {
        int length = str.length(); //og string length
        String newStr = "";

        //takes letters one by one 
        for (int i = 0; i < length; i++){

            char ch = str.charAt(i); //assigns the current index to character
            int numVal = (int) ch;

            if(numVal >= 65 && numVal <= 90){
                numVal += 32; //adds 32 indexes to get to the lovercase value on the ASCII table
                ch = (char) numVal; //casts the new lowercase ascii value back the char
                newStr += ch; //adds char to empty string
            }
            else{
                //if its not upper case then we add it just as it is
                newStr += ch;
            }

        }
        return newStr;


    }
}