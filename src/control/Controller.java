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
		this.view = v;
	}
	
	


}
