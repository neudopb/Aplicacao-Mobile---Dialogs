package br.imd.fic.exemplosdialogs;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;

public class MyEditDialogFragment extends DialogFragment {

    private EditText editText;
    private OnTextListener listener;

    public static void show(FragmentManager fm, OnTextListener listener) {
        MyEditDialogFragment dialog = new MyEditDialogFragment();
        dialog.listener = listener;
        dialog.show(fm,"textEditDialog");
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

        builder.setTitle("Insira seu texto aqui");

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(listener != null) {
                    String text = editText.getText().toString();
                    listener.onSetText(text);
                }
            }
        });

        builder.setNegativeButton("CANCELAR", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dismiss();
            }
        });

        View view = getActivity().getLayoutInflater().inflate(R.layout.dialog_my_edit, null);

        editText = view.findViewById(R.id.edit_texto);

        builder.setView(view);

        return builder.create();
    }

    public interface OnTextListener {
        void onSetText(String text);
    }
}
