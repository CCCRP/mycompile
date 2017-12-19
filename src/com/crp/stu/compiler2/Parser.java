package com.crp.stu.compiler2;

/*
 * E->TE'
 * E'->+TE'|$
 * E'->-TE'|$
 * T->FT'
 * T'->*FT'|$
 * T'->/FT'|$
 * F->(E)|i
 */
public class Parser {
	char evChar; // 当前ch
	String evString = null; // 输入的字符串
	int evId = 0; // 当前ch的下标
	int flag = 0; // flag代表出了什么样的错

	public Parser(String str) {
		// TODO Auto-generated constructor stub
		this.evString = str;
		evChar = evString.charAt(0);
		evString += ';';
	}

	/*
	 * 匹配分析
	 */
	public void match(char ch) {
		if (evId < (evString.length() - 1)) {
			evId++;
			evChar = evString.charAt(evId);
		}
	}

	public void F() {
		if (evChar == 'i') {
			match('i');
		} else if (evChar == '(') {
			match('(');
			E();
			if (evChar == ')') {
				match(')');
			} else {
				// 左右括号不匹配
				flag = 2;

			}
		} else {
			// 语法错误
			flag = 1;
		}
	}

	public void E() {
		// TODO Auto-generated method stub
		T();
		E_();
		jugment();

	}

	public void T() {
		// TODO Auto-generated method stub
		F();
		T_();
	}

	// 对乘除进行判断
	public void T_() {
		// TODO Auto-generated method stub
		if (evChar == '*') {
			match('*');
			F();
			T_();
		} else if (evChar == '/') {
			match('/');
			F();
			T_();
		}
	}

	// 对加减进行判断
	public void E_() {
		// TODO Auto-generated method stub
		if (evChar == '+') {
			match('+');
			T();
			E_();
		} else if (evChar == '-') {
			match('-');
			T();
			E_();
		}
	}

	private void jugment() {
		if (evId == (evString.length() - 1)) {
			if (flag == 0) {
				System.out.println("正确");
			} else if (flag == 1) {
				System.out.println("语法错误");
			} else if (flag == 2) {
				System.out.println("左右括号不对齐");
			}
		}
	}

}
