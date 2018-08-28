package Array;

/**
 * 稀疏数组
 * <p>
 * 数组中大部分的元素值都未被使用（或都为零），在数组中仅有少部分的空间使用，造成内存空间浪费
 * <p>
 * 采用一种压缩的方式来表示稀疏数组的内容
 * <p>
 * 数组行数  数组列数  使用个数
 * 【第一部分               】
 * 元素行数  元素列数  元素内容
 * 【第二部分               】
 * <p>
 * Data = [0 0 0 0 0 0 0
 * 0 3 0 0 0 0 0
 * 0 0 0 0 0 0 0
 * 1 4 0 0 0 0 0
 * 0 0 7 0 0 0 0
 * 0 0 0 0 0 5 0
 * 0 0 0 0 0 0 0
 * 0 0 0 0 0 0 0
 * 0 0 0 0 0 0 0]
 */
public class array07 {
	public static void main(String[] args) {
		int[][] Data = {{0, 0, 0, 0, 0, 0, 0},
				{0, 3, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0},
				{1, 4, 0, 0, 0, 0, 0},
				{0, 0, 7, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 5, 0},
				{0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0}};
		int[][] CompressData = new int[10][3];  // 存储压缩后数据的数组
		int Index = 0;  // 压缩数组的下标，不仅可以表示原数组中有多少个非零元素，还可以表示CompressData的索引行数

		System.out.println("Two dimensional sparse array:");
		print(Data);

		for (int i = 0; i < Data.length; i++) {
			for (int j=0;j<Data[0].length;j++)
				if (Data[i][j]!=0) {
					Index++;
					CompressData[Index][0]=i;
					CompressData[Index][1]=j;
					CompressData[Index][2]=Data[i][j];
				}
		}

		CompressData[0][0]=Data.length;
		CompressData[0][1]=Data[0].length;
		CompressData[0][2]=Index;

		System.out.println("Two dimensional compress array:");
		print(CompressData);
	}

	public static void print(int[][] Data) {
		int n=Data[0].length;

		for (int[] aData : Data) {
			for (int i = 0; i < n; i++)
				System.out.print(" " + aData[i]);
			System.out.println();
		}
	}
}
