package br.pucrio.poo.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class MainWindow extends JFrame {
	public MainWindow(BoardPanel boardPanel, DicesPanel dicesPanel, OperationsPanel operationsPanel) {
		super("Super Ludo");

		this.setResizable(false);

		Container contentPane = this.getContentPane();
		
		JPanel eastPanel = new JPanel();

		eastPanel.setLayout(new BorderLayout());
		eastPanel.add(operationsPanel,BorderLayout.PAGE_START);

		if (!boardPanel.finished()) {
			JPanel westPanel = boardPanel;
			eastPanel.add(dicesPanel,BorderLayout.CENTER);
			contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
			contentPane.add(westPanel);
			contentPane.add(eastPanel);
		}
		else {
			JPanel westPanelEnd = new JPanel();
			JLabel l=new JLabel("Isso é um B-777"); //
			westPanelEnd.add(l);//
			contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
			contentPane.add(westPanelEnd);
			contentPane.add(eastPanel);
		}
		

		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null); // Centraliza
		this.pack();
	}	
	

}
