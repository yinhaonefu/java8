package Joda;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;

import java.util.Date;

/**
 * Created by yinhao on 17/5/28.
 * 标准UTC时间:
 * 2017-12-1209:22:54.876Z 无时区
 * 2017-12-1209:22:54.876+08:00 东八区
 *
 */
public class JodaTimeTest2 {

    public static Date convertUTC2Date(String utcTime){
        DateTime dateTime = DateTime.parse(utcTime,
                DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZ"));
        return dateTime.toDate();
    }

    public static String convertDate2UTC(Date javaDate){
        DateTime dateTime = new DateTime(javaDate, DateTimeZone.UTC);
        return dateTime.toString();
    }

    public static String convertDate2LocaByDateFormat(Date javaDate,String dateFormat){
        DateTime dateTime = new DateTime(javaDate);
        return dateTime.toString();
    }

    public static void main(String[] args) {
        //Tue Dec 12 18:01:00 CST 2017 北京位于东八区，结果会加8小时
        System.out.println(JodaTimeTest2.convertUTC2Date("2017-12-12T10:01:00.567Z"));

        //当前时间转成UTC标准时间 会减8小时
        System.out.println(JodaTimeTest2.convertDate2UTC(new Date()));

        //转换为本地UTC时间，带时区 2017-05-28T09:14:37.359+08:00
        System.out.println(JodaTimeTest2.
                convertDate2LocaByDateFormat(new Date(),"yyyy-MM-dd HH:mm:ss"));
    }
}
