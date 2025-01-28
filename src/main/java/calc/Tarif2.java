package calc;
/**<b>Калькулятор (двухзонный)</b>
 * @author Bayras Kadyrov
 * 
 */
public class Tarif2 extends Calc {
	/**Сумма*/
	private static double[] sum = {0, 0};
	//Константы
	//пояснение для нейминга констант: первая цифра после основного названия константы номер класса тарифа
	//вторая цифра номер переменной в самом классе
	//последня часть cheap принадлежность тарифа к сельской местности
	/**Дешевый тариф*/
	private static final double TARIF21cheap = 3.05;
	/**Дешевый тариф*/
	private static final double TARIF22cheap = 2.25;
	/**Дефолтный тариф*/
	private static final double TARIF21 = 4.35;
	/**Дефолтный тариф*/
	private static final double TARIF22 = 3.21;
	
	/**Рассчет*/
	final public double[] calcer(double ind1, double ind2,boolean hasGas, boolean fromCountry) {
		if (!hasGas ||fromCountry) {
			setBaseTarif(TARIF21cheap);
			sum[0] = calc(ind1);
			setBaseTarif(TARIF22cheap);
			sum[1] = calc(ind2);
		}
		else {
			setBaseTarif(TARIF21);
			sum[0] = calc(ind1);
			setBaseTarif(TARIF22);
			sum[1] = calc(ind2);
		}
		return sum;
		
	}
	@Override
	final public String toString() {
		double outSum = sum[0] + sum[1];
		return "Вы должны заплатить: " + outSum;
	}
	/**Получение результата*/
	final public static double[] getRes() {
		return sum;
	}
	
	
}
