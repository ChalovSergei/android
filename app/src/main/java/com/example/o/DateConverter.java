package com.example.o;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter {
    static String dateTemplate = "^(0?[1-9]|[12][0-9]|3[01]).(0?[1-9]|1[012]).([12][0-9]{3})$";
    /**Метод для преобразования Григорианской даты в Юлианскую
     * @param unformattedDate - Григорианская дата
     * @return Юлианская дата в целочисленном формате
     */
    public static int ConvertToJulian(String unformattedDate)
    {
        int resultJulian = 0;
        if(unformattedDate.matches(dateTemplate) && unformattedDate.length() == 10){
            int[] monthValues = {31,28,31,30,31,30,31,31,30,31,30,31};

            String dayS, monthS, yearS;
            dayS = unformattedDate.substring(0,2);
            monthS = unformattedDate.substring(3, 5);
            yearS = unformattedDate.substring(6, 10);

            int day = Integer.valueOf(dayS);
            int month = Integer.valueOf(monthS);
            int year = Integer.valueOf(yearS);

            if(year % 4 == 0)
            {
                monthValues[1] = 29;
            }
            String julianDate = "1";

            julianDate += yearS.substring(2,4);

            int julianDays = 0;
            for (int i=0; i < month-1; i++)
            {
                julianDays += monthValues[i];
            }
            julianDays += day;

            if(String.valueOf(julianDays).length() < 2)
            {
                julianDate += "00";
            }
            if(String.valueOf(julianDays).length() < 3)
            {
                julianDate += "0";
            }

            julianDate += String.valueOf(julianDays);
            resultJulian =  Integer.valueOf(julianDate);
            return resultJulian;
        }
        else{
            return 0;
        }
    }
    /**Метод для преобразования Юлианской даты в Григорианскую
     * @param julian - Юлианская дата
     * @return Григорианская дата в формате строки
     */
    public static String ConvertFromJulian(int julian){
        DateFormat dt = new SimpleDateFormat("Myydd");
        String str = "";
        try
        {
            Date date = dt.parse(String.valueOf(julian));
            str = new SimpleDateFormat("dd.MM.yyyy").format(date);
        } catch (ParseException e) {}
        return str;
    }
}
