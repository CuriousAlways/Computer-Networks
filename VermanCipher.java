import java.util.Scanner;
import java.lang.Exception;

public class VermanCipher
{
	public static String key;
	public static String inputString;
	public static String encryptedString;
	public static String decryptedString;

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		boolean inputStatus = true;
		
		while(inputStatus)
		{
			try
			{
				System.out.print("Enter Key     : ");
				key = input.nextLine();
				System.out.print("Enter message : ");
				inputString = input.nextLine();
				inputStatus = false;
			}
			catch (Exception e)
			{
				System.out.print("Invalid Input!!!!");
			}
		}

	    vermanEncryption();
	    vermanDecryption();
		System.out.println("Encrypted message : "+encryptedString);
		System.out.println("Decrypted message : "+decryptedString);
	}

	public static void vermanEncryption()
	{
		encryptedString = "";
		int j = 0;
		for(int i=0;i<inputString.length();i++)
		{
			encryptedString += (char)(inputString.charAt(i)^key.charAt(j));
			j = (j+1)%(key.length());
		}
	}

	public static void vermanDecryption()
	{
		decryptedString = "";
		int j = 0;
		for(int i=0;i<encryptedString.length();i++)
		{
			decryptedString += (char)(encryptedString.charAt(i)^key.charAt(j));
			j = (j+1)%(key.length());
		}
	}

}