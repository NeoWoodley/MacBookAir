package Heap;

import org.junit.Test;

import static org.junit.Assert.*;

public class MaxHeapTest {
	private MaxHeap<Integer> maxHeap;
	private Integer[] nums;

	@org.junit.Before
	public void setUp() throws Exception {
		
	}

	@org.junit.After
	public void tearDown() throws Exception {
		maxHeap = null;
	}

	@org.junit.Test
	public void test1() {
		nums = new Integer[]{1232, 5, 45, 43, 6, 3, 56, 452, 7, 658, 45, 32, 7, 3, 2, 79};

	}

	@org.junit.Test
	public void test2() {
		nums = new Integer[]{2132, 354, 6, 45, 7, 568, 8, 4, 3, 5, 2, 431, 3, 243, 46, 464};

	}

	@org.junit.Test
	public void test3() {
		nums = new Integer[]{456246, 34, 5, 13, 6, 346, 345, 7, 56, 856, 324, 563, 3};

	}

	@org.junit.Test
	public void test4() {
		nums = new Integer[]{234, 53, 26, 5, 67, 7, 69, 7896, 5463, 434, 5, 24, 9};

	}

	@org.junit.Test
	public void test5() {
		nums = new Integer[]{2352, 43, 4, 645, 63, 5, 34, 656, 3, 35, 31, 353, 89, 26, 5, 7, 546, 7, 56};
	}

}