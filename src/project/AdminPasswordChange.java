package project;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class AdminPasswordChange extends JFrame{
	
	private JPanel Panel = new JPanel(); //화면 패널 생성
	private JLabel label = new JLabel("비밀번호 변경");
	private JLabel label1 = new JLabel("기존 비밀번호 : ");
	private JLabel label2 = new JLabel("비밀번호는 특수문자 및 숫자가 하나 이상 포함된 8자리 이상으로 설정해야 합니다.");
	private JLabel label3 = new JLabel("변경 비밀번호 입력 : ");//변경 할 비밀번호를 입력 받기 위한 라벨과 텍스트 필드
	private JTextField txt1 = new JTextField(10);//기존 비밀번호 입력필드
	private JTextField txt2 = new JTextField(10);//새로운 비밀번호 입력필드
	private JButton Bcheck = new JButton("확인");//비밀번호 확인 버튼
	private JButton Bchange = new JButton("변경하기"); //비밀번호 변경 버튼
	
	String passwordTemp;//사용자가 입력할 비밀번호를 받을 임시 변수
	
	public AdminPasswordChange() {
		setTitle("비밀번호 변경");//프레임 타이틀 달기
		setSize(600, 400);//프레임 사이즈 설정
		setDefaultCloseOperation(AdminPasswordChange.DISPOSE_ON_CLOSE);// 프레임 윈도우를 닫으면 이 창만 종료하도록 설정
		
		// 프레임 구성
		Panel.setLayout(null);
		label.setLocation(50, 50);label.setSize(300, 25);
		label2.setLocation(50, 100);label2.setSize(500, 25);
		label1.setLocation(50, 150);label1.setSize(150, 25);
		txt1.setLocation(200, 150);txt1.setSize(150, 25);
		Bcheck.setLocation(400, 150);Bcheck.setSize(100, 25);
		label3.setLocation(50, 200);label3.setSize(150, 25);
		txt2.setLocation(200, 200);txt2.setSize(150, 25);
		Bchange.setLocation(400, 200);Bchange.setSize(100, 25);
		Bchange.setEnabled(false);
		
		// 패널에 요소 추가
		Panel.add(label);
		Panel.add(label1);
		Panel.add(label2);
		Panel.add(label3);
		Panel.add(txt1);
		Panel.add(Bcheck);
		Panel.add(txt2);
		Panel.add(Bchange);
		add(Panel);//패널 add
	
		//입력 버튼 이벤트
		Bcheck.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				passwordTemp = txt1.getText(); // 사용자가 입력한 비밀번호를 임시 변수에 읽어와서
				if(passwordTemp.equals(Data.getPassword()))//기존 비밀번호 확인
				{
					Bchange.setEnabled(true);// 변경 버튼이 활성화
				}
				else//기존 비밀번화와 다른 경우
					JOptionPane.showMessageDialog(null, "비밀번호가 틀렸습니다. 다시 입력해주세요.", "확인 실패", JOptionPane.ERROR_MESSAGE);
			}
		});
		
		// 변경 버튼 이벤트
		Bchange.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				passwordTemp = txt2.getText();//사용자가 입력한 새로운 비밀번호 저장
				if(passwordTemp.length() >= 8 && passwordTemp.matches(".*[0-9].*") && !passwordTemp.matches("[0-9|a-z|A-Z|ㄱ-ㅎ|ㅏ-ㅣ|가-힝]*")) 
				{
					Data.setPassword(txt2.getText());//조건에 맞으면 비밀번호 변경
					JOptionPane.showMessageDialog(null, "비밀번호가 변경 완료.", "변경 성공", JOptionPane.INFORMATION_MESSAGE);
					setVisible(false);//화면 닫기
				}
				else 
				{ // 조건이 틀린 경우
					JOptionPane.showMessageDialog(null, "비밀번호는 특수문자 및 숫자가 하나 이상 포함된 8자리 이상으로 설정해야 합니다.", "변경 실패", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		setVisible(true);// 프레임 출력
	}
}