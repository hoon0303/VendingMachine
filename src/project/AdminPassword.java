package project;

/*
 * ���α׷� : ���Ǳ� ���α׷�
 * �ۼ��� : 20164006 ����
 * Ŭ���� : AdminPassword
 * ��� : ��й�ȣ Ȯ�� ���
 */

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class AdminPassword extends JFrame {

	private String TempPassword;//�Է¹��� ��й�ȣ �ӽ� ����
	
	public AdminPassword() {
		setTitle("������ �α���");//������ Ÿ��Ʋ
		setSize(500, 400);//������ ������
		setDefaultCloseOperation(AdminPassword.DISPOSE_ON_CLOSE);//�ش� â�� ���� ����
		
		JPanel panel = new JPanel();//�г�
		JTextField TxtPassword = new JTextField(10);//��й�ȣ �ؽ�Ʈ �ʵ�
		JLabel label1 = new JLabel("������ �α��� ������");//��
		JLabel label2 = new JLabel("�ʱ��й�ȣ�� 12345678! �Դϴ�.");//�ʱ� ��й�ȣ �ȳ� ��
		JButton Blogin = new JButton("�α���");//�α��� ��ư
		JLabel label3 = new JLabel("Password : ");//��й�ȣ ��
		
		panel.setLayout(null); // ������ ���̾ƿ��� ����
		
		//��й�ȣ üũ �����ӿ��� ������ ��ư�� ��ġ�� ũ�⸦ ��������
		label1.setLocation(50, 70);label1.setSize(400, 25);//�� ������ ��ġ
		label2.setLocation(50, 120);label2.setSize(400, 25);//�� ������ ��ġ
		label3.setLocation(50, 150);label3.setSize(200, 25);//�� ������ ��ġ
		TxtPassword.setLocation(120, 150);TxtPassword.setSize(100, 25);//�ؽ�Ʈ �ʵ� ������ ��ġ
		Blogin.setLocation(230, 150);Blogin.setSize(80, 25);//�α��� ��ư ������ ��ġ
		
		//�гο� ��ư�� �ؽ�Ʈ �ʵ� ���� �߰�
		panel.add(label1);//�� �߰�
		panel.add(label2);//�� �߰�
		panel.add(label3);//�� �߰�
		panel.add(TxtPassword);//��й�ȣ �ؽ�Ʈ �ʵ� �߰�
		panel.add(Blogin);//�α��� ��ư �߰�
		add(panel);//�г� �߰�
		
		setVisible(true);//������ ���
		
		//�α��� ��ư �̺�Ʈ
		Blogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TempPassword = TxtPassword.getText();//�Է��� ��й�ȣ ����
				if(TempPassword.equals(Data.getPassword())){ // ��й�ȣ�� ��ġ�� ���
					setVisible(false);//���� â�� ����
					new AdminMenu();//������ �޴� ȭ�� �̵�
				}
				else//��ġ���� ������ ���� ������ ����Ѵ�.
					JOptionPane.showMessageDialog(null, "��й�ȣ�� Ʋ�Ƚ��ϴ�.", "�α��� ����", JOptionPane.ERROR_MESSAGE);//��й�ȣ ���� �޽���
			}
		});
	}
	
}
