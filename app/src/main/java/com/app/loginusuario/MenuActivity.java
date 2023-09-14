package com.app.loginusuario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.app.loginusuario.Entidad.Usuario;
import com.app.loginusuario.Utils.Constans;
import com.app.loginusuario.interfaces.CRUDInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MenuActivity extends AppCompatActivity {

    private TextView txtUsuario;
    private TextView txtDni;
    private TextView txtNombres;
    private TextView txtEdad;
    private TextView txtCorreo;
    private TextView txtCelular;

    private Usuario usuario = new Usuario();

    private Bundle bundle;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        txtUsuario = findViewById(R.id.lblNombreUsuarioRegistrado);
        txtDni = findViewById(R.id.lblDniSesion);
        txtNombres = findViewById(R.id.lblNombresSesion);
        txtEdad = findViewById(R.id.lblEdadSesion);
        txtCorreo = findViewById(R.id.lblCorreoSesion);
        txtCelular = findViewById(R.id.lblTelefonoSesion);

        bundle = getIntent().getExtras();

        usuario = (Usuario) bundle.getSerializable("usuario");

        LlenarDatos(usuario);


    }

    public void Salir(View view){
        salida();
    }


    public void Eliminar(View view){// Supongo que tu objeto Usuario tiene un método getId().
        Log.i("ID ", String.valueOf(usuario.getId()));
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constans.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        CRUDInterface crudInterface = retrofit.create(CRUDInterface.class);

        Call<Void> call = crudInterface.eliminarUsuario(usuario.getId());

        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    // La eliminación fue exitosa
                    Toast.makeText(getApplicationContext(), "Usuario eliminado correctamente", Toast.LENGTH_LONG).show();
                    // Puedes redirigir al usuario a otra actividad o tomar otras acciones aquí
                    salida();

                } else {
                    // Error al eliminar
                    Toast.makeText(getApplicationContext(), "Error al eliminar usuario", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                // Manejar errores de red u otros errores aquí
                Log.e("THROWS ERROR", t.getMessage());
                Toast.makeText(getApplicationContext(), "Error al eliminar usuario", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void LlenarDatos(Usuario usuario){
        txtUsuario.setText(usuario.getNomUser());
        txtDni.setText(usuario.getDni());
        txtNombres.setText(usuario.getNombres() + " " + usuario.getApellidos());
        txtEdad.setText(String.valueOf(usuario.getEdad()));
        txtCorreo.setText(usuario.getCorreo());
        txtCelular.setText(usuario.getCelular());
    }

    void salida(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }




}