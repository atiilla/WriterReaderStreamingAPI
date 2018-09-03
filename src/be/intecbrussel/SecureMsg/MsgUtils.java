package be.intecbrussel.SecureMsg;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;

public class MsgUtils {

	String osName = System.getProperty("os.name");
	String osNameMatch = osName.toLowerCase();
	String home = System.getProperty("user.home");
	FileSystem file = FileSystems.getDefault();
	String KeyB = "INTEC-123";
	String folderName;
	String fileName;
	String yourMsg;
	String asd = home + "/" + folderName + "/" + fileName + ".txt";
	XorUtils xor;

	public MsgUtils() {
		super();
	}

	public MsgUtils(String folderName, String fileName, String yourMsg) {
		super();
		this.folderName = folderName;
		this.fileName = fileName;
		this.yourMsg = yourMsg;
	}

	public String getFolderName() {
		return folderName;
	}

	public void setFolderName(String folderName) {
		this.folderName = folderName;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getYourMsg() {
		return yourMsg;
	}

	public void setYourMsg(String yourMsg) {
		this.yourMsg = yourMsg;
	}

	public String process() {
		if (osNameMatch.contains("linux")) {
			new File(home + "/Desktop/" + folderName).mkdir(); // create a folder

			File f = new File(home + "/Desktop/" + folderName + "/" + fileName + ".txt");

			FileWriter writer = null;
			try {
				writer = new FileWriter(home + "/Desktop/" + folderName + "/" + fileName + ".txt"); // write somehing
																									// into file[txt]

				

				String enc = xor.encode_using_xor(yourMsg.getBytes(), KeyB.getBytes());
				writer.write(enc);
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();

			} finally {
				if (writer != null) {
					try {
						writer.close();

					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

		} else if (osNameMatch.contains("windows")) {
			new File(home + "\\Desktop\\testFolder").mkdir();
		} else if (osNameMatch.contains("solaris") || osNameMatch.contains("sunos")) {
			// solaris
		} else if (osNameMatch.contains("mac os") || osNameMatch.contains("macos") || osNameMatch.contains("darwin")) {
			// macos
		} else {
		}
		return yourMsg;
	}
	
	public void printer() {
		 
		try (FileInputStream inputStream = new FileInputStream(home + "/Desktop/" + folderName + "/" + fileName + ".txt");) {

			int databyte =0;
			// write the characters on the console
			
			while((databyte = inputStream.read())!=-1) {
				System.out.print((char)databyte);
				
				
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public String toString() {
		System.out.println("OS: " + System.getProperty("os.name") + ", USER DIRECTORY: " + System.getProperty("user.home"));
		return "MsgWrite [getFolderName()=" + getFolderName() + ", getFileName()=" + getFileName() + ", getYourMsg()="
				+ getYourMsg() + "]";
	}

	public void decode() {
		this.yourMsg = yourMsg;
		try (FileInputStream inputStream = new FileInputStream(home + "/Desktop/" + folderName + "/" + fileName + ".txt");) {

			int databyte =0;
			// write the characters on the console
			
			while((databyte = inputStream.read())!=-1) {
				
				String decrypt = xor.decode_operation(yourMsg, KeyB.getBytes());
				System.out.println(decrypt);
				
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}

}
