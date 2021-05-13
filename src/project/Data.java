package project;

import java.util.ArrayList;

public class Data {

	private static String password = "12345678!";// 초기 비밀번호를 설정
	public static ArrayList<item> itemlist;
	public static ArrayList<money> moneylist;
	
	public static String getPassword()//비밀번호 반환
	{
		return password;
	}
	public static void setPassword(String pw)//비밀번호 세팅
	{
		password = pw;
	}
	
}
