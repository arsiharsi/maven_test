package gui;

/**<b>Окно с информацией о разработчиках</b>
 * @author Arslan Khusainov
 * класс основан на JFrame
 */
import java.awt.GridLayout;
import java.net.URL;

import javax.swing.*;



public final class AboutUsFrame extends JFrame {
	
	private static final long serialVersionUID = -5995631673307803267L;
	/**
	 * Конструктор
	 */
	public AboutUsFrame() {
		super("О нас");
		setResizable(false);
		setLocationRelativeTo(null);
		JPanel headPanel = new JPanel(new GridLayout(1,2));
		JPanel mainPanel = new JPanel(new GridLayout(4,1,10,10));
		JLabel info1 = new JLabel("Арлан Хусаинов 21130073"); // Отображение текста или изображения
		mainPanel.add(info1);
		JLabel info2 = new JLabel("Трофим Тюлькин 21130819"); // Отображение текста или изображения
		mainPanel.add(info2);
		JLabel info3 = new JLabel("Байрас Кадыров 21130703"); // Отображение текста или изображения
		mainPanel.add(info3);
		JLabel info4 = new JLabel("Софья Колпашникова 21130193"); // Отображение текста или изображения
		mainPanel.add(info4);
		headPanel.add(mainPanel);
		JLabel img = new JLabel();
		img.setIcon(new ImageIcon(AboutUsFrame.class.getResource("/picture/code avengers.png")));
		headPanel.add(img);
		add(headPanel);
		pack();
	}
}
