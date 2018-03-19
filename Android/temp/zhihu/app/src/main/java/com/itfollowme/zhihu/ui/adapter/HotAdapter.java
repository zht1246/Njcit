package com.itfollowme.zhihu.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.itfollowme.zhihu.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by masterzht on 2018/3/18.
 */

public class HotAdapter extends RecyclerView.Adapter<HotAdapter.NormalTextViewHolder> {

    private LayoutInflater mLayoutInflater;
    private Context mContext;
    private String[] mTitles;

    public HotAdapter(Context context) {
        mTitles = context.getResources().getStringArray(R.array.titles);
        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public NormalTextViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new NormalTextViewHolder(mLayoutInflater.inflate(R.layout.item_hot_text, parent, false));

    }




    @Override
    public void onBindViewHolder(@NonNull NormalTextViewHolder holder, int position) {

        holder.mTextView.setText(mTitles[position]);
    }

    @Override
    public int getItemCount() {
        return mTitles == null ? 0 : mTitles.length;
    }

    public static class NormalTextViewHolder extends RecyclerView.ViewHolder {


        @BindView(R.id.text_view) TextView mTextView;

        NormalTextViewHolder(View view) {
            super(view);
            //mTextView=view.findViewById(R.id.text_view);
            ButterKnife.bind(this,view);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("NormalTextViewHolder", "onClick--> position = " + getPosition());
                }
            });
        }
    }
}


