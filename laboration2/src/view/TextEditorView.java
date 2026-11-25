package view;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import control.ControlTextEditor;

public class TextEditorView {
	private JFrame jFrame;
	private JMenu jMenu, jMenu2;
	private JMenuItem create, open, save , saveAs, exit, copy, paste, cut;
	private JTextArea jTextArea;
	private JMenuBar jMenuBar;
	private JScrollPane jsPanel;
	private ControlTextEditor conTxteditor;
	private boolean loading;



	public TextEditorView(ControlTextEditor conTxteditor) {
		this.conTxteditor = conTxteditor;
		//Gui component 
		jFrame = new JFrame("Text editor!");
		jMenu = new JMenu("File");
		jMenu2 = new JMenu("Redigera");
		jTextArea = new JTextArea();
		jMenuBar = new JMenuBar();
		jsPanel = new JScrollPane();
		
		create = new JMenuItem("Create");
		open = new JMenuItem("Open");
		save = new JMenuItem("Save");
		saveAs = new JMenuItem("Save as");
		exit = new JMenuItem("Exit");
		
		copy = new JMenuItem("Copy");
		paste = new JMenuItem("Paste");
		cut = new JMenuItem("Cut");
		
		create.addActionListener(new CreateListener(this));
		open.addActionListener(new OpenListener(this));
		save.addActionListener(new SaveListener(this));
		saveAs.addActionListener(new SaveAsListener(this));
		exit.addActionListener(new ExitListener(this));
		
		copy.addActionListener(new CopyListener(this));
		paste.addActionListener(new PasteListener(this));
		cut.addActionListener(new CutListener(this));
		
		

		jMenu.add(create);
		jMenu.add(open);
		jMenu.add(save);
		jMenu.add(saveAs);
		jMenu.add(exit);
		jMenuBar.add(jMenu);
		jFrame.setJMenuBar(jMenuBar);
		
		jMenu2.add(copy);
		jMenu2.add(paste);
		jMenu2.add(cut);
		jMenuBar.add(jMenu2);

		jsPanel.setViewportView(jTextArea);


		jFrame.setLayout(new BorderLayout());
		jFrame.add(jsPanel, BorderLayout.CENTER);

		jFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		jFrame.setSize(700, 500);
		jFrame.setLocationRelativeTo(null);
		
		changesHandler();
		jFrame.addWindowListener(new WindowAdapter() { 
			@Override
			private void windowClosing(WindowEvent e) { 
				windowHandler();
			}
		});

	}


	public void show() {
        jFrame.setVisible(true);
    }
	
	public void chooseExit() {
		conTxteditor.handleEvent(0);
	}
	
	public void chooseCreate() {
		conTxteditor.handleEvent(1);
	}

	public void chooseOpen() {
		conTxteditor.handleEvent(2);
	}

	public void chooseSave() {
		conTxteditor.handleEvent(3);
	}

	public void chooseSaveAs() {
		conTxteditor.handleEvent(4);
	}
	
	private void textChanged() { 
		if (!loading && conTxteditor != null) { 
			conTxteditor.handleEvent(5);
		}
	}
	
	private void changesHandler() { 
		DocumentListener list = new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				textChanged();
				
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				textChanged();
				
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				textChanged();
				
			} 
			
		};
		
		jTextArea.getDocument().addDocumentListener(list);
	}
	
	
	public void chooseCopy() {
		jTextArea.copy();
		
	}
	
	public void choosePaste() {
		
		jTextArea.paste();
		
	}
	
	public void chooseCut() {
		jTextArea.cut();
		
	}

	public String getText() {
		return jTextArea.getText();
	}
	
	public void setText(String txt) {
		loading = true;
		try { 
			jTextArea.setText(txt); 
		} finally { 
			loading = false;
		}
	}
	
	public void windowHandler() { 
		chooseExit();
		
		
	}
	
	



	






}
