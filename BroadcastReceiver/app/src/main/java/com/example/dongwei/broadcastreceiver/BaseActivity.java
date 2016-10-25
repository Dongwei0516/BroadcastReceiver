package com.example.dongwei.broadcastreceiver;

import android.app.Activity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class BaseActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCollector.addActivity(this);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }

    public static class ActivityCollector{
        public static List<Activity>activities = new ArrayList<Activity>();

        public static void addActivity(Activity activity){
            activities.add(activity);

        }

        public static void removeActivity(Activity activity){
            activities.remove(activity);
        }

        public static void finishAll(){
            for (Activity activity : activities){
                if (!activity.isFinishing()){
                    activity.finish();
                }
            }
        }

    }

}
