package project;

/*
 * 프로그램 : 자판기 프로그램
 * 작성자 : 20164006 박훈
 * 클래스 : AdminPassword
 * 기능 : 비밀번호 확인 기능
 */

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class AdminPassword extends JFrame {

	private String TempPassword;//입력받은 비밀번호 임시 저장
	
	public AdminPassword() {
		setTitle("관리자 로그인");//프레임 타이틀
		setSize(500, 400);//프레임 사이즈
		setDefaultCloseOperation(AdminPassword.DISPOSE_ON_CLOSE);//해당 창만 종료 설정
		
		JPanel panel = new JPanel();//패널
		JTextField TxtPassword = new JTextField(10);//비밀번호 텍스트 필드
		JLabel label1 = new JLabel("관리자 로그인 페이지");//라벨
		JLabel label2 = new JLabel("초기비밀번호는 12345678! 입니다.");//초기 비밀번호 안내 라벨
		JButton Blogin = new JButton("로그인");//로그인 버튼
		JLabel label3 = new JLabel("Password : ");//비밀번호 라벨
		
		panel.setLayout(null); // 임의의 레이아웃을 설정
		
		//비밀번호 체크 프레임에서 각각의 버튼의 위치와 크기를 설정해줌
		label1.setLocation(50, 70);label1.setSize(400, 25);//라벨 사이즈 위치
		label2.setLocation(50, 120);label2.setSize(400, 25);//라벨 사이즈 위치
		label3.setLocation(50, 150);label3.setSize(200, 25);//라벨 사이즈 위치
		TxtPassword.setLocation(120, 150);TxtPassword.setSize(100, 25);//텍스트 필드 사이즈 위치
		Blogin.setLocation(230, 150);Blogin.setSize(80, 25);//로그인 버튼 사이즈 위치
		
		//패널에 버튼과 텍스트 필드 등을 추가
		panel.add(label1);//라벨 추가
		panel.add(label2);//라벨 추가
		panel.add(label3);//라벨 추가
		panel.add(TxtPassword);//비밀번호 텍스트 필드 추가
		panel.add(Blogin);//로그인 버튼 추가
		add(panel);//패널 추가
		
		setVisible(true);//프레임 출력
		
		//로그인 버튼 이벤트
		Blogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TempPassword = TxtPassword.getText();//입력한 비밀번호 저장
				if(TempPassword.equals(Data.getPassword())){ // 비밀번호가 일치한 경우
					setVisible(false);//현재 창을 닫음
					new AdminMenu();//관리자 메뉴 화면 이동
				}
				else//일치하지 않으면 오류 문구를 출력한다.
					JOptionPane.showMessageDialog(null, "비밀번호가 틀렸습니다.", "로그인 실패", JOptionPane.ERROR_MESSAGE);//비밀번호 에러 메시지
			}
		});
	}
	
}
