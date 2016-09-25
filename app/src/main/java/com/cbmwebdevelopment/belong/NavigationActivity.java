package com.cbmwebdevelopment.belong;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;

/**
 * Created by cmeehan on 23-Sep-16.
 */

public class NavigationActivity {
    protected void navigationActivity(int id, Context context){

        if (id == R.id.nav_home) { // Navigate to the main layout
            Intent intent = new Intent(context, MainActivity.class);
            context.startActivity(intent);
        } else if (id == R.id.nav_schedule) { // Navigate to the class schedule layout
            Intent intent = new Intent(context, ClassScheduleActivity.class);
            context.startActivity(intent);
        } else if (id == R.id.nav_events) {

        } else if (id == R.id.nav_phoenix) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }
    }
}
