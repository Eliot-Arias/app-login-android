package com.app.loginusuario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.app.loginusuario.Entidad.Usuario;
import com.app.loginusuario.Utils.Constans;
import com.app.loginusuario.interfaces.CRUDInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {


    List<Usuario> usuarios;
    CRUDInterface crudInterface;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getAll();
    }

    private void getAll(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constans.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        crudInterface = retrofit.create(CRUDInterface.class);
        Call<List<Usuario>> call = crudInterface.getAll();
        call.enqueue(new Callback<List<Usuario>>() {
            @Override
            public void onResponse(Call<List<Usuario>> call, Response<List<Usuario>> response) {
                if(!response.isSuccessful()){
                    Log.e("Response Error", response.message());
                    Log.e("URL", call.request().url().toString()); // Agregar esta línea
                    Log.e("Response Code", String.valueOf(response.code())); // Agregar esta línea
                    return;
                }
                usuarios = response.body();
                usuarios.forEach(u -> Log.i("Clases: ",u.toString()));
            }

            @Override
            public void onFailure(Call<List<Usuario>> call, Throwable t) {
                Log.e("Throws err", t.getMessage());
            }
        });
    }






    public void Registrarse(View v){
        Intent intent = new Intent(this, FormularioRegistro.class);
        startActivity(intent);
    }

    public void IniciarSesion(View v){
        Intent intent = new Intent(this, FormularioIngreso.class);
        startActivity(intent);
    }
}