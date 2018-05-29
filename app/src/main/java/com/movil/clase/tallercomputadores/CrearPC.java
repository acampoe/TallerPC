package com.movil.clase.tallercomputadores;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.security.Principal;
import java.util.ArrayList;

public class CrearPC extends AppCompatActivity {
    private String id;
    private Spinner cmbMarca,cmbTipo,cmbRam,cmbColor,cmbSo;
    private ArrayAdapter<String> adapterMarca,adapterTipo,adapterRam,adapterColor,adapterSo;
    private String[] opcMarca,opcTipo,opcRam,opcColor,opcSo;
    private ArrayList<Integer> fotos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_pc);

        cmbMarca = findViewById(R.id.cmbMarca);
        cmbTipo = findViewById(R.id.cmbTipo);
        cmbRam = findViewById(R.id.cmbRam);
        cmbColor = findViewById(R.id.cmbColor);
        cmbSo = findViewById(R.id.cmbSo);


        opcMarca = this.getResources().getStringArray(R.array.marcas);
        opcTipo = this.getResources().getStringArray(R.array.tipos);
        opcRam = this.getResources().getStringArray(R.array.rams);
        opcColor = this.getResources().getStringArray(R.array.colores);
        opcSo = this.getResources().getStringArray(R.array.sos);

        adapterMarca = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,opcMarca);
        adapterTipo = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item, opcTipo);
        adapterRam = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,opcRam);
        adapterColor = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,opcColor);
        adapterSo = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item, opcSo);

        cmbMarca.setAdapter(adapterMarca);
        cmbTipo.setAdapter(adapterTipo);
        cmbRam.setAdapter(adapterRam);
        cmbColor.setAdapter(adapterColor);
        cmbSo.setAdapter(adapterSo);

        fotos = new ArrayList<>();
        fotos.add(R.drawable.images1);
        fotos.add(R.drawable.images2);
        fotos.add(R.drawable.images3);
    }

    public void guardar(View v){
        int marca,tipo,ram,color,so, foto;

        foto = Datos.fotoAleatoria(fotos);
        marca = cmbMarca.getSelectedItemPosition();
        tipo = cmbTipo.getSelectedItemPosition();
        ram = cmbRam.getSelectedItemPosition();
        color = cmbColor.getSelectedItemPosition();
        so = cmbSo.getSelectedItemPosition();

        id = Datos.getId();

        Computador c = new Computador(id,marca,tipo,ram,color,so,foto);
        c.guardar();

        Snackbar.make(v,this.getResources().getString(R.string.exitoso),Snackbar.LENGTH_SHORT).setAction("Action",null).show();

    }
    public void onBackPressed(){
        finish();
        Intent i = new Intent(CrearPC.this, MainActivity.class);
        startActivity(i);
    }
}
