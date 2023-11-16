package com.example.services_novigrad;

public class ServiceList {

    private String servicename;
    private String formulaires;
    private String documents;

    public ServiceList(){
        //empty constructor needed
    }

    public ServiceList(String servicename, String formulaires, String documents){
        this.servicename = servicename;
        this.formulaires = formulaires;
        this.documents = documents;

    }

    public String getServicename() {
        return servicename;
    }

    public String getFormulaires() {
        return formulaires;
    }

    public String getDocuments() {
        return documents;
    }
}
