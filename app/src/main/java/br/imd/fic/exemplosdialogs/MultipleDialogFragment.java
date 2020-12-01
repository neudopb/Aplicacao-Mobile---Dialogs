package br.imd.fic.exemplosdialogs;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class MultipleDialogFragment extends DialogFragment implements DialogInterface.OnMultiChoiceClickListener {

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        boolean[] checkeds = {false, true, false, true, false, false};

        return new AlertDialog.Builder(getContext())
                .setTitle("Escolha uma ou mais linguagens")
                .setMultiChoiceItems(R.array.linguagens, checkeds, this)
                .create();
    }

    @Override
    public void onClick(DialogInterface dialog, int which, boolean isChecked) {

        String[] linguagens = getContext().getResources().getStringArray(R.array.linguagens);
        String linguagem = linguagens[which];

        if(isChecked) {
            Toast.makeText(getContext(), "Você marcou a linguagem " + linguagem, Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getContext(), "Você desmarcou a linguagem " + linguagem, Toast.LENGTH_LONG).show();
        }
    }
}
