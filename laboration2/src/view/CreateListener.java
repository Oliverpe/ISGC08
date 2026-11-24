package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateListener implements ActionListener {
	private TextEditorView view;
	public CreateListener(TextEditorView txtView) {
		view = txtView;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		view.chooseCreate(); //handleEvent(1)

	}

}
