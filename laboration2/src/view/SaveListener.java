package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import control.ControlTextEditor;

public class SaveListener implements ActionListener {
	private TextEditorView view;

	public SaveListener(TextEditorView txtView) {
		view = txtView;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		view.chooseSave(); 

	}

}
