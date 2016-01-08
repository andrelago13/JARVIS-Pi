package configuration;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

@SuppressWarnings("serial")
public class Configuration implements Serializable {		// SINGLETON

	/*
	 * 		APPLICATION CONSTANTS
	 */
	private static String defaultFilePath = "./resources/conf/";
	private static String defaultFileName = "settings.conf";
	private static String defaultUserName = "sir";
	
	/*
	 * 		OBJECT ATTRIBUTES
	 */
	private String filePath;
	private String fileName;
	private String userName;

	protected static Configuration instance = null;

	
	protected Configuration() throws ClassNotFoundException, IOException {
		resetDefaults();
		loadFromFile();
	}

	public static Configuration getInstance() throws ClassNotFoundException, IOException {
		if(instance == null)
			instance = new Configuration();

		return instance;
	}

	public void loadFromFile() throws IOException, ClassNotFoundException {
		
		String fullPath = filePath + fileName;
		File file = new File(fullPath);
		
		if(!file.exists() || file.isDirectory()) {
			resetDefaults();
			storeToFile();
		}
		
		fullPath = filePath + fileName;
		System.out.println("Loading configs from " + fullPath);
		file = new File(fullPath);
		
		FileInputStream fin = new FileInputStream(file);
		ObjectInputStream ois = new ObjectInputStream(fin);
		Configuration conf = (Configuration) ois.readObject();
		ois.close();
		
		cloneFrom(conf);
	}

	private void cloneFrom(Configuration conf) {
		filePath = conf.filePath;
		fileName = conf.fileName;
		userName = conf.userName;
	}

	public void storeToFile() throws IOException {
		String fullPath = filePath + fileName;
		File file = new File(fullPath);
		
		if(file.exists()) {
			file.delete();
		}
		file.createNewFile();
		
		System.out.println("Storing configs on " + fullPath);
		
		FileOutputStream fout = new FileOutputStream(file);
		ObjectOutputStream oos = new ObjectOutputStream(fout);   
		oos.writeObject(this);
		oos.close();
	}
	
	public void resetDefaults() {
		setFileName(defaultFileName);
		setFilePath(defaultFilePath);
		setUserName(defaultUserName);
	}

	public String getFilePath() {
		return filePath;
	}

	public String defaultFilePath() {
		return defaultFilePath;
	}

	public String getFileName() {
		return fileName;
	}

	public String defaultFileName() {
		return defaultFileName;
	}

	public String getUserName() {
		return userName;
	}

	public String defaultUserName() {
		return defaultUserName;
	}

	public void setUserName(String name) throws IllegalArgumentException {
		if(name == null)
			throw new IllegalArgumentException();

		userName = name;
	}

	public void setFilePath(String name) throws IllegalArgumentException {
		if(name == null)
			throw new IllegalArgumentException();

		File file = new File(name + fileName);
		if (!file.isDirectory())
			file = file.getParentFile();
		if (!file.exists()){
			throw new IllegalArgumentException();
		}

		filePath = name;
	}

	public void setFileName(String name) throws IllegalArgumentException {
		if(name == null)
			throw new IllegalArgumentException();

		fileName = name;
	}

}
