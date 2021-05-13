package project;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class AdminPassword extends JFrame {

	private String passwordTemp;//입력받은 비밀번호 임시 저장
	
	public AdminPassword() {
		setTitle("관리자 로그인");//프레임 타이틀
		setSize(500, 400);//프레임 사이즈
		setDefaultCloseOperation(AdminPassword.DISPOSE_ON_CLOSE);
		
		JPanel loginPanel = new JPanel();//로그인 화면을 띄워줄 패널
		JTextField passText = new JTextField(10);//비밀번호를 입력 받을 텍스트 필드
		JLabel label1 = new JLabel("관리자 로그인 페이지");//초기 비밀번호를 변경하라는 안내 라벨
		JLabel label2 = new JLabel("초기비밀번호는 12345678! 입니다.");//초기 비밀번호를 변경하라는 안내 라벨
		JButton Blogin = new JButton("로그인");//로그인 기능을 수행할 버튼
		JLabel writePassword = new JLabel("Password : ");//입력 안내 라벨
		
		loginPanel.setLayout(null); // 임의의 레이아웃을 설정
		
		//비밀번호 체크 프레임에서 각각의 버튼의 위치와 크기를 설정해줌
		label1.setLocation(50, 70);label1.setSize(400, 25);
		label2.setLocation(50, 120);label2.setSize(400, 25);
		writePassword.setLocation(50, 150);writePassword.setSize(200, 25);
		passText.setLocation(120, 150);passText.setSize(100, 25);
		Blogin.setLocation(230, 150);Blogin.setSize(80, 25);
		
		//패널에 버튼과 텍스트 필드 등을 추가
		loginPanel.add(label1);
		loginPanel.add(label2);
		loginPanel.add(writePassword);
		loginPanel.add(passText);
		loginPanel.add(Blogin);
		add(loginPanel);
		
		setVisible(true);//프레임을 보이게 해준다.
		
		//로그인 버튼을 눌렀을때 
		Blogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				passwordTemp = passText.getText();//입력한 비밀번호 저장
				if(passwordTemp.equals(Data.getPassword())){ // 비밀번호가 일치한 경우
					setVisible(false);
					new AdminMenu();//관리자 메뉴 화면 이동
				}
				else//일치하지 않으면 오류 문구를 출력한다.
					JOptionPane.showMessageDialog(null, "비밀번호가 틀렸습니다.", "로그인 실패", JOptionPane.ERROR_MESSAGE);
			}
		});
	}
	
}
