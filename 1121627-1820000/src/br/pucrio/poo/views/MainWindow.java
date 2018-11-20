package br.pucrio.poo.views;

import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class MainWindow extends JFrame {
	public MainWindow(BoardPanel boardPanel, DicesPanel dicesPanel, OperationsPanel operationsPanel) {
		super("Super Ludo");

		this.setResizable(false);

		Container contentPane = this.getContentPane();

		JPanel westPanel = boardPanel;
		JPanel eastPanel = new JPanel();

		eastPanel.setLayout(new BorderLayout());
		eastPanel.add(operationsPanel,BorderLayout.PAGE_START);
		eastPanel.add(dicesPanel,BorderLayout.CENTER);

		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		contentPane.add(westPanel);
		contentPane.add(eastPanel);

		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null); // Centraliza
		this.pack();
	}
}
