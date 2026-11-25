package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class CutListener implements ActionListener {
	private TextEditorView view;
	public CutListener(TextEditorView txtView) { 
		view = txtView;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		view.chooseCut();

	}

}
