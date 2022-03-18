package com.example.se104_m21_pmcl_n10quanlysieuthi;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class homeFragment extends Fragment {

    private View view;
    private ListView lstvPost;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view=inflater.inflate(R.layout.frag_home,container,false);

        lstvPost=view.findViewById(R.id.lstvPost);
        ReceiveDataToDatabase();


        return inflater.inflate(R.layout.frag_home,container,false);
    }

    private void ReceiveDataToDatabase(){

        FirebaseDatabase db = FirebaseDatabase.getInstance("https://howkteamandroid-default-rtdb.asia-southeast1.firebasedatabase.app/");

        final ArrayList<String> listpost=new ArrayList<>();
        final ArrayAdapter adapterPost=new ArrayAdapter<String>(getContext(),R.layout.list_post,listpost);

        lstvPost.setAdapter(adapterPost);
        DatabaseReference testretrieve=db.getReference("Danh sach mat hang").child("dua");
        testretrieve.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    listpost.clear();
                    for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                        listpost.add(snapshot.getValue(String.class));
                    }
                    //txtvReceive.setText(dataSnapshot.child("Index").getValue(String.class));
                    adapterPost.notifyDataSetChanged();
                }
                listpost.add("nhu cc");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

}
