package com.example.firebaseretrieve;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "TAG";
    ListView mylistView;
    List<Brainfile> brainfileList;
    DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mylistView = findViewById(R.id.myListView);
        brainfileList = new ArrayList<>();

        Log.d("COBA", "_______");

        myRef = FirebaseDatabase.getInstance().getReference("Brainfile");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                brainfileList.clear();
                for(DataSnapshot brainfileDatasnap : snapshot.getChildren()){
                    Brainfile brainfile = brainfileDatasnap.getValue(Brainfile.class);
                    brainfileList.add(brainfile);
                    Log.d("TAG", brainfile.getPertanyaan());
                }

                Brainfileadapter brainfileadapter = new Brainfileadapter(MainActivity.this, brainfileList);
                mylistView.setAdapter(brainfileadapter);
            }

            @Override
            public void onCancelled(@NonNull  DatabaseError error) {

            }
        });
    }
}