package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.neri.alexa.cartaodevacinacao.R;

import java.util.ArrayList;


import modal.VacinasTomadas;

public class VacinasTomadasAdapter extends ArrayAdapter{

    private Context context = null;
    private final ArrayList<VacinasTomadas> elementos;

    public VacinasTomadasAdapter(Context context, ArrayList<VacinasTomadas> elementos) {
        super(context, R.layout.vacinatomadas, elementos);
        this.context = context;
        this.elementos = elementos;
    }

    public View getView (int position, View contvertView, ViewGroup parent){

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.vacinatomadas, parent, false);

        TextView nomeUsuario = (TextView) rowView.findViewById(R.id.textViewVacinasVacinasTomadas);
        nomeUsuario.setText(elementos.get(position).getNome());

        return  rowView;
    }


}
