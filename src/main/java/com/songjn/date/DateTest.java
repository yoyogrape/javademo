package com.songjn.date;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

/**
 * @author cdp songjianan@codemao.cn
 * @version 1.0
 * @className DateTest
 * @description
 * @date 2021-01-29 13:43
 */
public class DateTest {

    public static void main(String[] args) {


        LocalDate d = LocalDate.now(); // 当前日期
        LocalTime t = LocalTime.now(); // 当前时间
        LocalDateTime dt = LocalDateTime.now(); // 当前日期和时间
//        System.out.println(d); // 严格按照ISO 8601格式打印
//        System.out.println(t); // 严格按照ISO 8601格式打印
//        System.out.println(dt); // 严格按照ISO 8601格式打印

        System.out.println(dt.toLocalDate());
        System.out.println(dt.toLocalTime());

        LocalDateTime now = LocalDateTime.now();
//        System.out.println(now);

        //格式化时间
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy年MM月dd日");
        String format1 = dtf.format(now);//传入时间
        String format2 = now.format(dtf);//传入格式
//        System.out.println(format);
//        System.out.println(format1);


        //Instant获取当前时间
        Instant instant = Instant.now();//相对于1970-01-01 00:00:00，取得是格林威治标准时间
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));//偏移8个小时
//        System.out.println(offsetDateTime);


        //获取系统时区的时间
        ZonedDateTime zonedDateTime = Instant.now().atZone(ZoneOffset.systemDefault());
//        System.out.println(zonedDateTime);

        //获取时间戳
        Instant instant3 = Instant.now();
        long epochSecond = instant3.getEpochSecond();//获取当前时间10位时间戳
        long l = instant3.toEpochMilli();//获取当前时间13位时间戳
//        System.out.println(epochSecond);
//        System.out.println(l);


        //时间间隔计算
        LocalDateTime ofStart = LocalDateTime.of(2020, 12, 29, 0, 0, 0);
        LocalDateTime ofEnd = LocalDateTime.of(2021, 1, 29, 0, 0, 0);
        Duration between = Duration.between(ofStart, ofEnd);
//        System.out.println(between.toDays());
//        System.out.println(between.getSeconds());

        //日期间隔
        Period between2 = Period.between(LocalDate.now(), LocalDate.now().withMonth(1));


        LocalDateTime now3 = LocalDateTime.now();
        LocalDateTime with = now3.with(TemporalAdjusters.firstDayOfMonth());
//        System.out.println(with);






    }


}
