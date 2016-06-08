package model;

public interface IModelProcessing {

	abstract void compare();
	abstract void copyToRight(int sourceInd);
	abstract void copyToLeft(int sourceInd);
	abstract FileModel getLeft();
	abstract FileModel getRight();
	abstract int[] getLeftArea();
	abstract int[] getRightArea();
}
