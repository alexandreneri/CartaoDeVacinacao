package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.firebase.client.ValueEventListener;
import com.neri.alexa.cartaodevacinacao.R;

import java.util.ArrayList;
import modal.Vacina;
import vacina.VacinasActivity;


public class VacinaAdapter extends ArrayAdapter{
    private Context context;
    private final ArrayList<Vacina> elementos;

    public VacinaAdapter(VacinasActivity context, ArrayList<Vacina> elementos) {
        super(context, R.layout.vacina, elementos);
        this.context = context;
        this.elementos = elementos;
    }

    public View getView (int position, View contvertView, ViewGroup parent){

       View view;
       ViewHolderVacina holder;

        if( contvertView == null) {
            view = LayoutInflater.from(context).inflate(R.layout.vacina, parent, false);
            holder = new ViewHolderVacina(view);
            view.setTag(holder);
        } else {
            view = contvertView;
            holder = (ViewHolderVacina) view.getTag();
        }

        holder.nomeVacina.setText(elementos.get(position).getVacina());
        holder.dose.setText(elementos.get(position).getDose());

        return view;
    }
}
