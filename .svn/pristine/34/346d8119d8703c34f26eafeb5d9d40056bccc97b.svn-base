package gui;
/**<b>Кнопка вывода информации о разрабах</b>
 * @author Arslan Khusainov
 * класс основана на абстракции выпадающего списка
 */
import javax.swing.*;

public final class TarifChoosingCB extends AbstractCombobox {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1591059774485336432L;
	/**Поля ввода*/
	private MeasureTextField[][] measures;
	/**Лейблы полей ввода*/
	private JLabel[] measureLabels;
	/**Проверка на создание списка*/
	private boolean isCreated = false;
	public TarifChoosingCB() {
		addItem("Однозонный тариф");
		addItem("Двухзонный тариф");
		addItem("Трехзонный тариф");
		isCreated = true;
	}
	/**Установка полей ввода*/
	public void setMeasures(MeasureTextField[][] measures) {
		this.measures = measures;
	}
	/**Установка лейблов полей ввода*/
	public void setLabels(JLabel[] measureLabels) {
		this.measureLabels = measureLabels;
	}
	/**Обновление для отрисовки*/
	public void update() {
		cbAction();
	}
	@Override
	final protected void cbAction() {
		if (!isCreated) {
			return;
		}
		if (this.measures==null) {
			warningMsg("WARNING(TarifChoosingCB): Measure Fields Are Not Set");
			return;
		}
		if (this.measureLabels==null) {
			warningMsg("WARNING(TarifChoosingCB): Measure Labels ComboBox Is Not Set");
			return;
		}
		int counter = this.getSelectedIndex() + 1;
		while (counter > 0) {
			measures[counter-1][0].setVisible(true);
			measures[counter-1][1].setVisible(true);
			measureLabels[counter-1].setVisible(true);
			counter -= 1;
		}
		for (int i = this.getSelectedIndex() + 1; i <= 2;i++) {
			measures[i][0].setVisible(false);
			measures[i][1].setVisible(false);
			measureLabels[i].setVisible(false);
		}
		
	}
	/**Предупреждение*/
	private void warningMsg(String msg) {
		System.out.println(ConsoleColors.warning()+msg+ConsoleColors.reset());
	}
}
