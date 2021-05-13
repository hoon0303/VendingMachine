package project;

/*
 * 프로그램 : 자판기 프로그램
 * 작성자 : 20164006 박훈
 * 클래스 : AdminPasswordChange
 * 기능 : 비밀번호 변경 기능
 */

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class AdminPasswordChange extends JFrame{
	
	private JPanel Panel = new JPanel();//패널 선언
	private JLabel label = new JLabel("비밀번호 변경");//라벨 선언
	private JLabel label1 = new JLabel("기존 비밀번호 : ");//라벨 선언
	private JLabel label2 = new JLabel("비밀번호는 특수문자 및 숫자가 하나 이상 포함된 8자리 이상으로 설정해야 합니다.");//라벨 선언
	private JLabel label3 = new JLabel("변경 비밀번호 입력 : ");//라벨 선언
	private JTextField txt1 = new JTextField(10);//기존 비밀번호 텍스트 필드
	private JTextField txt2 = new JTextField(10);//새로운 비밀번호 텍스트 필드
	private JButton Bcheck = new JButton("확인");//비밀번호 확인 버튼
	private JButton Bchange = new JButton("변경하기");//비밀번호 변경 버튼
	
	String passwordTemp;//사용자가 입력할 비밀번호를 받을 임시 변수
	
	public AdminPasswordChange() {
		setTitle("비밀번호 변경");//프레임 타이틀 설정
		setSize(600, 400);//프레임 사이즈 설정
		setDefaultCloseOperation(AdminPasswordChange.DISPOSE_ON_CLOSE);//창를 닫으면 이 창만 종료하도록 설정
		
		// 프레임 구성
		Panel.setLayout(null);
		label.setLocation(50, 50);label.setSize(300, 25);//라벨 위치와 사이즈 설정
		label2.setLocation(50, 100);label2.setSize(500, 25);//라벨 위치와 사이즈 설정
		label1.setLocation(50, 150);label1.setSize(150, 25);//라벨 위치와 사이즈 설정
		txt1.setLocation(200, 150);txt1.setSize(150, 25);//텍스트 필드 위치와 사이즈 설정
		Bcheck.setLocation(400, 150);Bcheck.setSize(100, 25);//비밀번호 확인 버튼 위치와 사이즈 설정
		label3.setLocation(50, 200);label3.setSize(150, 25);//라벨 위치와 사이즈 설정
		txt2.setLocation(200, 200);txt2.setSize(150, 25);//텍스트 필드 위치와 사이즈 설정
		Bchange.setLocation(400, 200);Bchange.setSize(100, 25);//비밀번호 변경 버튼 위치와 사이즈 설정
		Bchange.setEnabled(false);
		
		// 패널에 요소 추가
		Panel.add(label);//라벨 추가
		Panel.add(label1);//라벨 추가
		Panel.add(label2);//라벨 추가
		Panel.add(label3);//라벨 추가
		Panel.add(txt1);//텍스트 필드 추가
		Panel.add(Bcheck);//확인 버튼 추가
		Panel.add(txt2);//텍스트 필드 추가
		Panel.add(Bchange);//비밀번호 변경 버튼 추가
		add(Panel);//패널 추가
	
		//입력 버튼 이벤트
		Bcheck.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				passwordTemp = txt1.getText();//사용자가 입력한 비밀번호 저장
				if(passwordTemp.equals(Data.getPassword()))//기존 비밀번호 확인
				{
					Bchange.setEnabled(true);//변경 버튼 활성화
				}
				else//기존 비밀번화와 다른 경우
					JOptionPane.showMessageDialog(null, "비밀번호가 틀렸습니다. 다시 입력해주세요.", "확인 실패", JOptionPane.ERROR_MESSAGE);//비밀번호 에러 메시지
			}
		});
		
		// 변경 버튼 이벤트
		Bchange.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				passwordTemp = txt2.getText();//사용자가 입력한 새로운 비밀번호 저장
				if(passwordTemp.length() >= 8 && passwordTemp.matches(".*[0-9].*") && !passwordTemp.matches("[0-9|a-z|A-Z|ㄱ-ㅎ|ㅏ-ㅣ|가-힝]*"))//조건 확인
				{
					Data.setPassword(txt2.getText());//비밀번호 변경
					JOptionPane.showMessageDialog(null, "비밀번호가 변경 완료.", "변경 성공", JOptionPane.INFORMATION_MESSAGE);//변경 성공 메시지
					setVisible(false);//화면 닫기
				}
				else//조건이 틀린 경우
				{
					JOptionPane.showMessageDialog(null, "비밀번호는 특수문자 및 숫자가 하나 이상 포함된 8자리 이상으로 설정해야 합니다.", "변경 실패", JOptionPane.ERROR_MESSAGE);//에러 메시지 출력
				}
			}
		});
		setVisible(true);// 프레임 출력
	}
}