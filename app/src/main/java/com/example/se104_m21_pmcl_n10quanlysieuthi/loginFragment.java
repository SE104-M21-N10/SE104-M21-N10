package com.example.se104_m21_pmcl_n10quanlysieuthi;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class loginFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view =inflater.inflate(R.layout.frag_login,container,false);

        Account n0=new Account("tue","123456","HMT");
        Account n1=new Account("tri","654321","HMTri");
        Account n2=new Account("admin","456789","ad");
        Account n3=new Account("guest","987654","gue");

        final ArrayList<Account> lstAcc=new ArrayList<>();
        lstAcc.add(n0);
        lstAcc.add(n1);
        lstAcc.add(n2);
        lstAcc.add(n3);

        EditText txtAcc=view.findViewById(R.id.editTextTextPersonName);
        EditText txtPass=view.findViewById(R.id.editTextTextPassword);


        Button btnLogin=view.findViewById(R.id.button);
        btnLogin.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int i=0;
                while(i<lstAcc.size()) {
                    if (txtAcc.getText().toString().compareTo(lstAcc.get(i).login) == 0) {
                        if(txtPass.getText().toString().compareTo(lstAcc.get(i).pass) == 0){
                            Toast.makeText(getContext(), "Succeed login", Toast.LENGTH_SHORT).show();
                            getFragmentManager().beginTransaction().replace(R.id.mainScreen, new homeFragment(),null).commit();

                            return;
                        }

                    }
                    i++;
                }

            }
        }));

        return view;
    }
}
