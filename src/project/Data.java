package project;

import java.util.ArrayList;

public class Data {

	private static String password = "12345678!";// �ʱ� ��й�ȣ�� ����
	public static ArrayList<item> itemlist;
	public static ArrayList<money> moneylist;
	
	public static String getPassword()//��й�ȣ ��ȯ
	{
		return password;
	}
	public static void setPassword(String pw)//��й�ȣ ����
	{
		password = pw;
	}
	
}
