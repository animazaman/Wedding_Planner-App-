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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.weddingplanner.ui.slideshow.SlideshowFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Currency;

public class CART extends AppCompatActivity {

    ListView listview;

    ArrayList<String> titleList = new ArrayList<>();
    ArrayList<String> priceList = new ArrayList<>();
    ArrayList<String> packageId = new ArrayList<>();
    MyAdapter adapter;
    public static int totalPrice  = 0;
    TextView totalPriceTextView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        TextView totalPriceTextView =  findViewById(R.id.totalPrice);

        CART.totalPrice = 0;
        totalPriceTextView.setText(CART.totalPrice+"");
        titleList = new ArrayList<>();
        priceList = new ArrayList<>();

        listview = findViewById(R.id.add_to_cart_listview);
        fireBaseDataGet();
        adapter = new MyAdapter(getApplicationContext(),titleList,priceList,packageId);
        listview.setAdapter(adapter);


        FloatingActionButton buy_all_packages = findViewById(R.id.buy_all_packages);
        buy_all_packages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(getApplicationContext(),  Details_info.class);
                startActivity(intent);
                finish();
            }
        });
    }



    void fireBaseDataGet(){
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
                CART.totalPrice = 0;
                TextView txt =  findViewById(R.id.totalPrice);
                priceList.clear();
                titleList.clear();
                packageId.clear();
                for (DataSnapshot data : dataSnapshot.getChildren()) {

                    String  price = data.child("price").getValue().toString();
                    String  title = data.child("name").getValue().toString();
                    String  pak = data.child("package_id").getValue().toString();
                    CART.totalPrice += Integer.parseInt( price );
                    Log.d("ADD_TO_CART_DATA_GET", "Value is: " + totalPrice);
                    priceList.add(price);
                    titleList.add(title);
                    packageId.add(pak);


                }
                NumberFormat format = NumberFormat.getCurrencyInstance();
                format.setMaximumFractionDigits(0);
                format.setCurrency(Currency.getInstance("BDT"));

                txt.setText("Total Amount : "+format.format(CART.totalPrice));

                adapter.notifyDataSetChanged();
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
        ArrayList<String> rtitle;
        ArrayList<String> rprice ;
        ArrayList<String> pak_id ;

        MyAdapter (Context c, ArrayList<String> rtitle, ArrayList<String>  price,ArrayList<String>  pkId ) {

            super(c,R.layout.row1, R.id.textViewCartName,rtitle);
            this.context =c;
            this.rtitle= rtitle;
            this.rprice= price;
            this.pak_id= pkId;

        }

        @NonNull
        @Override
        public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row= layoutInflater.inflate(R.layout.row1,parent,false);
            TextView title = row.findViewById(R.id.textViewCartName);
            TextView price =  row.findViewById(R.id.textViewCartPrice);

            Button remove =  row.findViewById(R.id.removeCartItem);

            if (rprice.size() >= 1 && rtitle.size() >= 1){
                title.setText(rtitle.get(position));
                price.setText(rprice.get(position));

            }
            remove.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    FirebaseAuth mFirebaseAuth = FirebaseAuth.getInstance();
                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    DatabaseReference myRef = database.getReference("ADD_TO_CART/"+mFirebaseAuth.getUid()+"/"+pak_id.get(position));
                    myRef.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            dataSnapshot.getRef().removeValue();
                            Toast.makeText(getApplicationContext(), "Remove  Here ", Toast.LENGTH_SHORT).show();
                            fireBaseDataGet();
                            finish();
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });

                }
            });

            return row;
        }



    }
}
