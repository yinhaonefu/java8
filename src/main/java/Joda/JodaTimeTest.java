package Joda;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;

/**
 * Created by yinhao on 17/5/28.
 */
public class JodaTimeTest {
    public static void main(String[] args) {

        DateTime today = new DateTime();
        DateTime tomorrow = today.plusDays(1);

        System.out.println("today:" + today.toString("yyyy-MM-dd"));
        System.out.println("-------");
        System.out.println("tomorrow" + tomorrow.toString("yyyy-MM-dd"));
        System.out.println("-------");

        DateTime firstDayOfMonth = today.withDayOfMonth(1);
        System.out.println("firstDayOfMonth:" + firstDayOfMonth.toString("yyyy-MM-dd"));
        System.out.println("-------");
        LocalDate localDate = new LocalDate();
        System.out.println(localDate);

        System.out.println("-------");
        //获取三个月后的月末那天
        DateTime future = today.plusMonths(3).dayOfMonth().withMaximumValue();
        System.out.println("future:" + future);
        System.out.println("-------");

        //两年前第三个月月末
        DateTime afterTwoYears = today.minusYears(2).monthOfYear().
                setCopy(3).dayOfMonth().withMaximumValue();
        System.out.println("afterTwoYears:" + afterTwoYears);
        System.out.println("-------");
    }
}
