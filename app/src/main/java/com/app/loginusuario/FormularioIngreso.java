package com.app.loginusuario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.app.loginusuario.Entidad.Usuario;
import com.app.loginusuario.Utils.Constans;
import com.app.loginusuario.interfaces.CRUDInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FormularioIngreso extends AppCompatActivity {

    private EditText etNomUser;
    private EditText etContrasenia;

    Usuario usuario = new Usuario();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        etNomUser = findViewById(R.id.txtNombreUsuarioLogin);
        etContrasenia = findViewById(R.id.txtContraseniaLogin);

    }

    public void Ingresar(View view){
        usuario.setNomUser(etNomUser.getText().toString());
        usuario.setContrasenia(etContrasenia.getText().toString());

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constans.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        CRUDInterface crudInterface = retrofit.create(CRUDInterface.class);

        Call<Usuario> call = crudInterface.validarUsuario(usuario.getNomUser(), usuario.getContrasenia());

        call.enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                if(!response.isSuccessful()){
                    Log.e("Response Error", response.message());
                    Toast toast = Toast.makeText(getApplicationContext(), "Nombre de Usuario o Contraseña Incorrectos", Toast.LENGTH_LONG);
                    toast.show();
                    return;
                }
                usuario = response.body();

                if (usuario != null) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Usuario Correcto", Toast.LENGTH_LONG);
                    toast.show();
                    Log.i("Usuario", usuario.toString());
                    IrInicio(usuario);



                } else {
                    Toast toast = Toast.makeText(getApplicationContext(), "Usuario o Contraseña Incorrectos", Toast.LENGTH_LONG);
                    toast.show();
                }
            }
            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {
                Log.e("THROWS ERROR", t.getMessage());
                Toast toast = Toast.makeText(getApplicationContext(), "Usuario o Contraseña Incorrectos", Toast.LENGTH_LONG);
                toast.show();
            }
        });

    }

    public void Limpiar(View view){
        etNomUser.setText("");
        etContrasenia.setText("");
    }

    public void Volver(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void IrInicio(Usuario usuario){
        startActivity(new Intent(this, MenuActivity.class).putExtra("usuario", usuario));
    }



}