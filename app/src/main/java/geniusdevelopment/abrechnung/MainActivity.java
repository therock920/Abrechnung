package geniusdevelopment.abrechnung;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends Activity {
    private String[] teststring;
    private ListView lv1;
    private Button b2;
    private KassenzettelAdapter Adapter1;
    private ArrayList<Kassenzettel> KassenzettelList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv1 = (ListView)findViewById(R.id.listView);
                KassenzettelList = new ArrayList<Kassenzettel>();
        Adapter1 = new KassenzettelAdapter(this,KassenzettelList);
        lv1.setAdapter(Adapter1);
        b2 = (Button) findViewById(R.id.button);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Adapter1.notifyDataSetChanged();
                Intent i1 = new Intent(MainActivity.this,Kassenzettelerfassen.class);
                startActivityForResult(i1,15);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode,resultCode,data);
        Bundle extras = data.getExtras();
        if(resultCode == RESULT_OK)
        {
            KassenzettelList.add(new Kassenzettel(data.getStringExtra("erfasser"),extras.getString("datum"),extras.getString("zweck"),Double.parseDouble(extras.getString("saldo"))));
            Adapter1.notifyDataSetChanged();
        }
    }

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
    }
}
