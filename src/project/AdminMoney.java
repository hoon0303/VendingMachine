package project;

/*
 * ���α׷� : ���Ǳ� ���α׷�
 * �ۼ��� : 20164006 ����
 * Ŭ���� : AdminMoney
 * ��� : ���� ���� ���
 */

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class AdminMoney extends JFrame {
	
	public AdminMoney() {
		setTitle("���� ������");//������ Ÿ��Ʋ ����
		setSize(500, 400);//������ ������ ����
		setDefaultCloseOperation(AdminPassword.DISPOSE_ON_CLOSE);
		
		JPanel panel = new JPanel();//�г� ����
		JLabel label1 = new JLabel("���� ������");//�� ����
		JLabel label2 = new JLabel("���� �ݾ� : 0");//�� ����
		JButton btn = new JButton("����");//���� ��ư ����
		
		String header[] = {"money", "count"};//���̺� ��� ����
		String contents[][] = {
				{"10",Integer.toString(Data.moneylist.get(0).getMoneyCount())},//���̺� ������ ����
				{"50",Integer.toString(Data.moneylist.get(1).getMoneyCount())},//���̺� ������ ����
				{"100",Integer.toString(Data.moneylist.get(2).getMoneyCount())},//���̺� ������ ����
				{"500",Integer.toString(Data.moneylist.get(3).getMoneyCount())},//���̺� ������ ����
				{"1000",Integer.toString(Data.moneylist.get(4).getMoneyCount())}//���̺� ������ ����
		};
		
		JTable table = new JTable(contents, header);//���̺� ����
		JScrollPane scrollpane = new JScrollPane(table);//��ũ�ѿ� ���̺� ����
		
		panel.setLayout(null);//������ ���̾ƿ��� ����
		
		label1.setLocation(50, 70);label1.setSize(400, 25);//�� ��ġ�� ������ ����
		label2.setLocation(300, 200);label2.setSize(100, 25);//�� ��ġ�� ������ ����
		scrollpane.setLocation(50, 150);scrollpane.setSize(200, 120);//��ũ�� ��ġ�� ������ ����
		btn.setLocation(300, 150);btn.setSize(100, 25);//���� ��ư ��ġ�� ������ ����
		
		//�гο� ��� �߰�
		panel.add(label1);//�� �߰�
		panel.add(label2);//�� �߰�
		panel.add(scrollpane);//��ũ�� �߰�
		panel.add(btn);//���� ��ư �߰�
		add(panel);//�г� �߰�
		
		setVisible(true);//������ ���
		
		//���� ��ư Ŭ��
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int total = 0;//���� �ݾ� ���� ����
				for(int i=0;i<5;i++)
				{
					if(Data.moneylist.get(i).getMoneyCount() > 5)//�ּ��� ���� ��������� �ּ��� ������ ���� ���
					{
						int x = Integer.parseInt(Data.moneylist.get(i).getMoneyName());//�ش� ���� �ݾ��� ����
						total = total + ((Data.moneylist.get(i).getMoneyCount() - 5) * x);//������ ���� ����
						Data.moneylist.get(i).setMoneyCount(5);//������ ���� ���� ����
						
						table.setValueAt(Integer.toString(Data.moneylist.get(i).getMoneyCount()), i, 1);//����� ���̺� ������ ����
					}
				}
				label2.setText("���� �ݾ� : "+Integer.toString(total));//���� �ݾ� ���
				
			}
		});
	}
	
}
