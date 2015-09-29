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
        //teststring = new String[10];
        /*for(int i = 0;i < teststring.length;i++)
        {

            teststring[i] = "String " + i;
        }*/

        KassenzettelList = new ArrayList<Kassenzettel>();
        //KassenzettelList.add(new Kassenzettel("Mike","28.09.15","Franky",68.95));
        /*KassenzettelList.add(new Kassenzettel("Mike","26.09.15","Franky",50.24));
        KassenzettelList.add(new Kassenzettel("Mike","25.09.15","Franky",30.95));
        KassenzettelList.add(new Kassenzettel("Mike","24.09.15","Franky",47.81));
        KassenzettelList.add(new Kassenzettel("Mike","23.09.15","Franky",33.94));
        KassenzettelList.add(new Kassenzettel("Mike","20.09.15","Franky",15.69));
        KassenzettelList.add(new Kassenzettel("Mike","15.09.15","Franky",40.52));
        KassenzettelList.add(new Kassenzettel("Mike","10.09.15","Franky",12.95));
        KassenzettelList.add(new Kassenzettel("Mike","08.09.15","Franky",17.80));
        KassenzettelList.add(new Kassenzettel("Mike","03.09.15","Franky",67.47));*/
        Adapter1 = new KassenzettelAdapter(this,KassenzettelList);
        lv1.setAdapter(Adapter1);
        b2 = (Button) findViewById(R.id.button);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //KassenzettelList.add(new Kassenzettel("Rocky", "30.09.15", "Schlecker", 65.36));
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
        Log.d("Requestcode","Requestcode = " + requestCode);
        Bundle extras = data.getExtras();
        if(resultCode == RESULT_OK)
        {
            //Log.d("Erfasser:", data.getStringExtra("erfasser"));
            //Log.d("Date:", extras.getString("datum"));
            //Log.d("Zweck:", extras.getString("zweck"));
            //Log.d("Saldo:", extras.getString("saldo"));
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
