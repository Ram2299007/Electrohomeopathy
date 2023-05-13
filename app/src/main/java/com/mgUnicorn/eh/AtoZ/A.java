package com.mgUnicorn.eh.AtoZ;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;

import com.mgUnicorn.eh.Adapter.DiseaseAdapter;
import com.mgUnicorn.eh.R;
import com.mgUnicorn.eh.models.DiseaseModel;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class A extends AppCompatActivity {

    RecyclerView recyclerView;


    //require change
    DiseaseAdapter adapter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);

        recyclerView=findViewById(R.id.recAViewAtoZA);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        FirebaseRecyclerOptions<DiseaseModel> options=
                new FirebaseRecyclerOptions.Builder<DiseaseModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("AtoZTreatment").child("A"),DiseaseModel.class)
                        .build();

        adapter=new DiseaseAdapter(options);
        recyclerView.setAdapter(adapter);





    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.startListening();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.search_menu,menu);
        MenuItem item=menu.findItem(R.id.search);

        SearchView searchView=(SearchView) item.getActionView();
        searchView.setInputType(InputType.TYPE_TEXT_FLAG_CAP_CHARACTERS);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {

                processSearch(s);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
             //   processSearch(s);
                processSearch(s);
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }

    private void processSearch(String s) {


        FirebaseRecyclerOptions<DiseaseModel> options=
                new FirebaseRecyclerOptions.Builder<DiseaseModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("AtoZTreatment")
                                .child("A").orderByChild("a").startAt(s).endAt(s+"\uf8ff"),DiseaseModel.class).build();

        adapter=new DiseaseAdapter(options);
        adapter.startListening();
       recyclerView.setAdapter(adapter);
      //  recyclerView.smoothScrollToPosition(adapter.getItemCount());


    }




}