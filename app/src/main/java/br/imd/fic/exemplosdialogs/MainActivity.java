package br.imd.fic.exemplosdialogs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openDialog(View view) {
        MyDialogFragment dialog = new MyDialogFragment();
        dialog.show(getSupportFragmentManager(), "dialog");
    }

    public void openSimple(View view) {
        SimpleDialogFragment simpleDialog = new SimpleDialogFragment();
        simpleDialog.show(getSupportFragmentManager(), "simpleDialog");
    }

    public void openRadio(View view) {
        RadioDialogFragment radioDialog = new RadioDialogFragment();
        radioDialog.show(getSupportFragmentManager(), "radioDialog");
    }

    public void openMultiple(View view) {
        MultipleDialogFragment multipleDialog = new MultipleDialogFragment();
        multipleDialog.show(getSupportFragmentManager(), "multipleDialog");
    }

    public void openEdit(View view) {
        MyEditDialogFragment.show(getSupportFragmentManager(), new MyEditDialogFragment.OnTextListener() {
            @Override
            public void onSetText(String text) {
                Toast.makeText(MainActivity.this, text, Toast.LENGTH_LONG).show();
            }
        });
    }
}