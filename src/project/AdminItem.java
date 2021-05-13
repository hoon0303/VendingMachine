package project;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class AdminItem extends JFrame {
	
	public AdminItem() {
		setTitle("아이템 관리 페이지");//프레임 타이틀
		setSize(500, 400);//프레임 사이즈
		setDefaultCloseOperation(AdminPassword.DISPOSE_ON_CLOSE);
		
		JPanel panel = new JPanel();//패널
		JLabel label1 = new JLabel("아이템 관리");
		JLabel label2 = new JLabel("테이블 수정후 저장 버튼을 눌러주세요.");
		JButton btn = new JButton("저장");//수금 버튼
		
		String header[] = {"Name", "price", "count"};//표 헤더
		String contents[][] = {//표 데이터
				{Data.itemlist.get(0).getItemName(),Integer.toString(Data.itemlist.get(0).getItemPrice()),Integer.toString(Data.itemlist.get(0).getItemCount())},
				{Data.itemlist.get(1).getItemName(),Integer.toString(Data.itemlist.get(1).getItemPrice()),Integer.toString(Data.itemlist.get(1).getItemCount())},
				{Data.itemlist.get(2).getItemName(),Integer.toString(Data.itemlist.get(2).getItemPrice()),Integer.toString(Data.itemlist.get(2).getItemCount())},
				{Data.itemlist.get(3).getItemName(),Integer.toString(Data.itemlist.get(3).getItemPrice()),Integer.toString(Data.itemlist.get(3).getItemCount())},
				{Data.itemlist.get(4).getItemName(),Integer.toString(Data.itemlist.get(4).getItemPrice()),Integer.toString(Data.itemlist.get(4).getItemCount())}
		};
		
		JTable table = new JTable(contents, header);//내용을 저장할 표 생성
		JScrollPane scrollpane = new JScrollPane(table);//표를 스크롤에 저장
		
		panel.setLayout(null); // 임의의 레이아웃을 설정
		
		//화면 구성 요소 설정
		label1.setLocation(50, 70);label1.setSize(200, 25);
		label2.setLocation(50, 100);label2.setSize(300, 25);
		scrollpane.setLocation(50, 150);scrollpane.setSize(400, 120);
		btn.setLocation(350, 100);btn.setSize(100, 25);
		
		//패널에 요소 추가
		panel.add(label1);
		panel.add(label2);
		panel.add(scrollpane);
		panel.add(btn);
		add(panel);
		
		setVisible(true);//프레임 출력
		
		//저장 버튼 클릭
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				for(int i=0;i<5;i++)
				{
					String name = (String) table.getValueAt(i, 0);
					int price = Integer.valueOf((String) table.getValueAt(i, 1));
					int count = Integer.valueOf((String) table.getValueAt(i, 2));
					Data.itemlist.get(i).setItemName(name);
					Data.itemlist.get(i).setItemPrice(price);
					Data.itemlist.get(i).setItemCount(count);
				}
				JOptionPane.showMessageDialog(null, "저장되었습니다.", "저장 완료", JOptionPane.INFORMATION_MESSAGE);
				
			}
		});
	}
	
}
