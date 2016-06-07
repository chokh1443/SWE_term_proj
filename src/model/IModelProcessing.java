package model;

public interface IModelProcessing {

	abstract void compare();
	abstract void copyToRight(int sourceInd, int dstInd);
	abstract void copyToLeft(int sourceInd, int dstInd);
	abstract FileModel getLeft();
	abstract FileModel getRight();
	abstract int[] getLeftArea();
	abstract int[] getRightArea();
}
