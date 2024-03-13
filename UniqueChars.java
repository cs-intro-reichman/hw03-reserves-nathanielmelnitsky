/** String processing exercise 2. */
public class UniqueChars {
    public static void main(String[] args) {  
        String str = args[0];
        System.out.println(uniqueChars(str));
    }

    /**
     * Returns a string which is identical to the original string, 
     * except that all the duplicate characters are removed,
     * unless they are space characters.
     */
    public static String uniqueChars(String str) {
        String newString = "";
        for(int i = 0; i < str.length(); i++){ //loops for each character in given string 

        //declares the new letter to be checked and declares so far its not duplicate
        char ch = str.charAt(i);
        boolean isDuplicate = false;
        boolean spacer = false;


            for(int j = 0; j < i; j++){

                if(ch == str.charAt(j)){

                    isDuplicate = true;
                    break;
                }

                if((int) ch == 32) {
                  spacer = true;
                }

            }

            if(!isDuplicate || spacer){

                newString += ch;
            }

            


       }
        return newString;
    }
}