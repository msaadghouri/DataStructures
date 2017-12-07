package stackandqueue;

import java.util.Stack;

public class DelimitersCheck {

	public static void main(String[] args) {
		String s = "{([])}";
		System.out.println(isBalanced(s));
	}
	static boolean isBalanced(String s) {

		Stack<Character> stackC= new Stack<Character>();
		for(int i=0;i<s.length();i++){
			char c= s.charAt(i);
			switch (c) {
			case '[':
			case '(':
			case '{':
				stackC.push(c);
				break;

			case ')':
			case '}':
			case ']':
				if(!stackC.isEmpty()){
					char chx = stackC.pop();
					if ((c == '}' && chx != '{') || (c == ']' && chx != '[') || (c == ')' && chx != '('))
						return false;
				} else{
					return false;
				}
				break;

			default:
				break;
			}
		}
		if (!stackC.isEmpty()){
			return false;
		}

		return true;

	}

}
