package com.example.tp2_convertidor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText etDo,etEu;
    private RadioButton rbcambiaDolar,rbCambiaEuro;
    private TextView tvResult;
    private Button btConvertir;
    private MainViewModel vm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iniciarVista();
        vm= ViewModelProviders.of(this).get(MainViewModel.class);
        vm.getDolar().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                rbcambiaDolar.setChecked(aBoolean);
               // etDo.setFocusable(aBoolean);
            }
        });
       vm.getEuro().observe(this, new Observer<Boolean>() {
           @Override
           public void onChanged(Boolean aBoolean) {
               rbCambiaEuro.setChecked(aBoolean);
               //etEu.setFocusable(aBoolean);
               //etEu.setEnabled(aBoolean);
               //etEu.setCursorVisible(aBoolean);
               //etDo.setFocusable(aBoolean);
           }
       });
        vm.getLeerDolar().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                etDo.setEnabled(aBoolean);
                //etDo.setChecked(aBoolean);
                // etDo.setFocusable(aBoolean);
            }
        });
        vm.getLeerEuro().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                etEu.setEnabled(aBoolean);
               // etDo.setChecked(aBoolean);
                // etDo.setFocusable(aBoolean);
            }
        });
        vm.getResultado().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String resultado) {
                tvResult.setText(resultado);
                // etDo.setChecked(aBoolean);
                // etDo.setFocusable(aBoolean);
            }
        });



    }

    public  void iniciarVista(){
        etDo=findViewById(R.id.etMoneda);
        etEu=findViewById(R.id.etMoneda2);
        rbcambiaDolar=findViewById(R.id.rbDolarEuro);
        rbCambiaEuro=findViewById(R.id.rbEuroDolar);
        tvResult=findViewById(R.id.tvResultado);
        etEu.setText("");
        etDo.setText("");
        rbcambiaDolar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etEu.setText("");
                etDo.setText("");
                
                vm.cambiarEstadoEuro();
               //vm.cambiarEstadoLeerEuro();

            }
        });

    }
    public  void cambiarEurosADolar(View v){
        etEu.setText("");
        etDo.setText("");
        vm.cambiarEstadoDolar();

    }
    public void calcular(View v){

            vm.hacerCambio(etEu.getText(),etDo.getText());



    }
}
