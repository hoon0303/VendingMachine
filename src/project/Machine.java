package project;

import java.util.ArrayList;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Machine extends JFrame implements MouseListener {

   private JButton[] Bitem = new JButton[5];//���Ǳ� ������ ��ư
   private JLabel[] Litem = new JLabel[5];//���� ��
   private JButton[] Bcoin = new JButton[5];//���Ǳ� ���� ��ư
   private JLabel LTotalCoin = new JLabel("�Է� �ݾ� : ");//�Է� �ݾ� ��
   private JLabel LJCoin = new JLabel("���� �ݾ� :");//���� �ݾ� ��
   private JLabel LRCoin = new JLabel("��ȯ �ݾ� :");//��ȯ �ݾ� ��
   private JTextField txt1 = new JTextField("0");//�Է� �ݾ�
   private JTextField txt2 = new JTextField("0");//���� �ݾ�
   private JTextField txt3 = new JTextField("0");//��ȯ �ݾ�
   
   private JButton Rbtn = new JButton("�ܵ� ��ȯ"); //�ܵ� ��ȯ ��ư
   private JButton restart = new JButton("���Ǳ� �����"); // ���Ǳ� ����� ��ư
   private JButton admin = new JButton("������"); // ������ ��ư
     
   private JPanel panel;
   
   static int User_Money = 0, Total_Money = 0, Count_Money = 0;
   
   public Machine() {
      setTitle("���Ǳ� ���� ���α׷�");//������ Ÿ��Ʋ
      setSize(1000, 540);//������ ������
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      
      //������ ��ư �ʱ�ȭ
      for(int i=0;i<5;i++)
      {
         Bitem[i] = new JButton(Data.itemlist.get(i).getItemName());//������ ��ư �ʱ�ȭ
         Bcoin[i] = new JButton(Data.moneylist.get(i).getMoneyName());//���� ��ư �ʱ�ȭ
         Litem[i] = new JLabel("$"+Integer.toString(Data.itemlist.get(i).getItemPrice()));//�ݝ� �� �ʱ�ȭ
      }
      
      JLabel title1 = new JLabel("���Ǳ� ���� ���α׷�");
      JLabel title2 = new JLabel("����");
      
      //��ư �̺�Ʈ ���
      admin.addMouseListener(this);restart.addMouseListener(this);Rbtn.addMouseListener(this);
      for(int i=0;i<5;i++)
      {
         Bitem[i].addMouseListener(this);
      }
      for(int i=0;i<5;i++)
      {
         Bcoin[i].addMouseListener(this);
      }
      
      //��ư ��ġ�� ������ ����
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
      
      setVisible(true); // ������ ���
   }

   @Override
   public void mouseClicked(MouseEvent e) {
      // TODO Auto-generated method stub
      JButton b = (JButton) e.getSource();
      if (b == (JButton)admin) // ������ ��ư
      {
    	 //setVisible(false); // ������ ���
         new AdminPassword();//�н����� �˻� �г� �̵�
      }
      if(b == (JButton)restart)//����� ��ư Ŭ��
      {
         User_Money = 0; Total_Money = 0; Count_Money = 0;//��� ���� �ʱ�ȭ
         txt1.setText(Integer.toString(0));
         txt2.setText(Integer.toString(0));
         txt3.setText(Integer.toString(0));
         for(int i=0;i<5;i++)//��ư Ȱ��ȭ
         {
            Bcoin[i].setEnabled(true);
            if(Data.itemlist.get(i).getItemCount() == 0)
            {
            	Litem[i].setText("$"+Data.itemlist.get(i).getItemPrice()+"(ǰ��)");
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
      for(int i=0;i<5;i++)//���� Ŭ�� �̺�Ʈ �߻���
      {
         
         if(b == (JButton)Bitem[i])
         {
        	
            if(Data.itemlist.get(i).getItemCount() == 0)//�ش� �������� ǰ���� ���
            {
            	Litem[i].setText("$"+Data.itemlist.get(i).getItemPrice()+"(ǰ��)");
               Bitem[i].setEnabled(false);// ǰ���̹Ƿ� ��ư�� ��Ȱ��ȭ
            }
            else//ǰ���� �ƴ� ���
            {
            	Bitem[i].setText(Data.itemlist.get(i).getItemName());
                Bitem[i].setEnabled(true);
     
            	for(int j=0;j<5;j++)
                {
                   if(User_Money < Data.itemlist.get(j).getItemPrice())//�����ۿ� ���Ͽ� �ݾ��� ������ ���
                   {
                      Litem[j].setText("$"+Data.itemlist.get(j).getItemPrice()+"(�ݾ׺���)");
                      Bitem[j].setEnabled(false);
                      
                      if(Data.itemlist.get(j).getItemCount() == 0)
                      {
                   	   	 Litem[j].setText("$"+Data.itemlist.get(j).getItemPrice()+"(ǰ��)");
                         Bitem[j].setEnabled(false);
                      }
                   }                
                }
            	if(User_Money >= Data.itemlist.get(i).getItemPrice())//���Ű� ������ ���
                {
                   User_Money = User_Money - Data.itemlist.get(i).getItemPrice();
                   int cnt = Data.itemlist.get(i).getItemSale();
                   Data.itemlist.get(i).setItemSale(cnt+1);//�ǸŰ��� ����
                   int cnt1 = Data.itemlist.get(i).getItemCount();
                   Data.itemlist.get(i).setItemCount(cnt1-1);
                   txt2.setText(String.valueOf(User_Money));
                }
            }
            
            if(Data.itemlist.get(i).getItemCount() == 0)//�ش� �������� ǰ���� ���
            {
            	Litem[i].setText("$"+Data.itemlist.get(i).getItemPrice()+"(ǰ��)");
            	Bitem[i].setEnabled(false);// ǰ���̹Ƿ� ��ư�� ��Ȱ��ȭ
            }
            
         }
         
      }
      for(int i=0;i<5;i++)
      {
    	 if(b == (JButton)Bcoin[i])
    	 {
    		 if(Total_Money + Integer.parseInt(Data.moneylist.get(i).getMoneyName()) > 5000)
    		 {
    			 for(int j=0;j<5;j++)//���� ������ 5000�� ������ ���� ��ư ��Ȱ��ȭ
    			 {
    				 Bcoin[j].setEnabled(false);
    			 }
    		 }
    		 else//5000�� �ƴϸ�
    		 {
    			 //������ �̸� �ʱ�ȭ
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
    					 Litem[j].setText("$"+Data.itemlist.get(j).getItemPrice()+"(���Ű���)");
    					 Bitem[j].setEnabled(true);
    					 if(Data.itemlist.get(j).getItemCount() == 0)
    					 {
    						 Litem[j].setText("$"+Data.itemlist.get(j).getItemPrice()+"(ǰ��)");
    						 Bitem[j].setEnabled(false);
    					 }
    				 }
    				 if(User_Money < Data.itemlist.get(j).getItemPrice())
    				 {
    					 Litem[j].setText("$"+Data.itemlist.get(j).getItemPrice()+"(�ݾ׺���)");
    					 Bitem[j].setEnabled(false);
    					 if(Data.itemlist.get(j).getItemCount() == 0)
    					 {
    						 Litem[j].setText("$"+Data.itemlist.get(j).getItemPrice()+"(ǰ��)");
    						 Bitem[j].setEnabled(false);
    					 }
    				 }
    			 }
    			 
    		 }
    	 }
      }
      
      if (b == (JButton)Rbtn) // �ܵ� ��ȯ �̺�Ʈ
      {
		int change = User_Money; // �ܵ��� ����ϱ� ���� ����
		int re1000 = 0, re500 = 0, re100 = 0, re50 = 0, re10 = 0; // ������ ���� �ܵ��� ����ϱ� ���� ����
		if (change > 0) 
		{
			re1000 = change / 1000; // �ܵ����� 1000�� ���� ������ ���
			re500 = (change % 1000) / 500; // �ܵ����� 500�� ���� ������ ���
			re100 = ((change % 1000) % 500) / 100; // �ܵ����� 100�� ���� ������ ���
			re50 = (((change % 1000) % 500) % 100) / 50; // �ܵ����� 50�� ���� ������ ���
			re10 = ((((change % 1000) % 500) % 100) % 50) / 10; // �ܵ����� 10�� ���� ������ ���
				
			// ���� �ݺ����� �̿��Ͽ� �ܵ��� ���� ���� ������ ������� ���� �Ǻ��� ����
			for (int i = 0; i < re1000; i++) 
			{
				if (Data.moneylist.get(4).getMoneyCount() == 0) 
				{ // ���� ������ ������ ���
					JOptionPane.showMessageDialog(new JFrame(), "1000�� ���� �����մϴ�.");
					re500 = change / 500;
					break;
				} 
				else 
				{ // �ܵ� ��ȯ�� 1000�� ����� ���� ���
					int nowm1000 = Data.moneylist.get(4).getMoneyCount();
					nowm1000 -= re500;
					Data.moneylist.get(4).setMoneyCount(nowm1000);
					change -= 1000;
				}
			}
			for (int i = 0; i < re500; i++) 
			{
				if (Data.moneylist.get(3).getMoneyCount() == 0) 
				{  // ���� ������ ������ ���
					JOptionPane.showMessageDialog(new JFrame(), "500�� ������ �����մϴ�.");
					re100 = change / 100;
					break;
				} 
				else 
				{ // �ܵ� ��ȯ�� 500�� �������� ���� ���
					int nowc500 = Data.moneylist.get(3).getMoneyCount();
					nowc500 -= re500;
					Data.moneylist.get(3).setMoneyCount(nowc500);
					change -= 500;
				}
			}
			for (int i = 0; i < re100; i++) 
			{
				if (Data.moneylist.get(2).getMoneyCount() == 0) 
				{ // ���� ������ ������ ���
					JOptionPane.showMessageDialog(new JFrame(), "100�� ������ �����մϴ�.");
					re50 = change / 50;
					break;
				} 
				else 
				{ // �ܵ� ��ȯ�� 100�� �������� ���� ���
					int nowc100 = Data.moneylist.get(2).getMoneyCount();
					nowc100 -= re100;
					Data.moneylist.get(2).setMoneyCount(nowc100);
					change -= 100;
				}
			}
			for (int i = 0; i < re50; i++) 
			{
				if (Data.moneylist.get(1).getMoneyCount() == 0) 
				{ // ���� ������ ������ ���
					JOptionPane.showMessageDialog(new JFrame(), "50�� ������ �����մϴ�.");
					re10 = change / 10;
					break;
				} 
				else 
				{ // �ܵ� ��ȯ�� 50�� �������� ���� ���
					int nowc50 = Data.moneylist.get(1).getMoneyCount();
					nowc50 -= re50;
					Data.moneylist.get(1).setMoneyCount(nowc50);
					change -= 50;
				}
			}
			for (int i = 0; i < re10; i++) 
			{
				if (Data.moneylist.get(0).getMoneyCount() == 0) 
				{ // ���� ������ ������ ���
					JOptionPane.showMessageDialog(new JFrame(), "10�� ������ �����մϴ�.");
					re10 = change / 1;
					break;
				} 
				else 
				{ // �ܵ� ��ȯ�� 10�� �������� ���� ���
					int nowc10 = Data.moneylist.get(0).getMoneyCount();
					nowc10 -= re10;
					Data.moneylist.get(0).setMoneyCount(nowc10);
					change -= 10;
				}
			}
			txt3.setText(String.valueOf(User_Money)); // �ܵ� ��ȯ �ؽ�Ʈ �ʵ忡 ���� ���� ���
			User_Money = 0;
			txt2.setText(String.valueOf(User_Money)); // ����ڰ� ���� ���� �ؽ�Ʈ �ʵ� �ʱ�ȭ
		}
		else 
		{ // ��ȯ�� ���� ���� �� ������
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

   public static void main(String[] args) { // ������ ����
      
	  //������ ��� ���Ḯ��Ʈ�� ����
      Data.itemlist = new ArrayList<>();
      Data.itemlist.add(new item("��",3,450));
      Data.itemlist.add(new item("Ŀ��",3,500));
      Data.itemlist.add(new item("�̿�����",3,550));
      Data.itemlist.add(new item("���Ŀ��",3,700));
      Data.itemlist.add(new item("ź������",3,750));
      
      //���� ��� ���Ḯ��Ʈ�� ����
      Data.moneylist = new ArrayList<>();
      Data.moneylist.add(new money("10", 5));
      Data.moneylist.add(new money("50", 5));
      Data.moneylist.add(new money("100", 5));
      Data.moneylist.add(new money("500", 5));
      Data.moneylist.add(new money("1000", 5));
      
      Machine frame = new Machine();
   }
}