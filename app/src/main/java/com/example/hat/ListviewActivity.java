package com.example.hat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListviewActivity extends AppCompatActivity {

    EditText edit1;
    int num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        edit1 = (EditText) findViewById(R.id.edit1);

    }
    public void clear(View v)
    {
        recreate();
    }


    public void Click (View v)
    {
        ListView listView = (ListView) findViewById(R.id.listview);

        ArrayList<Listviewitem> data = new ArrayList<>();

        String inPut = edit1.getText().toString();
        Listviewitem put = new Listviewitem(inPut);
        data.add(put);
        edit1.setText(null);

        num = ((int)(Math.random() * 4));
        num++;
        if (num == 1) {
            Listviewitem sad = new Listviewitem("글쎄... 아마 진주가면 있지 않을까?");
            data.add(sad);
        } else if (num == 2) {
            Listviewitem happy = new Listviewitem("안생겨요");
            data.add(happy);
        } else if (num == 3) {
            Listviewitem kk = new Listviewitem("저런...");
            data.add(kk);
        } else if (num == 4) {
            Listviewitem shival = new Listviewitem("쓰레기급");
            data.add(shival);
        }

        ListviewAdapter adapter = new ListviewAdapter (this,R.layout.item,data);
        listView.setAdapter(adapter);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_listview, menu);
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
    }
}
