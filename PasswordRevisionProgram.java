/**

 */

import java.util.Scanner;

public class PasswordRevisionProgram {
    private static final String PW_PROMPT = "Please enter a password: ";
    private static final String PW_TOO_SHORT = "Password is too short";
    private static final String PW_VERY_WEAK = "Password strength: very weak";
    private static final String PW_WEAK = "Password strength: weak";
    private static final String PW_MEDIUM = "Password strength: medium";
    private static final String PW_STRONG = "Password strength: strong";
    private static final String SUGGESTION_PROMPT = 
            "Here is a suggested stronger password: ";
    private static final String LETTER_RULE_SUGGESTION = "Cse";
    private static final String SYMBOL_RULE_SUGGESTION = "@!";

    private static final int MIN_PW_LENGTH = 8;
    private static final int VERY_WEAK_THRESHOLD = 1;
    private static final int WEAK_THRESHOLD = 2;
    private static final int MEDIUM_THRESHOLD = 3;
    private static final int STRONG_THRESHOLD = 4;
    private static final int LETTER_COUNT_THRESHOLD = 2;
    private static final int DIGIT_INTERVAL = 4;
    private static final int MOD_FACTOR = 10;

    /**
     * 1-2 senet:
     * using
     * @param args
     */
    public static void main (String[] args) {
    	
    	System.out.print(PW_PROMPT);
    	Scanner input = new Scanner( System.in );
    	String pass = input.next()+"";
      	StringBuilder password = new StringBuilder(pass);
    	
    	if( password.length() < 8 )
    	{
    		System.out.println(PW_TOO_SHORT);
    		return;
    	}
    	
    	else
    	{
    		//need later
    		int digits = 0;
    		int uppers = 0;
    		int lowers = 0;
    		int symbols = 0;
    		//
    		int total = 0;
    		
    		
    		for( int i = 0; i < password.length(); i++ )
    		{
    			if( Character.isDigit(password.charAt(i)) ) 
    			{
    				digits++;
    			}
    			else if( Character.isUpperCase(password.charAt(i)) )
    			{
    				uppers++;
    			}
    			else if( Character.isLowerCase(password.charAt(i)) )
    			{
    				lowers++;
    			}
    			else
    			{
    				symbols++;
    			}			
    			  			
    		}//end for
    		
    		//track if each category appear once. print how many appear
    		if( digits > 0 )
    		{
    			total++;
    		}
    		if( uppers > 0 )
    		{
    			total++;
    		}
    		if( lowers > 0 )
    		{
    			total++;
    		}
    		if( symbols > 0)
    		{
    			total++;
    		}
    		
    		
    		if( total == STRONG_THRESHOLD ) //4, 3, 2 ,1  why wrong
    		{
    			System.out.println(PW_STRONG);
    		}
    		else if( total == MEDIUM_THRESHOLD )
    		{
    			System.out.println(PW_MEDIUM);
    		}
    		else if( total == WEAK_THRESHOLD )
    		{
    			System.out.println(PW_WEAK);
    		}
    		else
    		{
    			//PW_VERY_WEAK. 
    			System.out.println(PW_VERY_WEAK);
    		}
    		
    		
    		//rule 1. If there fewer than 2 letters, prepend Cse to the current password. If this rule is applied, skip Rule 2 and Rule 3.
    		if( uppers + lowers < 2 )//if theres less than 2 letters
    		{
    			password = password.insert(0, LETTER_RULE_SUGGESTION);
    		
    			
    		}
    		
    		//rule 2.If there are no lowercase letters,
			// change the first uppercase letter to lowercase.
			// If this rule is applied, skip Rule 3.
    		else if( lowers == 0 )
    		{
    			char x = 'x';
    			int index = 0;
    		
    			
    			
    			for( int i = 0; i < password.length(); i++ )
    			{
    						
	    				if( password.charAt(i) >= 65 && password.charAt(i) <= 90)
	    				{
	    					x = password.charAt(i);
	    					index = i;
	    					break;
	    				}
	    				
    			}
    			
    			
    			
    			
    			char lower = Character.toLowerCase( x );
    			
    			password = password.deleteCharAt(index);
    			password = password.insert(index, lower);
    			
    		
    			
    		}
    		// If there are no uppercase letters, 
    		//change the last occurrence of the highest-ASCII-valued lowercase character 
    		//to uppercase.
    		else if( uppers == 0 )
    		{
    			int x = 0;
    			int index = 0;
    			
    			for( int i = 0; i < password.length(); i++ )
    			{
   
    				int z = (int)password.charAt(i);
    				if( z > x )
    				{
    					x = z; //change stored char to greatest one
    					index = i;

    				
    				}
    				
    			}	
    			
    			char toUp = Character.toUpperCase((char)x); //store
    			
    			password = password.deleteCharAt(index);
    			password = password.insert(index, toUp);
    			
    			
    			
    		}//end if
    					
    			
    		//rule4
    		//If there are no numbers, insert  into the current password every 4 characters,
    		//where  is the original length of the password mod 10. If the current password
    		//length (before this rule is applied) is divisible by 4,  should be inserted at the 
    		//very end as well.
    		
    		if( digits == 0 )
    		{
    			int k = password.length() % 10;

    			int index = 0;
    			int i = 3;
    			
    			while( i < password.length() )
    			{
    				password = password.deleteCharAt(i);
    				index = i;
    				password = password.insert(index, k);
    				i += 4;
    			}
    			
    		}
    		
    		//rule5
    		//If there are no symbols, append @! to the current password
    		 if( symbols == 0 )
    		{
    			String str = "@!";
    			
    			password = password.append(str);
    			
    			
    		}
    		
    		 System.out.print( SUGGESTION_PROMPT + password );
    		 
    	}//endelse
    	
    	
    	
    }


}