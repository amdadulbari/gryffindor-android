package com.gryffindor.lms.gryffindor.views.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.gryffindor.lms.gryffindor.R;
import com.gryffindor.lms.gryffindor.controllers.ClassController;

public class CreateClassFragment extends Fragment {

    private EditText etUserName;
    private EditText etName;
    private EditText etDetails;
    private EditText etInvitationCode;
    private Button btnSubmit;

    private String username;
    private String name;
    private String details;
    private String invitationCode;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Create Class");
        etUserName = view.findViewById(R.id.etUserName);
        etDetails = view.findViewById(R.id.etDetails);
        etInvitationCode = view.findViewById(R.id.etCode);
        etName = view.findViewById(R.id.etName);
        btnSubmit = view.findViewById(R.id.btnClassCreate);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = etUserName.getText().toString();
                details = etDetails.getText().toString();
                invitationCode = etInvitationCode.getText().toString();
                name = etName.getText().toString();

                Log.d("Btn", "Submitted");
                ClassController classController = new ClassController();
                boolean success;
                success = classController.createClass(username, name, details, invitationCode);
                if (success == true) {
                    Toast.makeText(getContext(), "Class Created Successfully", Toast.LENGTH_SHORT).show();
                    getActivity().getFragmentManager().popBackStack();
                }
            }
        });

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_create_class, container, false);
    }

}
