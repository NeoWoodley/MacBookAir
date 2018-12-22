package Graphics;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

public class MainTest {
	String data = "11,18\n" +
			"18,3\n" +
			"3,44\n" +
			"18,44\n" +
			"44,11\n" +
			"44,5\n" +
			"5,46\n" +
			"46,11\n" +
			"5,27\n" +
			"27,8\n";
	InputStream stdin = System.in;

	@Before
	public void setUp() {
		try {
			System.setIn(new ByteArrayInputStream(data.getBytes()));
			Scanner scanner = new Scanner(System.in);
			System.out.println(scanner.nextLine());
		} finally {
			System.setIn(stdin);
		}
	}

	@Test
	public void test() {
		Scanner scanner = new Scanner(System.in);
		Main main = new Main();
		String string;
		while ((scanner.hasNext())) {
			string = scanner.nextLine();
//			if (string.equals("#"))
//				break;
			main.addEdge(string);
		}
		main.findCycle(0);
		main.printCycles();
		scanner.close();
	}


}