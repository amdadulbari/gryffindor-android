package com.gryffindor.lms.gryffindor.views.fragments;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.gryffindor.lms.gryffindor.R;
import com.gryffindor.lms.gryffindor.constants.SettingsConstant;

import java.util.ArrayList;
import java.util.List;

public class ClassListFragment extends Fragment{
    private ListView listView;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Class List");
        listView = view.findViewById(R.id.lvClassList);
        /*SharedPreferences pref = getActivity().getApplicationContext().getSharedPreferences(SettingsConstant.userSharedPref, 0);
        String status = pref.get("status","");*/
        ArrayList<String> classList = new ArrayList<>();
        classList.add("CSE");
        classList.add("MAT");
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, android.R.id.text1, classList);
        listView.setAdapter(adapter);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_class_list,container,false);
    }
}
