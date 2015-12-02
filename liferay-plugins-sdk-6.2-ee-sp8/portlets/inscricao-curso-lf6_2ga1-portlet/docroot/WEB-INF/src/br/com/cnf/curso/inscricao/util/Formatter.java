package br.com.cnf.curso.inscricao.util;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Formatter {

	private static final char[] DIGITS = { '0', '1', '2', '3', '4', '5', '6',
			'7', '8', '9' };
	private static final char[] CNPJ = { '0', '0', '.', '0', '0', '0', '.',
			'0', '0', '0', '/', '0', '0', '0', '0', '-', '0', '0' };
	private static final char[] CPF = { '0', '0', '0', '.', '0', '0', '0', '.',
			'0', '0', '0', '-', '0', '0' };

	public static final String SPACE = " ";
	public static final String EMPTY = "";

	public Formatter() {
	}

	/**
	 * Retorna a representação em string do objeto. Caso o objeto seja igual a
	 * null, retorna uma string vazia.
	 * 
	 * @return representação em string do objeto.
	 * @param object
	 *            o objeto que se deseja ter a representação em string.
	 */
	public static String toString(Object object) {
		if (object != null) {
			return object.toString();
		}

		return EMPTY;
	}

	/**
	 * Insere caracteres do mesmo tipo no final de uma String até que esta
	 * atinja um determinado tamanho.
	 * 
	 * @param input
	 *            String original.
	 * @param c
	 *            caracter a ser inserido.
	 * @param length
	 *            tamanho total a ser atinjido.
	 * @return o novo valor para a string original.
	 * @since versão 1.0
	 */
	public static String fillRight(String input, char c, int length) {
		StringBuffer output;
		if (input != null) {
			if (input.length() >= length) {
				return input;
			}
			output = new StringBuffer(input);
			output.ensureCapacity(length);
		} else {
			output = new StringBuffer(length);
		}

		while (output.length() < length) {
			output.append(c);
		}
		return output.toString();
	}

	/**
	 * Ajusta o tamanho do campo para o especificado inserindo caracteres no
	 * final até que esta atinja um determinado tamanho. Caso o string seja
	 * maior que o tamanho especificado irá ser truncado a direita.
	 * 
	 * @param input
	 *            String original.
	 * @param c
	 *            caracter a ser inserido.
	 * @param length
	 *            tamanho total a ser atinjido.
	 * @return o novo valor para a string original.
	 * @since versão 1.0
	 */
	public static String truncateRight(String input, char c, int length) {
		StringBuffer output;
		if (input != null) {
			if (input.length() >= length) {
				return input.substring(0, length);
			}
			output = new StringBuffer(input);
			output.ensureCapacity(length);
		} else {
			output = new StringBuffer(length);
		}

		while (output.length() < length) {
			output.append(c);
		}

		return output.toString();
	}

	/**
	 * Ajusta o tamanho do campo para o especificado inserindo caracteres no
	 * início até que esta atinja um determinado tamanho. Caso o string seja
	 * maior que o tamanho especificado irá ser truncado a esquerda.
	 * 
	 * @param input
	 *            String original.
	 * @param c
	 *            caracter a ser inserido.
	 * @param length
	 *            tamanho total a ser atinjido.
	 * @return o novo valor para a string original.
	 * @since versão 1.0
	 */
	public static String truncateLeft(String input, char c, int length) {
		int temp = length;
		if (input != null) {
			temp -= input.length();
			if (temp <= 0) {
				return input.substring(Math.abs(temp));
			}
		}

		StringBuffer output = new StringBuffer(length);

		while (output.length() < temp) {
			output.append(c);
		}

		output.append(input);
		output.delete(0, output.length() - length);

		return output.toString();
	}

	/**
	 * Insere caracteres do mesmo tipo no início de uma String até que esta
	 * atinja um determinado tamanho.
	 * 
	 * @param input
	 *            String original.
	 * @param c
	 *            caracter a ser inserido.
	 * @param length
	 *            tamanho total a ser atinjido.
	 * @since versão 1.0
	 */
	public static String fillLeft(String input, char c, int length) {
		int temp = length;
		if (input != null) {
			temp -= input.length();
			if (temp <= 0) {
				return input;
			}
		}

		StringBuffer output = new StringBuffer(length);

		while (output.length() < temp) {
			output.append(c);
		}
		output.append(input);
		return output.toString();
	}

	/**
	 * Converte filtra os caracteres acentos e afins.
	 * 
	 * @param str
	 *            String a ser filtrado
	 * @return String filtrado.
	 */
	public static String filter(String str) {
		return filter(str, false);
	}

	/**
	 * Filtra os caracteres de acentos e afins.
	 * 
	 * @param str
	 *            String a ser filtrado.
	 * @param uppercase
	 *            Se <code>true</code>Coloca os caracteres em uppercase.
	 * @return String filtrado.
	 */
	public static String filter(String str, boolean uppercase) {
		char old[] = uppercase ? str.toUpperCase().toCharArray() : str
				.toCharArray();
		char result[] = new char[old.length];
		int _1st = 0;
		int size = 0;
		boolean isClean = true;

		loop: for (; _1st < old.length; _1st++) {
			char c = old[_1st];
			if (((c < 32 || c > 93) || (c < 97 || c > 122))
					&& (c != 123 && c != 125)
					|| (c == 38 || c == 39 || c == 44)) {
				isClean = false;
				break loop;
			}
		}
		if (isClean)
			return str;

		System.arraycopy(old, 0, result, 0, _1st);
		size = _1st;

		if (size == old.length)
			return new String(result, 0, size);

		_2nd_loop: for (int i = size; i < old.length; i++) {
			char c = old[i];
			if (((c < 32 || c > 93) || (c < 97 || c > 122))
					&& (c != 123 && c != 125)
					|| (c == 38 || c == 39 || c == 44)) {
				switch (c) {
				case 192:
				case 193:
				case 194:
				case 195:
				case 196:
				case 197:
					result[size] = 'A';
					size++;
					continue _2nd_loop;
				case 224:
				case 225:
				case 226:
				case 227:
				case 228:
				case 229:
					result[size] = 'a';
					size++;
					continue _2nd_loop;
				case 200:
				case 201:
				case 202:
				case 203:
					result[size] = 'E';
					size++;
					continue _2nd_loop;
				case 232:
				case 233:
				case 234:
				case 235:
					result[size] = 'e';
					size++;
					continue _2nd_loop;
				case 204:
				case 205:
				case 206:
				case 207:
					result[size] = 'I';
					size++;
					continue _2nd_loop;
				case 236:
				case 237:
				case 238:
				case 239:
					result[size] = 'i';
					size++;
					continue _2nd_loop;
				case 210:
				case 211:
				case 212:
				case 213:
				case 214:
					result[size] = 'O';
					size++;
					continue _2nd_loop;
				case 242:
				case 243:
				case 244:
				case 245:
				case 246:
					result[size] = 'o';
					size++;
					continue _2nd_loop;
				case 217:
				case 218:
				case 219:
				case 220:
					result[size] = 'U';
					size++;
					continue _2nd_loop;
				case 249:
				case 250:
				case 251:
				case 252:
					result[size] = 'u';
					size++;
					continue _2nd_loop;
				case 199:
					result[size] = 'C';
					size++;
					continue _2nd_loop;
				case 231:
					result[size] = 'c';
					size++;
					continue _2nd_loop;
				case 209:
					result[size] = 'N';
					size++;
					continue _2nd_loop;
				case 241:
					result[size] = 'n';
					size++;
					continue _2nd_loop;
				case 352:
					result[size] = 'S';
					size++;
					continue _2nd_loop;
				case 221:
				case 376:
					result[size] = 'Y';
					size++;
					continue _2nd_loop;
				case 253:
				case 255:
					result[size] = 'y';
					size++;
					continue _2nd_loop;
				case 381:
					result[size] = 'Z';
					size++;
					continue _2nd_loop;
				case 95:
					result[size] = 45;
					size++;
					continue _2nd_loop;
					/*
					 * default: result[i] = ' '; size++; continue _2nd_loop;
					 */
				}
			}
			result[i] = c;
			size++;
		}

		return new String(result, 0, size);
	}

	/**
	 * Converte um número inteiro no formato int para uma String contendo uma
	 * quantidade fixa de dígitos.
	 * <p>
	 * <font color="red">IMPORTANTE:</font> Caso o número seja maior o mesmo
	 * será truncado.
	 * 
	 * @param number
	 *            número no formato int a ser convertido.
	 * @param length
	 *            quantidade de dígitos do número após a conversão.
	 * @return texto referente ao número com o tamanho especificado.
	 */
	public static String format(int number, int length) {
		return format((long) number, length);
	}

	/**
	 * Converte um número inteiro no formato long para uma String contendo uma
	 * quantidade fixa de dígitos.
	 * <p>
	 * <font color="red">IMPORTANTE:</font> Caso o número seja maior o mesmo
	 * será truncado.
	 * 
	 * @param number
	 *            número no formato long a ser convertido.
	 * @param length
	 *            quantidade de dígitos do número após a conversão.
	 * @return texto referente ao número com o tamanho especificado.
	 */
	public static String format(long number, int length) {
		char[] result = new char[length];

		int pos = length;
		while (pos > 0) {
			result[--pos] = DIGITS[(int) (number % 10)];
			number /= 10;
		}

		return new String(result);
	}

	/**
	 * Formata um número inteiro no formato byte para uma String conforme
	 * parâmetros.
	 * 
	 * @param number
	 *            número no formato byte a ser convertido.
	 * @param milhar
	 *            caso se deseje que seja colocado o separador de milhar.
	 * @return texto referente ao número conforme especificado.
	 */
	public static String format(byte number, boolean milhar) {
		// formata o número desejado.
		return format((long) number, milhar);
	}

	/**
	 * Formata um número inteiro no formato short para uma String conforme
	 * parâmetros.
	 * 
	 * @param number
	 *            número no formato short a ser convertido.
	 * @param milhar
	 *            caso se deseje que seja colocado o separador de milhar.
	 * @return texto referente ao número conforme especificado.
	 */
	public static String format(short number, boolean milhar) {
		// formata o número desejado.
		return format((long) number, milhar);
	}

	/**
	 * Formata um número inteiro no formato int para uma String conforme
	 * parâmetros.
	 * 
	 * @param number
	 *            número no formato int a ser convertido.
	 * @param milhar
	 *            caso se deseje que seja colocado o separador de milhar.
	 * @return texto referente ao número conforme especificado.
	 */
	public static String format(int number, boolean milhar) {
		// formata o número desejado.
		return format((long) number, milhar);
	}

	/**
	 * Formata um número inteiro no formato long para uma String conforme
	 * parâmetros.
	 * 
	 * @param number
	 *            número no formato long a ser convertido.
	 * @param milhar
	 *            caso se deseje que seja colocado o separador de milhar.
	 * @return texto referente ao número conforme especificado.
	 */
	public static String format(long number, boolean milhar) {
		// recupera o formatador de números.
		NumberFormat formatter = NumberFormat.getIntegerInstance();
		// define a configuração de milhar.
		formatter.setGroupingUsed(milhar);
		// formata o número desejado.
		return formatter.format(number);
	}

	/**
	 * Formata um número inteiro no formato long para uma String conforme
	 * parâmetros.
	 * 
	 * @param number
	 *            número no formato long a ser convertido.
	 * @param milhar
	 *            caso se deseje que seja colocado o separador de milhar.
	 * @return texto referente ao número conforme especificado.
	 */
	public static String format(long number, char decimal, boolean milhar) {
		// recupera o formatador de números.
		NumberFormat formatter = NumberFormat.getIntegerInstance();
		// define a configuração de milhar.
		formatter.setGroupingUsed(milhar);
		// caso o decimal seja ponto.
		if (milhar && decimal == '.') {
			// formata e troca o milhar
			return formatter.format(number).replace(',', '.');
		}
		// formata o número desejado.
		return formatter.format(number);
	}

	/**
	 * Converte um número inteiro no formato short para uma String contendo uma
	 * quantidade fixa de dígitos.
	 * <p>
	 * <font color="red">IMPORTANTE:</font> Caso o número seja maior o mesmo
	 * será truncado.
	 * 
	 * @param number
	 *            número no formato short a ser convertido.
	 * @param length
	 *            quantidade de dígitos do número após a conversão.
	 * @return texto referente ao número com o tamanho especificado.
	 */
	public static String format(short number, int length) {
		return format((long) number, length);
	}

	/**
	 * Converte um número inteiro no formato byte para uma String contendo uma
	 * quantidade fixa de dígitos.
	 * <p>
	 * <font color="red">IMPORTANTE:</font> Caso o número seja maior o mesmo
	 * será truncado.
	 * 
	 * @param number
	 *            número no formato byte a ser convertido.
	 * @param length
	 *            quantidade de dígitos do número após a conversão.
	 * @return texto referente ao número com o tamanho especificado.
	 */
	public static String format(byte number, int length) {
		return format((long) number, length);
	}

	/**
	 * Converte um número inteiro no formato float para uma String contendo uma
	 * quantidade fixa de dígitos e decimais sem a representação da vírgula.
	 * <p>
	 * <font color="red">IMPORTANTE:</font> Caso o número seja maior o mesmo
	 * será truncado ou/e arredondado.
	 * </p>
	 * 
	 * <p>
	 * Caso número de decimais for maior que o número de digitos especificado o
	 * número será truncado e/ou arredondado, sendo descartado toda a parte
	 * inteira do mesmo. <br>
	 * Exemplo: 123,4567 em três digitos com quatro decimais retornará "456"
	 * </p>
	 * 
	 * @param number
	 *            número no formato float a ser convertido.
	 * @param length
	 *            quantidade de dígitos do número após a conversão.
	 * @param decimals
	 *            quantidade dos dígitos que representarão a parte decimal.
	 * @return texto referente ao número com o tamanho especificado.
	 */
	public static String formatFixed(float number, int length, int decimals) {
		// transforma para string para não perder precisão.
		String temp = Float.toString(number);
		return formatBigDecimal(new BigDecimal(temp), length, decimals);
	}

	/**
	 * Converte um número inteiro no formato double para uma String contendo uma
	 * quantidade fixa de dígitos e decimais sem a representação da vírgula.
	 * <p>
	 * <font color="red">IMPORTANTE:</font> Caso o número seja maior o mesmo
	 * será truncado ou/e arredondado.
	 * </p>
	 * 
	 * <p>
	 * Caso número de decimais for maior que o número de digitos especificado o
	 * número será truncado e/ou arredondado, sendo descartado toda a parte
	 * inteira do mesmo. <br>
	 * Exemplo: 123,4567 em três digitos com quatro decimais retornará "456"
	 * </p>
	 * 
	 * @param number
	 *            número no formato double a ser convertido.
	 * @param length
	 *            quantidade de dígitos do número após a conversão.
	 * @param decimals
	 *            quantidade dos dígitos que representarão a parte decimal.
	 * @return texto referente ao número com o tamanho especificado.
	 */
	public static String formatFixed(double number, int length, int decimals) {
		// transforma para string para não perder precisão.
		String temp = Double.toString(number);
		return formatBigDecimal(new BigDecimal(temp), length, decimals);
	}

	/**
	 * Formata uma data no padrão determinado.
	 * 
	 * @return data no padrão determinado.
	 * @param pattern
	 *            padrão de formatação para data.
	 * @param millis
	 *            Data representada em milisegundos.
	 * @param value
	 *            valor default para caso não possa se formatar a data.
	 */
	public static String formatDate(long millis, String pattern, String value) {
		Date date = new Date(millis);
		return format(date, pattern, value);
	}

	/**
	 * Formata uma data no padrão determinado. Caso a data em millis for nula ou
	 * vazia a função retornará o valor default.
	 * 
	 * @return data no padrão determinado.
	 * @param pattern
	 *            padrão de formatação para data.
	 * @param millis
	 *            Data representada em milisegundos.
	 * @param value
	 *            valor default para caso não possa se formatar a data.
	 */
	public static String formatDate(String millis, String pattern, String value) {
		if (!Helper.isEmptyString(millis)) {
			Date date = new Date(ObjectParser.parseLong(millis, 0));
			return format(date, pattern, value);
		} else {
			return value;
		}
	}

	/**
	 * Formata uma data no padrão determinado.
	 * 
	 * @return data no padrão determinado.
	 * @param pattern
	 *            padrão de formatação para data.
	 * @param date
	 *            a data a ser formatada.
	 * @param value
	 *            valor default para caso não possa se formatar a data.
	 */
	public static String format(Date date, String pattern, String value) {
		// caso base
		if (date == null || pattern == null) {
			return value;
		}

		try {

			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
			return simpleDateFormat.format(date);

		} catch (Exception e) {
			return value;
		}
	}

	/**
	 * Adiciona a virgula na ante-penultima posição do string.
	 */
	public static String addComma(String number) {
		int acerto = 0;
		char chars[] = new char[number.length() + 1];
		for (int i = 0; i < number.length(); i++) {
			if (i == number.length() - 2) {
				chars[i] = ',';
				acerto = 1;
			}
			chars[i + acerto] = number.charAt(i);
		}
		return new String(chars);
	}

	/**
	 * Remote as virgulas de um string.
	 */
	public static String removeComma(String number) {
		int count = 0;
		char chars[] = new char[number.length()];
		loop: for (int i = 0; i < number.length(); i++) {
			char c = number.charAt(i);
			if (c == ',') {
				count++;
				continue loop;
			}
			chars[i - count] = c;
		}
		return new String(chars, 0, number.length() - count);
	}

	/**
	 * Formata um valor para o padrão 'R$ #.##0,00'.
	 * 
	 * @param money
	 *            valor a ser formatado.
	 * @return o valor formatado no padrão 'R$ #.##0,00'.
	 * @since versão 1.0
	 */
	public static String formatMoney(double money) {
		return format(Formatter.formatFixed(money, 19, 2), ',', true, true);
	}

	/**
	 * Formata um valor conforme parâmetros de ajuste de formato.
	 * 
	 * @param money
	 *            valor a ser formatado.
	 * @param decimal
	 *            caracter de separação decimal '.' ou ','.
	 * @param monetario
	 *            <code>true</code> caso se deseje a inclusão do simbolo
	 *            monetário.
	 * @param milhar
	 *            caso se deseje que seja colocado o separador de milhar.
	 * @return o valor formatado no padrão conforme parâmetros de ajuste de
	 *         formato.
	 */
	public static String format(double money, char decimal, boolean monetario,
			boolean milhar) {
		return format(Formatter.formatFixed(money, 19, 2), decimal, monetario,
				milhar);
	}

	/**
	 * Formata um valor para o padrão 'R$ #.##0,00'.
	 * 
	 * @param money
	 *            valor a ser formatado.
	 * @return o valor formatado no padrão 'R$ #.##0,00'.
	 * @since versão 1.0
	 */
	public static String formatMoney(long money) {
		return format(money, ',', true, true);
	}

	/**
	 * Formata um valor conforme parâmetros de ajuste de formato.
	 * 
	 * @param money
	 *            valor a ser formatado.
	 * @param decimal
	 *            caracter de separação decimal '.' ou ','.
	 * @param monetario
	 *            <code>true</code> caso se deseje a inclusão do simbolo
	 *            monetário.
	 * @param milhar
	 *            caso se deseje que seja colocado o separador de milhar.
	 * @return o valor formatado no padrão conforme parâmetros de ajuste de
	 *         formato.
	 */
	public static String format(String money, char decimal, boolean monetario,
			boolean milhar) {
		return format(Long.parseLong(money), decimal, monetario, milhar);
	}

	/**
	 * Formata um valor conforme parâmetros de ajuste de formato.
	 * 
	 * @param money
	 *            valor a ser formatado.
	 * @param decimal
	 *            caracter de separação decimal '.' ou ','.
	 * @param monetario
	 *            <code>true</code> caso se deseje a inclusão do simbolo
	 *            monetário.
	 * @param milhar
	 *            caso se deseje que seja colocado o separador de milhar.
	 * @return o valor formatado no padrão conforme parâmetros de ajuste de
	 *         formato.
	 */
	public static String format(long money, char decimal, boolean monetario,
			boolean milhar) {
		boolean negative = false;
		if (money < 0) {
			negative = true;
			if (money == Long.MIN_VALUE)
				money++;
			money *= -1;
		}

		char chars[] = new char[29];
		chars[26] = decimal;
		int pos = 28;
		while (pos > 0 && money >= 10) {
			if (pos == 26)
				pos--;
			if (pos < 26 && pos % 4 == 2 && milhar) {
				chars[pos--] = '.' == decimal ? ',' : '.';
			} else {
				chars[pos--] = DIGITS[(int) (money % 10)];
				money /= 10;
			}
		}
		// verifica se é a posição da virgula.
		if (pos == 26)
			pos--;
		// verifica se é a posição do separador de milhar.
		if (pos < 26 && pos % 4 == 2 && milhar)
			chars[pos--] = '.' == decimal ? ',' : '.';
		// coloca o último digito.
		chars[pos--] = DIGITS[(int) money];
		// verifica se há necessidade de preencher com zeros.
		while (pos > 26)
			chars[pos--] = DIGITS[0];
		// verifica se é posição da virgula e preenche com zero a esquerda.
		if (pos == 26) {
			pos--;
			chars[pos--] = DIGITS[0];
		}
		if (negative)
			chars[pos--] = '-';

		if (monetario) {
			chars[pos--] = ' ';
			chars[pos--] = '$';
			chars[pos] = 'R';
		} else {
			pos++;
		}

		return new String(chars, pos, 29 - pos);

	}

	/**
	 * Formata um cpf para o padrão '000.000.000-00'.
	 * 
	 * @param cpf
	 *            valor a ser formatado.
	 * @return o valor formatado no padrão '000.000.000-00'.
	 * @since versão 1.0
	 */
	public static char[] cpfToChar(long cpf) {
		char[] result = new char[14];
		System.arraycopy(CPF, 0, result, 0, 14);
		for (int i = 13; i >= 0; i--) {
			if (i != 3 && i != 7 && i != 11) {
				result[i] = Character.forDigit((int) (cpf % 10), 10);
				cpf /= 10;
			}
		}
		return result;
	}

	/**
	 * Formata um cpf para o padrão '000.000.000-00'.
	 * 
	 * @param cpf
	 *            valor a ser formatado.
	 * @return o valor formatado no padrão '000.000.000-00'.
	 * @since versão 1.0
	 */
	public static String formatCpf(long cpf) {
		return new String(cpfToChar(cpf));
	}

	/**
	 * Formata um cnpj para o padrão '00.000.000/0000-00'.
	 * 
	 * @param cnpj
	 *            valor a ser formatado.
	 * @return o valor formatado no padrão '00.000.000/0000-00'.
	 * @since versão 1.0
	 */
	public static char[] cnpjToChar(long cnpj) {
		char[] result = new char[18];
		System.arraycopy(CNPJ, 0, result, 0, 18);
		for (int i = 17; i >= 0; i--) {
			if (i != 2 && i != 6 && i != 10 && i != 15) {
				result[i] = Character.forDigit((int) (cnpj % 10), 10);
				cnpj /= 10;
			}
		}
		return result;
	}

	/**
	 * Formata um cnpj para o padrão '00.000.000/0000-00'.
	 * 
	 * @param cnpj
	 *            valor a ser formatado.
	 * @return o valor formatado no padrão '00.000.000/0000-00'.
	 * @since versão 1.0
	 */
	public static String formatCnpj(long cnpj) {
		return new String(cnpjToChar(cnpj));
	}

	/**
	 * Converte um número inteiro no formato BigDecimal para uma String contendo
	 * uma quantidade fixa de dígitos e decimais sem a representação da vírgula.
	 * 
	 * <p>
	 * <font color="red">IMPORTANTE:</font> Caso o número seja maior o mesmo
	 * será truncado ou/e arredondado.
	 * </p>
	 * 
	 * <p>
	 * Caso número de decimais for maior que o número de digitos especificado o
	 * número será truncado e/ou arredondado, sendo descartado toda a parte
	 * inteira do mesmo. <br>
	 * Exemplo: 123,4567 em três digitos com quatro decimais retornará "456"
	 * </p>
	 * 
	 * @param number
	 *            número no formato BigDecimal a ser convertido.
	 * @param length
	 *            quantidade de dígitos do número após a conversão.
	 * @param decimals
	 *            quantidade dos dígitos que representarão a parte decimal.
	 * @return texto referente ao número com o tamanho especificado.
	 */
	private static String formatBigDecimal(BigDecimal bigDecimal, int length,
			int decimals) {
		// geting unscaled value
		BigInteger bigInteger = bigDecimal.unscaledValue();
		String integerPart = bigInteger.toString();
		String decimalPart = integerPart;
		// remove the decimal parts from integerPart
		integerPart = integerPart.substring(0, integerPart.length()
				- bigDecimal.scale());
		// remove the integer part from decimalPart
		decimalPart = decimalPart.substring(integerPart.length());
		// formatting parts
		String integer = formatInteger(integerPart, length - decimals);
		String decimal = formatDecimal(decimalPart, decimals);

		return new StringBuffer(integer).append(decimal).toString();
	}

	/**
	 * Converte um número inteiro para uma String contendo uma quantidade fixa
	 * de dígitos.
	 * <p>
	 * <font color="red">IMPORTANTE:</font> Caso o número seja maior o mesmo
	 * será truncado.
	 * 
	 * @param number
	 *            número no formato string a ser convertido.
	 * @param length
	 *            quantidade de dígitos do número após a conversão.
	 * @return texto referente ao número com o tamanho especificado.
	 */
	private static String formatDecimal(String number, int length) {
		if (number.length() > length) {
			return number.substring(0, length);
		} else if (number.length() < length) {
			return Formatter.fillRight(number, '0', length);
		} else {
			return number;
		}
	}

	/**
	 * Converte um número inteiro para uma String contendo uma quantidade fixa
	 * de dígitos.
	 * <p>
	 * <font color="red">IMPORTANTE:</font> Caso o número seja maior o mesmo
	 * será truncado.
	 * 
	 * @param number
	 *            número no formato string a ser convertido.
	 * @param length
	 *            quantidade de dígitos do número após a conversão.
	 * @return texto referente ao número com o tamanho especificado.
	 */
	private static String formatInteger(String number, int length) {
		if (number.length() > length) {
			return number.substring(number.length() - length);
		} else if (number.length() < length) {
			return Formatter.fillLeft(number, '0', length);
		} else {
			return number;
		}
	}

	public static String onlyDigits(String source) {
		if (source == null)
			return EMPTY;

		boolean clear = true;
		for (int i = 0; i < source.length(); i++) {
			if (!Character.isDigit(source.charAt(i))) {
				clear = false;
			}
		}

		if (clear) {
			return source;
		}

		char[] result = new char[source.length()];
		int j = 0;
		for (int i = 0; i < source.length(); i++) {
			char c;
			if (Character.isDigit(c = source.charAt(i))) {
				result[j++] = c;
			}
		}

		return new String(result, 0, j);
	}

	/**
	 * Formata um Calendar contendo data e hora em uma string no formato
	 * AAAA-MM-DDTHH:MM:SS.
	 * 
	 * @param calendar
	 *            Calendar contendo data e hora a serem formatados.
	 * @return uma string no formato AAAA-MM-DDTHH:MM:SS.
	 */
	public static String calendarToISO8601(Calendar calendar) {

		StringBuffer buffer = new StringBuffer();
		if (calendar != null) {
			int day = calendar.get(Calendar.DAY_OF_MONTH);
			int month = calendar.get(Calendar.MONTH) + 1;
			int year = calendar.get(Calendar.YEAR);
			int hour = calendar.get(Calendar.HOUR_OF_DAY);
			int minute = calendar.get(Calendar.MINUTE);
			int second = calendar.get(Calendar.SECOND);

			buffer.append(year);
			buffer.append('-');

			if (month < 10)
				buffer.append('0');
			buffer.append(month);
			buffer.append('-');

			if (day < 10)
				buffer.append('0');
			buffer.append(day);

			buffer.append('T');

			if (hour < 10)
				buffer.append('0');
			buffer.append(hour);
			buffer.append(':');

			if (minute < 10)
				buffer.append('0');
			buffer.append(minute);
			buffer.append(':');

			if (second < 10)
				buffer.append('0');
			buffer.append(second);
		}

		return buffer.toString();
	}

	/**
	 * Formata um Calendar contendo data e hora em uma string no formato
	 * AAAA-MM-DD.
	 * 
	 * @param calendar
	 *            Calendar contendo data e hora a serem formatados.
	 * @return uma string no formato AAAA-MM-DD.
	 */
	public static String calendarToDateISO8601(Calendar calendar) {

		StringBuffer buffer = new StringBuffer();
		if (calendar != null) {
			int day = calendar.get(Calendar.DAY_OF_MONTH);
			int month = calendar.get(Calendar.MONTH) + 1;
			int year = calendar.get(Calendar.YEAR);

			buffer.append(year);
			buffer.append('-');

			if (month < 10)
				buffer.append('0');
			buffer.append(month);
			buffer.append('-');

			if (day < 10)
				buffer.append('0');
			buffer.append(day);
		}

		return buffer.toString();
	}

	/**
	 * Retorna o string embaralhado.
	 * 
	 * @param source
	 *            string a ser embaralhado.
	 * @return o string embaralhado.
	 */
	public static String shuffle(String source) {
		List characters = new ArrayList(source.length());
		for (int i = 0; i < source.length(); i++)
			characters.add(new Character(source.charAt(i)));
		Collections.shuffle(characters);
		char[] chars = new char[source.length()];
		for (int i = 0; i < source.length(); i++)
			chars[i] = ((Character) characters.get(i)).charValue();
		return new String(chars);
	}

	/**
	 * Retorna o string embaralhado.
	 * 
	 * @param source
	 *            string a ser embaralhado.
	 * @param seed
	 *            seed para crição de um random.
	 * @return o string embaralhado.
	 */
	public static String shuffle(String source, int seed) {
		return shuffle(source, new Random(seed));
	}

	/**
	 * Retorna o string embaralhado.
	 * 
	 * @param source
	 *            string a ser embaralhado.
	 * @param random
	 *            random para ser utilizado no embaralhamendo.
	 * @return o string embaralhado.
	 */
	public static String shuffle(String source, Random random) {
		List characters = new ArrayList(source.length());
		for (int i = 0; i < source.length(); i++)
			characters.add(new Character(source.charAt(i)));
		Collections.shuffle(characters, random);
		char[] chars = new char[source.length()];
		for (int i = 0; i < source.length(); i++)
			chars[i] = ((Character) characters.get(i)).charValue();
		return new String(chars);
	}

	/**
	 * Concatena a coleção um string.
	 * 
	 * @param collection
	 *            a coleção a ser iteragida.
	 * @param attribute
	 *            o atributo de cada elemento.
	 * @param token
	 *            o token separador.
	 * @return Um string no formato:
	 *         element0+token[elementx+token[x=1..n]]+element
	 */
	public static String format(Collection collection, String token) {
		return format(collection, null, token, null);
	}

	/**
	 * Transforma a coleção um string.
	 * 
	 * @param collection
	 *            a coleção a ser iteragida.
	 * @param attribute
	 *            o atributo de cada elemento.
	 * @param token
	 *            o token separador.
	 * @return Um string no formato:
	 *         start+element+token[element+token]+element+end
	 */
	public static String format(Collection collection, String start,
			String token, String end) {
		StringBuffer buffer = new StringBuffer();

		if (!Helper.isEmptyString(start)) {
			buffer.append(start);
		}

		for (Iterator iter = collection.iterator(); iter.hasNext();) {
			Object element = (Object) iter.next();
			buffer.append(ObjectParser.parseString(element));

			if (iter.hasNext()) {
				buffer.append(token);
			}
		}

		if (!Helper.isEmptyString(end)) {
			buffer.append(end);
		}

		return buffer.toString();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(Formatter.format(1130059, true));
		System.out.println(Formatter.format(1130059L, true));
		System.out.println(Formatter.format(1130059L, false));
		System.out.println(Formatter.format(1130059, false));
	}
}
