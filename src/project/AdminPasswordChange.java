package project;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class AdminPasswordChange extends JFrame{
	
	private JPanel Panel = new JPanel(); //ȭ�� �г� ����
	private JLabel label = new JLabel("��й�ȣ ����");
	private JLabel label1 = new JLabel("���� ��й�ȣ : ");
	private JLabel label2 = new JLabel("��й�ȣ�� Ư������ �� ���ڰ� �ϳ� �̻� ���Ե� 8�ڸ� �̻����� �����ؾ� �մϴ�.");
	private JLabel label3 = new JLabel("���� ��й�ȣ �Է� : ");//���� �� ��й�ȣ�� �Է� �ޱ� ���� �󺧰� �ؽ�Ʈ �ʵ�
	private JTextField txt1 = new JTextField(10);//���� ��й�ȣ �Է��ʵ�
	private JTextField txt2 = new JTextField(10);//���ο� ��й�ȣ �Է��ʵ�
	private JButton Bcheck = new JButton("Ȯ��");//��й�ȣ Ȯ�� ��ư
	private JButton Bchange = new JButton("�����ϱ�"); //��й�ȣ ���� ��ư
	
	String passwordTemp;//����ڰ� �Է��� ��й�ȣ�� ���� �ӽ� ����
	
	public AdminPasswordChange() {
		setTitle("��й�ȣ ����");//������ Ÿ��Ʋ �ޱ�
		setSize(600, 400);//������ ������ ����
		setDefaultCloseOperation(AdminPasswordChange.DISPOSE_ON_CLOSE);// ������ �����츦 ������ �� â�� �����ϵ��� ����
		
		// ������ ����
		Panel.setLayout(null);
		label.setLocation(50, 50);label.setSize(300, 25);
		label2.setLocation(50, 100);label2.setSize(500, 25);
		label1.setLocation(50, 150);label1.setSize(150, 25);
		txt1.setLocation(200, 150);txt1.setSize(150, 25);
		Bcheck.setLocation(400, 150);Bcheck.setSize(100, 25);
		label3.setLocation(50, 200);label3.setSize(150, 25);
		txt2.setLocation(200, 200);txt2.setSize(150, 25);
		Bchange.setLocation(400, 200);Bchange.setSize(100, 25);
		Bchange.setEnabled(false);
		
		// �гο� ��� �߰�
		Panel.add(label);
		Panel.add(label1);
		Panel.add(label2);
		Panel.add(label3);
		Panel.add(txt1);
		Panel.add(Bcheck);
		Panel.add(txt2);
		Panel.add(Bchange);
		add(Panel);//�г� add
	
		//�Է� ��ư �̺�Ʈ
		Bcheck.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				passwordTemp = txt1.getText(); // ����ڰ� �Է��� ��й�ȣ�� �ӽ� ������ �о�ͼ�
				if(passwordTemp.equals(Data.getPassword()))//���� ��й�ȣ Ȯ��
				{
					Bchange.setEnabled(true);// ���� ��ư�� Ȱ��ȭ
				}
				else//���� ��й�ȭ�� �ٸ� ���
					JOptionPane.showMessageDialog(null, "��й�ȣ�� Ʋ�Ƚ��ϴ�. �ٽ� �Է����ּ���.", "Ȯ�� ����", JOptionPane.ERROR_MESSAGE);
			}
		});
		
		// ���� ��ư �̺�Ʈ
		Bchange.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				passwordTemp = txt2.getText();//����ڰ� �Է��� ���ο� ��й�ȣ ����
				if(passwordTemp.length() >= 8 && passwordTemp.matches(".*[0-9].*") && !passwordTemp.matches("[0-9|a-z|A-Z|��-��|��-��|��-��]*")) 
				{
					Data.setPassword(txt2.getText());//���ǿ� ������ ��й�ȣ ����
					JOptionPane.showMessageDialog(null, "��й�ȣ�� ���� �Ϸ�.", "���� ����", JOptionPane.INFORMATION_MESSAGE);
					setVisible(false);//ȭ�� �ݱ�
				}
				else 
				{ // ������ Ʋ�� ���
					JOptionPane.showMessageDialog(null, "��й�ȣ�� Ư������ �� ���ڰ� �ϳ� �̻� ���Ե� 8�ڸ� �̻����� �����ؾ� �մϴ�.", "���� ����", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		setVisible(true);// ������ ���
	}
}