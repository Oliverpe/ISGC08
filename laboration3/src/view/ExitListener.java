package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExitListener implements ActionListener {
	private TextEditorView view;
	public ExitListener(TextEditorView txtView) {
		view = txtView;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		view.chooseExit(); //handleEvent(0);

	}

}
