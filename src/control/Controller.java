package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
				c.loadLeft();
			}
			else if(e.getSource().toString().contains("saveLeft")){
				c.saveLeft();
			}
			else if(e.getSource().toString().contains("editLeft")){
				c.editLeft();
			}
			else if(e.getSource().toString().contains("loadRight")){
				c.loadRight();
			}
			else if(e.getSource().toString().contains("saveRight")){
				c.saveRight();
			}
			else if(e.getSource().toString().contains("editRight")){
				c.editRight();
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
	public void loadLeft() {
		String fileAddress = "";
		System.out.println("LL");
//		if( left.loadData("") ){
//			 view.showData(left.DataToAString());
//		}
//			
//		else
//			System.out.println("Fail to load at Controller.loadLeft.left.loadData()");
//		
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void saveLeft() {
		// TODO Auto-generated method stub
		System.out.println("SL");
	}

	@Override
	public void editLeft() {
		// TODO Auto-generated method stub
		System.out.println("EL");
	}

	@Override
	public void loadRight() {
		// TODO Auto-generated method stub
		System.out.println("LR");
	}

	@Override
	public void saveRight() {
		// TODO Auto-generated method stub
		System.out.println("SR");
	}

	@Override
	public void editRight() {
		// TODO Auto-generated method stub
		System.out.println("ER");
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