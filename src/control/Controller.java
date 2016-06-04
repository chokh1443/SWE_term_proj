package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.FileModel;
import view.View;

public class Controller implements IController{
	FileModel left = null;
	FileModel right = null;
	View view = null;
	
	ActionListener loadLeftAction;
	ActionListener saveLeftAction;
	ActionListener editLeftAction;
	ActionListener loadRightAction;
	ActionListener saveRightAction;
	ActionListener editRightAction;
	ActionListener copyToLeftAction;
	ActionListener copyToRightAction;
	ActionListener compareAction;
	
	public Controller(FileModel left, FileModel right, View v ){
		this.left = left;
		this.right = right;
		this.view = v;		
		
		view.make();
		this.setup();
		
	}
	
	public void setup() {
		loadLeftAction = new ELoadLeft(this);
		
		view.attachEvent("loadLeft",loadLeftAction);
	}
	public class ELoadLeft implements ActionListener {
		Controller controller;
		ELoadLeft(Controller c ){
			this.controller = c;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			controller.loadLeft();
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



}