package project;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class AdminPassword extends JFrame {

	private String passwordTemp;//�Է¹��� ��й�ȣ �ӽ� ����
	
	public AdminPassword() {
		setTitle("������ �α���");//������ Ÿ��Ʋ
		setSize(500, 400);//������ ������
		setDefaultCloseOperation(AdminPassword.DISPOSE_ON_CLOSE);
		
		JPanel loginPanel = new JPanel();//�α��� ȭ���� ����� �г�
		JTextField passText = new JTextField(10);//��й�ȣ�� �Է� ���� �ؽ�Ʈ �ʵ�
		JLabel label1 = new JLabel("������ �α��� ������");//�ʱ� ��й�ȣ�� �����϶�� �ȳ� ��
		JLabel label2 = new JLabel("�ʱ��й�ȣ�� 12345678! �Դϴ�.");//�ʱ� ��й�ȣ�� �����϶�� �ȳ� ��
		JButton Blogin = new JButton("�α���");//�α��� ����� ������ ��ư
		JLabel writePassword = new JLabel("Password : ");//�Է� �ȳ� ��
		
		loginPanel.setLayout(null); // ������ ���̾ƿ��� ����
		
		//��й�ȣ üũ �����ӿ��� ������ ��ư�� ��ġ�� ũ�⸦ ��������
		label1.setLocation(50, 70);label1.setSize(400, 25);
		label2.setLocation(50, 120);label2.setSize(400, 25);
		writePassword.setLocation(50, 150);writePassword.setSize(200, 25);
		passText.setLocation(120, 150);passText.setSize(100, 25);
		Blogin.setLocation(230, 150);Blogin.setSize(80, 25);
		
		//�гο� ��ư�� �ؽ�Ʈ �ʵ� ���� �߰�
		loginPanel.add(label1);
		loginPanel.add(label2);
		loginPanel.add(writePassword);
		loginPanel.add(passText);
		loginPanel.add(Blogin);
		add(loginPanel);
		
		setVisible(true);//�������� ���̰� ���ش�.
		
		//�α��� ��ư�� �������� 
		Blogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				passwordTemp = passText.getText();//�Է��� ��й�ȣ ����
				if(passwordTemp.equals(Data.getPassword())){ // ��й�ȣ�� ��ġ�� ���
					setVisible(false);
					new AdminMenu();//������ �޴� ȭ�� �̵�
				}
				else//��ġ���� ������ ���� ������ ����Ѵ�.
					JOptionPane.showMessageDialog(null, "��й�ȣ�� Ʋ�Ƚ��ϴ�.", "�α��� ����", JOptionPane.ERROR_MESSAGE);
			}
		});
	}
	
}
