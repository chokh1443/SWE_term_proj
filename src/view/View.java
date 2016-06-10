package view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;

//import controller.IController;

public class View extends JFrame implements IView {
	//static JFrame frame = new JFrame("myMerger");

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
		
		loadLeft.setName("loadLeft");
		saveLeft.setName("saveLeft");
		editLeft.setName("editLeft");
		loadRight.setName("loadRight");
		saveRight.setName("saveRight");
		editRight.setName("editRight");
		copyToLeft.setName("copyToLeft");
		copyToRight.setName("copyToRight");
		compare.setName("compare");

		/*frame.setLayout(null);

		frame.add(panelLeft);
		frame.add(panelRight);
		frame.add(panelDown);

		frame.setSize(1000, 650);
		frame.setResizable(false);

		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);*/
		this.setLayout(null);

		this.add(panelLeft);
		this.add(panelRight);
		this.add(panelDown);

		this.setSize(1000, 650);
		this.setResizable(false);

		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void attachEvent(ActionListener action) {
		// TODO Auto-generated method stub

		
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
	public int getCursor(String side) {
		int line = -1;
		if(side.equals("left")){
			int cursor = textLeft.getCaretPosition();
			try {
				line = textLeft.getLineOfOffset(cursor);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(side.equals("right")){
			int cursor = textRight.getCaretPosition();
			try {
				line = textRight.getLineOfOffset(cursor);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return line;
	}
	
	void hightLightInner(JTextArea txt, int[] diff){
		/*0: 공백 색 (x)
		1: 왼쪽 색1
		2: 양쪽 색 (x)
		3: 오른쪽 색3
		9: 출력끝*/
		Highlighter highlighter = txt.getHighlighter();
		for(int i=0; i<txt.getLineCount(); i++){
			if (diff[i] == 1) {
				try {
					highlighter.addHighlight(txt.getLineStartOffset(i), txt.getLineEndOffset(i), new DefaultHighlighter.DefaultHighlightPainter(Color.orange) );
				} catch (BadLocationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else if (diff[i] == 3) {
				try {
					highlighter.addHighlight(txt.getLineStartOffset(i), txt.getLineEndOffset(i), new DefaultHighlighter.DefaultHighlightPainter(Color.orange) );
				} catch (BadLocationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else if(diff[i] == 4) { // 머지한부분
				try {
					highlighter.addHighlight(txt.getLineStartOffset(i), txt.getLineEndOffset(i), new DefaultHighlighter.DefaultHighlightPainter(Color.green) );
				} catch (BadLocationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	@Override
	public ArrayList<String> StringToData(String side) {
		// TODO Auto-generated method stub
		ArrayList<String> data = new ArrayList<String>();
		JTextArea txt = null;
		if(side.equals("left")) {
			txt = textLeft;
		}
		else if(side.equals("right")) {
			txt= textRight;
		}
		for(int i=0;i<txt.getLineCount(); i++){
			try {
				int start = txt.getLineStartOffset(i);
				int end = txt.getLineEndOffset(i);
				if((end-start-2)>0){
					data.add(txt.getText(start, (end-start-2)));
				}
			} catch (BadLocationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return data;
	}



}
