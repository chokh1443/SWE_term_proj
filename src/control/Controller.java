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
			System.out.println("aaa");
//			if (name.equals("loadLeft")) {
//				this.loadLeft.addActionListener(action);
//				System.out.println("here");
//			}			
//			else if(name.equals("saveLeft"))
//				saveLeft.addActionListener(action);
//			else if(name.equals("editLeft"))
//				editLeft.addActionListener(action);
//			else if(name.equals("loadRight"))
//				loadRight.addActionListener(action);
//			else if(name.equals("saveRight"))
//				saveRight.addActionListener(action);
//			else if(name.equals("editRight"))
//				editRight.addActionListener(action);
//			else if(name.equals("copyToLeft"))
//				copyToLeft.addActionListener(action);
//			else if(name.equals("copyToRight"))
//				copyToRight.addActionListener(action);
//			else if(name.equals("compare"))
//				compare.addActionListener(action);
		}
		
	}

	@Override
	public void loadLeft() {
		String fileAddress = "";
		
		if( left.loadData("") ){
			 //view.showData(left.DataToAString());
		}
			
		else
			System.out.println("Fail to load at Controller.loadLeft.left.loadData()");
		
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void saveLeft() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editLeft() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void loadRight() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveRight() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editRight() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void copyToLeft() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void copyToRight() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void compare() {
		// TODO Auto-generated method stub
		
	}



}