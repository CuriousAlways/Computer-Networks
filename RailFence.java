import java.util.Scanner;
import java.util.InputMismatchException;

public class RailFence
{
	public static int key;
	public static String message;
	public static int[] encryptedPattern  ;
	public static String encryptedMessage = "";
	public static String decryptedMessage = "";

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		boolean inputstatus = true;
		while(inputstatus)
		{		
			try
			{
				System.out.print("Input key         : ");
				key = input.nextInt();
				input.nextLine();//to remove newline character from buffer
				System.out.print("Input message     : ");
				message = input.nextLine(); 
				inputstatus = false;
			}
			catch(InputMismatchException e)
			{
				System.out.println("Invalid Input!!!!!");
				inputstatus = true;
			}
		}

		RailEncryption();
		RailDecryption();
		System.out.println("Encrypted Message : "+encryptedMessage);
		System.out.println("decrypted Message : "+decryptedMessage);
	}


	public static void RailEncryption()
	{
		encryptedPattern = new int[message.length()];

		int offset = 2*(key - 1);
		int i = 0;
		int currseq = 1;
		int offset1 = offset;
		int offset2 = offset - offset1;
		while((currseq <= key) && (i < encryptedPattern.length))//generates pattern 
		{
			if(currseq == 1 || currseq == key)
			{
				offset1 = offset;
				offset2 = offset;
			}
			else
			{
				offset1 = offset1 - 2;
				offset2 = offset - offset1;
			}

			int j = currseq;
			encryptedPattern[i++] = j;
			int times = 1;
			while((j <= encryptedPattern.length) && (i < encryptedPattern.length))
			{
				if(times %2 != 0)
					j = j+ offset1;
				else
					j = j + offset2;

				if(j <= encryptedPattern.length)
					encryptedPattern[i++] = j; 

				times++; 
			}

			currseq++;

		}
		
		char[] temp = new char[encryptedPattern.length];
		for(i=0;i<encryptedPattern.length;i++)
		{
			temp[i] = message.charAt(encryptedPattern[i]-1);
		}
		for(i=0;i<temp.length;i++)
			encryptedMessage += temp[i];
	}


	public static void RailDecryption()
	{
		char[] temp = new char[encryptedPattern.length];
		for(int i=0;i<encryptedPattern.length;i++)
			temp[encryptedPattern[i]-1] = encryptedMessage.charAt(i);

		for(int i=0;i<temp.length;i++)
			decryptedMessage += temp[i];
	}
}