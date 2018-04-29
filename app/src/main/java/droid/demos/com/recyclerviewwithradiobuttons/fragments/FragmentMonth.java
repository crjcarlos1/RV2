package droid.demos.com.recyclerviewwithradiobuttons.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import droid.demos.com.recyclerviewwithradiobuttons.R;
import droid.demos.com.recyclerviewwithradiobuttons.adapters.AdapterMonth;
import droid.demos.com.recyclerviewwithradiobuttons.models.Month;

public class FragmentMonth extends Fragment implements AdapterMonth.SetOnClickListener {

    public static final String TAG = FragmentMonth.class.getSimpleName();
    private RecyclerView rv;
    private AdapterMonth adapterMonth;

    private SetOnChangeDataListener setOnChangeDataListener;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rv, container, false);
        rv = (RecyclerView) view.findViewById(R.id.rv);
        init();
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        setOnChangeDataListener = (SetOnChangeDataListener) context;
    }

    @Override
    public void onItemClick(int position, View v) {
        adapterMonth.changedData(position);
        setOnChangeDataListener.setOnChangeData(position);
    }

    private void init() {
        List<Month> monthList = new ArrayList<>();

        monthList.add(new Month("Enero", false));
        monthList.add(new Month("Febrero", false));
        monthList.add(new Month("Marzo", false));
        monthList.add(new Month("Abril", false));
        monthList.add(new Month("Mayo", false));
        monthList.add(new Month("Junio", false));
        monthList.add(new Month("Julio", false));
        monthList.add(new Month("Agos", false));
        monthList.add(new Month("Septiembre", false));
        monthList.add(new Month("Ocutbre", false));
        monthList.add(new Month("Noviembre", false));
        monthList.add(new Month("Diciembre", false));

        adapterMonth = new AdapterMonth(monthList);
        rv.setAdapter(adapterMonth);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(layoutManager);
        adapterMonth.setOnItemClickListener(this);

        List<Boolean> statusList = new ArrayList<>();
        for (int i = 0; i < monthList.size(); i++) {
            statusList.add(false);
        }
        setOnChangeDataListener.getListStatus(statusList);

    }

    public interface SetOnChangeDataListener {
        public void setOnChangeData(int position);

        public void getListStatus(List<Boolean> statusList);
    }

}
