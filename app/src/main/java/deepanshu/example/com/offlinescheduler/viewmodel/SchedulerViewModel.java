package deepanshu.example.com.offlinescheduler.viewmodel;

import androidx.lifecycle.ViewModel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import deepanshu.example.com.offlinescheduler.model.ScheduleData;
import deepanshu.example.com.offlinescheduler.utils.DataUtils;

public class SchedulerViewModel extends ViewModel {

    public List<Date> getDates(){
        List<Date> dates = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        for (int i = 0; i< 4; i++){
            dates.add(calendar.getTime());
            calendar.add(Calendar.DAY_OF_MONTH,1);
        }
        return dates;
    }

    public List<ScheduleData> getScheduleData(Date date){
        List<ScheduleData> dataList = DataUtils.getSchedulerData();
        List<ScheduleData> filteredData = new ArrayList<>();
        SimpleDateFormat sf = new SimpleDateFormat("dd-MMM",Locale.getDefault());
        for (ScheduleData data: dataList) {
            if (sf.format(data.getTime()).equals(sf.format(date))){
                filteredData.add(data);
            }
        }
        return filteredData;
    }
}
