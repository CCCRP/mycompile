package com.crp.stu.complier3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Start {
	public static void main(String[] args) throws IOException {
		System.out.println("请以$符结束");
		System.out.println("输入exit结束");
		while(true) {
		String ss = null;
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("请输入:");
		ss = bf.readLine();
		if(ss.equals("exit")) {
			System.out.println("程序结束");
			break;
		}
		PreParser p = new PreParser(ss);
		if(p.jugment()) {
			System.out.println("正确");
		}else {
			System.out.println("错误");
		}
		}
	}
}
