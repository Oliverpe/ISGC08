package model;

public class TextEditoreData {
	private  String textFileName = "";
	private String filePath = "";
	private String fileContent = "";
	private boolean changed = false;
	

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
	
	public boolean isChanged() { 
		return changed;
	}
	
	public void setChanged(boolean changed) { 
		this.changed = changed;
	}






}
