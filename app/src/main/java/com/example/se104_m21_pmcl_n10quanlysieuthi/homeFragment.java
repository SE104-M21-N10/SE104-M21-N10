package com.example.se104_m21_pmcl_n10quanlysieuthi;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.util.ArrayList;

public class homeFragment extends Fragment {

    private View view;
    private ListView lstvPost;
    private ImageView imageView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.frag_home,container,false);
        return inflater.inflate(R.layout.frag_home,container,false);
    }

    private void ReceiveDataFromDatabase(){

        FirebaseDatabase db = FirebaseDatabase.getInstance("https://howkteamandroid-default-rtdb.asia-southeast1.firebasedatabase.app/");
        DatabaseReference testretrieve=db.getReference("Danh sach mat hang").child("buoi");

        testretrieve.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if(dataSnapshot.exists()){

                }
                Toast.makeText(getContext(),dataSnapshot.getValue(String.class) , Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void RetriveImageFromDatabase(){

        StorageReference storageRef = FirebaseStorage.getInstance("gs://howkteamandroid.appspot.com/").getReference().child("imgs/1");
        imageView=view.findViewById(R.id.imgvImage);

        try {
            File localfile=File.createTempFile("tempfile","jpg");
            storageRef.getFile(localfile);
            Bitmap bitmap= BitmapFactory.decodeFile(localfile.getAbsolutePath());

        }
        catch (Exception ex){

        }

    }
}
