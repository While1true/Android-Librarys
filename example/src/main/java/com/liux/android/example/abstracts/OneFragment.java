package com.liux.android.example.abstracts;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.liux.android.abstracts.AbstractsFragment;
import com.liux.android.example.R;
import com.liux.android.tool.TT;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Liux on 2017/12/3.
 */

public class OneFragment extends AbstractsFragment {
    Unbinder unbinder;

    @BindView(R.id.et_text1)
    EditText etText1;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_base_one, container, false);
        unbinder = ButterKnife.bind(this, rootView);

        addIgnoreView(rootView.findViewById(R.id.btn_button_1));

        return rootView;
    }

    @OnClick({R.id.btn_button_1, R.id.btn_button_2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_button_1:
                TT.show(view.getContext(), "点击了按钮", TT.LENGTH_SHORT);
                break;
            case R.id.btn_button_2:
                startActivity(new Intent(getContext(), DialogActivity.class));
                break;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
