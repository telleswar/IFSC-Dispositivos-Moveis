package com.example.listagemapps;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterApp extends RecyclerView.Adapter<AdapterApp.AppViewHolder> {

    private ArrayList<ApplicationInfo> listaApps;
    private PackageManager packageManager;

    public AdapterApp(ArrayList<ApplicationInfo> lista, PackageManager pm){
        this.packageManager = pm;
        this.listaApps = lista;
    }
    public class AppViewHolder extends RecyclerView.ViewHolder{
        ImageView imgApp;
        TextView txtNome;

        public AppViewHolder(@NonNull View itemView) {
            super(itemView);

            imgApp = itemView.findViewById(R.id.imgApp);
            txtNome = itemView.findViewById(R.id.txtNome);
        }
    }

    @NonNull
    @Override
    public AppViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item_lista = LayoutInflater.from(parent.getContext()).inflate(R.layout.app_item,parent,false);

        return new AppViewHolder(item_lista);
    }

    @Override
    public void onBindViewHolder(@NonNull AppViewHolder holder, int position) {
        ApplicationInfo applicationInfo = listaApps.get(position);
        holder.imgApp.setImageDrawable(packageManager.getApplicationIcon(applicationInfo));
        holder.txtNome.setText(packageManager.getApplicationLabel(applicationInfo));
    }

    @Override
    public int getItemCount() {
        return listaApps.size();
    }


}
