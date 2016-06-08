package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;

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

		disableText("left");
		disableText("right");
		
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
		loadLeft.setName("loadLeft");
		saveLeft.setName("saveLeft");
		editLeft.setName("editLeft");
		loadRight.setName("loadRight");
		saveRight.setName("saveRight");
		editRight.setName("editRight");
		copyToLeft.setName("copyToLeft");
		copyToRight.setName("copyToRight");
		compare.setName("compare");
		
		loadLeft.addActionListener(action);
		saveLeft.addActionListener(action);
		editLeft.addActionListener(action);
		loadRight.addActionListener(action);
		saveRight.addActionListener(action);
		editRight.addActionListener(action);
		copyToLeft.addActionListener(action);
		copyToRight.addActionListener(action);
		compare.addActionListener(action);
	}

	@Override
	public void showData(String side, String data) {
		if(side.equals("left")){
			textLeft.setText("");
			textLeft.append(data);
		}
		else if(side.equals("right")){
			textRight.setText("");
			textRight.append(data);
		}
	}

	@Override
	public void switchTextAreaEditable(String side) {
		if(side.equals("left")) {
			if(textLeft.isEditable()) {
				disableText(side);
			}
			else {
				enableText(side);
			}
		}
		else if(side.equals("right")){
			if(textRight.isEditable()) {
				disableText(side);
			}
			else {
				enableText(side);
			}			
		}
	}
	
	public void enableText(String side) {
		if(side.equals("left")) {
			textLeft.setEditable(true);
			textLeft.setBackground(new Color(255,255,255));
		}
		if(side.equals("right")) {
			textRight.setEditable(true);
			textRight.setBackground(new Color(255,255,255));
		}
	}
	public void disableText(String side) {
		if(side.equals("left")) {
			textLeft.setEditable(false);
			textLeft.setBackground(new Color(200,200,200));
		}
		if(side.equals("right")) {
			textRight.setEditable(false);
			textRight.setBackground(new Color(200,200,200));
		}				
	}


	@Override
	public void highLight(String side, int[] diff) {
		if(side.equals("left")) {
			hightLightInner(textLeft, diff);
		}
		if(side.equals("right")) {
			hightLightInner(textRight, diff);
		}
		
	}
	
	void hightLightInner(JTextArea txt, int[] diff){
		/*0: ���� �� (x)
		1: ���� ��1
		2: ���� �� (x)
		3: ������ ��3
		9: ��³�*/
		Highlighter highlighter = txt.getHighlighter();
		for(int i=0; i<txt.getLineCount(); i++){
			if (diff[i] == 1) {
				try {
					highlighter.addHighlight(txt.getLineStartOffset(i), txt.getLineEndOffset(i), new DefaultHighlighter.DefaultHighlightPainter(Color.orange) );
				} catch (BadLocationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (diff[i] == 3) {
				try {
					highlighter.addHighlight(txt.getLineStartOffset(i), txt.getLineEndOffset(i), new DefaultHighlighter.DefaultHighlightPainter(Color.orange) );
				} catch (BadLocationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}



}
