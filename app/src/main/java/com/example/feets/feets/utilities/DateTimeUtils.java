package com.example.feets.feets.utilities;

import android.annotation.SuppressLint;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * An utilities class for date and time
 * <li>print out the date and time diffrences</li>
 */
public class DateTimeUtils {
    //1 minute = 60 seconds
    //1 hour = 60 x 60 = 3600
    //1 day = 3600 x 24 = 86400

    @SuppressLint("DefaultLocale")
    public long printDifferenceLong(Date startDate, Date endDate) {
        if (endDate == null || startDate == null) return 0;
        return endDate.getTime() - startDate.getTime();
    }

    @SuppressLint("DefaultLocale")
    public String printDifferenceInMillis(long timeInMillis) {
        long secondsInMilli = 1000;
        long minutesInMilli = secondsInMilli * 60;
        long hoursInMilli = minutesInMilli * 60;
        long daysInMilli = hoursInMilli * 24;
        long elapsedDays = timeInMillis / daysInMilli;
        timeInMillis = timeInMillis % daysInMilli;
        long elapsedHours = timeInMillis / hoursInMilli;
        timeInMillis = timeInMillis % hoursInMilli;
        long elapsedMinutes = timeInMillis / minutesInMilli;
        timeInMillis = timeInMillis % minutesInMilli;
        long elapsedSeconds = timeInMillis / secondsInMilli;
        final String strDay = placeZeroIfNeeded(elapsedDays);
        final String strHour = placeZeroIfNeeded(elapsedHours);
        final String strMin = placeZeroIfNeeded(elapsedMinutes);
        final String strSec = placeZeroIfNeeded(elapsedSeconds); // TODO: 10/3/2018  seconds??
        return String.format("%s : %s : %s ", strDay, strHour, strMin);
    }

    @SuppressLint("DefaultLocale")
    public String printDifference(Date startDate, Date endDate) {

        if (endDate == null || startDate == null) return "Error getting date";
        //milliseconds
        long different = endDate.getTime() - startDate.getTime();
        System.out.println("startDate : " + startDate);
        System.out.println("endDate : " + endDate);
        System.out.println("different : " + different);
        long secondsInMilli = 1000;
        long minutesInMilli = secondsInMilli * 60;
        long hoursInMilli = minutesInMilli * 60;
        long daysInMilli = hoursInMilli * 24;
        long elapsedDays = different / daysInMilli;
        different = different % daysInMilli;
        long elapsedHours = different / hoursInMilli;
        different = different % hoursInMilli;
        long elapsedMinutes = different / minutesInMilli;
        different = different % minutesInMilli;
        long elapsedSeconds = different / secondsInMilli;final String strDay = placeZeroIfNeeded(elapsedDays);
        final String strHour = placeZeroIfNeeded(elapsedHours);
        final String strMin = placeZeroIfNeeded(elapsedMinutes);
        final String strSec = placeZeroIfNeeded(elapsedSeconds); // TODO: 10/3/2018  seconds??
//        return String.format("%s : %s : %s : %2s ", strDay, strHour, strMin, strSec);
        return String.format("%s : %s : %s ", strDay, strHour, strMin);
    }

    private String placeZeroIfNeeded(long number) {
        return (number >= 10) ? Long.toString(number) : String.format("0%s", Long.toString(number));
    }

    public static String toISO8601UTC(Date date) {
        TimeZone tz = TimeZone.getTimeZone("GMT");
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.getDefault());
        df.setTimeZone(tz);
        return df.format(date);
    }

    public static Date fromISO8601UTC(String dateStr) {
        TimeZone tz = TimeZone.getTimeZone("GMT");
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.getDefault());
        df.setTimeZone(tz);
        try {
            return df.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

}
