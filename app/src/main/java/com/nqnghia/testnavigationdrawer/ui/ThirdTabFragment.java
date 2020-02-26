package com.nqnghia.testnavigationdrawer.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nqnghia.testnavigationdrawer.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ThirdTabFragment extends Fragment {

    public ThirdTabFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_third_tab, container, false);
    }
}
