package com.movil.clase.tallercomputadores;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Random;


public class Datos {
    private static String db = "computadores";
    private static DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
    private static ArrayList<Computador> computadores  = new ArrayList();

    /*public static void guardar(Computador p){
        personas.add(p);
    }*/

    public static void guardar(Computador p){
        databaseReference.child(db).child(p.getId()).setValue(p);
    }

    public static ArrayList<Computador> obtener(){
        return computadores;
    }

    public static int fotoAleatoria(ArrayList<Integer> fotos){
        int fotoSeleccionada;
        Random r = new Random();
        fotoSeleccionada = r.nextInt(fotos.size());
        return  fotos.get(fotoSeleccionada);
    }

    public static String getId(){
        return databaseReference.push().getKey();
    }

    public static void setComputador(ArrayList<Computador> computadors){
        Datos.computadores = computadors;
    }

    public static void eliminarComputadors(Computador p){
        databaseReference.child(db).child(p.getId()).removeValue();
    }
}
