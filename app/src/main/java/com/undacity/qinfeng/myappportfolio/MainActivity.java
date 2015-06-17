package com.undacity.qinfeng.myappportfolio;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.zip.Inflater;


public class MainActivity extends ActionBarActivity {

    private ListView appList;
    private Toast toast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        appList = (ListView) findViewById(R.id.app_list);

        App[] apps = new App[]{
                new App("sportify streamer", "SPOTIFY STREAMER",R.color.orange),
                new App("scores", "SCORES APP",R.color.orange),
                new App("library", "LIBRARY APP",R.color.orange),
                new App("build it bigger", "BUILD IT BIGGER",R.color.orange),
                new App("xyz reader", "XYZ READER",R.color.orange),
                new App("my capstone", "CAPSTONE: MY OWN APP",R.color.red, Color.WHITE),

        };

        ArrayAdapter<App> appArrayAdapter = new AppListAdapter<>(this, R.layout.app_item,apps);
        appList.setAdapter(appArrayAdapter);

    }

    class AppListAdapter<T> extends ArrayAdapter<T>{


        private int resource;

        public AppListAdapter(Context context, int resource, T[] objects) {
            super(context, resource, objects);
            this.resource = resource;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View v = inflater.inflate(this.resource, parent, false);

            Button btn =
                    (Button)v.findViewById(R.id.appButton);

            T t  = getItem(position);
            if(t instanceof App){
                final App app = (App) t;
                btn.setText(app.getLabel());
                btn.setTextColor(app.getTextColor());
                btn.setBackgroundColor(getResources().getColor(app.getColor()));
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if(toast!=null){
                            toast.cancel();
                        }
                        toast =Toast.makeText(getContext(), "This button will launch " + app.getName() + " app!", Toast.LENGTH_SHORT);
                        toast.show();
                        }


                });
            }

            return v;

        }
    }
/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/
}
