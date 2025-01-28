package gui;
/**<b>Абстракция выпадающего списка</b>
 * @author Arslan Khusainov
 * класс основан на JComboBox(String)
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

abstract class AbstractCombobox extends JComboBox<String> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7857413199519392371L;
	/**
	 * Конструктор
	 */
	protected AbstractCombobox() {
		super();
		addActionListener(new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent e) {
				cbAction();
			} 
			} );
	}
	/**
	 * Действие на выбор элемента
	 */
	protected void cbAction() {
		
	}
}
