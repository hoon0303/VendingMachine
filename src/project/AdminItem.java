package project;

/*
 * ���α׷� : ���Ǳ� ���α׷�
 * �ۼ��� : 20164006 ����
 * Ŭ���� : AdminItem
 * ��� : ������ ���� ���
 */

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class AdminItem extends JFrame {
	
	public AdminItem() {
		setTitle("������ ���� ������");//������ Ÿ��Ʋ
		setSize(500, 400);//������ ������
		setDefaultCloseOperation(AdminPassword.DISPOSE_ON_CLOSE);//â�� ������ �� â�� �����ϵ��� ����
		
		JPanel panel = new JPanel();//�г� ����
		JLabel label1 = new JLabel("������ ����");//�� ����
		JLabel label2 = new JLabel("���̺� ������ ���� ��ư�� �����ּ���.");//�� ����
		JButton btn = new JButton("����");//���� ��ư ����
		
		String header[] = {"Name", "price", "count"};//ǥ ���
		String contents[][] = {//ǥ ������
				{Data.itemlist.get(0).getItemName(),Integer.toString(Data.itemlist.get(0).getItemPrice()),Integer.toString(Data.itemlist.get(0).getItemCount())},//�����͸� ������
				{Data.itemlist.get(1).getItemName(),Integer.toString(Data.itemlist.get(1).getItemPrice()),Integer.toString(Data.itemlist.get(1).getItemCount())},//�����͸� ������
				{Data.itemlist.get(2).getItemName(),Integer.toString(Data.itemlist.get(2).getItemPrice()),Integer.toString(Data.itemlist.get(2).getItemCount())},//�����͸� ������
				{Data.itemlist.get(3).getItemName(),Integer.toString(Data.itemlist.get(3).getItemPrice()),Integer.toString(Data.itemlist.get(3).getItemCount())},//�����͸� ������
				{Data.itemlist.get(4).getItemName(),Integer.toString(Data.itemlist.get(4).getItemPrice()),Integer.toString(Data.itemlist.get(4).getItemCount())}//�����͸� ������
		};
		
		JTable table = new JTable(contents, header);//������ ������ ���̺� ����
		JScrollPane scrollpane = new JScrollPane(table);//���̺��� ��ũ�ѿ� ����
		
		panel.setLayout(null); // ������ ���̾ƿ��� ����
		
		//ȭ�� ���� ��� ����
		label1.setLocation(50, 70);label1.setSize(200, 25);//�� ��ġ�� ������ ����
		label2.setLocation(50, 100);label2.setSize(300, 25);//�� ��ġ�� ������ ����
		scrollpane.setLocation(50, 150);scrollpane.setSize(400, 120);//��ũ�� ��ġ�� ������ ����
		btn.setLocation(350, 100);btn.setSize(100, 25);//���� ��ư ��ġ�� ������ ����
		
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
				
				for(int i=0;i<5;i++)
				{
					String name = (String) table.getValueAt(i, 0);//���̺��� ������ �̸��� ������ ����
					int price = Integer.valueOf((String) table.getValueAt(i, 1));//���̺��� ������ ������ ������ ����
					int count = Integer.valueOf((String) table.getValueAt(i, 2));//���̺��� ������ ������ ������ ����
					Data.itemlist.get(i).setItemName(name);//������ �̸� ������ ����
					Data.itemlist.get(i).setItemPrice(price);//������ ���� ������ ����
					Data.itemlist.get(i).setItemCount(count);//������ ���� ������ ����
				}
				JOptionPane.showMessageDialog(null, "����Ǿ����ϴ�.", "���� �Ϸ�", JOptionPane.INFORMATION_MESSAGE);//���� ���� �޽��� ���
				
			}
		});
	}
	
}
