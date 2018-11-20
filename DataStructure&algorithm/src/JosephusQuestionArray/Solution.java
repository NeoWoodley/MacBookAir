package JosephusQuestionArray;

public class Solution {
	private int[] array;
	private int size;

	public Solution(int N, int diatance) {
		this.size=N;
		initArray(N);
		solution(diatance);
	}

	private void initArray(int N) {
		this.array = new int[N];
		for (int i = 0; i < N; i++) {
			this.array[i]=i+1;
		}
	}

	private void solution(int distance) {
		int index=0;
		while (this.size > 1) {
			int count=0;
			while (count<distance) {
				if (this.array[index%this.array.length] != -1) {
					count++;
				}
				index++;
			}
			index=index%this.array.length;
			while (this.array[index] == -1) {
				index++;
				index=index%this.array.length;
			}
			remove(index);
			index++;
		}
		printWinner();
	}

	private void remove(int index) {
		System.out.println("remove index: " + index);
		this.array[index]=-1;
		this.size--;
	}

	private void printWinner() {
		for (int i : this.array) {
			if (i != -1) {
				System.out.println("最后的胜利者是："+i);
			}
		}
	}

	/**
	 * 举例：总人数为10，距离为3，最后获胜者为5
	 * @param args
	 */
	public static void main(String[] args) {
		new JosephusQuestionArray.Solution(10, 3);  // 前一个参数代表总人数，后一个参数代表间隔的距离
	}

}
