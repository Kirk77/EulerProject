package kr.kirk.euler;

import java.util.Stack;

public class Problem0 {

	public static void main(String[] args) {
		System.out.println("========================================================");
		System.out.println(Problem0.solution("([awef{awef<awef>awef}awef])"));
		System.out.println("========================================================");
		System.out.println(Problem0.solution("([awef{awef<awef>awef}awef])]"));
		System.out.println("========================================================");

	}

	private static boolean solution(String str) {
		Stack<String> s = new Stack<>();
		
		for ( int i=0; i<str.length(); ++i) {
			String c = String.valueOf(str.charAt(i));
			switch (c) {
			
			case "(":
			case "[":
			case "<":
			case "{":
				s.push(c);
				break;
				
			case ")":
				if (s.empty() ||  ! s.pop().equals("(")) return false;
				break;
			case "]":
				if (s.empty() || ! s.pop().equals("[")) return false;
				break;
			case ">":
				if (s.empty() || ! s.pop().equals("<")) return false;
				break;
			case "}":
				if (s.empty() || ! s.pop().equals("{")) return false;
				break;
			}
		}
		if (s.empty()) return true;
		return false;
	}
}
