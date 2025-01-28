package gui;
/**<b>Абстракция поля ввода</b>
 * @author Arslan Khusainov
 * класс основан на JTextField
 */
import javax.swing.JTextField;

abstract class AbstractTextField extends JTextField {
	private static final long serialVersionUID = -8003722859238827075L;
	/**
	 * Конструктор
	 * */
	protected AbstractTextField() {
		super();
	}
	/**
	 * Проверка строки на число
	 * */
	final protected boolean isTextNumeric() { 
		  try {  
		    Double.parseDouble(this.getText());  
		    return true;
		  } catch(NumberFormatException e){  
		    return false;  
		  }  
		}
	/**
	 * Проверка правильности строки
	 * */
	public boolean isCorrectString() {
		return true;
	}
	
}
