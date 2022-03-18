package com.example.se104_m21_pmcl_n10quanlysieuthi;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
<<<<<<< HEAD
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
=======
>>>>>>> parent of 30adc21 (thêm, test listview)

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

<<<<<<< HEAD
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class homeFragment extends Fragment {

    private View view;
    private ListView lstvPost;
    private Button btnReceive;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view=inflater.inflate(R.layout.frag_home,container,false);

        lstvPost=view.findViewById(R.id.lstvPost);
        btnReceive=view.findViewById(R.id.btnReceive);
        btnReceive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ReceiveDataFromDatabase();
                ReceiveDataFromDatabase();

            }
        });


        return inflater.inflate(R.layout.frag_home,container,false);
    }

    private void ReceiveDataFromDatabase(){

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
                        Toast.makeText(getContext(),snapshot.getValue(String.class),Toast.LENGTH_SHORT).show();
                    }
                    //txtvReceive.setText(dataSnapshot.child("Index").getValue(String.class));
                    adapterPost.notifyDataSetChanged();
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }

            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date today = new Date();
            String timeStamp=formatter.format(today);

            FirebaseDatabase db = FirebaseDatabase.getInstance("https://howkteamandroid-default-rtdb.asia-southeast1.firebasedatabase.app/");

            DatabaseReference dbrefNames=db.getReference("Meets7"/*Chỗ này là ID riêng biệt từng cuộc họp, nếu chưa tồn tại thì thêm vào*/)
                    .child(timeStamp).child("Name");

        });
    }

=======
public class homeFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.frag_home,container,false);
    }
>>>>>>> parent of 30adc21 (thêm, test listview)
}
