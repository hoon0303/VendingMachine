package project;

/*
 * ���α׷� : ���Ǳ� ���α׷�
 * �ۼ��� : 20164006 ����
 * Ŭ���� : AdminPasswordChange
 * ��� : ��й�ȣ ���� ���
 */

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class AdminPasswordChange extends JFrame{
	
	private JPanel Panel = new JPanel();//�г� ����
	private JLabel label = new JLabel("��й�ȣ ����");//�� ����
	private JLabel label1 = new JLabel("���� ��й�ȣ : ");//�� ����
	private JLabel label2 = new JLabel("��й�ȣ�� Ư������ �� ���ڰ� �ϳ� �̻� ���Ե� 8�ڸ� �̻����� �����ؾ� �մϴ�.");//�� ����
	private JLabel label3 = new JLabel("���� ��й�ȣ �Է� : ");//�� ����
	private JTextField txt1 = new JTextField(10);//���� ��й�ȣ �ؽ�Ʈ �ʵ�
	private JTextField txt2 = new JTextField(10);//���ο� ��й�ȣ �ؽ�Ʈ �ʵ�
	private JButton Bcheck = new JButton("Ȯ��");//��й�ȣ Ȯ�� ��ư
	private JButton Bchange = new JButton("�����ϱ�");//��й�ȣ ���� ��ư
	
	String passwordTemp;//����ڰ� �Է��� ��й�ȣ�� ���� �ӽ� ����
	
	public AdminPasswordChange() {
		setTitle("��й�ȣ ����");//������ Ÿ��Ʋ ����
		setSize(600, 400);//������ ������ ����
		setDefaultCloseOperation(AdminPasswordChange.DISPOSE_ON_CLOSE);//â�� ������ �� â�� �����ϵ��� ����
		
		// ������ ����
		Panel.setLayout(null);
		label.setLocation(50, 50);label.setSize(300, 25);//�� ��ġ�� ������ ����
		label2.setLocation(50, 100);label2.setSize(500, 25);//�� ��ġ�� ������ ����
		label1.setLocation(50, 150);label1.setSize(150, 25);//�� ��ġ�� ������ ����
		txt1.setLocation(200, 150);txt1.setSize(150, 25);//�ؽ�Ʈ �ʵ� ��ġ�� ������ ����
		Bcheck.setLocation(400, 150);Bcheck.setSize(100, 25);//��й�ȣ Ȯ�� ��ư ��ġ�� ������ ����
		label3.setLocation(50, 200);label3.setSize(150, 25);//�� ��ġ�� ������ ����
		txt2.setLocation(200, 200);txt2.setSize(150, 25);//�ؽ�Ʈ �ʵ� ��ġ�� ������ ����
		Bchange.setLocation(400, 200);Bchange.setSize(100, 25);//��й�ȣ ���� ��ư ��ġ�� ������ ����
		Bchange.setEnabled(false);
		
		// �гο� ��� �߰�
		Panel.add(label);//�� �߰�
		Panel.add(label1);//�� �߰�
		Panel.add(label2);//�� �߰�
		Panel.add(label3);//�� �߰�
		Panel.add(txt1);//�ؽ�Ʈ �ʵ� �߰�
		Panel.add(Bcheck);//Ȯ�� ��ư �߰�
		Panel.add(txt2);//�ؽ�Ʈ �ʵ� �߰�
		Panel.add(Bchange);//��й�ȣ ���� ��ư �߰�
		add(Panel);//�г� �߰�
	
		//�Է� ��ư �̺�Ʈ
		Bcheck.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				passwordTemp = txt1.getText();//����ڰ� �Է��� ��й�ȣ ����
				if(passwordTemp.equals(Data.getPassword()))//���� ��й�ȣ Ȯ��
				{
					Bchange.setEnabled(true);//���� ��ư Ȱ��ȭ
				}
				else//���� ��й�ȭ�� �ٸ� ���
					JOptionPane.showMessageDialog(null, "��й�ȣ�� Ʋ�Ƚ��ϴ�. �ٽ� �Է����ּ���.", "Ȯ�� ����", JOptionPane.ERROR_MESSAGE);//��й�ȣ ���� �޽���
			}
		});
		
		// ���� ��ư �̺�Ʈ
		Bchange.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				passwordTemp = txt2.getText();//����ڰ� �Է��� ���ο� ��й�ȣ ����
				if(passwordTemp.length() >= 8 && passwordTemp.matches(".*[0-9].*") && !passwordTemp.matches("[0-9|a-z|A-Z|��-��|��-��|��-��]*"))//���� Ȯ��
				{
					Data.setPassword(txt2.getText());//��й�ȣ ����
					JOptionPane.showMessageDialog(null, "��й�ȣ�� ���� �Ϸ�.", "���� ����", JOptionPane.INFORMATION_MESSAGE);//���� ���� �޽���
					setVisible(false);//ȭ�� �ݱ�
				}
				else//������ Ʋ�� ���
				{
					JOptionPane.showMessageDialog(null, "��й�ȣ�� Ư������ �� ���ڰ� �ϳ� �̻� ���Ե� 8�ڸ� �̻����� �����ؾ� �մϴ�.", "���� ����", JOptionPane.ERROR_MESSAGE);//���� �޽��� ���
				}
			}
		});
		setVisible(true);// ������ ���
	}
}