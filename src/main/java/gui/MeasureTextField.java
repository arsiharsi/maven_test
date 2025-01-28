package gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**<b>Поле для ввода данных</b>
 * @author Arslan Khusainov
 * класс основан на абстракции поля ввода
 */
public final class MeasureTextField extends AbstractTextField {
	private static final long serialVersionUID = -7327702572579790412L;
	/**Конструктор*/
	public MeasureTextField() {
		super();
		addKeyListener(new KeyListener() {
		    public void keyTyped(KeyEvent e) { 
		        if (getText().length() >= 5 ) // limit textfield to 3 characters
		            e.consume(); 
		    }

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}  
		});
	}
	@Override
	final public boolean isCorrectString() {
		if (this.isTextNumeric()) {
			return this.getValue()>=0;
		}
		return false;
	}
	/**Получение значения*/
	final public double getValue() {
		if (this.isTextNumeric()) {
			return Double.parseDouble(this.getText());
		}
		return 0;
	}
}
