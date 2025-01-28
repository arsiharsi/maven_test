package pdf;
/**<b>Вывод в Пдф</b>
 * @author Kolpashnikova Sofia
 * 
 */


import java.io.IOException;


import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.BaseFont;

import calc.*;
import create.CreatePDF;


import gui.OutputFrame;
import maven_test.Main;

import java.net.URL;

public class ListenerPDF {
	/**Для тестинга*/
	private static boolean isTest = false;
	/**Установка для тестинга*/
	public static void setIsTest(boolean val) {
		isTest = true;
	}
	/**Формирование ПДФ*/
	public static void createPDF(int tarif) {
		
		String[][] NameCell = new String[3][6];;
		String[] Hat = new String[6];
		JTextField[] fields = OutputFrame.getFields();
		String[] res = Main.getMeasures();
		double result = 0; 
		//
		
		if (tarif == 0) {
			if (Main.chipTarif()) {
				NameCell[0][4]="2.81 руб/КВт";
			}
			else {
				NameCell[0][4]="4.01 руб/КВт";
			}
			double out = Tarif1.getRes();
			NameCell[0][0]="         1";
			NameCell[0][1]="ДЕНЬ(Т1)";
			NameCell[0][2]=res[0];
			NameCell[0][3]=res[1];
			
			NameCell[0][5]=String.format("%.2f",out);
			result = out;
		}
		if (tarif == 1) {
			
			if (Main.chipTarif()) {
				NameCell[0][4]="3.05 руб/КВт";
				NameCell[1][4]="2.25 руб/КВт";
			}
			else {
				NameCell[0][4]="4.35 руб/КВт";
				NameCell[1][4]="3.21 руб/КВт";
			}
			
			double[] out = Tarif2.getRes();
			
			NameCell[0][0]="         1";
			NameCell[0][1]="ДЕНЬ(Т1)";
			NameCell[0][2]=res[0];
			NameCell[0][3]=res[1];
			
			NameCell[0][5]=String.format("%.2f",out[0]);
			
			NameCell[1][0]="         2";
			NameCell[1][1]="НОЧЬ(Т2)";
			NameCell[1][2]=res[2];
			NameCell[1][3]=res[3];
			
			NameCell[1][5]=String.format("%.2f",out[1]);
			result = out[0] + out[1];
					
		}
		if (tarif == 2) {
			
			if (Main.chipTarif()) {
				NameCell[0][4]="3.45 руб/КВт";
				NameCell[1][4]="2.81 руб/КВт";
				NameCell[2][4]="2.25 руб/КВт";
			}
			else {
				NameCell[0][4]="4.93 руб/КВт";
				NameCell[1][4]="4.01 руб/КВт";
				NameCell[2][4]="3.21 руб/КВт";
			}
			
			double[] out = Tarif3.getRes();
			
			NameCell[0][0]="         1";
			NameCell[0][1]="ПИК(Т1)";
			NameCell[0][2]=res[0];
			NameCell[0][3]=res[1];
			
			NameCell[0][5]=String.format("%.2f",out[0]);
			
			NameCell[1][0]="         2";
			NameCell[1][1]="ПОЛУПИК(Т3)";
			NameCell[1][2]=res[4];
			NameCell[1][3]=res[5];
			
			NameCell[1][5]=String.format("%.2f",out[1]);
			
			NameCell[2][0]="         3";
			NameCell[2][1]="НОЧЬ(Т2)";
			NameCell[2][2]=res[2];
			NameCell[2][3]=res[3];
			
			NameCell[2][5]=String.format("%.2f",out[2]);
			result =out[0] + out[1] + out[2];
		}

		Hat[0]="Код платежа";
		Hat[1]="Тарифная зона";
		Hat[2]="Показания счетчика предыдущее";
		Hat[3]="Показания сетчика текущее";
		Hat[4]="Тариф";
		Hat[5]="Сумма к оплате (руб)";
		
		String Texthat = " Калькулятор расчета размеры платы за электроснабжение ";
		String Textgeneral = "Получатель платежа: ООО «Энергетическя сбытовая компания Башкортостана»: \n"
				+ "ИНН 0275038496 \n р/с 40702810200250303660 \n"
				 + "ф-л банк ГПБ (АО)в г. Уфе БИК 048073928"
				+ " КПП 027801001s \n к/с 30101810300000000928";
	
		String TextFirst;
		String TextSecond;
		String TextTable;
		if (!isTest) {
			System.out.println(" 21"+ fields[0].getText().equals(""));
		}
		
		if (!isTest) {
			TextFirst = "Номер лицевого счета: " + fields[0].getText();
			TextSecond = "Адрес: " + fields[1].getText();
			TextTable = "Ф.И.О.: " + fields[2].getText();
		}else {
			TextFirst = "Номер лицевого счета " + "12345673211";
			TextSecond = "Адрес: " + "Г.Уфа ул. есть д. нет";
			TextTable = "Ф.И.О.: " + "Иванов Иван Иванович";
		}
		String Namefile = "Отчёт о расчётах.pdf";
		BaseFont times = null;
		try {
			times = BaseFont.createFont("/fonts/times.ttf", "cp1251", BaseFont.EMBEDDED);
		} catch (DocumentException e2) {
			e2.printStackTrace();
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		
		URL image = ListenerPDF.class.getResource("/picture/code avengers.png");
		
		CreatePDF pdf = new CreatePDF(Namefile,times);
		Document document = pdf.getDocument();
		pdf.addText(document, Texthat, 20,true);
		pdf.addPicture(image, document, 725, 475);
		pdf.addText(document, Textgeneral, 14,true);
		pdf.addText(document, TextFirst, 14,true);
		pdf.addText(document, TextSecond, 14,true);
		pdf.addText(document, TextTable, 14, true);
		pdf.InitTableAndAddHat(document,Hat);
		pdf.addRowsInTable(pdf.getTable(), NameCell);
		pdf.addTable(document,pdf.getTable());
		//pdf.addText(document, TextNext, 14,true);
		//pdf.addPicture(Imagelink, document, 90, 400);
		pdf.addText(document, " ", 14, true);
		//pdf.addText(document, " Подпись абонента:", 14, true);
		pdf.addText(document, " Подпись абонента:                                                                                                                             Итого к оплате: " + String.format("%.2f",result), 14, true);
		pdf.getClose();
		
		if (!isTest) {
			JOptionPane.showMessageDialog(null, "Подробные данные можно посмортеть в файле "
					 + Namefile,"Create PDF", JOptionPane.PLAIN_MESSAGE);
		}
		
	}
}
