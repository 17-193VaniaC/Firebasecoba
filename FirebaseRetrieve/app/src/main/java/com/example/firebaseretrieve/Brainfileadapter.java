package com.example.firebaseretrieve;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class Brainfileadapter extends ArrayAdapter {

    private Activity mContext;
    List<Brainfile> brainfileList;

    public Brainfileadapter(Activity mContext, List<Brainfile> brainfileList){
        super(mContext, R.layout.list_items);
        this.mContext = mContext;
        this.brainfileList = brainfileList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        LayoutInflater inflater = mContext.getLayoutInflater();
        View listitemView = inflater.inflate(R.layout.list_items, null, true);
        TextView pertanyaan = listitemView.findViewById(R.id.pertanyaan);
        TextView jawaban = listitemView.findViewById(R.id.jawaban);

        Brainfile brainfile = brainfileList.get(position);

        pertanyaan.setText(brainfile.getPertanyaan());
        jawaban.setText(brainfile.getJawaban());

        return listitemView;
    }
}
