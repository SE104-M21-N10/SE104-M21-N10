package com.example.se104_m21_pmcl_n10quanlysieuthi;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class menuFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.frag_menu, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button btnHome = view.findViewById(R.id.btnHome);
        Button btnMemList = view.findViewById(R.id.btnMemList);
        Button btnAbout = view.findViewById(R.id.btnAbout);

        // Định nghĩa event onClick của button Home
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragManage = getActivity().getSupportFragmentManager();
                FragmentTransaction fragTrans = fragManage.beginTransaction();

                homeFragment fragHome = (homeFragment) getActivity().getSupportFragmentManager().findFragmentByTag("frgHome");
                if (fragHome == null) fragHome = new homeFragment();
                fragTrans.replace(R.id.contentContainer, fragHome, "frgHome");
                fragTrans.addToBackStack("backStack");
                fragTrans.commit();


                //if (fragManage.getBackStackEntryCount() == 0) return;
            }
        });


    }
}
