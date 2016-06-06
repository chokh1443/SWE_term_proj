package controll;

import model.FileModel;
import view.View;

public interface IController {
	FileModel left = null;
	FileModel right = null;
	View view = null;
	
	abstract void load(String side);
	abstract void save(String side);
	abstract void edit(String side);
	
	abstract void copyToLeft();
	abstract void copyToRight();
	abstract void compare();
	

	
}
