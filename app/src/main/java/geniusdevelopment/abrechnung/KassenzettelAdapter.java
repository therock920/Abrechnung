package geniusdevelopment.abrechnung;

import android.app.Activity;
import android.content.Context;
import android.database.DataSetObserver;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class KassenzettelAdapter extends ArrayAdapter {
    private LayoutInflater inflater;
    private ArrayList<Kassenzettel> KassenzettelList;
    private Context context;
    public KassenzettelAdapter(Activity activity,ArrayList<Kassenzettel> items ) {
        super(activity, R.layout.kassenzettel_row, items);
        this.KassenzettelList = items;
        inflater = activity.getWindow().getLayoutInflater();
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null)
            convertView = inflater.inflate(R.layout.kassenzettel_row,parent,false);
        TextView value_Verwendungszweck = (TextView) convertView.findViewById(R.id.value_zweck);
        TextView value_Erfasser = (TextView) convertView.findViewById(R.id.value_erfasser);
        TextView value_Betrag = (TextView) convertView.findViewById(R.id.value_betrag);
        TextView value_Datum = (TextView) convertView.findViewById(R.id.value_date);

        value_Verwendungszweck.setText(this.KassenzettelList.get(position).getVendor());
        value_Erfasser.setText(this.KassenzettelList.get(position).getCreator());
        value_Betrag.setText(String.valueOf(this.KassenzettelList.get(position).getSum()));
        value_Datum.setText(this.KassenzettelList.get(position).getDate());
        return convertView;
    }

    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }
}
