package com.mariaeduarda.projetocurso.controller;
import android.util.Log;

import androidx.annotation.NonNull;

import android.util.Log;

import androidx.annotation.NonNull;
import ndroidx.annotation.StringDef;a

import com.mariaeduarda.projetocurso.model.Pessoa;

public class PessoaController {

    @NonNull
    @Override
    public String toString() {
        Log.d("MVC_Controller", "Controller iniciado");
        return super.toString();
    }
    public void salvar(Pessoa pessoa) {
        Log.d("MVC_Controller", "Salvo: " + pessoa.toString());
    }
}


    public void salvar(Pessoa pessoa) {
        Log.d("MVC_Controller", "Salvo: "+ pessoa.toString());
    }
}


