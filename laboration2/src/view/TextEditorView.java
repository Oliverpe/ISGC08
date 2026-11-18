package view;

import javax.swing.*;
import java.awt.*;

public class TextEditorView {
	private JFrame jFrame;
	private JButton jcreate, jopen, jsave, jsaveAs, jexit;
	private JPanel jPanel;
	private JMenu jMenu;
	private JTextArea jTextArea;
	private JMenuBar jMenuBar;
	private JScrollPane jsPanel;
	
	public TextEditorView() { 
		jFrame = new JFrame("Text editor!");
		
		jcreate = new JButton("CREATE");
		jopen = new JButton("OPEN");
		jsave = new JButton("SAVE");
		jsaveAs = new JButton("SAVE AS");
		jexit = new JButton("EXIT");
		
		jPanel = new JPanel();
		jMenu = new JMenu();
		jTextArea = new JTextArea();
		jMenuBar = new JMenuBar();
		jsPanel = new JScrollPane();
		
		jFrame.add(jMenu);
		jFrame.add(jMenuBar);
		
		jPanel.add(jcreate);
		jPanel.add(jopen);
		jPanel.add(jsave);
		jPanel.add(jsaveAs);
		jPanel.add(jexit);
		
		jsPanel.setViewportView(jTextArea);
		
		
		jFrame.setLayout(new BorderLayout());
		jFrame.add(jPanel, BorderLayout.NORTH );
		jFrame.add(jsPanel, BorderLayout.CENTER);
		
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setSize(700, 500);
		jFrame.setLocationRelativeTo(null);
		
		
	}
	
	public void show() {
        jFrame.setVisible(true);
    }
 	
	 public static void main(String[] args) {
	        SwingUtilities.invokeLater(() -> new TextEditorView().show());
	    }

	
	
	
}
