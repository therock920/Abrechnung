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
        //LayoutInflater mInflater = (LayoutInflater) getContext().getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        //LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.kassenzettel_row,parent,false);
        /*TextView TVTitle = (TextView)convertView.findViewById(R.id.textView);
        TextView TVBody = (TextView) convertView.findViewById(R.id.textView2);
        TextView TVBottom = (TextView) convertView.findViewById(R.id.textView3);
        Log.d("Kassenzettel", this.KassenzettelList.get(position).getVendor() + " - " + this.KassenzettelList.get(position).getDate() + " - " + this.KassenzettelList.get(position).getSum());
        TVTitle.setText(this.KassenzettelList.get(position).getVendor());
        TVBody.setText(String.valueOf(this.KassenzettelList.get(position).getSum()));
        TVBottom.setText(this.KassenzettelList.get(position).getDate());
        //return inflater.inflate(R.layout.kassenzettel_row,parent,false);*/
        //TextView lbl_Verwendungszweck = (TextView) convertView.findViewById(R.id.lbl_zweck);
        //TextView lbl_Erfasser = (TextView) convertView.findViewById(R.id.lbl_erfasser);
        //TextView lbl_Betrag = (TextView) convertView.findViewById(R.id.lbl_betrag);
        //TextView lbl_Datum = (TextView) convertView.findViewById(R.id.lbl_date);
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
