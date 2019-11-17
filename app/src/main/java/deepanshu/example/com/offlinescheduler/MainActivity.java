package deepanshu.example.com.offlinescheduler;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import deepanshu.example.com.offlinescheduler.adapter.SchedulerAdapter;
import deepanshu.example.com.offlinescheduler.databinding.ActivityMainBinding;
import deepanshu.example.com.offlinescheduler.model.ScheduleData;
import deepanshu.example.com.offlinescheduler.viewmodel.SchedulerViewModel;

public class MainActivity extends AppCompatActivity {
    public ActivityMainBinding binding;
    public SchedulerViewModel viewModel;
    public SchedulerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        init();
    }

    private void init() {
        initBinding();
        initToolbar();
        initViewModel();

        setDate();
        initRecylerview();
    }

    private void initRecylerview() {
        binding.schedulers.setLayoutManager(new LinearLayoutManager(this));
        binding.schedulers.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        List<ScheduleData> data = getFilterScheduledTimes(0);
        adapter = new SchedulerAdapter(data);
        binding.schedulers.setAdapter(adapter);
    }

    private void setDate() {
        List<Date> dates = viewModel.getDates();
        SimpleDateFormat sf = new SimpleDateFormat("dd-MMM", Locale.getDefault());
        binding.today.setText(sf.format(dates.get(0)));
        binding.tomorrow.setText(sf.format(dates.get(1)));
        binding.dayAfterTomorrow.setText(sf.format(dates.get(2)));
        binding.forthDay.setText(sf.format(dates.get(3)));
    }

    private void initViewModel() {
        viewModel = ViewModelProviders.of(this).get(SchedulerViewModel.class);
    }

    private void initToolbar() {
        if(getSupportActionBar() != null) {
            getSupportActionBar().setTitle(R.string.toolbar_title);
        }
    }

    private void initBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
    }

    private List<ScheduleData> getFilterScheduledTimes(int dateSelectedPosition){
        return viewModel.getScheduleData(viewModel.getDates().get(dateSelectedPosition));
    }

    public void onDateClicked(View view){
        int position = Integer.parseInt((String) view.getTag());
        adapter.updateList(getFilterScheduledTimes(position - 1));
    }
}
