package com.movil.clase.tallercomputadores;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.security.PrivateKey;
import java.util.ArrayList;

public class AdaptadorComputador extends RecyclerView.Adapter<AdaptadorComputador.ComputadorViewHolder> {
    private ArrayList<Computador> computadores;
    private OnComputadorClickListener clickListener;
    private String[] opcMarca,opcTipo,opcRam,opcColor,opcSo;
    public AdaptadorComputador(ArrayList<Computador> computadores, OnComputadorClickListener clickListener) {
        this.computadores = computadores;
        this.clickListener = clickListener;

    }

    @Override
    public ComputadorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_detalle__pc,parent,false);
        return new ComputadorViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ComputadorViewHolder holder, int position) {
        final Computador c = computadores.get(position);
        holder.foto.setImageResource(c.getFoto());
        holder.marca.setText(c.getMarca());
        holder.tipo.setText(c.getTipo());
        holder.ram.setText(c.getRam());
        holder.color.setText(c.getColor());
        holder.so.setText(c.getSo());

        holder.v.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                clickListener.onComputadorClick(c);
            }
        });
    }

    @Override
    public int getItemCount() {
        return computadores.size();
    }

    public class ComputadorViewHolder extends RecyclerView.ViewHolder{
        private ImageView foto;
        private TextView marca;
        private TextView tipo;
        private TextView ram;
        private TextView color;
        private TextView so;
        private View v;

        public ComputadorViewHolder(View itemView) {
            super(itemView);
            v = itemView;

            foto = v.findViewById(R.id.imgFoto);
            marca = v.findViewById(R.id.lblMarca);
            tipo = v.findViewById(R.id.lblTipo);
            ram = v.findViewById(R.id.lblRam);
            color = v.findViewById(R.id.lblColor);
            so = v.findViewById(R.id.lblSo);
        }
    }

    public interface OnComputadorClickListener{
        void onComputadorClick(Computador c);
    }
}
