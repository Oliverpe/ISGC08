package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OpenListener implements ActionListener {
	private TextEditorView view;
	public OpenListener(TextEditorView txtView) {
		view = txtView;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		view.chooseOpen();
		//handleEvent(2);
	}

}
