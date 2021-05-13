package project;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class AdminMenu extends JFrame implements MouseListener {
	
	JButton BPasswordChange = new JButton("��й�ȣ ����");
	JButton BMoneyManagement = new JButton("���� ����");
	JButton BDrinkManagement = new JButton("������ ����");
	JButton BSaleManagement = new JButton("���� ����");
	JButton BMachine = new JButton("���Ǳ� ���ư���");
	
	public AdminMenu() {
		setTitle("������  �޴�");//������ Ÿ��Ʋ 
		setSize(900, 500);//������ ������
		setDefaultCloseOperation(AdminMenu.DISPOSE_ON_CLOSE);//â�� ������ �� â�� �����ϵ��� ����
		
		//������ �����ӿ��� ��ư�� ��ġ ��������
		BPasswordChange.setLocation(50, 150); BPasswordChange.setSize(150, 60);
		BMoneyManagement.setLocation(250, 150); BMoneyManagement.setSize(150, 60);
		BDrinkManagement.setLocation(450, 150); BDrinkManagement.setSize(150, 60);
		BSaleManagement.setLocation(650, 150); BSaleManagement.setSize(150, 60);
		BMachine.setLocation(650, 350); BMachine.setSize(150, 50);
		
		//���콺 �̺�Ʈ�� �̿��ϱ� ���Ͽ� ��ư �߰�
		BPasswordChange.addMouseListener(this);
		BMoneyManagement.addMouseListener(this);
		BDrinkManagement.addMouseListener(this);
		BSaleManagement.addMouseListener(this);
		BMachine.addMouseListener(this);
			
		CPanel cpanel = new CPanel();//�г� ����
	    add(cpanel, BorderLayout.CENTER);
	    cpanel.add(BPasswordChange);
	    cpanel.add(BMoneyManagement);
	    cpanel.add(BDrinkManagement);
	    cpanel.add(BSaleManagement);
	    cpanel.add(BMachine);
	     
	    setVisible(true);//������ ���
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		JButton b = (JButton) e.getSource();
		if (b == (JButton)BMachine) {//���Ǳ� ��ư�� ������
			setVisible(false);//������ �޴��� â�� ���ش�.
		}
		if (b == (JButton)BPasswordChange) { // ��й�ȣ���� ��ư�� ������
			new AdminPasswordChange(); // ��й�ȣ ���� â���� ���� ���ش�.
		}
		
		if (b == (JButton)BMoneyManagement) { // ȭ����Ȳ���� ��ư�� ������
			new AdminMoney(); // ���Ǳ� ���� ȭ�� ��Ȳ�� �ľ��ϰ� �����ϱ� ���� â���� ���� ���ش�.
		}
		
		if (b == (JButton)BDrinkManagement) { // �Ǹ�������� ��ư�� ������
			new AdminItem(); // ���Ǳ� ���� ������ ����(�̸�, ����, ����)����� ��� ��Ȳ �ľ��� ���� â���� ���� ���ش�.
		}
		
		if (b == (JButton)BSaleManagement) { // ������� ��ư�� ������
			//new SalesManagement(); // ����������� �̿��Ͽ� ����, ��� ��Ȳ, ������ ��� �ľ��ϱ� ���� â���� ���� ���ش�. 
		}
	}
	@Override
	public void mousePressed(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
}
