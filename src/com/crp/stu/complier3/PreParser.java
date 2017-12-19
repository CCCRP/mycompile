package com.crp.stu.complier3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*文法:
 * E->TE'
 * E'->+TE'
 * E'->$
 * T->FT'
 * T'->*FT'
 * T'->$
 * F->(E)
 * F->i
 */
public class PreParser {
	String ss = null;
	String stack = "E";
	int i = 0;
	static String[][] table = new String[200][200];
	boolean flag = false;
	
	public PreParser(String ss) {
		this.ss = ss;
	}

	public boolean isT(char ch) {
		if (ch == 'i' || ch == '+' || ch == '*' || ch == '(' || ch == ')' || ch == '$')
			return true;
		return false;
	}

	public boolean jugment() {
		/*
		 * 预测表
		 */
		table['E']['i'] = "eT";
		table['E']['('] = "eT";
		table['e']['+'] = "eT+";
		table['e'][')'] = "";
		table['e']['$'] = "";
		table['E']['$'] = "";
		table['T']['i'] = "tF";
		table['T']['('] = "tF";
		table['t']['+'] = "";
		table['t']['*'] = "tF*";
		table['t'][')'] = "";
		table['t']['$'] = "";
		table['F']['i'] = "i";
		table['F']['('] = ")E(";
		System.out.println("12312");
		int z = 0;
		while(!stack.equals("") && z < 20) {
			char c =stack.charAt(stack.length()-1);
			z++;
			if(!isT(c)) {
				stack = stack.substring(0, stack.length() - 1);
				stack += table[c][ss.charAt(i)];
				System.out.println(stack + "       " + ss.substring(i, ss.length()));
				if(table[c][ss.charAt(i)] == null)
					return flag;
			}else {
				if(c == ss.charAt(i)) {
					stack = stack.substring(0, stack.length() - 1);
					if(i <= (ss.length()-2))
						i ++;
				}else {
					return flag;
				}
			
			}
			
			
		}
		return true;
	}
}
