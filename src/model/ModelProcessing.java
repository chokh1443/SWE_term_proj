package model;

public class ModelProcessing implements IModelProcessing{
	FileModel left;
	FileModel right;
	int[][] lcs; // lcs 알고리즘 수행 결과
	int[] areaLeft, areaRight; // lcs 알고리즘 수행 결과를 바탕으로 구역을 나눔.
	
	public ModelProcessing(FileModel left, FileModel right){
		this.left = left;
		this.right = right;
	}

	@Override
	public void compare() {
		// TODO Auto-generated method stub
		int l=0, r=0;
		int leftLength = left.Data.size(), rightLength = right.Data.size();
		lcs = new int[leftLength+1][rightLength+1];
		areaLeft = new int[leftLength];
		areaRight = new int[rightLength];
		
		for(l = 1; l <= leftLength ; l++){ // 최종값은 lcs[leftLength][rightLength] 에 저장.
			for(r = 1; r <= rightLength ; r++){
				if( left.Data.get(l-1).equals( right.Data.get(r-1) ) ){
						lcs[l][r] = lcs[l-1][r-1] + 1;
						areaLeft[l-1] = 0;
						areaRight[r-1] = 0;
				}else{
					lcs[l][r] = Math.max(lcs[l-1][r], lcs[l][r-1]);
					areaLeft[l-1] = 1;
					areaRight[r-1] = 1;
				}
			}
		}
		
		
	}

	@Override
	public void copyToRight(int sourceInd, int dstInd) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void copyToLeft(int sourceInd, int dstInd) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public FileModel getLeft() {
		// TODO Auto-generated method stub
		return left;
	}

	@Override
	public FileModel getRight() {
		// TODO Auto-generated method stub
		return right;
	}

	@Override
	public int[] getLeftArea() {
		// TODO Auto-generated method stub
		return areaLeft;
	}

	@Override
	public int[] getRightArea() {
		// TODO Auto-generated method stub
		return areaRight;
	}

}
