package br.imd.fic.exemplosdialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class RadioDialogFragment extends DialogFragment implements DialogInterface.OnClickListener {

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        return new AlertDialog.Builder(getContext())
                .setTitle("Escolha a Linguagem")
                .setSingleChoiceItems(R.array.linguagens,1, this)
                .create();
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {

        String[] linguagens = getContext().getResources()
                .getStringArray(R.array.linguagens);

        String linguagem = linguagens[which];

        Toast.makeText(getContext(), linguagem, Toast.LENGTH_LONG).show();
    }
}
