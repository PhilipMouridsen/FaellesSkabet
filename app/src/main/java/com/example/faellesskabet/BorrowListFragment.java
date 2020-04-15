package com.example.faellesskabet;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.List;
import java.util.Observable;
import java.util.Observer;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;

public class BorrowListFragment extends Fragment implements Observer {

    private TextView mBorrowers;
    private static BorrowDB BorrowDB;
    private RecyclerView mListRecyclerView;
    private ItemAdapter mItemAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BorrowDB = BorrowDB.get(getContext());
        BorrowDB.addObserver(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.list_fragment, container, false);

        BorrowDB.addObserver(this);

        mListRecyclerView = (RecyclerView) v.findViewById(R.id.list_recycler_view);
        mListRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


        updateUI();

        return v;
    }

    public void updateUI() {
        BorrowDB BorrowsDB = BorrowDB.get(getActivity());
        List<Borrow> borrowers = BorrowDB.getBorrowers();

        mItemAdapter = new ItemAdapter(borrowers);
        mListRecyclerView.setAdapter(mItemAdapter);
    }

    public void update(Observable obs, Object args) {
    updateUI();
    }

    private class ItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView mID;
        private TextView mName;
        private TextView mRoomNumber;
        private TextView mPhoneNumber;
        private TextView mDeposit;

        private Borrow mBorrow;

        public ItemHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.one_row, parent, false));

            //mID = (TextView) itemView.findViewById(R.id.borrow_id);
            mName = (TextView) itemView.findViewById(R.id.borrow_name);
            mRoomNumber = (TextView) itemView.findViewById(R.id.borrow_roomNo);
            mPhoneNumber = (TextView) itemView.findViewById(R.id.borrow_phoneNo);
            mDeposit = (TextView) itemView.findViewById(R.id.borrow_deposit);
        }

        public void bind(Borrow borrow) {
            mBorrow = borrow;
            //mID.setText(mBorrow.getID());
            mName.setText(mBorrow.getName());
            mRoomNumber.setText(mBorrow.getRoomNo());
            mPhoneNumber.setText(mBorrow.getPhoneNo());
            mDeposit.setText(mBorrow.getDeposit());

        }

        @Override
        public void onClick(View v) {
            //BorrowDB.deleteItem(mWhat.getText().toString());
        }

    }

    private class ItemAdapter extends RecyclerView.Adapter<ItemHolder> {
        private List<Borrow> mBorrowers;

        public ItemAdapter(List<Borrow> borrowers) {
            mBorrowers = borrowers;

        }

        @NonNull
        @Override
        public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            return new ItemHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(@NonNull ItemHolder holder, int position) {
            Borrow borrow = mBorrowers.get(position);
            holder.bind(borrow);
        }

        @Override
        public int getItemCount() {

            return mBorrowers.size();
        }
    }
}
