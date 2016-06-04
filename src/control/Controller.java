package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;

import model.FileModel;
import view.View;

public class Controller implements IController{
	FileModel left = null;
	FileModel right = null;
	View view = null;
	ActionListener myActionListener;
	public Controller(FileModel left, FileModel right, View v ){
		this.left = left;
		this.right = right;
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
			left.saveData(fileAddress);
		}
		else if(side.equals("right")) {
			right.saveData(fileAddress);
		}
	}
	
	@Override
	public void edit(String side) {
		view.switchTextAreaEditable(side);
	}


	@Override
	public void copyToLeft() {
		// TODO Auto-generated method stub
		System.out.println("C2L");
	}

	@Override
	public void copyToRight() {
		// TODO Auto-generated method stub
		System.out.println("C2R");
	}

	@Override
	public void compare() {
		// TODO Auto-generated method stub
		System.out.println("COM");
	}





}