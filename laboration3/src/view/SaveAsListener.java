package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SaveAsListener implements ActionListener {
	private TextEditorView view;
	public SaveAsListener(TextEditorView txtView) {
		view = txtView;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		view.chooseSaveAs();

	}

}
