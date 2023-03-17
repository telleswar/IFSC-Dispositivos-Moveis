package com.ifsc.meuapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragment_a#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragment_a extends Fragment implements  View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public fragment_a() {
        // Required empty public constructor
    }

    EditText edMsg;
    Button btnAbrirFragB;
    View v;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fragment_a.
     */
    // TODO: Rename and change types and number of parameters
    public static fragment_a newInstance(String param1, String param2) {
        fragment_a fragment = new fragment_a();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_a, container, false);
        edMsg = v.findViewById(R.id.edMsg);
        btnAbrirFragB = v.findViewById(R.id.btnAbrirFragB);
        btnAbrirFragB.setOnClickListener(this);
        if (getArguments() != null) {
            edMsg.setText(getArguments().getString("msg"));
        }
        return v;
    }

    @Override
    public void onClick(View view) {
        FragmentTransaction ft =  getFragmentManager().beginTransaction();
        Bundle b = new Bundle();
        b.putString("msg",edMsg.getText().toString());
        Fragment fragB = new fragment_b();
        fragB.setArguments(b);
        //ft.replace(R.id.framemain,fragB);
        ft.commit();
    }
}