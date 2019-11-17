package deepanshu.example.com.offlinescheduler.model;

import java.util.Date;

public class ScheduleData {

    private String title;
    private Date time;

    public ScheduleData(String title, Date time) {
        this.title = title;
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
