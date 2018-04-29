package droid.demos.com.recyclerviewwithradiobuttons.views;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import droid.demos.com.recyclerviewwithradiobuttons.R;
import droid.demos.com.recyclerviewwithradiobuttons.fragments.FragmentMonth;

public class MainActivity extends AppCompatActivity implements FragmentMonth.SetOnChangeDataListener {

    private List<Boolean> statusList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        showFragment();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            for (int i = 0; i < statusList.size(); i++) {
                Log.e("STATUS", "::: " + statusList.get(i) + " :::");
            }
        }

        return super.onOptionsItemSelected(item);
    }

    private void showFragment() {
        FragmentMonth fragmentMonth = new FragmentMonth();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.conteinerFragments, fragmentMonth, FragmentMonth.TAG)
                .commit();
    }

    @Override
    public void setOnChangeData(int position) {
        Boolean newStatus = !statusList.get(position);
        statusList.set(position, newStatus);
    }

    @Override
    public void getListStatus(List<Boolean> statusList) {
        this.statusList = statusList;
    }
}
