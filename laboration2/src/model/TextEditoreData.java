package model;
import java.io.File;

public class TextEditoreData {
	private  String textFileName;
	private String filePath;
	private String fileContent;
	
	public TextEditoreData() {
		textFileName = "";
		filePath = "";
		fileContent = "";
		
	}
	
	
	
	
	
	public String readTextFile() { 
		return fileContent;
	}
	
	

	public String getTextFileName() {
		return textFileName;
	}

	public void setTextFileName(String textFileName) {
		this.textFileName = textFileName;
	}
	
	public String getFilePath() {
		return filePath;
	}
	
	public void setFilePath(String filePath) { 
		this.filePath = filePath;
	}
	
	
	
	public String getFileContent() {
		return fileContent;
	}
	
	public void setFileContent(String fileContent) { 
		this.fileContent = fileContent;
	}

	
	
	
	
	
}
