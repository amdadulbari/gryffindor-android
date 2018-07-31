package com.gryffindor.lms.gryffindor.views.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.gryffindor.lms.gryffindor.R;
import com.gryffindor.lms.gryffindor.controllers.ClassController;

public class JoinClassFragment extends Fragment{

    EditText etJoinCode;
    Button btnJoin;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Join Class");
        etJoinCode = view.findViewById(R.id.etJoinCode);
        btnJoin = view.findViewById(R.id.btnJoin);
        btnJoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClassController classController = new ClassController();
                boolean success;
                success = classController.joinClass(etJoinCode.getText().toString());
                if(success){
                    Toast.makeText(getContext(),"Class Joined Successfully",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_join_class,container,false);
    }
}
