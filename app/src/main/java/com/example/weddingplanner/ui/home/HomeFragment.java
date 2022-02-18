package com.example.weddingplanner.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.weddingplanner.Akdh;
import com.example.weddingplanner.Bridal_shower;
import com.example.weddingplanner.Holud;
import com.example.weddingplanner.Mehendi_sangeet;
import com.example.weddingplanner.R;
import com.example.weddingplanner.Reception;
import com.example.weddingplanner.Wedding;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;


    private Button holud_button;
    private Button mehendi_button;
    private Button bridalshower_button;
    private Button akdh_button;
    private Button wedding_button;
    private Button reception_button;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        View root = inflater.inflate(R.layout.fragment_home, container, false);


        init(root);

        return root;
    }




    void init(View root){
        ImageSlider imageSlider = root.findViewById(R.id.slider);

        List<SlideModel> slideModels=new ArrayList<>();
        slideModels.add(new SlideModel("https://i.pinimg.com/736x/71/18/a2/7118a2e8ee4599532c9a86639604e6fe.jpg"));
        slideModels.add(new SlideModel("https://bdshowbiz.com/images/wed/2.jpg"));
        slideModels.add(new SlideModel("https://i.ytimg.com/vi/Yl410PvsOu4/maxresdefault.jpg"));
        slideModels.add(new SlideModel("https://3.imimg.com/data3/SG/MH/MY-9682556/marriage-party-management-500x500.jpg"));
        slideModels.add(new SlideModel("https://i.pinimg.com/736x/25/2d/77/252d77c0817bd75ba7fa83c523117f1c--winter-wedding-ceremonies-wedding-ceremony-decorations.jpg"));
        imageSlider.setImageList(slideModels,true);


        holud_button=(Button)root.findViewById(R.id.holud);
        holud_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getActivity(), Holud.class);
                startActivity(intent);
            }
        });



        //event mehendi to mehendi page

        mehendi_button=(Button) root.findViewById(R.id.mehendi_sangeet);
        mehendi_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getActivity(), Mehendi_sangeet.class);
                startActivity(intent);
            }
        });
        //event bridalshwr to bridalshwr page

        bridalshower_button=(Button) root.findViewById(R.id.bridal_shower);
        bridalshower_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getActivity(), Bridal_shower.class);
                startActivity(intent);
            }
        });

        //event Akdh to akdh page

        akdh_button=(Button)root.findViewById(R.id.akdh);
        akdh_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getActivity(), Akdh.class);
                startActivity(intent);
            }
        });
        //event wedding to wedding page

        wedding_button=(Button)root.findViewById(R.id.wedding);
        wedding_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getActivity(), Wedding.class);
                startActivity(intent);
            }
        });

        //event reception to reception page

        reception_button=(Button)root.findViewById(R.id.reception);
        reception_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getActivity(), Reception.class);
                startActivity(intent);
            }
        });




    }
}
