package project;

/*
 * 프로그램 : 자판기 프로그램
 * 작성자 : 20164006 박훈
 * 클래스 : AdminItem
 * 기능 : 아이템 관리 기능
 */

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class AdminItem extends JFrame {
	
	public AdminItem() {
		setTitle("아이템 관리 페이지");//프레임 타이틀
		setSize(500, 400);//프레임 사이즈
		setDefaultCloseOperation(AdminPassword.DISPOSE_ON_CLOSE);//창를 닫으면 이 창만 종료하도록 설정
		
		JPanel panel = new JPanel();//패널 생성
		JLabel label1 = new JLabel("아이템 관리");//라벨 생성
		JLabel label2 = new JLabel("테이블 수정후 저장 버튼을 눌러주세요.");//라벨 생성
		JButton btn = new JButton("저장");//수금 버튼 생성
		
		String header[] = {"Name", "price", "count"};//표 헤더
		String contents[][] = {//표 데이터
				{Data.itemlist.get(0).getItemName(),Integer.toString(Data.itemlist.get(0).getItemPrice()),Integer.toString(Data.itemlist.get(0).getItemCount())},//데이터를 가져옴
				{Data.itemlist.get(1).getItemName(),Integer.toString(Data.itemlist.get(1).getItemPrice()),Integer.toString(Data.itemlist.get(1).getItemCount())},//데이터를 가져옴
				{Data.itemlist.get(2).getItemName(),Integer.toString(Data.itemlist.get(2).getItemPrice()),Integer.toString(Data.itemlist.get(2).getItemCount())},//데이터를 가져옴
				{Data.itemlist.get(3).getItemName(),Integer.toString(Data.itemlist.get(3).getItemPrice()),Integer.toString(Data.itemlist.get(3).getItemCount())},//데이터를 가져옴
				{Data.itemlist.get(4).getItemName(),Integer.toString(Data.itemlist.get(4).getItemPrice()),Integer.toString(Data.itemlist.get(4).getItemCount())}//데이터를 가져옴
		};
		
		JTable table = new JTable(contents, header);//내용을 저장할 테이블 생성
		JScrollPane scrollpane = new JScrollPane(table);//테이블을 스크롤에 저장
		
		panel.setLayout(null); // 임의의 레이아웃을 설정
		
		//화면 구성 요소 설정
		label1.setLocation(50, 70);label1.setSize(200, 25);//라벨 위치와 사이즈 설정
		label2.setLocation(50, 100);label2.setSize(300, 25);//라벨 위치와 사이즈 설정
		scrollpane.setLocation(50, 150);scrollpane.setSize(400, 120);//스크롤 위치와 사이즈 설정
		btn.setLocation(350, 100);btn.setSize(100, 25);//저장 버튼 위치와 사이즈 설정
		
		//패널에 요소 추가
		panel.add(label1);//라벨 추가
		panel.add(label2);//라벨 추가
		panel.add(scrollpane);//스크롤 추가
		panel.add(btn);//저장 버튼 추가
		add(panel);//패널 추가
		
		setVisible(true);//프레임 출력
		
		//저장 버튼 클릭
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				for(int i=0;i<5;i++)
				{
					String name = (String) table.getValueAt(i, 0);//테이블에서 아이템 이름을 변수에 저장
					int price = Integer.valueOf((String) table.getValueAt(i, 1));//테이블에서 아이템 가격을 변수에 저장
					int count = Integer.valueOf((String) table.getValueAt(i, 2));//테이블에서 아이템 개수를 변수에 저장
					Data.itemlist.get(i).setItemName(name);//아이템 이름 데이터 설정
					Data.itemlist.get(i).setItemPrice(price);//아이템 가격 데이터 설정
					Data.itemlist.get(i).setItemCount(count);//아이템 개수 데이터 설정
				}
				JOptionPane.showMessageDialog(null, "저장되었습니다.", "저장 완료", JOptionPane.INFORMATION_MESSAGE);//저장 성공 메시지 출력
				
			}
		});
	}
	
}
