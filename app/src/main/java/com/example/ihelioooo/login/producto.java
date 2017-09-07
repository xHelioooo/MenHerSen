package com.example.ihelioooo.login;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class producto extends Fragment {

    Button btnModificar,btnIngresar;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View view= inflater.inflate(R.layout.fragment_producto, container, false);

        btnIngresar = (Button) view.findViewById(R.id.btn_IngresarProductos);
        btnModificar= (Button) view.findViewById(R.id.btn_ModificarProductos);

        btnModificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager=getFragmentManager();
                FragmentTransaction transaction2=manager.beginTransaction().addToBackStack("productosFragment");
                ModificarProductoFragment modificarProductoFragment=new ModificarProductoFragment();
                Bundle bundle=new Bundle();
                bundle.putString("test"," Segunda llamada desde fragment productos");
                modificarProductoFragment.setArguments(bundle);
                transaction2.replace(R.id.contenedorFragmentProductos, modificarProductoFragment,"ingPFragment");
                transaction2.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                transaction2.commit();
            }
        });

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager=getFragmentManager();
                FragmentTransaction transaction2=manager.beginTransaction().addToBackStack("productosFragment");
                IngresarProductoFragment ingresarProductoFragment =new IngresarProductoFragment();
                Bundle bundle=new Bundle();
                bundle.putString("test"," Segunda llamada desde fragment productos");
                ingresarProductoFragment.setArguments(bundle);
                transaction2.replace(R.id.contenedorFragmentProductos, ingresarProductoFragment,"ingPFragment");
                transaction2.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                transaction2.commit();
            }
        });


        return view;

    }
}
