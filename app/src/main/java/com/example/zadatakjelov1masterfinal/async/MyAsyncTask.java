package com.example.zadatakjelov1masterfinal.async;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

public class MyAsyncTask extends AsyncTask<Integer, Void, Integer> {

    private Context context;
    private String string;

    public MyAsyncTask(Context context, String string) {
        this.context = context;
        this.string = string;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }


    @Override
    protected Integer doInBackground(Integer... integers) {

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(Integer integer) {
        super.onPostExecute(integer);

        Intent intent = new Intent("Order");
        intent.putExtra("RESULT_CODE", integer);
        intent.putExtra("Finish", string);
        context.sendBroadcast(intent);

    }
}
