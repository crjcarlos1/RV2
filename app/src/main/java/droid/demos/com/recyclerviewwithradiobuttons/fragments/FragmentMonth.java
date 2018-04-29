package droid.demos.com.recyclerviewwithradiobuttons.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import droid.demos.com.recyclerviewwithradiobuttons.R;

public class FragmentMonth extends Fragment {

    public static final String TAG=FragmentMonth.class.getSimpleName();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_rv,container,false);
        return view;
    }
}
