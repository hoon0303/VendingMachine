package project;

/*
 * 프로그램 : 자판기 프로그램
 * 작성자 : 20164006 박훈
 * 클래스 : AdminMoney
 * 기능 : 수금 관리 기능
 */

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class AdminMoney extends JFrame {
	
	public AdminMoney() {
		setTitle("수금 페이지");//프레임 타이틀 설정
		setSize(500, 400);//프레임 사이즈 설정
		setDefaultCloseOperation(AdminPassword.DISPOSE_ON_CLOSE);
		
		JPanel panel = new JPanel();//패널 생성
		JLabel label1 = new JLabel("수금 페이지");//라벨 생성
		JLabel label2 = new JLabel("수금 금액 : 0");//라벨 생성
		JButton btn = new JButton("수금");//수금 버튼 생성
		
		String header[] = {"money", "count"};//테이블 헤더 설정
		String contents[][] = {
				{"10",Integer.toString(Data.moneylist.get(0).getMoneyCount())},//테이블 데이터 설정
				{"50",Integer.toString(Data.moneylist.get(1).getMoneyCount())},//테이블 데이터 설정
				{"100",Integer.toString(Data.moneylist.get(2).getMoneyCount())},//테이블 데이터 설정
				{"500",Integer.toString(Data.moneylist.get(3).getMoneyCount())},//테이블 데이터 설정
				{"1000",Integer.toString(Data.moneylist.get(4).getMoneyCount())}//테이블 데이터 설정
		};
		
		JTable table = new JTable(contents, header);//테이블 생성
		JScrollPane scrollpane = new JScrollPane(table);//스크롤에 테이블 저장
		
		panel.setLayout(null);//임의의 레이아웃을 설정
		
		label1.setLocation(50, 70);label1.setSize(400, 25);//라벨 위치와 사이즈 설정
		label2.setLocation(300, 200);label2.setSize(100, 25);//라벨 위치와 사이즈 설정
		scrollpane.setLocation(50, 150);scrollpane.setSize(200, 120);//스크롤 위치와 사이즈 설정
		btn.setLocation(300, 150);btn.setSize(100, 25);//수금 버튼 위치와 사이즈 설정
		
		//패널에 요소 추가
		panel.add(label1);//라벨 추가
		panel.add(label2);//라벨 추가
		panel.add(scrollpane);//스크롤 추가
		panel.add(btn);//수금 버튼 추가
		add(panel);//패널 추가
		
		setVisible(true);//프레임 출력
		
		//수금 버튼 클릭
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int total = 0;//수금 금액 누적 변수
				for(int i=0;i<5;i++)
				{
					if(Data.moneylist.get(i).getMoneyCount() > 5)//최소의 돈을 남기기위해 최소의 돈보다 많은 경우
					{
						int x = Integer.parseInt(Data.moneylist.get(i).getMoneyName());//해당 돈의 금액을 저장
						total = total + ((Data.moneylist.get(i).getMoneyCount() - 5) * x);//수금한 돈을 누적
						Data.moneylist.get(i).setMoneyCount(5);//수금후 남은 돈의 개수
						
						table.setValueAt(Integer.toString(Data.moneylist.get(i).getMoneyCount()), i, 1);//변경된 테이블 데이터 설정
					}
				}
				label2.setText("수금 금액 : "+Integer.toString(total));//수금 금액 출력
				
			}
		});
	}
	
}
