import javax.swing.*;
import java.awt.event.*;
import java.util.Date;

public class MenuExample {
	public static void main(String[] args){
		JFrame frame = new JFrame("MyFrame");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		JMenu fileMenu = new JMenu("File");
		JMenuItem item = new JMenuItem("Close");
		item.addActionListener(new MenuActionListener());
		fileMenu.add(item);
		
		fileMenu.add(new JMenuItem("New"));
		fileMenu.add(new JMenuItem("Open"));
		fileMenu.add(new JMenuItem("Close"));
		
		JMenu editMenu = new JMenu("Edit");
		editMenu.add(new JMenuItem("Undo"));
		editMenu.add(new JMenuItem("Redo"));
		editMenu.add(new JMenuItem("Cut"));
		
		JMenuBar menubar = new JMenuBar();
		menubar.add(fileMenu);
		menubar.add(editMenu);
		
		frame.setJMenuBar(menubar);
		
		frame.setSize(300, 400);
		frame.setVisible(true);
	}
}
class MenuActionListener implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(
			MenuExample.frame, "Got an ActionEvent at " + new Date() +
			"from" + e.getSource().getClass()
		);
	}
}
