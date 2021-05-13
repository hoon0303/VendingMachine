package project;

import java.util.ArrayList;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Machine extends JFrame implements MouseListener {

   private JButton[] Bitem = new JButton[5];//자판기 아이템 버튼
   private JLabel[] Litem = new JLabel[5];//가격 라벨
   private JButton[] Bcoin = new JButton[5];//자판기 코인 버튼
   private JLabel LTotalCoin = new JLabel("입력 금액 : ");//입력 금액 라벨
   private JLabel LJCoin = new JLabel("현재 금액 :");//현재 금액 라벨
   private JLabel LRCoin = new JLabel("반환 금액 :");//반환 금액 라벨
   private JTextField txt1 = new JTextField("0");//입력 금액
   private JTextField txt2 = new JTextField("0");//현재 금액
   private JTextField txt3 = new JTextField("0");//반환 금액
   
   private JButton Rbtn = new JButton("잔돈 반환"); //잔돈 반환 버튼
   private JButton restart = new JButton("자판기 재부팅"); // 자판기 재부팅 버튼
   private JButton admin = new JButton("관리자"); // 관리자 버튼
     
   private JPanel panel;
   
   static int User_Money = 0, Total_Money = 0, Count_Money = 0;
   
   public Machine() {
      setTitle("자판기 관리 프로그램");//프레임 타이틀
      setSize(1000, 540);//프레임 사이즈
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      
      //아이템 버튼 초기화
      for(int i=0;i<5;i++)
      {
         Bitem[i] = new JButton(Data.itemlist.get(i).getItemName());//아이템 버튼 초기화
         Bcoin[i] = new JButton(Data.moneylist.get(i).getMoneyName());//코인 버튼 초기화
         Litem[i] = new JLabel("$"+Integer.toString(Data.itemlist.get(i).getItemPrice()));//금앩 라벨 초기화
      }
      
      JLabel title1 = new JLabel("자판기 관리 프로그램");
      JLabel title2 = new JLabel("동전");
      
      //버튼 이벤트 등록
      admin.addMouseListener(this);restart.addMouseListener(this);Rbtn.addMouseListener(this);
      for(int i=0;i<5;i++)
      {
         Bitem[i].addMouseListener(this);
      }
      for(int i=0;i<5;i++)
      {
         Bcoin[i].addMouseListener(this);
      }
      
      //버튼 위치와 사이즈 지정
      title1.setLocation(90,50);title1.setSize(200,20);
      Bitem[0].setLocation(90,100); Bitem[0].setSize(120,55);
      Bitem[1].setLocation(240, 100); Bitem[1].setSize(120, 55);
      Bitem[2].setLocation(390, 100); Bitem[2].setSize(120, 55);
      Bitem[3].setLocation(540, 100); Bitem[3].setSize(120, 55);
      Bitem[4].setLocation(690, 100); Bitem[4].setSize(120, 55);
      
      Litem[0].setLocation(130,180); Litem[0].setSize(100,20);
      Litem[1].setLocation(280, 180); Litem[1].setSize(100, 20);
      Litem[2].setLocation(430, 180); Litem[2].setSize(100, 20);
      Litem[3].setLocation(580, 180); Litem[3].setSize(100, 20);
      Litem[4].setLocation(730, 180); Litem[4].setSize(100, 20);
      
      title2.setLocation(90,300);title2.setSize(200,20);
      Bcoin[0].setLocation(90,350); Bcoin[0].setSize(100,20);
      Bcoin[1].setLocation(240, 350); Bcoin[1].setSize(100, 20);
      Bcoin[2].setLocation(390, 350); Bcoin[2].setSize(100, 20);
      Bcoin[3].setLocation(540, 350); Bcoin[3].setSize(100, 20);
      Bcoin[4].setLocation(690, 350); Bcoin[4].setSize(100, 20);
         
      LTotalCoin.setLocation(90,420);LTotalCoin.setSize(80, 20);txt1.setLocation(150,420);txt1.setSize(80, 20);
      LJCoin.setLocation(250,420);LJCoin.setSize(80, 20);txt2.setLocation(310,420);txt2.setSize(80, 20);
      LRCoin.setLocation(410,420);LRCoin.setSize(80, 20);txt3.setLocation(470,420);txt3.setSize(80, 20);
      
      Rbtn.setLocation(570,420);Rbtn.setSize(100, 40);
      restart.setLocation(680,420);restart.setSize(150, 40);
      admin.setLocation(840,420);admin.setSize(80, 40);
      
      CPanel cpanel = new CPanel();
      add(cpanel, BorderLayout.CENTER);
      cpanel.add(title1);cpanel.add(title2);
      cpanel.add(LTotalCoin);cpanel.add(txt1);
      cpanel.add(LJCoin);cpanel.add(txt2);
      cpanel.add(LRCoin);cpanel.add(txt3);
      cpanel.add(restart);
      cpanel.add(admin);
      cpanel.add(Rbtn);
      for(int i=0;i<5;i++)
      {
         cpanel.add(Bitem[i]);
         cpanel.add(Litem[i]);
         cpanel.add(Bcoin[i]);
      }
      
      setVisible(true); // 프레임 출력
   }

   @Override
   public void mouseClicked(MouseEvent e) {
      // TODO Auto-generated method stub
      JButton b = (JButton) e.getSource();
      if (b == (JButton)admin) // 관리자 버튼
      {
    	 //setVisible(false); // 프레임 출력
         new AdminPassword();//패스워드 검사 패널 이동
      }
      if(b == (JButton)restart)//재부팅 버튼 클릭
      {
         User_Money = 0; Total_Money = 0; Count_Money = 0;//모든 변수 초기화
         txt1.setText(Integer.toString(0));
         txt2.setText(Integer.toString(0));
         txt3.setText(Integer.toString(0));
         for(int i=0;i<5;i++)//버튼 활성화
         {
            Bcoin[i].setEnabled(true);
            if(Data.itemlist.get(i).getItemCount() == 0)
            {
            	Litem[i].setText("$"+Data.itemlist.get(i).getItemPrice()+"(품절)");
               Bitem[i].setEnabled(false);
            }
            else
            {
               Bitem[i].setText(Data.itemlist.get(i).getItemName());
               Litem[i].setText("$"+Data.itemlist.get(i).getItemPrice());
               Bitem[i].setEnabled(true);
            }
         }      
      }
      for(int i=0;i<5;i++)//음료 클릭 이벤트 발생시
      {
         
         if(b == (JButton)Bitem[i])
         {
        	
            if(Data.itemlist.get(i).getItemCount() == 0)//해당 아이템이 품절인 경우
            {
            	Litem[i].setText("$"+Data.itemlist.get(i).getItemPrice()+"(품절)");
               Bitem[i].setEnabled(false);// 품절이므로 버튼을 비활성화
            }
            else//품절이 아닌 경우
            {
            	Bitem[i].setText(Data.itemlist.get(i).getItemName());
                Bitem[i].setEnabled(true);
     
            	for(int j=0;j<5;j++)
                {
                   if(User_Money < Data.itemlist.get(j).getItemPrice())//아이템에 대하여 금액이 부족한 경우
                   {
                      Litem[j].setText("$"+Data.itemlist.get(j).getItemPrice()+"(금액부족)");
                      Bitem[j].setEnabled(false);
                      
                      if(Data.itemlist.get(j).getItemCount() == 0)
                      {
                   	   	 Litem[j].setText("$"+Data.itemlist.get(j).getItemPrice()+"(품절)");
                         Bitem[j].setEnabled(false);
                      }
                   }                
                }
            	if(User_Money >= Data.itemlist.get(i).getItemPrice())//구매가 가능한 경우
                {
                   User_Money = User_Money - Data.itemlist.get(i).getItemPrice();
                   int cnt = Data.itemlist.get(i).getItemSale();
                   Data.itemlist.get(i).setItemSale(cnt+1);//판매개수 증가
                   int cnt1 = Data.itemlist.get(i).getItemCount();
                   Data.itemlist.get(i).setItemCount(cnt1-1);
                   txt2.setText(String.valueOf(User_Money));
                }
            }
            
            if(Data.itemlist.get(i).getItemCount() == 0)//해당 아이템이 품절인 경우
            {
            	Litem[i].setText("$"+Data.itemlist.get(i).getItemPrice()+"(품절)");
            	Bitem[i].setEnabled(false);// 품절이므로 버튼을 비활성화
            }
            
         }
         
      }
      for(int i=0;i<5;i++)
      {
    	 if(b == (JButton)Bcoin[i])
    	 {
    		 if(Total_Money + Integer.parseInt(Data.moneylist.get(i).getMoneyName()) > 5000)
    		 {
    			 for(int j=0;j<5;j++)//돈의 총합이 5000이 넘으면 동전 버튼 비활성화
    			 {
    				 Bcoin[j].setEnabled(false);
    			 }
    		 }
    		 else//5000이 아니면
    		 {
    			 //아이템 이름 초기화
    			 for(int j=0;j<5;j++)
    			 {
    				 Bitem[j].setText(Data.itemlist.get(j).getItemName());
    			 }
    			 Total_Money = Total_Money + Integer.parseInt(Data.moneylist.get(i).getMoneyName());
    			 User_Money = User_Money + Integer.parseInt(Data.moneylist.get(i).getMoneyName());
    			 txt1.setText(String.valueOf(Total_Money));
    			 txt2.setText(String.valueOf(User_Money));
    			 txt3.setText(String.valueOf(0));
    			 int cnt = Data.moneylist.get(i).getMoneyCount();
    			 Data.moneylist.get(i).setMoneyCount(cnt+1);
    			 
    			 for(int j=0;j<5;j++)
    			 {
    				 if(User_Money >= Data.itemlist.get(j).getItemPrice())
    				 {
    					 Litem[j].setText("$"+Data.itemlist.get(j).getItemPrice()+"(구매가능)");
    					 Bitem[j].setEnabled(true);
    					 if(Data.itemlist.get(j).getItemCount() == 0)
    					 {
    						 Litem[j].setText("$"+Data.itemlist.get(j).getItemPrice()+"(품절)");
    						 Bitem[j].setEnabled(false);
    					 }
    				 }
    				 if(User_Money < Data.itemlist.get(j).getItemPrice())
    				 {
    					 Litem[j].setText("$"+Data.itemlist.get(j).getItemPrice()+"(금액부족)");
    					 Bitem[j].setEnabled(false);
    					 if(Data.itemlist.get(j).getItemCount() == 0)
    					 {
    						 Litem[j].setText("$"+Data.itemlist.get(j).getItemPrice()+"(품절)");
    						 Bitem[j].setEnabled(false);
    					 }
    				 }
    			 }
    			 
    		 }
    	 }
      }
      
      if (b == (JButton)Rbtn) // 잔돈 반환 이벤트
      {
		int change = User_Money; // 잔돈을 계산하기 위한 변수
		int re1000 = 0, re500 = 0, re100 = 0, re50 = 0, re10 = 0; // 각각의 돈의 잔돈을 계산하기 위한 변수
		if (change > 0) 
		{
			re1000 = change / 1000; // 잔돈에서 1000원 지폐 개수를 계산
			re500 = (change % 1000) / 500; // 잔돈에서 500원 동전 개수를 계산
			re100 = ((change % 1000) % 500) / 100; // 잔돈에서 100원 동전 개수를 계산
			re50 = (((change % 1000) % 500) % 100) / 50; // 잔돈에서 50원 동전 개수를 계산
			re10 = ((((change % 1000) % 500) % 100) % 50) / 10; // 잔돈에서 10원 동전 개수를 계산
				
			// 각각 반복문을 이용하여 잔돈을 위한 돈의 개수가 충분한지 여부 판별을 해줌
			for (int i = 0; i < re1000; i++) 
			{
				if (Data.moneylist.get(4).getMoneyCount() == 0) 
				{ // 돈의 개수가 부족한 경우
					JOptionPane.showMessageDialog(new JFrame(), "1000원 지폐가 부족합니다.");
					re500 = change / 500;
					break;
				} 
				else 
				{ // 잔돈 반환을 1000원 지폐로 해준 경우
					int nowm1000 = Data.moneylist.get(4).getMoneyCount();
					nowm1000 -= re500;
					Data.moneylist.get(4).setMoneyCount(nowm1000);
					change -= 1000;
				}
			}
			for (int i = 0; i < re500; i++) 
			{
				if (Data.moneylist.get(3).getMoneyCount() == 0) 
				{  // 돈의 개수가 부족한 경우
					JOptionPane.showMessageDialog(new JFrame(), "500원 동전이 부족합니다.");
					re100 = change / 100;
					break;
				} 
				else 
				{ // 잔돈 반환을 500원 동전으로 해준 경우
					int nowc500 = Data.moneylist.get(3).getMoneyCount();
					nowc500 -= re500;
					Data.moneylist.get(3).setMoneyCount(nowc500);
					change -= 500;
				}
			}
			for (int i = 0; i < re100; i++) 
			{
				if (Data.moneylist.get(2).getMoneyCount() == 0) 
				{ // 돈의 개수가 부족한 경우
					JOptionPane.showMessageDialog(new JFrame(), "100원 동전이 부족합니다.");
					re50 = change / 50;
					break;
				} 
				else 
				{ // 잔돈 반환을 100원 동전으로 해준 경우
					int nowc100 = Data.moneylist.get(2).getMoneyCount();
					nowc100 -= re100;
					Data.moneylist.get(2).setMoneyCount(nowc100);
					change -= 100;
				}
			}
			for (int i = 0; i < re50; i++) 
			{
				if (Data.moneylist.get(1).getMoneyCount() == 0) 
				{ // 돈의 개수가 부족한 경우
					JOptionPane.showMessageDialog(new JFrame(), "50원 동전이 부족합니다.");
					re10 = change / 10;
					break;
				} 
				else 
				{ // 잔돈 반환을 50원 동전으로 해준 경우
					int nowc50 = Data.moneylist.get(1).getMoneyCount();
					nowc50 -= re50;
					Data.moneylist.get(1).setMoneyCount(nowc50);
					change -= 50;
				}
			}
			for (int i = 0; i < re10; i++) 
			{
				if (Data.moneylist.get(0).getMoneyCount() == 0) 
				{ // 돈의 개수가 부족한 경우
					JOptionPane.showMessageDialog(new JFrame(), "10원 동전이 부족합니다.");
					re10 = change / 1;
					break;
				} 
				else 
				{ // 잔돈 반환을 10원 동전으로 해준 경우
					int nowc10 = Data.moneylist.get(0).getMoneyCount();
					nowc10 -= re10;
					Data.moneylist.get(0).setMoneyCount(nowc10);
					change -= 10;
				}
			}
			txt3.setText(String.valueOf(User_Money)); // 잔돈 반환 텍스트 필드에 남은 돈을 출력
			User_Money = 0;
			txt2.setText(String.valueOf(User_Money)); // 사용자가 넣은 돈의 텍스트 필드 초기화
		}
		else 
		{ // 반환할 돈이 없을 때 누르면
			txt3.setText(String.valueOf(0));
			User_Money = 0;
		}
	}
   }

   @Override
   public void mousePressed(MouseEvent e) {
      // TODO Auto-generated method stub
   }
   @Override
   public void mouseReleased(MouseEvent e) {
      // TODO Auto-generated method stub
   }
   @Override
   public void mouseEntered(MouseEvent e) {
      // TODO Auto-generated method stub
   }
   @Override
   public void mouseExited(MouseEvent e) {
      // TODO Auto-generated method stub
   }

   public static void main(String[] args) { // 메인이 실행
      
	  //아이템 목록 연결리스트에 저장
      Data.itemlist = new ArrayList<>();
      Data.itemlist.add(new item("물",3,450));
      Data.itemlist.add(new item("커피",3,500));
      Data.itemlist.add(new item("이온음료",3,550));
      Data.itemlist.add(new item("고급커피",3,700));
      Data.itemlist.add(new item("탄산음료",3,750));
      
      //동전 목록 연결리스트에 저장
      Data.moneylist = new ArrayList<>();
      Data.moneylist.add(new money("10", 5));
      Data.moneylist.add(new money("50", 5));
      Data.moneylist.add(new money("100", 5));
      Data.moneylist.add(new money("500", 5));
      Data.moneylist.add(new money("1000", 5));
      
      Machine frame = new Machine();
   }
}