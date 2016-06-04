package control;

import model.FileModel;
import view.View;

public interface IController {
	FileModel left = null;
	FileModel right = null;
	View view = null;
	
	abstract void loadLeft();
	abstract void saveLeft();
	abstract void editLeft();
	
	abstract void loadRight();
	abstract void saveRight();
	abstract void editRight();
	

	
}
