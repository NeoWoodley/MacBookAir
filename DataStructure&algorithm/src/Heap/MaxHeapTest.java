package Heap;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class MaxHeapTest {
	private MaxHeap<Integer> maxHeap;
	private Integer[] nums;

	private PrintStream console;  // 输出流（字符设备）
	private ByteArrayOutputStream byteArrayOutputStream;  // 用于缓存console重定向过来的字符流

	@org.junit.Before
	public void setUp() {
		byteArrayOutputStream = new ByteArrayOutputStream();  // 分配空间
		console = System.out;  // 获取System.out输出流的句柄
		System.setOut(new PrintStream(byteArrayOutputStream));  // 将原本输出到控制台console的字符流重定向到byteArrayOutputStream

	}

	@org.junit.After
	public void tearDown() {
		maxHeap = null;
		System.setOut(console);  // 将标准输出重定向回控制台console
	}

	@org.junit.Test
	public void test1() {
		nums = new Integer[]{23,98,1232, 5, 45, 43, 6, 3, 56, 452, 7, 658, 45, 32, 7, 1, 2, 79};
		maxHeap = new MaxHeap<>(nums);
		maxHeap.preOrderTraverse();
		assertEquals("1232 452 79 3 1 2 56 5 98 45 7 658 45 43 23 32 6 7 ",byteArrayOutputStream.toString());  //
		// 将byteArrayOutputStream中的内容转换为字符流
	}

	@org.junit.Test
	public void test2() {
		nums = new Integer[]{2132, 354, 6, 45, 7, 568, 8, 4, 3, 5, 2, 431, 3, 243, 46, 464};
		maxHeap = new MaxHeap<>(nums);
		maxHeap.preOrderTraverse();
		assertEquals("2132 464 354 45 4 3 7 5 2 568 431 6 3 243 8 46 ",byteArrayOutputStream.toString());

	}

	@org.junit.Test
	public void test3() {
		nums = new Integer[]{456246, 34, 5, 13, 6, 53454523,346, 345, 7, 56, 856, 324, 563, 3};
		maxHeap = new MaxHeap<>(nums);
		maxHeap.preOrderTraverse();
		assertEquals("53454523 856 345 13 7 56 34 6 456246 563 324 5 346 3 ",byteArrayOutputStream.toString());
	}

	@org.junit.Test
	public void test4() {
		nums = new Integer[]{234, 53, 26, 5, 67, 7, 69, 7896, 5463, 434, 5, 24, 9};
		maxHeap = new MaxHeap<>(nums);
		maxHeap.preOrderTraverse();
		assertEquals("7896 5463 234 5 53 434 67 5 69 24 7 9 26 ",byteArrayOutputStream.toString());
	}

	@org.junit.Test
	public void test5() {
		nums = new Integer[]{2352, 43, 4, 645, 63, 5, 34, 656, 3, 35, 31, 33453, 89, 26, 5, 7, 546, 7, 56};
		maxHeap = new MaxHeap<>(nums);
		maxHeap.preOrderTraverse();
		assertEquals("33453 656 645 546 7 43 56 7 3 63 35 31 2352 89 5 4 34 26 5 ",byteArrayOutputStream.toString());
	}

}