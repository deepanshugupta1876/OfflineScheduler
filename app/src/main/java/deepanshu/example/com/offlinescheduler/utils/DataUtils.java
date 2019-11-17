package deepanshu.example.com.offlinescheduler.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import deepanshu.example.com.offlinescheduler.model.ScheduleData;

public class DataUtils {

    public static List<ScheduleData> getSchedulerData(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy, hh:mm aa", Locale.getDefault());
        List<ScheduleData> data = new ArrayList<>();
        try {
            data.add(new ScheduleData("Test1", simpleDateFormat.parse("17-11-2019, 04:25 pm")));
            data.add(new ScheduleData("Test2", simpleDateFormat.parse("18-11-2019, 01:25 pm")));
            data.add(new ScheduleData("Test3", simpleDateFormat.parse("19-11-2019, 08:25 pm")));
            data.add(new ScheduleData("Test4", simpleDateFormat.parse("20-11-2019, 08:25 pm")));
            data.add(new ScheduleData("Test5", simpleDateFormat.parse("17-11-2019, 01:25 pm")));
            data.add(new ScheduleData("Test6", simpleDateFormat.parse("17-11-2019, 07:25 pm")));
            data.add(new ScheduleData("Test7", simpleDateFormat.parse("18-11-2019, 04:25 pm")));
            data.add(new ScheduleData("Test8", simpleDateFormat.parse("20-11-2019, 01:00 am")));
            data.add(new ScheduleData("Test9", simpleDateFormat.parse("18-11-2019, 12:00 pm")));
            data.add(new ScheduleData("Test10", simpleDateFormat.parse("19-11-2019, 10:25 am")));
            data.add(new ScheduleData("Test11", simpleDateFormat.parse("18-11-2019, 03:25 pm")));
            data.add(new ScheduleData("Test12", simpleDateFormat.parse("19-11-2019, 04:25 pm")));
            data.add(new ScheduleData("Test13", simpleDateFormat.parse("18-11-2019, 05:25 pm")));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return data;
    }

}
