package project;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class password extends JFrame {

	static String pw = "12345678!"; // �ʱ� ��й�ȣ�� ����
	String temp; // ��й�ȣ �Է� ����
	public password() {
		setTitle("������ �޴� �α���"); // ������ Ÿ��Ʋ �ޱ�
		setSize(600, 900); // ������ ������ ����
		setDefaultCloseOperation(password.DISPOSE_ON_CLOSE);// ������ �����츦 ������ �� â�� �����ϵ��� ����
		
		JPanel loginPanel = new JPanel(); // �α��� ȭ���� ����� �г�
		JTextField passText = new JTextField(10); // ��й�ȣ�� �Է� ���� �ؽ�Ʈ �ʵ�
		JLabel warning = new JLabel("�ʱ��й�ȣ�� 12345678! �Դϴ�."); // �ʱ� ��й�ȣ�� �����϶�� �ȳ� ��
		JButton login = new JButton("�α���"); // �α��� ����� ������ ��ư
		JLabel writePassword = new JLabel("��й�ȣ�� �Է����ּ��� : "); // �Է� �ȳ� ��
		
		loginPanel.setLayout(null); // ������ ���̾ƿ��� ����
		
		// ��й�ȣ üũ �����ӿ��� ������ ��ư�� ��ġ�� ũ�⸦ ��������
		warning.setLocation(50, 400);
		warning.setSize(400, 25);
		writePassword.setLocation(50, 425);
		writePassword.setSize(200, 25);
		passText.setLocation(200, 425);
		passText.setSize(100, 25);
		login.setLocation(350, 425);
		login.setSize(100, 25);
		
		// �гο� ��ư�� �ؽ�Ʈ �ʵ� ���� �߰�
		loginPanel.add(warning);
		loginPanel.add(writePassword);
		loginPanel.add(passText);
		loginPanel.add(login);
		add(loginPanel);
		
		setVisible(true); // �������� ���̰� ���ش�.
		
		// �α��� ��ư�� �������� 
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				temp = passText.getText(); // �Է��� ��й�ȣ�� �޾ƿͼ�
				if(temp.equals(pw)){ // ��й�ȣ�� ��ġ�ϸ�
					setVisible(false); // â�� �ݰ�
					//new AdminFrame(); // ������ �������� �����Ѵ�.
				}
				else // ��ġ���� ������ ���� ������ ����Ѵ�.
					JOptionPane.showMessageDialog(null, "��й�ȣ�� Ʋ�Ƚ��ϴ�. ��й�ȣ�� �ٽ� �Է����ּ���.", "�α��� ����", JOptionPane.ERROR_MESSAGE);
			}
		});
	}
}
