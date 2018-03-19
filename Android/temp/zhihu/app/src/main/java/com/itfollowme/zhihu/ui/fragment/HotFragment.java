package com.itfollowme.zhihu.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.itfollowme.zhihu.R;
import com.itfollowme.zhihu.ui.adapter.HotAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * http://frank-zhu.github.io/android/2015/01/16/android-recyclerview-part-1/
 */
public class HotFragment extends Fragment {

    @BindView(R.id.rv_hot_items) RecyclerView mRecyclerView;
    private HotAdapter hotadapter;

    public HotFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_hot, container, false);


        View view = inflater.inflate(R.layout.fragment_hot, container, false);
        //mRecyclerView=view.findViewById(R.id.rv_hot_items);
        ButterKnife.bind(this,view);
        hotadapter=new HotAdapter(getContext());
        ButterKnife.bind(view);
        mRecyclerView.setAdapter(hotadapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        return view;




    }

}
