package FCFS;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class HorseEatGrass extends JFrame{
	private Horse_Grass hg = new Horse_Grass();
	public HorseEatGrass() {
		super("小马吃草模拟FCFS 1.0");
		this.setSize(800, 600);
		Toolkit tool = Toolkit.getDefaultToolkit(); //获取屏幕大小
		Dimension dim = tool.getScreenSize(); //存放获取屏幕的大小
		int swidth = (int)dim.getWidth(); //宽高度转换为int型
		int sheight = (int)dim.getHeight();
		this.setLocation((swidth-800)/2,(sheight-600)/2); //居中
		
		this.setLayout(new GridLayout(6, 1));
		this.add(hg.jpHorseOne);
		this.add(hg.jpHorseTwo);
		this.add(hg.jpHorseThree);
		this.add(hg.jpHorseFour);
		this.add(hg.jpGrass);
		this.add(hg.jpButton);
		
		//设置图标
		String path="/Img/horse.jpg";
		try{
			Image img = ImageIO.read(this.getClass().getResource(path));
			this.setIconImage(img);
		}catch(IOException e){
			e.printStackTrace();
		}
		
		this.setResizable(false); //不可最大化
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new HorseEatGrass();
	}
}
