import java.util.*;
public class stack {
	public static void main(String[] args) {
		Stack<Float> stack_test = new Stack();
		stack_test.push((float)11111);
		stack_test.push((float)22222);
		stack_test.push((float)33333);
		stack_test.push((float)55555);
		stack_test.pop();//丟掉55555
		System.out.print("stack:");
		System.out.print(stack_test.peek());//output: 33333.0
		//peek() 讀取top值(但不移除)
	}
}
