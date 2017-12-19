package com.crp.stu.compiler1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Start {
	public static void main(String[] args) {
		Lexical l = new Lexical();
		String ss = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("以分号结束");
		do {
		System.out.print("请输入：");
		try {
			ss = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		l.jugment(ss);
	}while(!ss.equals("exit"));
	}
}
