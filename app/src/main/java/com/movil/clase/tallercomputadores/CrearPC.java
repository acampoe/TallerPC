package com.movil.clase.tallercomputadores;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class CrearPC extends AppCompatActivity {
    private String id;
    private Spinner cmbMarca,cmbTipo,cmbRam,cmbColor,cmbSo;
    private ArrayAdapter<String> adapterMarca,adapterTipo,adapterRam,adapterColor,adapterSo;
    private String[] opcMarca,opcTipo,opcRam,opcColor,opcSo;
    private ArrayAdapter<Integer> fotos;

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
        opcSo = this.getResources().getStringArray(R.array.colores);

        adapterMarca = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,opcMarca);
        adapterTipo = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item, opcTipo);
        adapterRam = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,opcRam);
        adapterColor = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,opcColor);
        adapterSo = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item, opcColor);

        cmbMarca.setAdapter(adapterMarca);
        cmbTipo.setAdapter(adapterTipo);
        cmbRam.setAdapter(adapterRam);
        cmbColor.setAdapter(adapterColor);
        cmbSo.setAdapter(adapterSo);
    }
}
