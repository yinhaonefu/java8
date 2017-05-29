package Joda;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Set;
import java.util.TreeSet;

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

        System.out.println("----------");

        LocalDate localDate3 = LocalDate.now();
        System.out.println(localDate3.plus(2, ChronoUnit.WEEKS));//增加两周

        System.out.println("----------");

        System.out.println(localDate.minus(2,ChronoUnit.WEEKS));//后退两周

        System.out.println("----------");

        Clock clock = Clock.systemDefaultZone();
        System.out.println(clock.millis());

        System.out.println("----------");

        LocalDate localDate4 = LocalDate.now();
        LocalDate localDate5 = LocalDate.of(2017,12,12);
        System.out.println(localDate4.isAfter(localDate5));
        System.out.println(localDate4.isBefore(localDate5));
        System.out.println(localDate4.equals(localDate5));

        System.out.println("----------");

        Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
        availableZoneIds.stream().forEach(System.out::println);//所有时区 地区/地名

        System.out.println("----------");

        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.addAll(availableZoneIds);
        treeSet.stream().forEach(System.out::println);//所有时区 排序

        System.out.println("----------");

        ZoneId zoneId = ZoneId.of("Asia/Shanghai");
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);//2017-05-28T21:01:02.864 本地时间
        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime,zoneId);
        System.out.println(zonedDateTime);//2017-05-28T21:01:02.864+08:00[Asia/Shanghai] 带时区的时间

        System.out.println("----------");

        YearMonth yearMonth = YearMonth.now();
        System.out.println(yearMonth);
        System.out.println(yearMonth.lengthOfMonth());//天数
        System.out.println(yearMonth.isLeapYear());//是不是闰年

        System.out.println("----------");

        YearMonth yearMonth1 = YearMonth.of(2016,2);
        System.out.println(yearMonth1);
        System.out.println(yearMonth1.lengthOfMonth());//天数
        System.out.println(yearMonth1.lengthOfYear());//天数
        System.out.println(yearMonth1.isLeapYear());//是不是闰年

        System.out.println("----------");

        LocalDate localDate6 = LocalDate.now();
        LocalDate localDate7 = LocalDate.of(2018,5,29);
        Period period = Period.between(localDate6,localDate7);
        System.out.println(period.getYears());//间隔年数
        System.out.println(period.getMonths());//间隔月数 只比较月数
        System.out.println(period.getDays());//间隔天数 只比较天

        System.out.println("----------");

        System.out.println(Instant.now());//标准UTC时间 不带时区 北京时间减8小时



    }
}
