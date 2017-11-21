package com.openjaw.ibe.tests.dsl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public final class Utils {
    public static final float PRICE_DELTA = 0.001f;

    private Utils() {
        throw new IllegalAccessError("Utility class");
    }

    public static String generateDate(Integer daysToAdd) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd : hh:mm:ss");
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, daysToAdd);
        return dateFormat.format(cal.getTime());
    }
    
    public static String dateChange(String departure, Integer daysToChange ){
    	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd : hh:mm");
    	Date date = null;
		try {
			date = dateFormat.parse(departure);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(cal.DATE, daysToChange);
    	return dateFormat.format(cal.getTime());
    }

    /**
     *
     * @param f1 first float number to compare
     * @param f2 second float number to compare
     * @return 0 is prices are equals, -1 if price1 is greater than price2 else return 1
     */
    public static int compareFloats(float f1, float f2, float delta) {
        if (Math.abs(f1 - f2) < delta) {
            return 0;
        } else {
            if (f1 < f2) {
                return -1;
            } else {
                return 1;
            }
        }
    }

    /**
     * Default delta for price comparision is 0.001f
     * @param price1 first price to compare
     * @param price2 second price to compare
     * @return 0 is prices are equals, -1 if price1 is greater than price2 else return 1
     */
    public static int compareFloatPrices(float price1, float price2){
        return compareFloats(price1, price2, PRICE_DELTA);
    }
}
