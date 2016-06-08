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
		int longerLength = 0;
		
		lcs = new int[leftLength+1][rightLength+1];

	/*	
		for(l = 1; l <= leftLength ; l++){ // 최종값은 lcs[leftLength][rightLength] 에 저장.
			for(r = 1; r <= rightLength ; r++){
				System.out.println("index left: " + l + " index right: " + r);
				System.out.println(left.Data.get(l-1) + " ? " + right.Data.get(r-1));
				if( left.Data.get(l-1).equals( right.Data.get(r-1) ) ){
					System.out.println("Same. Writing areaLeft["+(l-1)+"] and areaRight["+(r-1)+"] as 0\n");
						lcs[l][r] = lcs[l-1][r-1] + 1;
						areaLeft[l-1] = 0;
						areaRight[r-1] = 0;
				}else{
					lcs[l][r] = Math.max(lcs[l-1][r], lcs[l][r-1]);
					System.out.println("Diff. Writing areaLeft[l-1] and areaRight[r-1] as 1\n");
					areaLeft[l-1] = 1;
					areaRight[r-1] = 1;
				}
			}
		}*/
		
		for(l = leftLength-1; l >=0  ; l--){ // 최종값은 lcs[leftLength][rightLength] 에 저장.
			for(r = rightLength-1; r >= 0 ; r--){
				//System.out.println("index left: " + l + " index right: " + r);
				//System.out.println(left.Data.get(l) + " ? " + right.Data.get(r));
				if( left.Data.get(l).equals( right.Data.get(r) ) ){
					//System.out.println("Same. Writing areaLeft["+(l)+"] and areaRight["+(r)+"] as 0\n");
						lcs[l][r] = lcs[l+1][r+1] + 1;
					//	areaLeft[l-1] = 0;
					//	areaRight[r-1] = 0;
				}else{
					lcs[l][r] = Math.max(lcs[l][r+1], lcs[l+1][r]);
					//System.out.println("Diff. Writing areaLeft[l-1] and areaRight[r-1] as 1\n");
					//areaLeft[l-1] = 1;
					//areaRight[r-1] = 1;
				}
			}
		}
		
		
		areaLeft = new int[ leftLength + (leftLength - lcs[0][0]) ]; // 원래 길이 + 공통된 부분을 제외한 길이
		areaRight = new int[ rightLength + (rightLength - lcs[0][0]) ];
		
		for(l = 0; l <= leftLength ; l++){
			for(r=0; r <= rightLength ; r++){
				System.out.print(" " + lcs[l][r]);
			}
			System.out.println("");
		}
		
		/*
		if(leftLength < rightLength)
			longerLength = rightLength;
		else
			longerLength = leftLength;
		*/
		l = 0;
		r = 0;
		
		int temp;
		int tl=0;
		int tr=0;
		
		while(true){
			temp = lcs[l][r];
			
			if(temp == lcs[l][r+1]){
			//	areaL 공백
				areaLeft[tl] = 0;
				System.out.println("areaLeft[tl] = 0 tl++");
				tl++;
			//	areaR 라인
				areaRight[tr] = 1;
				System.out.println("areaRight[tr] = 1 tr++");
				tr++;
				
				r++;
				System.out.println("right");
			}else if(temp == lcs[l+1][r]){
			//	areaL 라인
				areaLeft[tl] = 1;
				System.out.println("areaLeft[tl] = 1 tl++");
				tl++;
			//	areaR 공백
				areaRight[tr] = 0;
				System.out.println("areaRight[tr] = 0 tr++");
				tr++;
				
				l++;
				System.out.println("down");
			}else{
			//	areaL 라인
				areaLeft[l] = 1;
				System.out.println("areaLeft[tl] = 1 tl++");
				tl++;
			//	areaR 라인
				areaRight[r] = 1;
				System.out.println("areaRight[tr] = 1 tr++");
				tr++;
				
				l++;
				r++;
				System.out.println("diagonal");
			}
			
			if( (l == leftLength) && (r < rightLength)){
			// areaR 남은라인 추가
				areaRight[r] = 99;
				System.out.println("areaRight[tr] = 99 r++");
				tr++;
				System.out.println("Left part done.");
				break;
			}else if( (l < leftLength) && (r == rightLength)){
			// areaL 남은라인 추가
				areaLeft[l] = 99;
				System.out.println("areaLeft[tl] = 99 tl++");
				tl++;
				System.out.println("Rightt part done.");
				break;
			}			
		}
		
		for(int i = 0; i < tl; i++){
			System.out.println(areaLeft[i]);
		}
		System.out.println("-------");
		for(int i = 0; i < tr; i++){
			System.out.println(areaRight[i]);
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
