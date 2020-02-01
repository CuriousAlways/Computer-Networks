import java.util.Scanner;
import java.util.InputMismatchException; 
import java.util.ArrayList;

public class CesorCipher
{
	private static int key;
	private static String inputString;
	private static String encryptedString;
	private static String decryptedString;

	public static void main(String[] args)
	{
		boolean inputstatus = true;
		while(inputstatus)
		{

			Scanner input = new Scanner(System.in);
			try
			{
				System.out.print("Key : ");
				key = (input.nextInt())%26;
				input.nextLine(); //to remove trailing newline in buffer
				System.out.print("Input String     : ");
				inputString = input.nextLine();
				inputstatus = false;	
			}
			catch (InputMismatchException e)
			{
				System.out.println("Invalid input try again!!!");
				inputstatus = true;
			}			
		}

		ceasorCipherEncryption();
		System.out.println("Encrypted String : "+encryptedString);
		ceasorCipherdecryption();
		System.out.println("Decrypted String : "+decryptedString);
		
	}

	public static void ceasorCipherEncryption()
	{
		char[] temp = new char[inputString.length()];
		for(int i=0;i<inputString.length();i++)
		{
			char c = inputString.charAt(i);
			if(((c >= 'a') && (c <= 'z')) || ((c >= 'A') && (c <= 'A'))) 
			{
				if((c >= 'a') && (c <= 'z'))
				{
					temp[i] = (char)('a'+((c - 'a') + key)%26);
				}
				else
				{
					temp[i] = (char)('A'+((c - 'A') + key)%26);
				}
			}
			else  //no cipher algo is applied on non-alphabet character
			{
				temp[i] = (c);
			}

		}

		encryptedString = arrayToString(temp);

	}

	public static void ceasorCipherdecryption()
	{
		char[] temp = new char[encryptedString.length()];
		for(int i=0;i<encryptedString.length();i++)
		{
			char c = encryptedString.charAt(i);
			if(((c >= 'a') && (c <= 'z')) || ((c >= 'A') && (c <= 'A'))) 
			{
				
				if((c >= 'a') && (c <= 'z'))
				{
					int offset = (c - 'a') - key;
				    if(offset >= 0)
					{
						temp[i] = (char)('a' + offset);
					}
					else
					{
						temp[i] = (char)('z' + offset + 1);
					}	

				}
				else
				{
					int offset = c - 'A' - key;
					if((c >= 'A') && (c <= 'Z'))
					{
				    	if(offset >= 0)
						{
							temp[i] = (char)('A' + offset);
						}
						else
						{
							temp[i] = (char)('Z' + offset + 1);
						}
					}	
				}
			}
			else  //no cipher algo is applied on non-alphabet character
			{
				temp[i] = c;
			}

		}

		decryptedString = arrayToString(temp) ;
	}

  public static String arrayToString(char[] arr)
  {
  	String str = "";
  	for(int i=0;i<arr.length;i++)
  		str += arr[i];
    return str;
  }

}