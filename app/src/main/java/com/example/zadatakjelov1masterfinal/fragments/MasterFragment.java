package com.example.zadatakjelov1masterfinal.fragments;


import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.zadatakjelov1masterfinal.R;
import com.example.zadatakjelov1masterfinal.providers.CategoryProvider;

import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MasterFragment extends Fragment {

   public interface  OnItemSelectedListener {

        void OnItemSelected(int position);
    }

    OnItemSelectedListener listener;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_master, container, false);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            listener = (OnItemSelectedListener)getActivity();
        } catch (ClassCastException e) {
                e.toString();
        }

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        final List<String> listaKategorija = CategoryProvider.getCategorysNames();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(),android.R.layout.simple_list_item_1,listaKategorija);
        ListView listaK = getActivity().findViewById(R.id.lista_kategorije);
        listaK.setAdapter(adapter);

       listaK.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            listener.OnItemSelected(position);
           }
       });

    }

}
