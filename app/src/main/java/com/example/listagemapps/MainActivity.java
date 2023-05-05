package com.example.listagemapps;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    PackageManager packageManager;
    RecyclerView rcvMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        packageManager = getPackageManager();
        rcvMain = findViewById(R.id.rcvMain);

        AdapterApp adapterApp = new AdapterApp(CarregarListaApps(),packageManager);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rcvMain.setLayoutManager(layoutManager);
        rcvMain.setAdapter(adapterApp);
        rcvMain.setHasFixedSize(true);
    }

    public ArrayList<ApplicationInfo> CarregarListaApps(){
        List<PackageInfo> ListPK= packageManager.getInstalledPackages(PackageManager.GET_ACTIVITIES);
        ArrayList<ApplicationInfo> arrayListApps = new ArrayList<>();
        for(PackageInfo pkinfo:ListPK){
            try{
                arrayListApps.add(packageManager.getApplicationInfo(pkinfo.packageName,0));
            }catch (PackageManager.NameNotFoundException e){
                e.printStackTrace();
            }
        }
        return arrayListApps;
    }
}