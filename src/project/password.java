package project;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class password extends JFrame {

	static String pw = "12345678!"; // 초기 비밀번호를 설정
	String temp; // 비밀번호 입력 변수
	public password() {
		setTitle("관리자 메뉴 로그인"); // 프레임 타이틀 달기
		setSize(600, 900); // 프레임 사이즈 설정
		setDefaultCloseOperation(password.DISPOSE_ON_CLOSE);// 프레임 윈도우를 닫으면 이 창만 종료하도록 설정
		
		JPanel loginPanel = new JPanel(); // 로그인 화면을 띄워줄 패널
		JTextField passText = new JTextField(10); // 비밀번호를 입력 받을 텍스트 필드
		JLabel warning = new JLabel("초기비밀번호는 12345678! 입니다."); // 초기 비밀번호를 변경하라는 안내 라벨
		JButton login = new JButton("로그인"); // 로그인 기능을 수행할 버튼
		JLabel writePassword = new JLabel("비밀번호를 입력해주세요 : "); // 입력 안내 라벨
		
		loginPanel.setLayout(null); // 임의의 레이아웃을 설정
		
		// 비밀번호 체크 프레임에서 각각의 버튼의 위치와 크기를 설정해줌
		warning.setLocation(50, 400);
		warning.setSize(400, 25);
		writePassword.setLocation(50, 425);
		writePassword.setSize(200, 25);
		passText.setLocation(200, 425);
		passText.setSize(100, 25);
		login.setLocation(350, 425);
		login.setSize(100, 25);
		
		// 패널에 버튼과 텍스트 필드 등을 추가
		loginPanel.add(warning);
		loginPanel.add(writePassword);
		loginPanel.add(passText);
		loginPanel.add(login);
		add(loginPanel);
		
		setVisible(true); // 프레임을 보이게 해준다.
		
		// 로그인 버튼을 눌렀을때 
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				temp = passText.getText(); // 입력한 비밀번호를 받아와서
				if(temp.equals(pw)){ // 비밀번호가 일치하면
					setVisible(false); // 창을 닫고
					//new AdminFrame(); // 관리자 프레임을 실행한다.
				}
				else // 일치하지 않으면 오류 문구를 출력한다.
					JOptionPane.showMessageDialog(null, "비밀번호가 틀렸습니다. 비밀번호를 다시 입력해주세요.", "로그인 실패", JOptionPane.ERROR_MESSAGE);
			}
		});
	}
}
