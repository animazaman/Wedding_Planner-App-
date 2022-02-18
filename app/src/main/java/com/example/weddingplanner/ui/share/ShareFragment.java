package com.example.weddingplanner.ui.share;

import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.weddingplanner.R;

import org.w3c.dom.Text;

public class ShareFragment extends Fragment {

    private ShareViewModel shareViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        

        View root = inflater.inflate(R.layout.fragment_share, container, false);
        init(root);
        return root;
    }
//user can directly mail us using our mail in about us page
    void init(View root) {

        TextView email= (TextView) root.findViewById(R.id.mail);
        email.setText(Html.fromHtml("<a href=\"mailto:weddingplanner693@gmail.com.au\"> weddingplanner693@gmail.com.au</a>"));
        email.setMovementMethod(LinkMovementMethod.getInstance());
    }


}