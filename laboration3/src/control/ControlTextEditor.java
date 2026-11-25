package control;

import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import model.FileManager;
import view.TextEditorView;

public class ControlTextEditor {
	private TextEditorView txtView;
	private FileManager fm;

	public ControlTextEditor() {

		fm = new FileManager();
		txtView = new TextEditorView(this);
	}
	public void handleEvent(int event) {
		switch (event) {
		case 0: exit();
		break;
		case 1: create();
		break;
		case 2: open();
		break;
		case 3: save();
		break;
		case 4:saveAs();
		break;
		case 5: fm.fileContentChanged();
		break;
		default: System.out.println("unknown event " + event);

		}
	}

	
	public void run() {
		txtView.show();
	}
	
	private boolean isSaved() { 
		if (!fm.isChanged()) { 
			return true;
		}
		int choice = JOptionPane.showConfirmDialog(
				null,
				"You have not saved the changes in the file. Save before continuing?", 
				"unsaved changes",
				JOptionPane.YES_NO_CANCEL_OPTION);
		if (choice == JOptionPane.YES_OPTION) { 
			return save();
		}
		
		if(choice == JOptionPane.NO_OPTION) { 
			return true;
		}
		return false;
	}
	
	private boolean saveAs() {
		String fileName = JOptionPane.showInputDialog("Save as:");
		if (fileName == null || fileName.isBlank()) {
			return false;
		}

		try {
			fm.saveFile(fileName, txtView.getText());
			return true;

		} catch(IOException e) {
			JOptionPane.showMessageDialog(null,"could not save as." + e.getMessage());
			return false;
		}

	}
	private boolean save() {
		String fileName = fm.getCurrentFileName();
		if(fileName ==null || fileName.isEmpty()) {
			return saveAs();
		
		}
		try {
			fm.saveFile(fileName, txtView.getText());
			return true;
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null,"Could not save" + e.getMessage());
			return false;
		}

	}

	private void open() {
		if(!isSaved()) { 
			return;
		}
		JFileChooser choosenFile = new JFileChooser();
		if(choosenFile.showOpenDialog(null) != JFileChooser.APPROVE_OPTION) {
			return;
		}
		try {
			txtView.setText(fm.openTextFile(choosenFile.getSelectedFile()));

		} catch(IOException e) {
			JOptionPane.showMessageDialog(null,"could not open." + e.getMessage());
		}

	}
	private void create() {
		if(!isSaved()) { 
			return;
		}
		String fileName = JOptionPane.showInputDialog("File name:");
		if (fileName == null || fileName.isBlank()) {
			return;
		}

		try {
			fm.createTextFile(fileName);
			txtView.setText("");

		} catch(IOException e) {
			JOptionPane.showMessageDialog(null,"Error"+e.getMessage());
		}

	}
	private void exit() {
		if(isSaved()) { 
			System.exit(0);
		}

	}

	 public static void main(String[] args) {
	        SwingUtilities.invokeLater(() -> new ControlTextEditor().run());
	    }
}
