package com.example.weddingplanner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class Bridal_Shower_Package2 extends AppCompatActivity {

    ListView listview;
    String package_id = "bridal_shower_package_1_2";
    String package_name = "Bridal_Shower Medium";
    String package_type = "Bridal_Shower";
    String price = "35000";

    String mtitle[] = {"Flower","Lighting","Stage","Food","Music","Decoration"};
    String mDescription[]={"Artificial themed Flower","Themed lighting","Stage Decorated with flower and fabric","Themed cake with sweets and other items ","Sound box and other instruments ","Outdour decoration"};
    int images[] ={R.drawable.bs_flower,
            R.drawable.bs_lighting,
            R.drawable.bridalshower_stage2,
            R.drawable.bridalshower_food2,
            R.drawable.wedding_music2,
            R.drawable.bs_deco};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bridal__shower__package2);

        final FloatingActionButton add_to_cart = findViewById(R.id.add_to_cart);
        add_to_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                add_to_cart.setEnabled(false);
                addToCartInDatabase();
            }
        });

        listview = findViewById(R.id.listview);
        //listview.setAdapter((adapter2));

        //adapter class
        Bridal_Shower_Package2.MyAdapter adapter = new   Bridal_Shower_Package2.MyAdapter(this,mtitle,mDescription,images);
        listview.setAdapter(adapter);



        // set item click on list view

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==0){
                    Toast.makeText( Bridal_Shower_Package2.this,"Flower",Toast.LENGTH_SHORT).show();
                }
                if(i==1){
                    Toast.makeText(  Bridal_Shower_Package2.this,"Lighting",Toast.LENGTH_SHORT).show();
                }
                if(i==2){
                    Toast.makeText(  Bridal_Shower_Package2.this,"Stage",Toast.LENGTH_SHORT).show();
                }
                if(i==3){
                    Toast.makeText(  Bridal_Shower_Package2.this,"Food",Toast.LENGTH_SHORT).show();
                }
                if(i==4){
                    Toast.makeText(  Bridal_Shower_Package2.this,"Music",Toast.LENGTH_SHORT).show();
                }
                if(i==5){
                    Toast.makeText(  Bridal_Shower_Package2.this,"Decoration",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    void addToCartInDatabase(){

        FirebaseAuth mFirebaseAuth = FirebaseAuth.getInstance();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("ADD_TO_CART/"+mFirebaseAuth.getUid());

        // Read from the database
        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
//                titleList = new ArrayList<>();
//                priceList = new ArrayList<>();
                Log.d("ADD_TO_CART_DATA_GET", "Value is: " + dataSnapshot.toString());
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                //String value = dataSnapshot.getValue(String.class);
                boolean haveThisPackage = false;
                for (DataSnapshot data : dataSnapshot.getChildren()) {
                    Log.d("ADD_TO_CART_DATA_GET", "Value is: " + data.toString());
                    String  package_type_database = data.child("package_type").getValue().toString();
                    if (package_type.contains(package_type_database)){
                        haveThisPackage = true;
                        Toast.makeText(getApplicationContext(), "Already Have an package in " + package_type, Toast.LENGTH_SHORT).show();
                        break;
                    }

                }
                if (!haveThisPackage){
                    Toast.makeText(getApplicationContext(), "Add to cart is added ", Toast.LENGTH_SHORT).show();

                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    DatabaseReference myRef = database.getReference("ADD_TO_CART/"+ FirebaseAuth.getInstance().getUid()+"/"+package_id);
                    Map<String, String> cart = new HashMap<>();
                    cart.put("package_id", package_id);
                    cart.put("name", package_name);
                    cart.put("price", price);
                    cart.put("package_type", package_type);
                    myRef.setValue(cart);

                    Intent intent =new Intent(getApplicationContext(),  CART.class);
                    startActivity(intent);
                    finish();
                }
                /*
                Map<String, String> cart = new HashMap<>();
                cart.put("package_id", package_id);
                cart.put("name", "Holud Package 1");
                cart.put("price", price);
                */

                Log.d("ADD_TO_CART_DATA_GET", "Value is: " + dataSnapshot.toString());


            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("ADD_TO_CART_DATA_GET", "Failed to read value.", error.toException());
            }
        });

    }
    class MyAdapter extends ArrayAdapter<String>
    {
        Context context;
        String rtitle[];
        String rdescription[];
        int rimages[];

        MyAdapter (Context c, String title[], String description[],int img[]) {

            super(c,R.layout.row, R.id.textview1,title);
            this.context =c;
            this.rtitle= title;
            this.rdescription=description;
            this.rimages= img;

        }

        @NonNull
        @Override
        public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row= layoutInflater.inflate(R.layout.row,parent,false);
            ImageView images = row.findViewById(R.id.imag1);
            TextView myTitle =  row.findViewById(R.id.textview1);
            TextView myDes =  row.findViewById(R.id.textView2);
            //Button add_to_cart =  row.findViewById(R.id.add_to_cart);

            /*add_to_cart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, position+"" , Toast.LENGTH_SHORT).show();
                }
            });*/

            images.setImageResource(rimages[position]);
            myTitle.setText(rtitle[position]);
            myDes.setText(rdescription[position]);

            return row;
        }



    }
}
