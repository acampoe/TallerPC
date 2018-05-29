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
    private int marca,tipo,ram,color,so, fotod;
    private String[] detMarca,detTipo,detRam,detColor,detSo;
    private Intent i;
    private Bundle bundle;
    private String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion_computador);

        txtMarca = findViewById(R.id.lblMarca);
        txtTipo = findViewById(R.id.lblTipo);
        txtRam = findViewById(R.id.lblRam);
        txtColor = findViewById(R.id.lblColor);
        txtSo = findViewById(R.id.lblSo);
        foto = findViewById(R.id.imgFoto);
        detMarca = this.getResources().getStringArray(R.array.marcas);
        detTipo = this.getResources().getStringArray(R.array.tipos);
        detRam = this.getResources().getStringArray(R.array.rams);
        detColor = this.getResources().getStringArray(R.array.colores);
        detSo = this.getResources().getStringArray(R.array.sos);

        bundle = i.getBundleExtra("datos");
        marca = bundle.getInt("marca");
        tipo = bundle.getInt("tipo");
        ram =bundle.getInt("ram");
        color = bundle.getInt("color");
        so = bundle.getInt("so");
        id = bundle.getString("id");

        txtMarca.setText(detMarca[marca]);
        txtTipo.setText(detTipo[tipo]);
        txtRam.setText(detRam[ram]);
        txtColor.setText(detColor[color]);
        txtSo.setText(detColor[so]);
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
