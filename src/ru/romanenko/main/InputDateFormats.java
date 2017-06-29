package ru.romanenko.main;

import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class InputDateFormats {
	
	private static Pattern datePattern;
	private static Matcher dateMatcher;

	public static final String DATE_PATTERN = "(0[1-9]|[12][0-9]|3[01])" //day
			+ "-"
			+ "(0[1-9]|1[012])" //month
			+ "-"
			+ "(197\\d|198\\d|199\\d|20\\d\\d)" //year
			+ " "
			+ "(0[0-9]|[1][0-9]|2[0-3])" //hours
			+ ":"
			+ "(0[0-9]|[012345][0-9])" //minutes
			+ ":"
			+ "(0[0-9]|[012345][0-9])"; //seconds
	
	public static final String UNIXTIME_PATTERN = "([1-3]\\d?\\d?\\d?\\d?\\d?\\d?\\d?\\d?\\d?\\d?)"; 
	
	public static final String UNIXTIME_HEX_PATTERN = "([0-9A-F]?[0-9A-F]?[0-9A-F][0-9A-F][0-9A-F][0-9A-F][0-9A-F][0-9A-F][0-9A-F][0-9A-F])";
	
	public static final String DAYS_SINCE_1970_PATTERN = "([1-9]\\d?\\d?\\d?\\d?)";
	
	public static final String DAYS_SINCE_1970_HEX_PATTERN = "([0-9A-F][0-9A-F][0-9A-F][0-9A-F])";

	
	
	public InputDateFormats(String inputeDate, String dateFormat) throws ParseException{
		System.out.println("Входная дата " + inputeDate);
		System.out.println("Формат даты " + dateFormat);
		ValidateInputDayText(inputeDate, dateFormat);
		ConvertDate(inputeDate);
		
	}
	
	public static boolean checkDayTfWithRegExp(String inputDate, String dateFormat) {
		datePattern = Pattern.compile(dateFormat);
		dateMatcher = datePattern.matcher(inputDate);
	    return dateMatcher.matches();
	    }
	
	public static void ValidateInputDayText(String inputDay, String dateFormat) throws ParseException, java.text.ParseException{
		boolean dayValidation = checkDayTfWithRegExp(inputDay, dateFormat);
		if (dayValidation == true) {
			System.out.println("Дата корректна");
			
		}
		else {
			JOptionPane.showMessageDialog(ApplicationFrame.contentPane, "Некорректно введена дата", "Ошибка", JOptionPane.WARNING_MESSAGE);
		}
	}
	
	public static void ConvertDate(String inputDate) throws ParseException, java.text.ParseException {
		
		ApplicationFrame.countDaysTf.setText(Integer.toString(ConversionMethods.UnixDaysHexToUnixDays(inputDate)));
		ApplicationFrame.unixdateTf.setText(Long.toString(ConversionMethods.UnixDaysToTimestamp(ConversionMethods.UnixDaysHexToUnixDays(inputDate))));
		/*ApplicationFrame.unixdateTf.setText(Long.toString(ConversionMethods.ToTimeStamp(inputDate)));
		ApplicationFrame.unixTsHexTf.setText(ConversionMethods.TimeStampToHex(ConversionMethods.ToTimeStamp(inputDate)));
		ApplicationFrame.countDaysTf.setText(Integer.toString(ConversionMethods.TimeStampToUnixDays(ConversionMethods.ToTimeStamp(inputDate))));
		ApplicationFrame.countDaysHexTf.setText(ConversionMethods.UnixDaysToHex(ConversionMethods.TimeStampToUnixDays(ConversionMethods.ToTimeStamp(inputDate))));
	*/
	}
}