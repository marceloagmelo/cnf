package br.com.cnf.curso.inscricao.util;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;

public class ObjectParser {
	public static final String STR_EMPTY = "";

	/**
	 * Converte um objeto no tipo básico byte.
	 * @param object Objeto a ser convertido.
	 * @param value Valor default para caso o 
	 * objeto não possa ser convertido.
	 * @return o resultado da conversão em byte.
	 */
    public static byte parseByte(Object object, byte value)
    {
        //if the object is not retrived, returns the default value
        if(object == null)
        {
            return value;
        }

        //if is Numeric use conventional conversion
        if(object instanceof Number)
        {
            return ((Number) object).byteValue();
        }

        try
        {
            //force the conversion by parse
            return Byte.parseByte(object.toString().trim());
        } catch (NumberFormatException nfe) {
            return value;
        }
    }

	/**
	 * Converte um objeto no tipo básico short.
	 * @param object Objeto a ser convertido.
	 * @param value Valor default para caso o 
	 * objeto não possa ser convertido.
	 * @return o resultado da conversão em short.
	 */
    public static short parseShort(Object object, short value)
    {
        //if the object is not retrived, returns the default value
        if(object == null)
        {
            return value;
        }

        //if is Numeric use conventional conversion
        if(object instanceof Number)
        {
            return ((Number) object).shortValue();
        }

        try
        {
            //force the conversion by parse
            return Short.parseShort(object.toString().trim());
        } catch (NumberFormatException nfe) {
            return value;
        }
    }

	/**
	 * Converte um objeto no tipo básico int.
	 * @param object Objeto a ser convertido.
	 * @param value Valor default para caso o 
	 * objeto não possa ser convertido.
	 * @return o resultado da conversão em int.
	 */
    public static int parseInt(Object object, int value)
    {
        //if the object is not retrived, returns the default value
        if(object == null)
        {
            return value;
        }

        //if is Numeric use conventional conversion
        if(object instanceof Number)
        {
            return ((Number) object).intValue();
        }

        try
        {
            //force the conversion by parse
            return Integer.parseInt(object.toString().trim());
        } catch (NumberFormatException nfe) {
            return value;
        }
    }

	/**
	 * Converte um objeto em Integer.
	 * @param object Objeto a ser convertido.
	 * @param value Valor default para caso o 
	 * objeto não possa ser convertido.
	 * @return o resultado da conversão em Integer.
	 */
    public static Integer parseInteger(Object object, Integer value)
    {
        //if the object is not retrived, returns the default value
        if(object == null)
        {
            return value;
        }

        // if is Integer use conventional conversion
        if(object instanceof Integer)
        {
            return (Integer)object;
        }

        //if is Numeric use conventional conversion
        if(object instanceof Number)
        {
            return new Integer(((Number) object).intValue());
        }

        String temp = object.toString().trim();
        if(temp.length() == 0)
            return value;

        try
        {
            //force the conversion by parse
            return new Integer(Integer.parseInt(temp));
        } catch (NumberFormatException nfe) {
            return value;
        }
    }

	/**
	 * Converte um objeto no tipo básico long.
	 * @param object Objeto a ser convertido.
	 * @param value Valor default para caso o 
	 * objeto não possa ser convertido.
	 * @return o resultado da conversão em long.
	 */
    public static long parseLong(Object object, long value)
    {
        //if the object is not retrived, returns the default value
        if(object == null)
        {
            return value;
        }

        //if is Numeric use conventional conversion
        if(object instanceof Number)
        {
            return ((Number) object).longValue();
        }

        try
        {
            //force the conversion by parse
        	return Long.parseLong(object.toString().trim());
        } catch (NumberFormatException nfe) {
        	try
            {
                //force the conversion by parse only digits
            	return Long.parseLong(Formatter.onlyDigits(object.toString().trim()));
            } catch (NumberFormatException nfe1) {
                return value;
            }
        }
    }

	/**
	 * Converte um objeto em Long.
	 * @param object Objeto a ser convertido.
	 * @param value Valor default para caso o 
	 * objeto não possa ser convertido.
	 * @return o resultado da conversão em Long.
	 */
    public static Long parseLong(Object object, Long value)
    {
        //if the object is not retrived, returns the default value
        if(object == null)
        {
            return value;
        }

        // if is Long use conventional conversion
        if(object instanceof Long)
        {
            return (Long)object;
        }

        //if is Numeric use conventional conversion
        if(object instanceof Number)
        {
            return new Long(((Number) object).longValue());
        }

        String temp = object.toString().trim();
    	if(temp.length() == 0)
    		return value;

        try
        {
            //force the conversion by parse
            return new Long(Long.parseLong(temp));
        } catch (NumberFormatException nfe) {
        	try
            {
                //force the conversion by parse only digits
                return new Long(Long.parseLong(Formatter.onlyDigits(temp)));
            } catch (NumberFormatException nfe1) {
                return value;
            }
        }
    }
    
	/**
	 * Converte um objeto em BigInteger.
	 * @param object Objeto a ser convertido.
	 * @param value Valor default para caso o 
	 * objeto não possa ser convertido.
	 * @return o resultado da conversão em BigInteger.
	 */
    public static BigInteger parseBigInteger(Object object, BigInteger value){
        //if the object is not retrived, returns the default value
        if(object == null)
        {
            return value;
        }

        //caso seja um big integer
        if(object instanceof BigInteger)
        {
        	return (BigInteger) object;
        }
        
        //caso seja um big integer
        if(object instanceof BigDecimal)
        {
        	return ((BigDecimal) object).toBigInteger();
        }
        
        //if is another number
        if(object instanceof Number)
        {
        	return new BigInteger(String.valueOf(((Number) object).longValue()));
        }
    	
        try
        {
            //force the conversion by parse
            return new BigInteger(object.toString().trim());
        } catch (NumberFormatException nfe) {
            return value;
        }    	
    }
    
	/**
	 * Converte um objeto no tipo básico float.
	 * @param object Objeto a ser convertido.
	 * @param value Valor default para caso o 
	 * objeto não possa ser convertido.
	 * @return o resultado da conversão em float.
	 */
    public static float parseFloat(Object object, float value)
    {
        //if the object is not retrived, returns the default value
        if(object == null)
        {
            return value;
        }

        //if is Numeric use conventional conversion
        if(object instanceof Number)
        {
            return ((Number) object).floatValue();
        }

        try
        {
            //force the conversion by parse
            return Float.parseFloat(object.toString().trim());
        } catch (NumberFormatException nfe) {
        	try
            {
                //force the conversion by parse only digits
                return Float.parseFloat(Formatter.onlyDigits(object.toString().trim()));
            } catch (NumberFormatException nfe1) {
                return value;
            }
        }
    }

	/**
	 * Converte um objeto no tipo básico double.
	 * @param object Objeto a ser convertido.
	 * @param value Valor default para caso o 
	 * objeto não possa ser convertido.
	 * @return o resultado da conversão em double.
	 */
    public static double parseDouble(Object object, double value)
    {
        //if the object is not retrived, returns the default value
        if(object == null)
        {
            return value;
        }

        //if is Numeric use conventional conversion
        if(object instanceof Number)
        {
            return ((Number) object).doubleValue();
        }

        try
        {
            //force the conversion by parse
            return Double.parseDouble(object.toString().trim());
        } catch (NumberFormatException nfe) {
            return value;
        }
    }

	/**
	 * Converte um objeto em BigDecimal.
	 * @param object Objeto a ser convertido.
	 * @param value Valor default para caso o 
	 * objeto não possa ser convertido.
	 * @return o resultado da conversão em BigDecimal.
	 */
    public static BigDecimal parseBigDecimal(Object object, BigDecimal value){
        //if the object is not retrived, returns the default value
        if(object == null)
        {
            return value;
        }

        //caso seja um big decimal
        if(object instanceof BigDecimal)
        {
        	return (BigDecimal) object;
        }
        
        //caso seja um big integer
        if(object instanceof BigInteger)
        {
        	return new BigDecimal((BigInteger) object);
        }
        
        //if is double or a float
        if(object instanceof Double || object instanceof Float)
        {
            return new BigDecimal(((Number) object).doubleValue());
        }
        
        //if is another number
        if(object instanceof Number)
        {
        	return new BigDecimal(((Number) object).longValue());
        }
    	
        try
        {
            //force the conversion by parse
            return new BigDecimal(object.toString().trim());
        } catch (NumberFormatException nfe) {
            return value;
        }    	
    }
    
	/**
	 * Converte um objeto no tipo básico boolean.
	 * @param object Objeto a ser convertido.
	 * @param value Valor default para caso o 
	 * objeto não possa ser convertido.
	 * @return o resultado da conversão em boolean.
	 */
    public static boolean parseBoolean(Object object, boolean value)
    {
    	//return the boolean value of the Boolean parser.
    	return parseBoolean(object, value ? Boolean.TRUE : Boolean.FALSE).booleanValue();
    }
    
	/**
	 * Converte um objeto em Boolean.
	 * @param object Objeto a ser convertido.
	 * @param value Valor default para caso o 
	 * objeto não possa ser convertido.
	 * @return o resultado da conversão em Boolean.
	 */
    public static Boolean parseBoolean(Object object, Boolean value){
        //if the object is not retrived, returns the default value
        if(object == null)
        {
            return value;
        }

        //if is Boolean use conventional conversion
        if(object instanceof Boolean)
        {
            return ((Boolean) object);
        }

        String str = object.toString().trim();

        //force the conversion by parse.
        if(Boolean.valueOf(str).booleanValue())
        {
            return Boolean.TRUE;
        }

        //valida a possibilidade de ser false
        if(Boolean.FALSE.toString().equalsIgnoreCase(str)){
        	return Boolean.FALSE;
        }
        
        //try to get (S|Y)/N pattern
        if(str.length() == 1)
        {
            if(str.charAt(0) == 'S' || str.charAt(0) == 's' || str.charAt(0) == 'Y' || str.charAt(0) == 'y')
            {
                return Boolean.TRUE;
            }

            if(str.charAt(0) == 'N' || str.charAt(0) == 'n')
            {
                return Boolean.FALSE;
            }
        }

        try
        {
            return Long.parseLong(str) != 0 ? Boolean.TRUE : Boolean.FALSE;
        } catch (NumberFormatException nfe)  {
            return value;
        }
    }
    

	/**
	 * Converte um objeto no tipo básico char.
	 * @param object Objeto a ser convertido.
	 * @param value Valor default para caso o 
	 * objeto não possa ser convertido.
	 * @return o resultado da conversão em char.
	 */
    public static char parseChar(Object object, char value)
    {
        //if the object is not retrived, returns the default value
        if(object == null)
        {
            return value;
        }

        //if is Character use conventional conversion
        if(object instanceof Character)
        {
            return ((Character) object).charValue();
        }

        String temp = object.toString().trim();
        //return the default value, if the string representation is empty.
        if(Helper.isEmptyString(temp))
        {
            return value;
        }

        //return the first character of the string representation.
        return temp.charAt(0);
    }

	/**
	 * Converte um objeto java.util.Date utilizando o
	 * formato especificado caso seja necessário.
	 * @param object Objeto a ser convertido.
	 * @param value Valor default para caso o 
	 * objeto não possa ser convertido.
	 * @param format O formato de data a ser utilizado na 
	 * conversão.
	 * @return o resultado da conversão em java.util.Date.
	 */
    public static Date parseDate(Object object, Date value, String format)
    {
        //if the object is not retrived, returns the default value
        if(object == null)
        {
            return value;
        }

        //if is Date use conventional conversion
        if(object instanceof Date)
        {
            return (Date) object;
        }
        
        //if is Calendar use getTime conversion.
        if(object instanceof Calendar){
        	return ((Calendar) object).getTime();
        }

        String temp = object.toString().trim();
        //return the default value, if the string representation is empty.
        if(Helper.isEmptyString(temp))
        {
            return value;
        }

        //try to parse de date with the format.
        try
        {

 	        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
	        simpleDateFormat.setLenient(false);
			return simpleDateFormat.parse(temp);

        } catch (Exception e) {
            return value;
        }
    }
    
	/**
	 * Converte um objeto java.sql.Date utilizando o
	 * formato especificado caso seja necessário.
	 * @param object Objeto a ser convertido.
	 * @param value Valor default para caso o 
	 * objeto não possa ser convertido.
	 * @param format O formato de data a ser utilizado na 
	 * conversão.
	 * @return o resultado da conversão em java.sql.Date.
	 */
    public static java.sql.Date parseDate(Object object, java.sql.Date value, String format){
        //if the object is not retrived, returns the default value
        if(object == null)
        {
            return value;
        }

        //if is java.sql.Date use conventional conversion
        if(object instanceof java.sql.Date)
        {
            return (java.sql.Date) object;
        }

        //try to parse like java.util.Date
        Date date = parseDate(object, (Date)value, format);
        
        //if the parsed date is null
        if(date == null){
        	return value;
        }
        
        //create a java.sql.Date with the parsed date.
        return new java.sql.Date(date.getTime());
    }
    
	/**
	 * Converte um objeto java.sql.Time utilizando o
	 * formato especificado caso seja necessário.
	 * @param object Objeto a ser convertido.
	 * @param value Valor default para caso o 
	 * objeto não possa ser convertido.
	 * @param format O formato de data a ser utilizado na 
	 * conversão.
	 * @return o resultado da conversão em java.sql.Time.
	 */
    public static Time parseTime(Object object, Time value, String format){
        //if the object is not retrived, returns the default value
        if(object == null)
        {
            return value;
        }

        //if is time use conventional conversion
        if(object instanceof Time)
        {
            return (Time) object;
        }

        //try to parse like java.util.Date
        Date date = parseDate(object, (Date)value, format);
        
        //if the parsed date is null
        if(date == null){
        	return value;
        }
        
        //create a java.sql.Date with the parsed date.
        return new Time(date.getTime());
    }
    
	/**
	 * Converte um objeto java.sql.Timestamp utilizando o
	 * formato especificado caso seja necessário.
	 * @param object Objeto a ser convertido.
	 * @param value Valor default para caso o 
	 * objeto não possa ser convertido.
	 * @param format O formato de data a ser utilizado na 
	 * conversão.
	 * @return o resultado da conversão em java.sql.Timestamp.
	 */
    public static Timestamp parseTimestamp(Object object, Timestamp value, String format){
        //if the object is not retrived, returns the default value
        if(object == null)
        {
            return value;
        }

        //if is timestamp use conventional conversion
        if(object instanceof Timestamp)
        {
            return (Timestamp) object;
        }

        //try to parse like java.util.Date
        Date date = parseDate(object, (Date)value, format);
        
        //if the parsed date is null
        if(date == null){
        	return value;
        }
        
        //create a java.sql.Date with the parsed date.
        return new Timestamp(date.getTime());
    }    
    
	/**
	 * Converte um objeto Calendar utilizando o
	 * formato especificado caso seja necessário.
	 * @param object Objeto a ser convertido.
	 * @param value Valor default para caso o 
	 * objeto não possa ser convertido.
	 * @param format O formato de data a ser utilizado na 
	 * conversão.
	 * @return o resultado da conversão em Calendar.
	 */
    public static Calendar parseCalendar(Object object, Calendar value, String format){
        //if the object is not retrived, returns the default value
        if(object == null)
        {
            return value;
        }
    	
        //if is calendar use conventional conversion
        if(object instanceof Calendar)
        {
            return (Calendar) object;
        }
    	    	
    	//parse the object as date.
    	Date date = ObjectParser.parseDate(object, (Date)null, format);

        //if the object is not retrived, returns the default value
        if(date == null)
        {
            return value;
        }

        //create the new calendar.
        Calendar result = Calendar.getInstance();
        
        //update the timestamp of calendar.
        result.setTime(date);
        
        //returns the calandar.
    	return result;
    }

	/**
	 * Converte um objeto Calendar utilizando o
	 * formato ISO8601 caso seja necessário, levando-se
	 * em consideração somente a parte de ano-mes-dia do 
	 * padrão.
	 * @param object Objeto a ser convertido.
	 * @param value Valor default para caso o 
	 * objeto não possa ser convertido.
	 * @return o resultado da conversão em Calendar.
	 */
    public static Calendar parseDateISO8601(Object object, Calendar value)
    {
        //if the object is not retrived, returns the default value
        if(object == null)
        {
            return value;
        }

        //if already is a calendar.
        if(object instanceof Calendar)
        {
            return (Calendar) object;
        }

        String str = object.toString().trim();

        if(str.length() != 10)
        {
            return value;
        }

        try
        {
            int year = Integer.parseInt(str.substring(0,4));
            int month = Integer.parseInt(str.substring(5,7))-1;
            int day = Integer.parseInt(str.substring(8,10));

            return new GregorianCalendar(year, month, day);

        } catch (Exception e) {
            return value;
        }
    }
        
    
	/**
	 * Converte um objeto Calendar utilizando o
	 * formato ISO8601 caso seja necessário.
	 * @param object Objeto a ser convertido.
	 * @param value Valor default para caso o 
	 * objeto não possa ser convertido.
	 * @return o resultado da conversão em Calendar.
	 */
    public static Calendar parseISO8601(Object object, Calendar value)
    {
        //if the object is not retrived, returns the default value
        if(object == null)
        {
            return value;
        }

        //if already is a calendar.
        if(object instanceof Calendar)
        {
            return (Calendar) object;
        }

        String str = object.toString().trim();

        //TODO: mudar para expressao regular.
        if(str.length() != 19)
        {
            return value;
        }

        try
        {
            int year = Integer.parseInt(str.substring(0,4));
            int month = Integer.parseInt(str.substring(5,7))-1;
            int day = Integer.parseInt(str.substring(8,10));

            int hour = Integer.parseInt(str.substring(11,13));
            int minute = Integer.parseInt(str.substring(14,16));
            int second = Integer.parseInt(str.substring(17,19));

            return new GregorianCalendar(year, month, day, hour, minute, second);

        } catch (Exception e) {
            return value;
        }
    }    
    
	/**
	 * Converte um objeto em String. O objeto convertido
	 * é submetido a um trim() antes de ser retornado.
	 * @param object Objeto a ser convertido.
	 * @param value Valor default para caso o 
	 * objeto seja nulo.
	 * @return o resultado da conversão em String.
	 */
    public static String parseString(Object object, String value)
    {
        //if the object is not retrived, returns the default value
        if(object == null)
        {
            return value;
        }

        return object.toString().trim();
    }

	/**
	 * Converte um objeto em String. O objeto convertido
	 * é submetido a um trim() antes de ser retornado.
	 * @param object Objeto a ser convertido.
	 * @return o resultado da conversão em String ou uma 
	 * string vazia caso o objeto não possa ser convertido.
	 */
    public static String parseString(Object object){
    	return parseString(object, STR_EMPTY);
    }
    
    /**
     * Realiza o parse de um objeto para um Level.
	 * @param object Objeto a ser convertido.
     * @param value O valor default para caso o objeto seja 
     * nulo ou o nome do atributo seja nulo.
	 * @return o resultado da conversão em Level, ou o valor 
	 * default caso a conversão não seja possível.
     */
    public static Level parseLevel(Object object, Level value){
        //if the object is not retrived, returns the default value
        if(object == null)
        {
            return value;
        }

        //se já é um level
        if(object instanceof Level){
        	return (Level) object;
        }
    	
    	//transforma para string.
    	String string = parseString(object);
    	
    	try {
    		//retorna conversão fornecida pela classe level.
    		return Level.parse(string);
    	} catch (IllegalArgumentException e){
    		//if the value is neither one of the known names nor an integer.
    		return value;
    	}
    }
    
}

