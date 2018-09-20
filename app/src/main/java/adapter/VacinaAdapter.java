package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.neri.alexa.cartaodevacinacao.R;

import java.util.ArrayList;
import modal.Vacina;


public class VacinaAdapter extends ArrayAdapter{
    private Context context = null;
    private final ArrayList<Vacina> elementos;

    public VacinaAdapter(Context context, ArrayList<Vacina> elementos) {
        super(context, R.layout.vacina, elementos);
        this.context = context;
        this.elementos = elementos;
    }

    public View getView (int position, View contvertView, ViewGroup parent){

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.vacina, parent, false);

        TextView nomeVacina = (TextView) rowView.findViewById(R.id.textViewNomeVacina);
        TextView idade =  (TextView) rowView.findViewById(R.id.textViewIdadeVacina);

        nomeVacina.setText(elementos.get(position).getVacina());
        idade.setText(elementos.get(position).getIdade());

        return  rowView;
    }
}
