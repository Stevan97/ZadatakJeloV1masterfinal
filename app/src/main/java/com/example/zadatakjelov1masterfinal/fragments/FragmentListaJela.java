package com.example.zadatakjelov1masterfinal.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.zadatakjelov1masterfinal.R;
import com.example.zadatakjelov1masterfinal.model.Jelo;
import com.example.zadatakjelov1masterfinal.providers.JeloProvider;

import java.util.List;

public class FragmentListaJela extends Fragment {

    private int position = 0;

    public interface OnItemSelectedListaJela {
        void OnItemClick(int position);
    }

    OnItemSelectedListaJela listener;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            listener = (OnItemSelectedListaJela)activity;
        } catch (ClassCastException e) {
            e.toString();
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
         super.onCreateView(inflater, container, savedInstanceState);

       return inflater.inflate(R.layout.fragment_lista_jela,container,false);

    }

    @Override
    public void onActivityCreated( Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        final List<Jelo> listaJela = JeloProvider.getJela();
        final ListView listView = getView().findViewById(R.id.fragment_lista_jela);
        ArrayAdapter<Jelo> adapter = new ArrayAdapter<>(getActivity(),android.R.layout.simple_list_item_1,listaJela);
        listView.setAdapter(adapter);


    }
}
