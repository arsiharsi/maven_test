package cucumber_test;

import static org.junit.Assert.assertEquals;

import calc.Tarif1;
import calc.Tarif2;
import calc.Tarif3;
import io.cucumber.java.ru.Допустим;
import io.cucumber.java.ru.Тогда;

public class FirstCalcTest {
	Tarif1 T1 = new Tarif1();
	Tarif2 T2  = new Tarif2();
	Tarif3 T3  = new Tarif3();
	int ind1;
	boolean isSelo; 
	boolean hasGas = false;
	int ind2;
	double res;
	int ind3;
	
	@Допустим("идёт рассчёт одного кВт")
	public void идёт_рассчёт_одного_к_вт() {
	    ind1 = 1;
	}

	@Допустим("рассчёт для сельской местности")
	public void рассчёт_для_сельской_местности() {
		isSelo = true;
	}

	@Тогда("калькулятор вернёт значение {double} копейка")
	public void калькулятор_вернёт_значение_копейка(Double double1) {
		assertEquals(res, double1, 0.1);
		
	}
	@Допустим("рассчёт для города")
	public void рассчёт_для_города() {
	    isSelo = false;
	}

	@Допустим("есть газовая плита")
	public void есть_газовая_плита() {
	    hasGas = true;
	}
	@Допустим("нет газовой плиты")
	public void нет_газовой_плиты() {
	    hasGas = false;
	}
	@Допустим("идёт рассчёт одного кВт \\(ночной)")
	public void идёт_рассчёт_одного_к_вт_ночной() {
		ind2 = 1;
	}
	@Допустим("калькулятор вычислил \\(двухзонный)")
	public void калькулятор_вычислил_двухзонный() {
	    double[] preRes = T2.calcer(ind1, ind2, hasGas, isSelo);
	    res = preRes[0] + preRes[1];
	}
	@Допустим("калькулятор вычислил \\(однозонный)")
	public void калькулятор_вычислил_однозонный() {
		res = T1.calcer(ind1, hasGas, isSelo);
	}

	@Допустим("идёт рассчёт одного кВт \\(полупик)")
	public void идёт_рассчёт_одного_к_вт_полупик() {
		ind3 = 1;
	}
	
	@Допустим("калькулятор вычислил \\(трёхзонный)")
	public void калькулятор_вычислил_трёхзонный() {
	    double[] preRes = T3.calcer(ind1, ind2, ind3, hasGas, isSelo);
	    res = preRes[0] + preRes[1] + preRes[2];
	}
	
	
}
