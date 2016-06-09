package model;

public class ModelProcessing implements IModelProcessing {
	FileModel left;
	FileModel right;
	int[][] lcs; // lcs �˰��� ���� ���
	int[] areaLeft, areaRight; // lcs �˰��� ���� ����� �������� ������ ����.
	boolean compared = false;

	public ModelProcessing(FileModel left, FileModel right) {
		this.left = left;
		this.right = right;
	}

	@Override
	public void compare() {
		// TODO Auto-generated method stub
		if (!compared) {

			int l = 0, r = 0;
			int leftLength = left.Data.size(), rightLength = right.Data.size();
			lcs = new int[leftLength + 1][rightLength + 1];

			for (l = leftLength - 1; l >= 0; l--) { // ��������
													// lcs[leftLength][rightLength]
													// �� ����.
				for (r = rightLength - 1; r >= 0; r--) {
					if (left.Data.get(l).equals(right.Data.get(r))) {
						lcs[l][r] = lcs[l + 1][r + 1] + 1;
					} else {
						lcs[l][r] = Math.max(lcs[l][r + 1], lcs[l + 1][r]);
					}
				}
			}

			System.out.println("LCS completed");

			areaLeft = new int[leftLength + rightLength]; // worst case�� ����
			areaRight = new int[leftLength + rightLength];

			for (l = 0; l <= leftLength; l++) {
				for (r = 0; r <= rightLength; r++) {
					System.out.print(" " + lcs[l][r]);
				}
				System.out.println("");
			}

			l = 0;
			r = 0;
			int temp;
			int tl = 0;
			int tr = 0;
			String blank = "";
			
			while (true) {
				temp = lcs[l][r];
				if (l + 1 > leftLength)
					break;
				if (r + 1 > rightLength)
					break;

				if (temp == lcs[l][r + 1]) {
					System.out.println("right");
					areaLeft[tl] = 0; // areaL ����
					left.Data.add(tl, blank);

					tl++;
					areaRight[tr] = 3; // areaR ����
					tr++;

					r++;

				} else if (temp == lcs[l + 1][r]) {
					System.out.println("down");
					areaLeft[tl] = 1; // areaL ����
					tl++;

					areaRight[tr] = 0; // areaR ����
					right.Data.add(tr, blank);

					tr++;

					l++;
				} else {
					System.out.println("diagonal");
					areaLeft[tl] = 2; // areaL ����
					tl++;
					areaRight[tr] = 2; // areaR ����
					tr++;

					l++;
					r++;
				}

				if ((l == leftLength) && (r < rightLength)) {// areaR �������� �߰�
					while (true) {
						areaRight[tr] = 3;
						tr++;

						// left.Data.add(tl, "");
						// tl++;
						r++;
						if (r == rightLength)
							break;
					}
					tl++;
					break;
				} else if ((l < leftLength) && (r == rightLength)) {// areaL
																	// �������� �߰�
					while (true) {
						areaLeft[tl] = 1;
						tl++;
						// right.Data.add(tr, "");
						// tr++;
						l++;
						if (l == leftLength)
							break;
					}
					tr++;
					break;
				}
			}

			areaLeft[tl] = 9;
			areaRight[tr] = 9;

			if (tl > tr) {
				for (int i = 0; i < tl; i++) {
					System.out.println(areaLeft[i] + " " + areaRight[i]);
				}
			}
			System.out.println("-------");
			if (tl < tr) {
				for (int i = 0; i < tr; i++) {
					System.out.println(areaLeft[i] + " " + areaRight[i]);
				}
			}
			left.setCompared();
			right.setCompared();
			compared = true;
		}
	}

	@Override
	public void copyToRight(int sourceInd) {
		if (left.getCompared() && right.getCompared()) {
			if ((areaLeft[sourceInd] == 1) && (areaRight[sourceInd] == 0)) {
				areaRight[sourceInd] = 2;
				areaLeft[sourceInd] = 2;
				right.Data.set(sourceInd, left.Data.get(sourceInd));
				compared = false;
			}
		}
	}

	@Override
	public void copyToLeft(int sourceInd) {
		if (left.getCompared() && right.getCompared()) {
			if ((areaRight[sourceInd] == 3) && (areaLeft[sourceInd] == 0)) {
				areaRight[sourceInd] = 2;
				areaLeft[sourceInd] = 2;
				left.Data.set(sourceInd, right.Data.get(sourceInd));
				compared = false;
			}
		}
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
