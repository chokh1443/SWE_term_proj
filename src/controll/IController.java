package controll;



public interface IController {

	
	abstract void load(String side);
	abstract void save(String side);
	abstract void edit(String side);
	
	abstract void copyToLeft();
	abstract void copyToRight();
	abstract void compare();
	

	
}
