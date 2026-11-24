package model;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileManager {
	private  TextEditoreData currentFile;


	public FileManager() {
		this.currentFile = new TextEditoreData();
	}

	public String openTextFile(File selectedFile) throws IOException {
		StringBuilder content = new StringBuilder();

		try(BufferedReader br = new BufferedReader(new FileReader(selectedFile))) {
			String l;
			while((l = br.readLine()) != null) {
				content.append(l).append("\n");
			}
		}

		currentFile.setTextFileName(selectedFile.getName());
		currentFile.setFilePath(selectedFile.getPath());
		currentFile.setFileContent(content.toString());
		currentFile.setChanged(false);

		return content.toString();
	}

	public void createTextFile(String textFileName) throws IOException {


		File file = new File(textFileName);
		if(file.exists()) {
			throw new IOException("File already exist " + textFileName);
		}

		currentFile.setTextFileName(textFileName);
		currentFile.setFileContent("");
		writeTextFile(textFileName, "");
		currentFile.setChanged(false);



	}

	public void saveFile(String textFileName, String fileContent) throws IOException {
		currentFile.setTextFileName(textFileName);
		currentFile.setFileContent(fileContent);
		writeTextFile(textFileName, fileContent);
		currentFile.setChanged(false);

		System.out.println("File Saved!");

	}

	public void writeTextFile(String filePath, String fileContent) {
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
			bw.write(fileContent);
		} catch(IOException e) {
			System.out.println("Error when trying to write.");
		}
	}

	public void saveFileAs(String fileContent, String filePath) {
		currentFile.setFileContent(fileContent);
		currentFile.setFilePath(filePath);
		writeTextFile(filePath, fileContent);


		}

	public boolean isChanged() { 
		return currentFile.isChanged();
	}
	
	public void fileContentChanged() { 
		currentFile.setChanged(true);
	}

	public String getCurrentFileName() {
		
		return currentFile.getTextFileName();
	}

}
