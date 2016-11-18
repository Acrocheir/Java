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
		super("С��Բ�ģ��FCFS 1.0");
		this.setSize(800, 600);
		Toolkit tool = Toolkit.getDefaultToolkit(); //��ȡ��Ļ��С
		Dimension dim = tool.getScreenSize(); //��Ż�ȡ��Ļ�Ĵ�С
		int swidth = (int)dim.getWidth(); //��߶�ת��Ϊint��
		int sheight = (int)dim.getHeight();
		this.setLocation((swidth-800)/2,(sheight-600)/2); //����
		
		this.setLayout(new GridLayout(6, 1));
		this.add(hg.jpHorseOne);
		this.add(hg.jpHorseTwo);
		this.add(hg.jpHorseThree);
		this.add(hg.jpHorseFour);
		this.add(hg.jpGrass);
		this.add(hg.jpButton);
		
		//����ͼ��
		String path="/Img/horse.jpg";
		try{
			Image img = ImageIO.read(this.getClass().getResource(path));
			this.setIconImage(img);
		}catch(IOException e){
			e.printStackTrace();
		}
		
		this.setResizable(false); //�������
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new HorseEatGrass();
	}
}
