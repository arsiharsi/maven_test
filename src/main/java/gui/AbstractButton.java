package gui;
/**<b>Абстракция кнопки</b>
 * @author Arslan Khusainov
 * класс основан на JButton
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

abstract class AbstractButton extends JButton{
	private static final long serialVersionUID = 371805777530287470L;
	/**
	 * Конструктор
	 * */
	protected AbstractButton(String name) {
		super(name);
		addActionListener(new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent e) {
				buttonAction();
			} 
			} );
	}
	/**
	 * Действие на нажатие кнопки
	 * */
	protected void buttonAction() {
		
	}
}
