package project;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class AdminMoney extends JFrame {
	
	public AdminMoney() {
		setTitle("수금 페이지");//프레임 타이틀
		setSize(500, 400);//프레임 사이즈
		setDefaultCloseOperation(AdminPassword.DISPOSE_ON_CLOSE);
		
		JPanel panel = new JPanel();//패널
		JLabel label1 = new JLabel("수금 페이지");
		JLabel label2 = new JLabel("수금 금액 : 0");
		JButton btn = new JButton("수금");//수금 버튼
		
		String header[] = {"money", "count"};
		String contents[][] = {
				{"10",Integer.toString(Data.moneylist.get(0).getMoneyCount())},
				{"50",Integer.toString(Data.moneylist.get(1).getMoneyCount())},
				{"100",Integer.toString(Data.moneylist.get(2).getMoneyCount())},
				{"500",Integer.toString(Data.moneylist.get(3).getMoneyCount())},
				{"1000",Integer.toString(Data.moneylist.get(4).getMoneyCount())}
		};
		
		JTable table = new JTable(contents, header);
		JScrollPane scrollpane = new JScrollPane(table);
		
		
		panel.setLayout(null); // 임의의 레이아웃을 설정
		
		
		label1.setLocation(50, 70);label1.setSize(400, 25);
		label2.setLocation(300, 200);label2.setSize(100, 25);
		scrollpane.setLocation(50, 150);scrollpane.setSize(200, 120);
		btn.setLocation(300, 150);btn.setSize(100, 25);
		
		//패널에 요소 추가
		panel.add(label1);
		panel.add(label2);
		panel.add(scrollpane);
		panel.add(btn);
		add(panel);
		
		setVisible(true);//프레임 출력
		
		//수금 버튼 클릭
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int total = 0;
				for(int i=0;i<5;i++)
				{
					if(Data.moneylist.get(i).getMoneyCount() > 5)
					{
						int x = Integer.parseInt(Data.moneylist.get(i).getMoneyName());
						total = total + ((Data.moneylist.get(i).getMoneyCount() - 5) * x);
						Data.moneylist.get(i).setMoneyCount(5);
						
						table.setValueAt(Integer.toString(Data.moneylist.get(i).getMoneyCount()), i, 1);
					}
				}
				label2.setText("수금 금액 : "+Integer.toString(total));
				
			}
		});
	}
	
}
