package br.imd.fic.exemplosdialogs;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class SimpleDialogFragment extends DialogFragment implements DialogInterface.OnClickListener {

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

        builder.setTitle("Escolha uma Linguagem")
                .setItems(R.array.linguagens, this);

        return builder.create();
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {

        String[] linguagens = getContext().getResources()
                .getStringArray(R.array.linguagens);

        String linguagem = linguagens[which];

        Toast.makeText(getContext(), linguagem, Toast.LENGTH_LONG).show();
    }
}
