package gui;
/**<b>Кнопка расчета</b>
 * @author Arslan Khusainov
 * класс основан на абстракции кнопки
 */
import javax.swing.*;

import calc.*;


public final class ButtonCalculate extends AbstractButton {
	/**Поля для ввода*/
	private MeasureTextField[][] measures;
	/**Выпадающий список выбора местности*/
	private JComboBox<String> countryChoice;
	/**Выпадающий список выбора тарифа*/
	private JComboBox<String> zoneChoice;
	/**Кнопка для вывода ПДФ*/
	private JButton pdfButton;
	/**Метка "Есть газовая плита"*/
	private JCheckBox hasGazCB;
	/**Лейблы вывода*/
	private JLabel[] outputLabels;
	/**Тариф числом*/
	private static int tarif;
	private static final long serialVersionUID = -5612525072357149168L;
	/**Констркутор*/
	public ButtonCalculate(String name) {
		super(name);
	}
	@Override
	final protected void buttonAction() {
		if (this.measures==null) {
			warningMsg("WARNING(ButtonCalculate): Measure Fields Are Not Set");
			return;
		}
		if (this.zoneChoice==null) {
			warningMsg("WARNING(ButtonCalculate): Zone Choice ComboBox Is Not Set");
			return;
		}
		if (this.outputLabels==null) {
			warningMsg("WARNING(ButtonCalculate): Output Labels Are Not Set");
			return;
		}
		if (this.countryChoice==null) {
			warningMsg("WARNING(ButtonCalculate): Country Choice ComboBox Is Not Set");
			return;
		}
		if (this.hasGazCB==null) {
			warningMsg("WARNING(ButtonCalculate): Has Gaz CheckBox Is Not Set");
			return;
		}
		if (this.pdfButton==null) {
			warningMsg("WARNING(ButtonCalculate): PDF Button Is Not Set");
			return;
		}
		boolean isAllMCorrect = true;
		for (int i = 0; i <= this.zoneChoice.getSelectedIndex(); i++) {
			if (!this.measures[i][0].isCorrectString() || !this.measures[i][1].isCorrectString() || (measures[i][1].getValue()-measures[i][0].getValue() < 0)) {
				this.measures[i][0].setText("");
				this.measures[i][1].setText("");
				isAllMCorrect = false;
			}
		}
		if (!isAllMCorrect) {
			this.outputLabels[0].setText("Неверный формат ввода данных");
			this.outputLabels[1].setText("");
			pdfButton.setVisible(false);
			return;	
		}else {
			pdfButton.setVisible(true);
		}
		Tarif1 t1 = new Tarif1();
		Tarif2 t2 = new Tarif2();
		Tarif3 t3 = new Tarif3();
		
		if(this.zoneChoice.getSelectedIndex() == 0) {
			double result = t1.calcer(measures[0][1].getValue()-measures[0][0].getValue(), this.hasGazCB.isSelected(), this.countryChoice.getSelectedIndex()==1);
			this.outputLabels[0].setText((int)result+" р.");
			this.outputLabels[1].setText((int)(result*100%100)+" к.");
			tarif = 0;
			
		};
		if(this.zoneChoice.getSelectedIndex() == 1) {
			double[] preResult = t2.calcer(measures[0][1].getValue()-measures[0][0].getValue(), measures[1][1].getValue()-measures[1][0].getValue(), this.hasGazCB.isSelected(), this.countryChoice.getSelectedIndex()==1);
			double result = preResult[0]+preResult[1];
			this.outputLabels[0].setText((int)result+" р.");
			this.outputLabels[1].setText((int)(result*100%100)+" к.");
			tarif = 1;
		};
		if(this.zoneChoice.getSelectedIndex() == 2) {
			double[] preResult = t3.calcer(measures[0][1].getValue()-measures[0][0].getValue(), measures[1][1].getValue()-measures[1][0].getValue(),measures[2][1].getValue()-measures[2][0].getValue(),  this.hasGazCB.isSelected(), this.countryChoice.getSelectedIndex()==1);
			double result = preResult[0]+preResult[1]+preResult[2];
			this.outputLabels[0].setText((int)result+" р.");
			this.outputLabels[1].setText((int)(result*100%100)+" к.");
			tarif = 2;
		};
		
		System.out.println(zoneChoice.getSelectedItem());
		
	}
	/**Установка полей ввода*/
	public void setMeasures(MeasureTextField[][] inMeasures) {
		this.measures = inMeasures;
	}
	/**Установка лейблов вывода*/
	public void setOutputLabels(JLabel[] inLabels) {
		this.outputLabels = inLabels;
	}
	/**Установка выпадающего списка (выбор тарифа)*/
	public void setZoneChoice(JComboBox<String> inZC) {
		zoneChoice = inZC;
	}
	/**Возвращение текущего тарифа*/
	public static int getTarif(){
		return tarif;
	}
	/**Установка выпадающего списка (выбор местности)*/
	public void setCountryChoice(JComboBox<String> inCC) {
		this.countryChoice = inCC;
	}
	/**Установка метки галочки газовой плиты*/
	public void setHasGazCb(JCheckBox inHasGazCB) {
		this.hasGazCB = inHasGazCB;
	}
	/**Установки кнопки вывода ПДФ*/
	public void setPDFButton(ButtonPDF inButton) {
		pdfButton = inButton;
	}
	/**Предупреждение*/
	private void warningMsg(String msg) {
		System.out.println(ConsoleColors.warning()+msg+ConsoleColors.reset());
	}
}
