package controll;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JFileChooser;

import model.FileModel;
import model.ModelProcessing;
import view.View;

public class Controller implements IController{
	FileModel left = null;
	FileModel right = null;
	ModelProcessing mp = null;
	View view = null;
	ActionListener myActionListener;
	
	
	public Controller(ModelProcessing MP,  View v){
		this.mp = MP;
		this.left = this.mp.getLeft();
		this.right = this.mp.getRight();
		this.view = v;
		view.make();
		this.setup();
		
	}
	
	
	public void setup() {
		myActionListener = new MyActionListener(this);
		this.view.attachEvent(myActionListener);
	}
	public class MyActionListener implements ActionListener {
		Controller c;
		public MyActionListener(Controller c) {
			this.c = c;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource().toString().contains("loadLeft")){
				c.load("left");
			}
			else if(e.getSource().toString().contains("saveLeft")){
				c.save("left");
			}
			else if(e.getSource().toString().contains("editLeft")){
				c.edit("left");
			}
			else if(e.getSource().toString().contains("loadRight")){
				c.load("right");
			}
			else if(e.getSource().toString().contains("saveRight")){
				c.save("right");
			}
			else if(e.getSource().toString().contains("editRight")){
				c.edit("right");
			}
			else if(e.getSource().toString().contains("copyToLeft")){
				c.copyToLeft();
			}
			else if(e.getSource().toString().contains("copyToRight")){
				c.copyToRight();
			}
			else if(e.getSource().toString().contains("compare")){
				c.compare();
			}
		}
	}

	@Override
	public void load(String side) {
		String fileAddress = "";
		JFileChooser fileChooser = new JFileChooser();
		
		if(fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			fileAddress = fileChooser.getSelectedFile().getPath();
		}		
		else {
			System.out.println("Fail to load at Controller.load()");
		}
		view.disableText(side);
		
		if (side.equals("left")){
			if( left.loadData(fileAddress)){
				 view.showData(side, left.DataToAString());
			}
			
		}
		else if(side.equals("right")) {
			if( right.loadData(fileAddress)){
				 view.showData(side, right.DataToAString());
			}
		}
		mp.compareStatusReset();
		
		
	}

	@Override
	public void save(String side) {
		String fileAddress = "";
		JFileChooser fileChooser = new JFileChooser();
		
		if(fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			fileAddress = fileChooser.getSelectedFile().getPath();
		}
		else {
			System.out.println("Fail to load at Controller.load()");
		}
		if (side.equals("left")){
			left.saveEdit(view.StringToData(side));
			left.saveData(fileAddress);
		//	mp.Save("left",fileAddress);
		}
		else if(side.equals("right")) {
			right.saveEdit(view.StringToData(side));
			right.saveData(fileAddress);
		}
	}
	
	@Override
	public void edit(String side) {
		view.switchTextAreaEditable(side);
	}


	@Override
	public void copyToLeft() {
		String side = "right";
		System.out.println("current line = "+view.getCursor(side));
		
		mp.copyToLeft(view.getCursor(side)); // 파라메터로 옮기고싶은 인덱스를 넣어줘야함
		
		view.showData("left", left.DataToAString());
		view.highLight("right", mp.getRightArea());
		view.highLight("left", mp.getLeftArea());
		
		System.out.println("C2L");
	}

	@Override
	public void copyToRight() {
		String side = "left";
		System.out.println("current line = "+view.getCursor(side));
		
		mp.copyToRight(view.getCursor(side)); // 파라메터로 옮기고싶은 인덱스를 넣어줘야함
		
		view.showData("right", right.DataToAString());
		view.highLight("right", mp.getRightArea());
		view.highLight("left", mp.getLeftArea());
		
		System.out.println("C2R");
	}

	@Override
	public void compare() {
		// TODO Auto-generated method stub
		mp.compare();
		view.showData("left", left.DataToAString());
		view.highLight("left", mp.getLeftArea());
		view.showData("right", right.DataToAString());
		view.highLight("right", mp.getRightArea());
		view.enableText("left");
		view.enableText("right");
		
		System.out.println("COM");
	}





}