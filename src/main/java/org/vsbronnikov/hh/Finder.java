package org.vsbronnikov.hh;

/**
 * Поиск первого вхождения заданной последовательности A в бесконечной
 * последовательности S.
 * 
 * @author VBronnikov
 *
 */
public class Finder {

	/**
	 * Объект, хранящий обрабатываемую часть последовательности.
	 */
	private StringBuilder sb;

	/**
	 * Позиция искомой строки в заданной бесконечной последовательности.
	 */
	private long result = 0;

	/**
	 * Флаг готовности результата поиска.
	 */
	private boolean done = false;

	/**
	 * Заданная последовательность A. Инициализируется конструктором.
	 */
	private final String searchString;

	/**
	 * Длина заданной последовательности A. Инициализируется конструктором. Не
	 * изменяется, используется в алгоритмах поиска.
	 */
	private final int searchStringLength;

	/**
	 * Первый символ заданной последовательности A. Инициализируется
	 * конструктором. Не изменяется, используется в алгоритмах поиска.
	 */
	private final String searchStringFirst;

	/**
	 * Позиция символа в цикле поиска по заданной последовательности A.
	 */
	private int searchStringPosition = 0;

	public Finder(String searchString) {

		this.sb = new StringBuilder();

		this.searchString = searchString;
		this.searchStringLength = searchString.length();
		this.searchStringFirst = searchString.substring(0, 1);
	}

	public void find(String str) {

		if (this.done) {
			// Не делаем обработку, если результат уже получен.
			return;
		}

		sb.append(str); // склеиваем строки

		do {
			if (this.searchStringPosition == 0) {
				int index = sb.indexOf(this.searchStringFirst);

				// Если количество символов в последовательности A = 1
				// и мы нашли этот символ, то завершаем работу.
				if (index != -1 && this.searchStringLength == 1) {
					this.done = true;
					break;
				}

				int count = (index == -1) ? sb.length() : index;

				this.searchStringPosition = (index == -1) ? 0 : 1;
				this.result += count;

				// Обрезаем строку слева, она нам больше не нужна.
				sb.delete(0, count);
			}

			for (int i = this.searchStringPosition; i < this.searchStringLength; i++) {
				// Необходим следующий элемент бесконечной последовательности S.
				// Сохраняем позицию в последовательности A.
				if (sb.length() <= i) {
					this.searchStringPosition = i;
					return;
				}

				// Наткнулись в последовательности S на символ не из
				// последовательности A.
				// Сбрасываем позицию, увеличиваем результат, обрезаем строку
				// слева.
				if (this.searchString.charAt(i) != sb.charAt(i)) {
					this.searchStringPosition = 0;
					this.result += i;

					sb.delete(0, i);
					break;
				}

				// Позиция найдена.
				if (i == this.searchStringLength - 1) {
					this.done = true;
				}
			}
		} while (!this.done);
	}

	public long getResult() {

		return this.done ? this.result + 1 : 0; // + 1 - т.к. нумерация начинается с 1
	}

	public boolean isDone() {
		return this.done;
	}
}
