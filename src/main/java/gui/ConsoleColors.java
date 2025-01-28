package gui;
/**<b>Цвета для конслоли</b>
 * @author Arslan Khusainov
 * 
 */
class ConsoleColors {
	/**Дефолтный цвет*/
	private static final String ANSI_RESET = "\u001B[0m";
	/**Красный цвет*/
	private static final String ANSI_RED = "\u001B[31m";
	/**Смена на дефолтный свет*/
	final public static String reset() {
		return ANSI_RESET;
	}
	/**Смена на красный цвет*/
	final public static String warning() {
		return ANSI_RED;
	}
}
