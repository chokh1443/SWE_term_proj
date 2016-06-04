package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

//import controller.IController;

public class View implements IView {
	static JFrame frame = new JFrame("myMerger");

	static JPanel panelLeft = new JPanel();
	static JPanel panelRight = new JPanel();
	static JPanel panelDown = new JPanel();

	static JButton loadLeft = new JButton("LOAD");
	static JButton saveLeft = new JButton("SAVE");
	static JButton editLeft = new JButton("EDIT");
	static JTextArea textLeft = new JTextArea(28, 43);
	static JScrollPane scrollPaneLeft = new JScrollPane(textLeft);

	static JButton loadRight = new JButton("LOAD");
	static JButton saveRight = new JButton("SAVE");
	static JButton editRight = new JButton("EDIT");
	static JTextArea textRight = new JTextArea(28, 43);
	static JScrollPane scrollPaneRight = new JScrollPane(textRight);

	static JButton copyToLeft = new JButton("<-");
	static JButton copyToRight = new JButton("->");
	static JButton compare = new JButton("COMPARE");

	public void make() {

		panelLeft.setLayout(new FlowLayout());
		panelLeft.setBounds(5, 5, 490, 550);
		panelRight.setLayout(new FlowLayout());
		panelRight.setBounds(500, 5, 490, 550);
		panelDown.setBounds(0, 570, 1000, 100);

		panelLeft.setBackground(new Color(255, 9, 9));
		panelRight.setBackground(new Color(0, 255, 0));

		panelLeft.add(loadLeft);
		panelLeft.add(saveLeft);
		panelLeft.add(editLeft);
		panelLeft.add(scrollPaneLeft);

		panelRight.add(loadRight);
		panelRight.add(saveRight);
		panelRight.add(editRight);
		panelRight.add(scrollPaneRight);

		panelDown.add(copyToLeft);
		panelDown.add(compare);
		panelDown.add(copyToRight);

		frame.setLayout(null);

		frame.add(panelLeft);
		frame.add(panelRight);
		frame.add(panelDown);

		frame.setSize(1000, 650);
		frame.setResizable(false);

		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	@Override
	public void attachEvent(ActionListener action) {
		// TODO Auto-generated method stub
		// Event Listeners
		this.loadLeft.addActionListener(action);
		this.saveLeft.addActionListener(action);
		this.editLeft.addActionListener(action);
		this.loadRight.addActionListener(action);
		this.saveRight.addActionListener(action);
		this.editRight.addActionListener(action);
		this.copyToLeft.addActionListener(action);
		this.copyToRight.addActionListener(action);
		this.compare.addActionListener(action);
	}
}
