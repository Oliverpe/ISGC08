package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CopyListener implements ActionListener {

	private TextEditorView view;
	public CopyListener(TextEditorView txtView) { 
		view = txtView;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		view.chooseCopy();

	}

}
