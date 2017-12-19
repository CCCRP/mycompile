package com.crp.stu.compiler2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Start {
	public static void main(String[] args) throws IOException {
		String ss = null;
		boolean flag = true;
		System.out.println("输入exit结束");
		do {
			System.out.println("请输入:");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			try {
				ss = br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(ss.equals("exit")) {
				break;
			}
			Parser p = new Parser(ss);
			p.E();
			
		}while (flag);

	}
}
