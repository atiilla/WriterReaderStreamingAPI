package be.intecbrussel.SecureMsg;

public class MessageApp {

	public static void main(String[] args) {
		//System.out.println("OS: " + System.getProperty("os.name") + ", USER DIRECTORY: " + System.getProperty("user.home"));
		
		// "Folder" , "FileName" , "Your Msg" >>> Msg will be encrypted
		MsgUtils msg = new MsgUtils("Foldername", "FileName", "ContentFileTXT");
		System.out.println(msg);
		
		// Create folder and TxtFile and typing msg into the TxtFile
		msg.process();
		
		// Printing .txt file that you created
		msg.printer();
		
	
		
	}

}
