package maven_test;
/**<b>Кнопка вывода информации о разрабах</b>
 * @author Code Avengers
 * главный класс с точкой входа 
 */

import java.awt.GridLayout;
import java.io.File;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import gui.*;


public class Main extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5938851580172250685L;
	/**Кнопка "О нас"*/
	private ButtonAboutUs aboutUs;
	/**Кнопка рассчета*/
	private ButtonCalculate calcButton;
	/**Поля для ввода(день)*/
	private static MeasureTextField[] inElectroCountDay = {new MeasureTextField(), new MeasureTextField()};
	/**Поля для ввода(ночь)*/
	private static MeasureTextField[] inElectroCountNight = {new MeasureTextField(), new MeasureTextField()};
	/**Поля для ввода(полупик)*/
	private static MeasureTextField[] inElectroCountPike = {new MeasureTextField(), new MeasureTextField()};
	/**Лейблы вывода*/
	private JLabel[] outputLabelsTest;
	/**Выпадающий список (тариф)*/
	private TarifChoosingCB zoneChoiceBox;
	/**Кнопка выхода*/
	private ButtonExit exitButton;
	/**Выпадающий список (местность)*/
	private static TypeChoosingCB typeCB;
	/**Галочкка "есть газовая плита"*/
	private static JCheckBox hasGaz;
	/**Панели для компонентов*/
	private JPanel[] measuresPanels = new JPanel[3];
	/**Кнопка вывода pdfButton*/
	private ButtonPDF pdfButton;
	/**Конструктор*/
	public Main() {
		super("Калькулятор расчета размеры платы за электроснабжение");
		loadComponents();
	}
	/**Загрузка компонентов*/
	final private void loadComponents() {
		JPanel mainPanel = new JPanel(new GridLayout(7,2,20,20));
		JPanel buttonsLeftPanel = new JPanel(new GridLayout(1,2,10,0));
		JPanel settingsPanel = new JPanel(new GridLayout(3,1,5,0));
		JPanel buttonsRightPanel = new JPanel(new GridLayout(1,2,10,0));
		for (int i = 0; i < measuresPanels.length;i++) {
			measuresPanels[i] = new JPanel(new GridLayout(2,1,20,20));
		}
		measuresPanels[0].add(inElectroCountDay[0]);
		measuresPanels[0].add(inElectroCountDay[1]);
		measuresPanels[1].add(inElectroCountNight[0]);
		measuresPanels[1].add(inElectroCountNight[1]);
		measuresPanels[2].add(inElectroCountPike[0]);
		measuresPanels[2].add(inElectroCountPike[1]);
		mainPanel.setBounds(0,0,500,500);
		setBounds(500,500,500,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null);
		hasGaz = new JCheckBox("есть газовая плита");
		exitButton = new ButtonExit("Выход");
		pdfButton = new ButtonPDF("Подробнее");
		pdfButton.setVisible(false);
		zoneChoiceBox = new TarifChoosingCB();
		pdfButton.setZCB(zoneChoiceBox);
		typeCB = new TypeChoosingCB();
		JLabel dayLabel = new JLabel("<html>показания в дневной зоне:<br/>предыдущие/текщие</html>");
		JLabel nightLabel = new JLabel("<html>показания в ночной зоне:<br/>предыдущие/текщие</html>");
		JLabel pikeLabel = new JLabel("<html>показания в полупиковой зоне:<br/>предыдущие/текщие</html>");
		JLabel outputLabelRubles = new JLabel("");
		JLabel outputLabelKopeyks = new JLabel("");
		JLabel[] outputLabels = {outputLabelRubles, outputLabelKopeyks};
		outputLabelsTest = outputLabels;
		JLabel[] measureLabels = {dayLabel, nightLabel, pikeLabel};
		zoneChoiceBox.setLabels(measureLabels);
		mainPanel.add(dayLabel);
		settingsPanel.add(zoneChoiceBox);
		settingsPanel.add(typeCB);
		settingsPanel.add(hasGaz);
		mainPanel.add(settingsPanel);
		mainPanel.add(measuresPanels[0]);
		mainPanel.add(new JLabel("")); // TODO Убрать костыли
		mainPanel.add(nightLabel);
		mainPanel.add(new JLabel("")); // TODO Убрать костыли
		mainPanel.add(measuresPanels[1]);
		mainPanel.add(outputLabelRubles); 
		mainPanel.add(pikeLabel);
		mainPanel.add(outputLabelKopeyks); 
		mainPanel.add(measuresPanels[2]);
		mainPanel.add(new JLabel("")); // TODO Убрать костыли
		MeasureTextField[][] measures = {inElectroCountDay, inElectroCountNight, inElectroCountPike};
		calcButton = new ButtonCalculate("Расчитать");
		calcButton.setMeasures(measures);
		calcButton.setOutputLabels(outputLabels);
		calcButton.setCountryChoice(typeCB);
		calcButton.setHasGazCb(hasGaz);
		calcButton.setPDFButton(pdfButton);
		zoneChoiceBox.setMeasures(measures);
		zoneChoiceBox.update();
		aboutUs = new ButtonAboutUs("О нас");
		buttonsLeftPanel.add(exitButton);
		buttonsLeftPanel.add(aboutUs);
		mainPanel.add(buttonsLeftPanel); 
		calcButton.setZoneChoice(zoneChoiceBox);
		buttonsRightPanel.add(pdfButton);
		buttonsRightPanel.add(calcButton);
		mainPanel.add(buttonsRightPanel);
		add(mainPanel);
		repaint();
		pack();
	}
	/**Точка входа*/
	public static void main(String[] args) {
		new Main();
	}
	final public boolean isNumeric(String str) { 
		  try {  
		    Double.parseDouble(str);
		    return true;
		  } catch(NumberFormatException e){  
		    return false;  
		  }  
		}
	
	/**Дешевый тариф*/
	final public static boolean chipTarif() {
		return (!hasGaz.isSelected() || typeCB.getSelectedIndex()==1);
	}
	/**Получение полей ввода(строк)*/
	final public static String[] getMeasures() {
		String[] res = {inElectroCountDay[0].getText(), inElectroCountDay[1].getText(),
				inElectroCountNight[0].getText(), inElectroCountNight[1].getText(),
				inElectroCountPike[0].getText(), inElectroCountPike[1].getText()};
		return res;
		
	}
	/**Получение строк лейблов вывода*/
	final public String[] getOutputLabels() {
		String[] res = {outputLabelsTest[0].getText(), outputLabelsTest[1].getText()};
		return res;
	}
	/**Нажатие кнопки рассчета через код*/
	final public void buttonCalculateClick() {
		calcButton.doClick();
	}
	/**Установка значений полей ввода*/
	final public void setMeasure(String measure, int measureField) {
		switch (measureField) {
		case 0:
			inElectroCountDay[0].setText(measure);
			break;
		case 1:
			inElectroCountDay[1].setText(measure);
			break;
		case 2:
			inElectroCountNight[0].setText(measure);
			break;
		case 3:
			inElectroCountDay[1].setText(measure);
			break;
		case 4:
			inElectroCountPike[0].setText(measure);
			break;
		case 5:
			inElectroCountPike[1].setText(measure);
			break;
		}
		
	}	
	/**Нажатие на кнопку ПДФ через код*/
	final public void pdfButtonClick() {
		if (pdfButton.isVisible()) {
			pdfButton.doClick();
		}
	}
	/**Проверка на наличие файла*/
	final public boolean isFileExists(String fileName) {
		File f = new File(fileName);
		return (f.exists() && !f.isDirectory());
	}
}

