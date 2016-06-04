package control;

import model.FileModel;
import view.View;

public class Controller implements IController{
	FileModel left = null;
	FileModel right = null;
	View view = null;
	
	public Controller(FileModel left, FileModel right, View v ){
		this.left = left;
		this.right = right;
		this.view = view View(this);		
		
		view.make();
	}
	
	public void eventOccured(String asd){
		if(asd.equals("load")){
			loadLeft();
		}
	}
	
	@Override
	public void loadLeft() {
		String fileAddress = "";
		
		if( left.loadData("") )
			 view.showData(left.DataToAString());
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