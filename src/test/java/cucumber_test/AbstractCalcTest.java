package cucumber_test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

import calc.Calc;
import calc.Tarif1;
import io.cucumber.java.ru.Допустим;
import io.cucumber.java.ru.Тогда;

public class AbstractCalcTest {
	
	Calc calc = new Tarif1();
	double res;

	@Test
	public void testCalc() {
		Calc mockedApp = mock(Calc.class);
		mockedApp.setBaseTarif(2);
		when(mockedApp.calc(1)).thenReturn(2.0);
		when(mockedApp.calc(3)).thenReturn(6.0);
		assertEquals(mockedApp.calc(1), 2, 0.0);
		assertEquals(mockedApp.calc(3), 6, 0.0);
		
	}
	@Допустим("мы задаём ставку {int}")
	public void мы_задаём_ставку(Integer int1) {
		calc.setBaseTarif(int1);
	}

	@Допустим("передаём показания {int}")
	public void передаём_показания(Integer int1) {
		res = calc.calc(int1);
	}

	@Тогда("калькулятор вернёт значение {double}")
	public void калькулятор_вернёт_значение(Double double1) {
		assertEquals(res, double1, 0.0);
	}

}
