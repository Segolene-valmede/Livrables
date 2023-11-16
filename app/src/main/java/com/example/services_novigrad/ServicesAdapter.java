package com.example.services_novigrad;

import androidx.annotation.NonNull;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;


public class ServicesAdapter extends FirestoreRecyclerAdapter<ServiceList,ServicesAdapter.ServicesHolder> {

    /**
     * Create a new RecyclerView adapter that listens to a Firestore Query.  See {@link
     * FirestoreRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public ServicesAdapter(@NonNull FirestoreRecyclerOptions<ServiceList> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull ServicesHolder holder, int position, @NonNull ServiceList model) {
        holder.textViewServiceName.setText(model.getServicename());
        holder.textViewFormulaire.setText(model.getFormulaires());
        holder.textViewDocument.setText(model.getDocuments());

    }

    @NonNull
    @Override
    public ServicesHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_add_services_page,parent,false);
        return new ServicesHolder(v);
    }

    class ServicesHolder extends RecyclerView.ViewHolder {

        TextView textViewServiceName;
        TextView textViewFormulaire;
        TextView textViewDocument;

        public ServicesHolder(@NonNull View itemView) {
            super(itemView);

            textViewServiceName = itemView.findViewById(R.id.text_view_service_name);
            textViewFormulaire = itemView.findViewById(R.id.text_view_formulaires);
            textViewDocument = itemView.findViewById(R.id.text_view_documents);
        }
    }
}

