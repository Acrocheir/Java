package FCFS;

import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Horse_Grass {
	JPanel jpHorseOne = new JPanel();
	JPanel jpHorseTwo = new JPanel();
	JPanel jpHorseThree = new JPanel();
	JPanel jpHorseFour = new JPanel();
	JPanel jpGrass = new JPanel();
	JPanel jpButton = new JPanel();
	JButton jbStart = new JButton("开始");
	JButton jbStop = new JButton("暂停");
	JButton jbContinue = new JButton("继续");
	JButton jbReset = new JButton("重置");
	FlowLayout flLeft=new FlowLayout(); //布局
	FlowLayout flRight=new FlowLayout(); 
	//四个JLabel
	private JLabel jlHOne = new JLabel(), jlHTwo = new JLabel(), jlHThree = new JLabel(),
			jlHFour = new JLabel(), jlGrass = new JLabel();
	//放四只小羊图片
	//private ImageIcon iconOne = null, iconTwo = null, iconThree = null, iconFour = null, iconGrass = null;
	private ImageIcon iconOne = new ImageIcon("F:\\Eclipse\\大三上\\Computer_OS\\src\\Img\\horse_1.jpg");
	private ImageIcon iconTwo = new ImageIcon("F:\\Eclipse\\大三上\\Computer_OS\\src\\Img\\horse_2.jpg");
	private ImageIcon iconThree = new ImageIcon("F:\\Eclipse\\大三上\\Computer_OS\\src\\Img\\horse_3.jpg");
	private ImageIcon iconFour = new ImageIcon("F:\\Eclipse\\大三上\\Computer_OS\\src\\Img\\horse_4.jpg");
	private ImageIcon iconGrass = new ImageIcon("F:\\Eclipse\\大三上\\Computer_OS\\src\\Img\\grass.jpg");
	//放四只小羊的顺序
	private JLabel jlOne = new JLabel(), jlTwo = new JLabel(), jlThree = new JLabel(), jlFour = new JLabel();
	//四个线程
	Thread tHorseOne,tHorseTwo,tHorseThree,tHorseFour;
	private int a,b,c,d; //用于产生随机数
	private Point p1,p2,p3,p4; //获取4个小马的坐标
	private int a0,b0,c0,d0; //4个小马的初始横坐标
	private int a1=0,b1=0,c1=0,d1=0; //用于判断吃草顺序，a1相当于第一个来的
	private Queue<Integer> queue = new LinkedList<Integer>(); //队列，用于排序
	
	public Horse_Grass(){
		/*iconOne = new ImageIcon("F:\\Eclipse\\大三上\\Computer_OS\\src\\Img\\horse_1.jpg");
		iconTwo = new ImageIcon("F:\\Eclipse\\大三上\\Computer_OS\\src\\Img\\horse_2.jpg");
		iconThree = new ImageIcon("F:\\Eclipse\\大三上\\Computer_OS\\src\\Img\\horse_3.jpg");
		iconFour = new ImageIcon("F:\\Eclipse\\大三上\\Computer_OS\\src\\Img\\horse_4.jpg");
		iconGrass = new ImageIcon("F:\\Eclipse\\大三上\\Computer_OS\\src\\Img\\horse_4.jpg");
		jlHOne = new JLabel(iconOne);
		jlHTwo = new JLabel(iconTwo);
		jlHThree = new JLabel(iconThree);
		jlHFour = new JLabel(iconFour);
		jlGrass = new JLabel(iconGrass);*/
		jlHOne.setIcon(iconOne);
		jlHTwo.setIcon(iconTwo);
		jlHThree.setIcon(iconThree);
		jlHFour.setIcon(iconFour);
		jlGrass.setIcon(iconGrass);
		flLeft.setAlignment(FlowLayout.LEFT); //靠左
		jpHorseOne.setLayout(flLeft);
		jpHorseTwo.setLayout(flLeft);
		jpHorseThree.setLayout(flLeft);
		jpHorseFour.setLayout(flLeft);
		flRight.setAlignment(FlowLayout.RIGHT); //靠右
		jpGrass.setLayout(flRight);
		jbReset.setEnabled(false); //一开始复位不能用
		jbStop.setEnabled(false);
		jbContinue.setEnabled(false);
		
		jpHorseOne.add(jlHOne);
		jpHorseTwo.add(jlHTwo);
		jpHorseThree.add(jlHThree);
		jpHorseFour.add(jlHFour);
		//第5个panel
		jpGrass.add(jlFour);
		jpGrass.add(jlThree);
		jpGrass.add(jlTwo);
		jpGrass.add(jlOne);
		jpGrass.add(jlGrass);
		//第6个panel
		jpButton.add(jbStart);
		jpButton.add(jbStop);
		jpButton.add(jbContinue);
		jpButton.add(jbReset);
		
		jpHorseOne.setVisible(true);
		jpHorseTwo.setVisible(true);
		jpHorseThree.setVisible(true);
		jpHorseFour.setVisible(true);
		jpGrass.setVisible(true);
		jpButton.setVisible(true);
		/**
		 * 开始
		 */
		jbStart.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				jbStart.setEnabled(false);
				jbStop.setEnabled(true);
				jbReset.setEnabled(true);
				a = 50+new Random().nextInt(100);
				b = 50+new Random().nextInt(100);
				c = 50+new Random().nextInt(100);
				d = 50+new Random().nextInt(100);
				//1号小马起始位置
				p1 = jlHOne.getLocation();
			    a0 = p1.x; //为了复位
			    //2号下马的
			    p2 = jlHTwo.getLocation();
				b0 = p2.x;
				//3号下马的
				p3 = jlHThree.getLocation();
				c0 = p3.x;
				//4号下马的
				p4 = jlHThree.getLocation();
				d0 = p4.x;
				//第一匹小马
				tHorseOne = new Thread(){
					public void run(){
						while(p1.x<650){
							try {
								Thread.sleep(a);
							} catch (Exception e1) {}
						    jlHOne.setBounds(p1.x+5, p1.y, 98, 81);
						    p1.x = p1.x+5;
						}
						//jlHOne.setBounds(p1.x-5, p1.y, 98, 81);
						queue.offer(1); //第一匹小马到了，放入1
						QOrder(); //用于排序
					}
				};
				tHorseOne.start();
				//第二匹小马
				tHorseTwo = new Thread(){
					public void run(){
						while(p2.x<650){
							try {
								Thread.sleep(b);
							} catch (Exception e2) {}
						    jlHTwo.setBounds(p2.x+5, p2.y, 98, 82);
						    p2.x = p2.x+5;
						}
						queue.offer(2); //第二匹小马到了，放入2
						QOrder();
					}
				};
				tHorseTwo.start();
				//第三匹小马
				tHorseThree = new Thread(){
					public void run(){	
						while(p3.x<650){
							try {
								Thread.sleep(c);
							} catch (Exception e3) {}
							jlHThree.setBounds(p3.x+5, p3.y, 99, 83);
							p3.x = p3.x+5;
						}
						queue.offer(3); //第三匹小马到了，放入3
						QOrder();
					}
				};
				tHorseThree.start();
				//第四匹小马
				tHorseFour = new Thread(){
					public void run(){	
						while(p4.x<650){
							try {
								Thread.sleep(d);
							} catch (Exception e3) {}
							jlHFour.setBounds(p4.x+5, p4.y, 98, 83);
							p4.x = p4.x+5;
						}
						queue.offer(4); //第四匹小马到了，放入4
						QOrder();
					}
				};
				tHorseFour.start();
			}
		});
		/**
		 * 暂停
		 */
		jbStop.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				jbStop.setEnabled(false);
				tHorseOne.suspend();
				tHorseTwo.suspend();
				tHorseThree.suspend();
				tHorseFour.suspend();
				jbContinue.setEnabled(true);
			}
		});
		/**
		 * 继续
		 */
		jbContinue.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				jbContinue.setEnabled(false);
				tHorseOne.resume();
				tHorseTwo.resume();
				tHorseThree.resume();
				tHorseFour.resume();
				jbStop.setEnabled(true);
			}
		});
		/**
		 * 重置
		 */
		jbReset.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				jlHOne.setBounds(a0, p1.y, 98, 81);
				jlHTwo.setBounds(b0, p2.y, 98, 82);
				jlHThree.setBounds(c0, p3.y, 99, 83);
				jlHFour.setBounds(d0, p4.y, 98, 83);
				a1=b1=c1=d1=0;
				jbReset.setEnabled(false);
				jbStart.setEnabled(true);
				jbStop.setEnabled(false);
				tHorseOne.stop();
				tHorseTwo.stop();
				tHorseThree.stop();
				tHorseFour.stop();
				jlOne.setIcon(null);
				jlTwo.setIcon(null);
				jlThree.setIcon(null);
				jlFour.setIcon(null);
			}
		});
	}
	
	//排序
	public void QOrder(){
		if(queue.peek()!=null){ //返回队头元素，不会删除
	    	int q = queue.poll(); //返回队头元素并删除
	    	System.out.println(q);
	    	System.out.println("a1="+a1+" b1="+b1+" c1="+c1+" d1="+d1);
	    	if(a1 == 0){ //第一匹小马是否到达
	    	    if(q == 1)
	    	        jlOne.setIcon(iconOne);
	    	    else if(q == 2)
	    	    	jlOne.setIcon(iconTwo);
	    	    else if(q == 3)
	    	    	jlOne.setIcon(iconThree);
	    	    else if(q == 4)
	    	    	jlOne.setIcon(iconFour);
	    	    a1 = 1;//表明已经有第一个到达
	    	}
	    	else if(b1 == 0){
	    		if(q == 1)
	    	        jlTwo.setIcon(iconOne);
	    	    else if(q == 2)
	    	    	jlTwo.setIcon(iconTwo);
	    	    else if(q == 3)
	    	    	jlTwo.setIcon(iconThree);
	    	    else if(q == 4)
	    	    	jlTwo.setIcon(iconFour);
	    		b1 = 1;
	    	}
	    	else if(c1 == 0){
	    		if(q == 1)
	    	        jlThree.setIcon(iconOne);
	    	    else if(q == 2)
	    	    	jlThree.setIcon(iconTwo);
	    	    else if(q == 3)
	    	    	jlThree.setIcon(iconThree);
	    	    else if(q == 4)
	    	    	jlThree.setIcon(iconFour);
	    		c1 = 1;
	    	}
	    	else if(d1 == 0){
	    		if(q == 1)
	    	        jlFour.setIcon(iconOne);
	    	    else if(q == 2)
	    	    	jlFour.setIcon(iconTwo);
	    	    else if(q == 3)
	    	    	jlFour.setIcon(iconThree);
	    	    else if(q == 4)
	    	    	jlFour.setIcon(iconFour);
	    		d1 = 1;
	    	}
	    	if(a1==1&&b1==1&&c1==1&&d1==1){
	    		jbStop.setEnabled(false);
	    		jbReset.setEnabled(true);
	    	}
	    }
	}

}
