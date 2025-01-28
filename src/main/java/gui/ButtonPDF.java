package gui;
/**<b>Кнопка вывода ПДФ</b>
 * @author Arslan Khusainov
 * класс основан на абстракции кнопки
 */
public final class ButtonPDF extends AbstractButton {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3193797860405517944L;
	/**Выпадающий список (тариф)*/
	private TarifChoosingCB zoneChoiceBox;
	/**Конструтор*/
	public ButtonPDF(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	@Override
	final protected void buttonAction() {
		new OutputFrame(this.zoneChoiceBox.getSelectedIndex());
	}
	/**Установка выпадающего списка (тариф)*/
	final public void setZCB(TarifChoosingCB inZCB) {
		this.zoneChoiceBox = inZCB;
	}
}
