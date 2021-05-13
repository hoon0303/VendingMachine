package project;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class AdminMenu extends JFrame implements MouseListener {
	
	JButton BPasswordChange = new JButton("비밀번호 변경");
	JButton BMoneyManagement = new JButton("수금 관리");
	JButton BDrinkManagement = new JButton("아이템 관리");
	JButton BSaleManagement = new JButton("매출 관리");
	JButton BMachine = new JButton("자판기 돌아가기");
	
	public AdminMenu() {
		setTitle("관리자  메뉴");//프레임 타이틀 
		setSize(900, 500);//프레임 사이즈
		setDefaultCloseOperation(AdminMenu.DISPOSE_ON_CLOSE);//창를 닫으면 이 창만 종료하도록 설정
		
		//관리자 프레임에서 버튼의 위치 설정해줌
		BPasswordChange.setLocation(50, 150); BPasswordChange.setSize(150, 60);
		BMoneyManagement.setLocation(250, 150); BMoneyManagement.setSize(150, 60);
		BDrinkManagement.setLocation(450, 150); BDrinkManagement.setSize(150, 60);
		BSaleManagement.setLocation(650, 150); BSaleManagement.setSize(150, 60);
		BMachine.setLocation(650, 350); BMachine.setSize(150, 50);
		
		//마우스 이벤트를 이용하기 위하여 버튼 추가
		BPasswordChange.addMouseListener(this);
		BMoneyManagement.addMouseListener(this);
		BDrinkManagement.addMouseListener(this);
		BSaleManagement.addMouseListener(this);
		BMachine.addMouseListener(this);
			
		CPanel cpanel = new CPanel();//패널 생성
	    add(cpanel, BorderLayout.CENTER);
	    cpanel.add(BPasswordChange);
	    cpanel.add(BMoneyManagement);
	    cpanel.add(BDrinkManagement);
	    cpanel.add(BSaleManagement);
	    cpanel.add(BMachine);
	     
	    setVisible(true);//프레임 출력
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		JButton b = (JButton) e.getSource();
		if (b == (JButton)BMachine) {//자판기 버튼을 누르면
			setVisible(false);//관리자 메뉴의 창을 꺼준다.
		}
		if (b == (JButton)BPasswordChange) { // 비밀번호변경 버튼을 누르면
			new AdminPasswordChange(); // 비밀번호 변경 창으로 가게 해준다.
		}
		
		if (b == (JButton)BMoneyManagement) { // 화폐현황관리 버튼을 누르면
			new AdminMoney(); // 자판기 내의 화폐 현황을 파악하고 수금하기 위한 창으로 가게 해준다.
		}
		
		if (b == (JButton)BDrinkManagement) { // 판매음료관리 버튼을 누르면
			new AdminItem(); // 자판기 내의 음료의 내용(이름, 가격, 수량)변경과 재고 현황 파악을 위한 창으로 가게 해준다.
		}
		
		if (b == (JButton)BSaleManagement) { // 매출관리 버튼을 누르면
			//new SalesManagement(); // 파일입출력을 이용하여 매출, 재고 현황, 소진된 재고를 파악하기 위한 창으로 가게 해준다. 
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
