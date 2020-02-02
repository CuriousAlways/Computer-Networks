import java.util.Scanner;
import java.util.InputMismatchException; 


public class VigenereCipher
{
	public static String key;
	public static String message;
	public static String encryptedMessage;
	public static String decryptedMessage;

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		boolean inputstatus = true;
		while(inputstatus)
		{		
			try
			{
				System.out.print("Input key         : ");
				key = input.nextLine();
				System.out.print("Input message     : ");
				message = input.nextLine(); 
				verifyInput(key);
				verifyInput(message);
				inputstatus = false;
			}
			catch(InputMismatchException e)
			{
				System.out.println("Invalid Input!!!!!");
				inputstatus = true;
			}
		}

		vigenereEncryption();
		vigenereDecryption();
		System.out.println("Encrypted Message : "+encryptedMessage);
		System.out.println("decrypted Message : "+decryptedMessage);
	}

	public static void verifyInput(String str) throws InputMismatchException
	{
		for(int i=0;i<str.length();i++)
			if(str.charAt(i)<'A' || str.charAt(i)>'Z')
				throw (new InputMismatchException ());
	}

	public static void vigenereEncryption()
	{
		String tempkey = createKey();
		encryptedMessage = "";
		int offset = 0;
		for(int i=0;i<message.length();i++)
		{	
			offset = (message.charAt(i)+tempkey.charAt(i)-2*'A')%26;
			encryptedMessage += (char)('A' + offset);
		}
	}

	public static void vigenereDecryption()
	{
		String tempkey = createKey();
		decryptedMessage = "";
		int offset = 0;
		for(int i=0;i<message.length();i++)
		{
			offset = (encryptedMessage.charAt(i) - tempkey.charAt(i) + 26)%26;
			decryptedMessage += (char)('A'+ offset);
		}
	}

	public static String createKey() //creates temporary key of size same as message using original key
	{
		String tempstr = "";
		int j = 0;
		for(int i=0;i<message.length();i++)
		{
			if( j >= key.length())
			{
				j = 0;
			}

			tempstr += key.charAt(j);
			j++;
		}

		return tempstr;
	}

}