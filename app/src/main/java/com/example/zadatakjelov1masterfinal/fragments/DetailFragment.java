package com.example.zadatakjelov1masterfinal.fragments;


import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import com.example.zadatakjelov1masterfinal.R;
import com.example.zadatakjelov1masterfinal.providers.CategoryProvider;
import com.example.zadatakjelov1masterfinal.providers.JeloProvider;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends android.app.Fragment {

    private int position = 0;

    public interface OnSpinnerSelected {
        void onSpinnerClick(int position);
    }

    OnSpinnerSelected listener;




    public DetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @Override
    public void onAttach(Context context) {

        super.onAttach(context);

        try {
            listener = (OnSpinnerSelected)getActivity();
        } catch (ClassCastException e) {
            e.toString();
        }

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (savedInstanceState != null) {
           position = savedInstanceState.getInt("position");
        }

        final List<String> listaKategorija = CategoryProvider.getCategorysNames();
        Spinner spinner = getView().findViewById(R.id.spinner);
        SpinnerAdapter adapter = new ArrayAdapter<>(getActivity(),android.R.layout.simple_spinner_item,listaKategorija);
        spinner.setAdapter(adapter);
        spinner.setSelection(position);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                listener.onSpinnerClick(position);
                final List<String> listaJela = JeloProvider.getJeloNameByCategoryId(position);
                final ListView listVJela = getView().findViewById(R.id.list_view);
                ArrayAdapter<String> adapter1 = new ArrayAdapter<>(getActivity(),android.R.layout.simple_list_item_1,listaJela);
                listVJela.setAdapter(adapter1);

                final TextView opisJela = getView().findViewById(R.id.textView);
                final ImageView imageView = getView().findViewById(R.id.image_view);

                opisJela.setText(JeloProvider.jeloNull().toString());

                try {
                    InputStream is = getActivity().getAssets().open(JeloProvider.jeloNull().getImage());
                    Drawable drawable = Drawable.createFromStream(is,null);
                    imageView.setImageDrawable(drawable);
                } catch (IOException e) {
                    e.toString();
                }


                listVJela.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        opisJela.setText(JeloProvider.getJeloByName(listaJela.get(position)).toString());

                        try {
                            InputStream is = getActivity().getAssets().open(JeloProvider.getJeloByName(listaJela.get(position)).getImage());
                            Drawable drawable = Drawable.createFromStream(is,null);
                            imageView.setImageDrawable(drawable);
                        } catch (IOException e) {
                            e.toString();
                        }
                    }
                });

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

        savedInstanceState.putInt("position",position);

    }

    public void setContent(final int position) {

        this.position = position;

    }

    public void updateContent(final int position) {

        this.position = position;

        final List<String> listaKategorija = CategoryProvider.getCategorysNames();
        Spinner spinner = getView().findViewById(R.id.spinner);
        SpinnerAdapter adapter = new ArrayAdapter<>(getActivity(),android.R.layout.simple_spinner_item,listaKategorija);
        spinner.setAdapter(adapter);
        spinner.setSelection(position);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                final List<String> listaJela = JeloProvider.getJeloNameByCategoryId(position);
                final ListView listVJela = getView().findViewById(R.id.list_view);
                ArrayAdapter<String> adapter1 = new ArrayAdapter<>(getActivity(),android.R.layout.simple_list_item_1,listaJela);
                listVJela.setAdapter(adapter1);

                final TextView opisJela = getView().findViewById(R.id.textView);
                final ImageView imageView = getView().findViewById(R.id.image_view);

                opisJela.setText(JeloProvider.jeloNull().toString());

                try {
                    InputStream is = getActivity().getAssets().open(JeloProvider.jeloNull().getImage());
                    Drawable drawable = Drawable.createFromStream(is,null);
                    imageView.setImageDrawable(drawable);
                } catch (IOException e) {
                    e.toString();
                }


                listVJela.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        opisJela.setText(JeloProvider.getJeloByName(listaJela.get(position)).toString());

                        try {
                            InputStream is = getActivity().getAssets().open(JeloProvider.getJeloByName(listaJela.get(position)).getImage());
                            Drawable drawable = Drawable.createFromStream(is,null);
                            imageView.setImageDrawable(drawable);
                        } catch (IOException e) {
                            e.toString();
                        }
                    }
                });

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }
}
