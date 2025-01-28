package gui;
/**<b>Окно для вывода в ПДФ</b>
 * @author Arslan Khusainov
 * класс основан на JDialog
 */
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.*;


import pdf.ListenerPDF;


public class OutputFrame extends JDialog {
	
	
	/**Поля ввода данных*/
	private static JTextField fieldAdress, fieldName, fieldBank;	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/***
	 * Констркутор
	 * @param Тариф для вывода
	 */
	public OutputFrame(int tarif) {
		
		setModal(true);//это окно модальное, то есть всё внимание на нем и не создашь больше 1 окна
		Container container = new Container();//контейнер, в котором наши поля ввода и кнопка будут
        container.setLayout(new GridLayout(4, 2, -60, 20));//тип расположения элементов в контейнере
        setLayout(new FlowLayout(FlowLayout.LEFT));
		setTitle("Подробнее");
		setSize(400,300);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		Font f = new Font(Font.DIALOG, Font.PLAIN, 15);//шрифтик красивый
		
		JLabel lbl_name = new JLabel("ФИО");
		lbl_name.setFont(f);
		fieldName = new JTextField(15);
		fieldName.setFont(f);
		
		JLabel lbl_adress = new JLabel("Адрес");
		lbl_adress.setFont(f);
		fieldAdress = new JTextField(15);
		fieldAdress.setFont(f);
		
		JLabel lbl_bank = new JLabel("<html>Номер<br>лицевого счёта</html>");
		lbl_bank.setFont(f);
		fieldBank = new JTextField(15);
		fieldBank.setFont(f);
		
		JButton btn = new JButton("Сгенерировать ПДФ");
		btn.addActionListener(e -> {
        	
			ListenerPDF.createPDF(ButtonCalculate.getTarif());
            
        });
		
		container.add(lbl_name);
		container.add(fieldName);
		container.add(lbl_adress);
		container.add(fieldAdress);
		container.add(lbl_bank);
		container.add(fieldBank);
		container.add(btn);
		add(container);
		setVisible(true);	
	}
	/**Получение полей ввода*/
	final public static JTextField[] getFields() {
		JTextField[] result = {fieldBank, fieldAdress, fieldName};
		return result;
		}
	
}
