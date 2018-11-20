package Expression;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 中缀表达式——>后缀表达式；对后缀表达式求值，合为一趟
 * <p>
 * 思路
 * 1、读入字符
 * 2、如果读入的字符为操作符，则压栈，如果是操作数，则输出
 * 3、如果读入的操作符优先级比栈顶元素低，则弹出栈操作符直至遇到比读入的操作符优先级更低的操作符。左括号( 为特殊情况，读入时当作高优先级，弹出时为低优先级，直至读入一个) 右括号，然后弹出栈中第一个左括号及其之前的所有操作符
 * <p>
 * 1.遇到操作数，直接输出（放入操作数栈，在这里放入一个StringBuilder中）；
 * 2.栈为空时，遇到运算符，入栈；
 * 3.遇到左括号，将其入栈；
 * 4.遇到右括号，执行出栈操作，并将出栈的元素输出，直到弹出栈的是左括号，左括号不输出；
 * 5.遇到其他运算符’+”-”*”/’时，弹出所有优先级大于或等于该运算符的栈顶元素，然后将该运算符入栈；
 * 6.最终将栈中的元素依次出栈，输出。
 * 经过上面的步骤，得到的输出即是转换得到的后缀表达式。
 * 举例：a+b*c+(d*e+f)g ———> abc+de*f+g*+
 */
public class CenterToFront {
	private static LinkedList<String> operators = new LinkedList<>();  // 记录操作符号，利用链表来实现栈
//	private static LinkedList<String> output = new LinkedList<>();  // 记录输出
	private static StringBuilder stringBuilder = new StringBuilder();

	/**
	 * 将前缀表达式转为后缀表达式
	 *
	 * @param linkedList 存放着前缀表达式
	 */
	private static void transferToPostFix(LinkedList<String> linkedList) {
		Iterator<String> listIterator = linkedList.iterator();  // 放入读取的内容

		while (listIterator.hasNext()) {
			String string = listIterator.next();

			if (isOperator(string)) {
				if (operators.isEmpty()) {
					operators.push(string);
				} else {
					//如果读入的操作符为非")"且优先级比栈顶元素的优先级高或一样，则将操作符压入栈
					if (!string.equals(")") && priority(operators.peek()) < priority(string)) {
						operators.push(string);
					} else if (!string.equals(")") && priority(operators.peek()) >= priority(string)) {
						// 如果读入的操作符为非")"且优先级比栈顶元素低，则将弹出
						while (operators.size() != 0 && priority(operators.peek()) >= priority(string) && !operators.peek().equals("(")) {
							if (!operators.peek().equals("(")) {
								String operator = operators.pop();
								stringBuilder.append(operator).append(" ");
//								output.push(operator);
							}
						}
						operators.push(string);
					} else if (string.equals(")")) {
						//如果读入的操作符是")"，则弹出从栈顶开始第一个"("及其之前的所有操作符
						while (!operators.peek().equals("(")) {
							String operator = operators.pop();
							stringBuilder.append(operator).append(" ");
//							output.push(operator);
						}
						// 弹出"("
						operators.pop();
					}
				}
			} else {
				// 读入的为非操作符
				stringBuilder.append(string).append(" ");
//				output.push(string);
			}
		}

		if (!operators.isEmpty()) {
			Iterator<String> operatorIterator = operators.iterator();
			while (operatorIterator.hasNext()) {
				String operator = operatorIterator.next();
				stringBuilder.append(operator).append(" ");
//				output.push(operator);
				operatorIterator.remove();
			}
		}
		System.out.println("后缀：" + stringBuilder);
		calculate();
	}

	/**
	 * 根据后缀表达式计算结果
	 */
	private static void calculate() {
		LinkedList<String> linkedList = new LinkedList<>();
		String[] postString = stringBuilder.toString().split(" ");  // 将StringBuilder根据空格切分得到后缀表达式的数组

		for (String s : postString) {
			if (isOperator(s)) {
				if (!linkedList.isEmpty()) {
					double a = Double.valueOf(linkedList.pop());
					double b = Double.valueOf(linkedList.pop());
					if (s.equals("/") && a == 0) {
						System.out.println("除数不能为零");
						return;
					}

					double result = caltulate(b, a, s);
					linkedList.push(String.valueOf(result));
				}
			} else {
				// 数字则压入栈中
				linkedList.push(s);
			}
		}
		if (!linkedList.isEmpty()) {
			System.out.println("result: " + linkedList.pop());
		}
	}

	/**
	 * 判断是否是操作符
	 *
	 * @param operator
	 * @return
	 */
	private static boolean isOperator(String operator) {
		if (operator.equals("+") || operator.equals("-") || operator.equals("*") || operator.equals("/") || operator.equals("" +
				"(") || operator.equals(")")) {
			return true;
		}
		return false;
	}

	/**
	 * 计算操作符的优先级
	 *
	 * @param string
	 * @return
	 */
	private static int priority(String string) {
		switch (string) {
			case "+":
				return 1;
			case "-":
				return 1;
			case "*":
				return 2;
			case "/":
				return 2;
			case "(":
				return 3;
			case ")":
				return 3;
			default:
				return 0;
		}
	}

	/**
	 * 计算"单个"表达式的值
	 *
	 * @param a
	 * @param b
	 * @param operator 操作符
	 * @return
	 */
	private static double caltulate(double a, double b, String operator) {
		switch (operator) {
			case "+":
				return a + b;
			case "-":
				return a - b;
			case "*":
				return a * b;
			case "/":
				return a / b;
			default:
				return 0;
		}

	}

	/**
	 * 输入格式：每个字符之间都要加空格
	 * @param args
	 */
	public static void main(String[] args) {
		LinkedList<String> linkedList = new LinkedList<>();
		Scanner scanner = new Scanner(System.in);
		String s;
		// #号结束输入
		// #号结束输入
		// #号结束输入
		// #号结束输入
		// 输入的字符间要有"空格"
		// 输入的字符间要有“空格”
		// 输入的字符间要有”空格”
		// 输入的字符间要有“空格”
		// 输入的字符间要有”空格“
		// 输入的字符间要有”空格”
		// 输入的字符间要有”空格“
		// 输入的字符间要有”空格”
		// 输入的字符间要有”空格”
		// 输入的字符间要有”空格”
		// eg.  1 + 2 * 9 / 3

		while (!(s = scanner.next()).equals("#")) {
			linkedList.add(s);
		}

		try {
			transferToPostFix(linkedList);
		} catch (Exception e) {
			System.out.println("后缀表达式无法匹配");
		}

		scanner.close();
	}
}
