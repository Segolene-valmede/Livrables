package com.example.services_novigrad;



import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;




public class AddServicesPage extends AppCompatActivity {

    private FirebaseFirestore db= FirebaseFirestore.getInstance();
    private CollectionReference servicesBookRef = db.collection("ServicesBookRef");
    private ServicesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_services_page);



        setUpRecyclerView();
    }



    private void setUpRecyclerView() {
        Object Document;
        Query query = FirebaseFirestore.getInstance().collection("ServicesBookRef"); // a revoir cette ligne car c est elle qui permet l affichage des services mais ne fonctionne pas ;
        FirestoreRecyclerOptions<ServiceList>options = new FirestoreRecyclerOptions.Builder<ServiceList>()
                .setQuery(query, ServiceList.class).build();

        adapter = new ServicesAdapter(options);

        RecyclerView recyclerView = findViewById(R.id.rv);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager( new LinearLayoutManager(this));
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
        adapter.stopListening();
    }


}
