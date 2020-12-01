package br.imd.fic.exemplosdialogs;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class MyDialogFragment extends DialogFragment implements DialogInterface.OnClickListener {

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

        builder.setTitle("Minha Pergunta")
                .setMessage("Entendeu como funciona o dialog?")
                .setPositiveButton("SIM", this)
                .setNegativeButton("NÃO", this);

        return builder.create();
    }

    @Override
    public void onClick(DialogInterface dialog, int i) {

        String msg = null;

        if(i == DialogInterface.BUTTON_POSITIVE) {
            msg = "Clicou no botão SIM";
        } else if(i == DialogInterface.BUTTON_NEGATIVE) {
            msg = "Clicou no botão NÃO";
        }

        Toast.makeText(getContext(), msg, Toast.LENGTH_LONG).show();
    }
}
