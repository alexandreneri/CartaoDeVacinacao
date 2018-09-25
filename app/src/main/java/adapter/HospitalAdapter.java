package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.neri.alexa.cartaodevacinacao.R;

import java.util.ArrayList;

import modal.Hospital;


public class HospitalAdapter extends ArrayAdapter{
    private Context context = null;
    private final ArrayList<Hospital> elementos;

    public HospitalAdapter(Context context, ArrayList<Hospital> elementos) {
        super(context, R.layout.hospital, elementos);
        this.context = context;
        this.elementos = elementos;
    }

    public View getView (int position, View contvertView, ViewGroup parent){

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.hospital, parent, false);

        TextView nomeHospital = (TextView) rowView.findViewById(R.id.textViewNomeHospital);

        nomeHospital.setText(elementos.get(position).getUnidade());

        return  rowView;
    }





}
