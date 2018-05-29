package com.movil.clase.tallercomputadores;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdaptadorComputador.OnComputadorClickListener{
    private RecyclerView lstOpciones;
    private Intent i;
    private ArrayList<Computador> computadores;
    private AdaptadorComputador adapter;
    private LinearLayoutManager llm;
    private String db = "computadores";
    private DatabaseReference dataReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        lstOpciones = findViewById(R.id.lstOpciones);
        computadores = new ArrayList<>();

        llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        adapter = new AdaptadorComputador(computadores, this);

        lstOpciones.setLayoutManager(llm);
        lstOpciones.setAdapter(adapter);

        dataReference = FirebaseDatabase.getInstance().getReference();
        dataReference.child(db).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                computadores.clear();
                if (dataSnapshot.exists()){
                    for (DataSnapshot snapshot:dataSnapshot.getChildren()){
                        Computador P = snapshot.getValue(Computador.class);
                        computadores.add(P);
                    }
                }
                adapter.notifyDataSetChanged();
                Datos.setComputador(computadores);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void crerPC(View v){
        Intent i = new Intent(MainActivity.this,CrearPC.class);
        startActivity(i);
    }
    @Override
    public void onComputadorClick(Computador p) {
        Intent i = new Intent(MainActivity.this,InformacionComputador.class);
        Bundle b = new Bundle();
        b.putString("id",p.getId());
        b.putString("marca",p.getMarca());
        b.putString("tipo",p.getTipo());
        b.putString("ram",p.getRam());
        b.putString("color",p.getColor());
        b.putString("so",p.getSo());
        b.putInt("foto",p.getFoto());

        i.putExtra("datos",b);
        startActivity(i);
    }
}
