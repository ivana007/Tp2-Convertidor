package com.example.tp2_convertidor;

import android.text.Editable;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {
    private MutableLiveData<String> resultado;
    private MutableLiveData<Boolean>dolar;
    private MutableLiveData<Boolean>euro;
    private MutableLiveData<Boolean>leerDolar;
    private MutableLiveData<Boolean>leerEuro;

    public LiveData<String>getResultado(){
        if(resultado==null){
            resultado= new MutableLiveData<String>();
        }
        return resultado;
    }
    public LiveData<Boolean>getDolar(){
        if(dolar==null){
            dolar =  new MutableLiveData<Boolean>();
        }
        return dolar;
    }
    public LiveData<Boolean>getEuro(){
        if(euro==null){
            euro= new MutableLiveData<Boolean>();
        }
        return euro;
    }
    public LiveData<Boolean>getLeerEuro(){
        if(leerEuro==null){
            leerEuro= new MutableLiveData<Boolean>();
        }
        return leerEuro;
    }
    public LiveData<Boolean>getLeerDolar(){
        if(leerDolar==null){
            leerDolar= new MutableLiveData<Boolean>();
        }
        return leerDolar;
    }


    public void cambiarEstadoDolar(){
        dolar.setValue(false);
        leerDolar.setValue(false);
        leerEuro.setValue(true);
    }
    public void cambiarEstadoEuro(){

        euro.setValue(false);
        leerEuro.setValue(false);
        leerDolar.setValue(true);
    }

    public void hacerCambio(Editable nro1, Editable nro2){
        double res=0;
        double nro=0;
        Log.d("salida","haciendo calculo");

        if(!nro2.toString().equals("")){
            nro=Double.parseDouble(nro2.toString());
            res= nro * 0.92;// 1 euro vale 1.08 dolares
            resultado.setValue(res+"");
        }else if(!nro1.toString().equals("")){
            nro=Double.parseDouble(nro1.toString());
            res= nro * 1.08;// 1 euro vale 1.08 dolares
            resultado.setValue(res+"");
        }


    }
}
