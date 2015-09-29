package geniusdevelopment.abrechnung;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Kassenzettelerfassen extends Activity {
    private Button b1;
    private EditText e_erfasser;
    private EditText e_zweck;
    private EditText e_datum;
    private EditText e_saldo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kassenzettelerfassen);
        e_erfasser = (EditText) findViewById(R.id.editText);
        e_zweck = (EditText) findViewById(R.id.editText2);
        e_datum = (EditText) findViewById(R.id.editText3);
        e_saldo = (EditText) findViewById(R.id.editText4);

        b1 = (Button) findViewById(R.id.button3);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent returnintent = new Intent(Kassenzettelerfassen.this,MainActivity.class);
                //Intent returnintent = getIntent();
                returnintent.putExtra("erfasser", e_erfasser.getText().toString());
                returnintent.putExtra("zweck", e_zweck.getText().toString());
                returnintent.putExtra("datum", e_datum.getText().toString());
                returnintent.putExtra("saldo", e_saldo.getText().toString());
                Log.d("inside", "inside");
                if(getParent() == null) {
                    setResult(RESULT_OK, returnintent);
                } else {
                    getParent().setResult(RESULT_OK,returnintent);
                }
                finish();
            }
    });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_kassenzettelerfassen, menu);
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
