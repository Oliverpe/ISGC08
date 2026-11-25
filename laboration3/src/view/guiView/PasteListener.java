package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PasteListener implements ActionListener {
	
	private TextEditorView view;
	public PasteListener(TextEditorView txtView) { 
		view = txtView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		view.choosePaste();

	}

}
