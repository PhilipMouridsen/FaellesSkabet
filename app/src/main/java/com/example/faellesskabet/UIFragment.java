package com.example.faellesskabet;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class UIFragment extends Fragment {

    private static BorrowDB BorrowDB;

    private Button mExistingUsers;
    private Button mNewUser;
    private EditText mName;
    private EditText mRoomNumber;
    private EditText mPhoneNumber;
    private EditText mDeposit;
    private TextView mDate;
    private EditText mItems;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BorrowDB = BorrowDB.get(getContext());
    }

    @Override
    @Nullable
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_ui, container, false);

        mExistingUsers = v.findViewById(R.id.existing_user);
        mExistingUsers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), BorrowListActivity.class);
                startActivity(intent);
            }
        });

        mNewUser = v.findViewById(R.id.createBorrowerButton);
        mNewUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mName.getText().toString().length() > 0 && mRoomNumber.getText().toString().length() > 0 &&
                mPhoneNumber.getText().toString().length() > 0 && mDeposit.getText().toString().length() > 0) {
                    BorrowDB.addBorrower(mName.getText().toString(), mRoomNumber.getInputType(),
                            mPhoneNumber.getInputType(), mDeposit.getInputType());
                    mName.getText().clear();
                    mRoomNumber.getText().clear();
                    mPhoneNumber.getText().clear();
                    mDeposit.getText().clear();
                }
            }
        });

        mName = v.findViewById(R.id.name);

        mRoomNumber = v.findViewById(R.id.roomNumber);

        mPhoneNumber = v.findViewById(R.id.phoneNumber);

        mDeposit = v.findViewById(R.id.deposit);

        mDate = v.findViewById(R.id.datePicker);

        mItems = v.findViewById(R.id.item);


        return v;
    }


}
