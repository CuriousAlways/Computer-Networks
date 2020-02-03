import java.util.Scanner;
import java.util.InputMismatchException;

public class HillCipher
{
	public static String message;
	public static String encryptedMessage;
	public static String decryptedMessage;

	public static int[][] matrix   = { {6,24,1},{13,16,10},{20,17,15}};
	public static int[][] inmatrix = { {8,5,10},{21,8,21},{21,12,8}};

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		boolean inputstatus = true;
		while(inputstatus)
		{		
			try
			{
				System.out.print("Input message     : ");
				message = input.nextLine(); 
				verifyInput(message);
				inputstatus = false;
			}
			catch(InputMismatchException e)
			{
				System.out.println("Invalid Input!!!!!");
				inputstatus = true;
			}
		}

		hillEncryption();
		hillDecryption();
		System.out.println("Encrypted Message : "+encryptedMessage);
		System.out.println("decrypted Message : "+decryptedMessage);
	}

	public static void verifyInput(String str) throws InputMismatchException
	{
		for(int i=0;i<str.length();i++)
			if(str.charAt(i)<'A' || str.charAt(i)>'Z')
				throw (new InputMismatchException ());

		if(str.length()%3 != 0)
			{
				throw (new InputMismatchException ());
			}
	}

	public static void hillEncryption()
	{
		encryptedMessage = "";
		int i = 0; //traversing through message
		while(i<message.length())
		{
			for(int r=0;r<matrix.length;r++)
				{
					int tsum = 0;
					int j = i;
					for(int c=0;c<matrix[r].length;c++,j++)
						tsum += matrix[r][c]*(message.charAt(j) - 'A');

					encryptedMessage += (char)('A'+ tsum%26);
				}

			i = i+3;

		}

	}
    
    public static void hillDecryption()
	{
		decryptedMessage = "";
		int i = 0; //traversing through message
		while(i<encryptedMessage.length())
		{
			for(int r=0;r<inmatrix.length;r++)
				{
					int tsum = 0;
					int j = i;
					for(int c=0;c<inmatrix[r].length;c++,j++)
						tsum += inmatrix[r][c]*(encryptedMessage.charAt(j)-'A');

					decryptedMessage += (char)('A'+ tsum%26);
				}

			i = i+3;

		}

	}
}