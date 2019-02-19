package com.example.zadatakjelov1masterfinal.fragments;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.content.LocalBroadcastManager;
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
import com.example.zadatakjelov1masterfinal.activities.MainActivity;
import com.example.zadatakjelov1masterfinal.async.MyAsyncTask;
import com.example.zadatakjelov1masterfinal.async.MyReceiver;
import com.example.zadatakjelov1masterfinal.async.MyService;
import com.example.zadatakjelov1masterfinal.providers.CategoryProvider;
import com.example.zadatakjelov1masterfinal.providers.JeloProvider;
import com.example.zadatakjelov1masterfinal.tools.ReviewerTools;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends android.app.Fragment {

    private Context context;
    private int position = 0;
    MyReceiver myReceiver;

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

        return inflater.inflate(R.layout.fragment_detail, container, false);


    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            listener = (OnSpinnerSelected)activity;
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
            public void onItemSelected(AdapterView<?> parent, View view, final int position, long id) {
                listener.onSpinnerClick(position);
                final List<String> listaJela = JeloProvider.getJeloNameByCategoryId(position);
                final ListView listVJela = getView().findViewById(R.id.list_view);
                ArrayAdapter<String> adapter1 = new ArrayAdapter<>(getActivity(),android.R.layout.simple_list_item_1,listaJela);
                listVJela.setAdapter(adapter1);

                final TextView opisJela = getView().findViewById(R.id.textView);
                final ImageView imageView = getView().findViewById(R.id.image_view);
                final FloatingActionButton floatingActionButton = getView().findViewById(R.id.floatingActionButton);

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
                    public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                        opisJela.setText(JeloProvider.getJeloByName(listaJela.get(position)).toString());


                        try {
                            InputStream is = getActivity().getAssets().open(JeloProvider.getJeloByName(listaJela.get(position)).getImage());
                            Drawable drawable = Drawable.createFromStream(is,null);
                            imageView.setImageDrawable(drawable);
                        } catch (IOException e) {
                            e.toString();
                        }


                        floatingActionButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                int status = ReviewerTools.getConnectivityStatus(getActivity().getApplicationContext());
                                String string = JeloProvider.getJeloByName(listaJela.get(position)).getNaziv();
                                Intent intent = new Intent(getActivity(), MyService.class);
                                intent.putExtra("STATUS", status);
                                intent.putExtra("Finish", string);
                                getActivity().startService(intent);

                            }
                        });


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

    public void setUpReceiver() {

        myReceiver = new MyReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("Order");
        getActivity().registerReceiver(myReceiver, intentFilter);


    }

    @Override
    public void onResume() {
        super.onResume();
        setUpReceiver();



    }

    @Override
    public void onPause() {
        super.onPause();
        getActivity().unregisterReceiver(myReceiver);

    }
}
