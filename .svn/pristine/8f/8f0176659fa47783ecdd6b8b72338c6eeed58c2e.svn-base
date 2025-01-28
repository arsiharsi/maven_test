package cucumber_test;

import static org.junit.Assert.assertEquals;

import io.cucumber.java.ru.Допустим;
import io.cucumber.java.ru.Тогда;
import maven_test.Main;

public class MainFrameFirstTarifSuccesTest {
	Main app;
	@SuppressWarnings("deprecation")
	@Допустим("пользователь открывает приложение")
	public void пользователь_открывает_приложение() {
	    app = new Main();
	    app.hide();;
	}
	@Допустим("Пользователь вводит {string} в предыдущие показания")
	public void пользователь_вводит_в_предыдущие_показания(String string) {
	    app.setMeasure(string, 0);;
	}
	@Допустим("Пользователь вводит {string} в текущие показаний")
	public void пользователь_вводит_в_текущие_показаний(String string) {
		app.setMeasure(string, 1);
	}
	@Допустим("Пользователь нажимает на кнопку расчета")
	public void пользователь_нажимает_на_кнопку_расчета() {
		app.buttonCalculateClick();;
	}
	@Тогда("на экран выведет {string} и {string}")
	public void на_экран_выведет_и(String string, String string2) {
	    assertEquals(app.getOutputLabels()[0]+app.getOutputLabels()[1], string+string2);
	}
}
