package com.mariaeduarda.projetocurso.view;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.mariaeduarda.projetocurso.R;
import com.mariaeduarda.projetocurso.controller.PessoaController;
import com.mariaeduarda.projetocurso.model.Pessoa;


public class MainActivity extends AppCompatActivity {
    Pessoa pessoa;

    SharedPreferences.Editor listaVip;
    public static final String NOME_PREFERENCES = "pref_listaVip";
    SharedPreferences preferences;
    PessoaController controller;

    EditText Curso;
    EditText Sobrenome;
    EditText PrimeiroNome;
    EditText Telefone;


    Button btnLimpar;
    Button btnSalvar;
    Button btnFinalizar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        preferences = getSharedPreferences(NOME_PREFERENCES, 0);
         listaVip = preferences.edit();


        pessoa = new Pessoa();

        pessoa.setPrimeiroNome(preferences.getString("primeiroNome", "NA")); //Se caso não for encontrado o primeiro nome, com o NA vai aparecer que não foi encontrado.
        pessoa.setSobrenome(preferences.getString("sobrenome", "NA"));
        pessoa.setCursoDesejado(preferences.getString("cursoDesejado", "NA"));
        pessoa.setTelefone(preferences.getString("telefone", "NA"));

        controller = new PessoaController();

        controller.toString();

        PrimeiroNome = findViewById(R.id.editPrimeiroNome);
        Sobrenome = findViewById(R.id.editSobrenome);
        Telefone = findViewById(R.id.editTelefone);
        Curso = findViewById(R.id.editCurso);
        btnLimpar = findViewById(R.id.btnLimpar);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnFinalizar = findViewById(R.id.btnFinalizar);

        PrimeiroNome.setText(pessoa.getPrimeiroNome());
        Sobrenome.setText(pessoa.getSobrenome());
        Telefone.setText(pessoa.getTelefone());
        Curso.setText(pessoa.getCursoDesejado());

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PrimeiroNome.setText(" ");
                Sobrenome.setText(" ");
                Telefone.setText(" ");
                Curso.setText(" ");

                listaVip.clear();
                listaVip.apply();
            }
        });
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pessoa.setPrimeiroNome(PrimeiroNome.getText().toString());
                pessoa.setSobrenome(Sobrenome.getText().toString());
                pessoa.setTelefone(Telefone.getText().toString());
                pessoa.setCursoDesejado(Curso.getText().toString());

                Toast.makeText(MainActivity.this, "Dados salvos!" + pessoa.toString(), Toast.LENGTH_SHORT).show();

                listaVip.putString("primeiroNome", pessoa.getPrimeiroNome());
                listaVip.putString("sobrenome", pessoa.getSobrenome());
                listaVip.putString("cursoDesejado", pessoa.getCursoDesejado());
                listaVip.putString("telefone", pessoa.getTelefone());
                listaVip.apply();

                controller.salvar(pessoa);
            }

        });
        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}