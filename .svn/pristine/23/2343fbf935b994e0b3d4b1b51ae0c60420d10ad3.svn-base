package cucumber_test;

import maven_test.Main;
import pdf.ListenerPDF;
import io.cucumber.java.ru.Допустим;
import io.cucumber.java.ru.Тогда;

public class PdfTest {
	Main app; 
	@SuppressWarnings("deprecation")
	@Допустим("клиент запускает программу")
	public void клиент_запускает_программу() {
	   app = new Main();
	   app.hide();
	}

	@Допустим("клиент правильно вводит все значения")
	public void клиент_правильно_вводит_все_значения() {
	    app.setMeasure("1", 0);
	    app.setMeasure("2", 1);
	}

	@Допустим("он нажимет на кнопку рассчета")
	public void он_нажимет_на_кнопку_рассчета() {
	   app.buttonCalculateClick();
	   
	}

	@Допустим("настраивает вывод в PDF")
	public void настраивает_вывод_в_pdf() {
		ListenerPDF.setIsTest(true);
	    ListenerPDF.createPDF(0);
	}

	@Тогда("PDF создастся")
	public void pdf_создастся() {
	   app.isFileExists("Document");
	}
}
