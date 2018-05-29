package com.movil.clase.tallercomputadores;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class InformacionComputador extends AppCompatActivity {
    private TextView txtMarca,txtTipo,txtRam,txtColor,txtSo;
    private ImageView foto;
    private String marca,tipo,ram,color,so;
    int fotod;
    private Intent i;
    private Bundle bundle;
    private String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion_computador);

        i = getIntent();
        txtMarca = findViewById(R.id.txtMarca);
        txtTipo = findViewById(R.id.txtTipo);
        txtRam = findViewById(R.id.txtRam);
        txtColor = findViewById(R.id.txtColor);
        txtSo = findViewById(R.id.txtSo);
        foto = findViewById(R.id.imgFoto);

        bundle = i.getBundleExtra("datos");

        marca = bundle.getString("marca");
        tipo = bundle.getString("tipo");
        ram =bundle.getString("ram");
        color = bundle.getString("color");
        so = bundle.getString("so");
        id = bundle.getString("id");
        fotod = bundle.getInt("foto");

       txtMarca.setText(marca);
       txtTipo.setText(tipo);
       txtRam.setText(ram);
       txtColor.setText(color);
       txtSo.setText(so);
       foto.setImageResource(fotod);
    }
    public void eliminar(View v){
        String positivo,negativo;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getResources().getString(R.string.eliminar));
        builder.setMessage(getResources().getString(R.string.pregunta_eliminacion));
        positivo = getResources().getString(R.string.positivo);
        negativo = getResources().getString(R.string.negativo);

        builder.setPositiveButton(positivo, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Computador p = new Computador(id);
                p.eliminar();
                onBackPressed();
            }
        });

        builder.setNegativeButton(negativo, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
    public void onBackPressed() {
        finish();
        Intent i = new Intent(InformacionComputador.this,MainActivity.class);
        startActivity(i);
    }
}
