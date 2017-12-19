package com.crp.stu.compiler1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Lexical {
	private static String[] keyword = { "boolean", "byte", "char", "double", "false", "float", "int", "long", "new",
			"null", "short", "true", "void", "instanceof", "break", "case", "catch", "continue", "default", "do",
			"else", "for", "if", "return", "switch", "try", "while", "finally", "throw", "this", "super", "abstract",
			"final", "namtive", "private", "protected", "public", "static", "synchronized", "transient", "volatile",
			"class", "extends", "implements", "interface", "package", "import", "throws" };

	public static boolean isLetter(char c) {
		if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
			return true;
		} else
			return false;
	}

	/*
	 * 判断读入的字符是否为数字
	 */
	public static boolean isDigit(char c) {
		if (c >= '0' && c <= '9') {
			return true;
		} else
			return false;
	}

	/*
	 * 判断是否为关键字
	 */
	public static boolean isKey(String ss) {
		int flag = 0;
		for (int i = 0; i < keyword.length; i++) {
			if (ss.equals(keyword[i])) {
				flag = 1;
				break;
			}
		}
		if (flag == 1) {
			return true;
		}
		return false;
	}

	/*
	 * 判断是否为运算符
	 */
	public static boolean isSpilt(char ch) {
		if (ch == '+' || ch == '-' || ch == '|' || ch == '=' || ch == '&' || ch == '>' || ch == '<') {
			return true;
		} else
			return false;
	}

	public static boolean isSpe(char ch) {
		if (ch == ' ' || ch == ';' || ch == '(' || ch == ')' || ch == '{' || ch == '}') {
			return true;
		} else
			return false;
	}

	public void jugment(String ss) {
		String str = ""; // 为什么用null会出现这样的问题
		int m = 0;
		for (int i = 0; i < ss.length(); i++) {
			char ch = ss.charAt(i);
			// 查看是否超前搜索
			switch (m) {
			case 0:
				if (isSpilt(ch) || isSpe(ch)) {
					// 判断是否为关键词
					if (isKey(str)) {
						System.out.println("关键词:" + str);
					} else {
						if (str != "")
							System.out.println("标识符:" + str);
					}
					str = "";
					str += ch;
					// 是否为运算符
					if (isSpilt(ch)) {
						if (isSpilt(ss.charAt(i + 1))) {
							str += ch;
							i++;
							System.out.println("运算符:" + str);
						} else {
							System.out.println("运算符:" + str);

						}
						str = "";
						continue;
					}
					if (ch != ' ')
						System.out.println("分隔符:" + ch);
					str = "";
				}

				else if (isLetter(ch)) {
					str += ch;
					m = 1;
				} else if (isDigit(ch)) {
					str += ch;
					m = 2;
				}
				break;

			// 第一个字符出现字母的情况
			case 1:
				// 标识符为数字字母和下划线都可以
				if (isLetter(ch) || isDigit(ch) || ch == '_') {
					str += ch;
				} else {
					m = 0;
					i--;
				}
				break;
			// 第一个字符出现数字的情况
			case 2:
				if (isDigit(ch) || ch == '.') {
					str += ch;
				} else {
					m = 0;
					i--;
				}
				break;
			}

		}
	}
}
