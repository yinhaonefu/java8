package Joda;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.MonthDay;

/**
 * Created by yinhao on 17/5/28.
 */
public class Java8TimeTest {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        System.out.println(localDate.getYear() + "-" +
                localDate.getMonthValue() + "-" +
                localDate.getDayOfMonth());

        System.out.println("----------");

        //2017-12-12
        LocalDate localDate1 = LocalDate.of(2017,12,12);
        System.out.println(localDate1);

        System.out.println("----------");

        LocalDate localDate2 = LocalDate.of(2010,3,25);
        //3.25
        MonthDay monthDay  = MonthDay.of(localDate2.getMonth(),localDate2.getDayOfMonth());
        //3.25
        MonthDay monthDay1 = MonthDay.from(LocalDate.of(2011,3,25));
        //月和日相同，不关注年
        System.out.println(monthDay.equals(monthDay1));//true

        System.out.println("----------");

        //年月日时分秒
        LocalDateTime time = LocalDateTime.now();
        System.out.println(time);

        //增加3小时，20分钟
        LocalDateTime time1 = time.plusHours(3).plusMinutes(20);
        System.out.println(time1);

    }
}
