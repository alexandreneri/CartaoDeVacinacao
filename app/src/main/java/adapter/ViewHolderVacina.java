package adapter;

import android.view.View;
import android.widget.TextView;

import com.neri.alexa.cartaodevacinacao.R;

public class ViewHolderVacina {

    final TextView nomeVacina;
    final TextView dose;

    public ViewHolderVacina (View view){
        nomeVacina = (TextView) view.findViewById(R.id.textViewNomeVacina);
        dose  = (TextView) view.findViewById(R.id.textViewIdadeVacina);
    }
}
