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
import com.app.loginusuario.MenuActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FormularioRegistro extends AppCompatActivity {

    private EditText etDni;
    private EditText etNombres;
    private EditText etApellidos;
    private EditText etNomUser;
    private EditText etContrasenia;
    private EditText etEdad;
    private EditText etCorreo;
    private EditText etCelular;

    private Usuario usuario = new Usuario();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_registro);

        etDni = findViewById(R.id.txtDni);
        etNombres = findViewById(R.id.txtNombres);
        etApellidos = findViewById(R.id.txtApellidos);
        etNomUser = findViewById(R.id.txtNombreUsuarioRegistro);
        etContrasenia = findViewById(R.id.txtContrasenia);
        etEdad = findViewById(R.id.txtEdad);
        etCorreo = findViewById(R.id.txtCorreo);
        etCelular = findViewById(R.id.txtCelular);
    }

    public void Registrar(View view){
        String dni = etDni.getText().toString();
        String nombres = etNombres.getText().toString();
        String apellidos = etApellidos.getText().toString();
        String nomUser = etNomUser.getText().toString();
        String contrasenia = etContrasenia.getText().toString();
        String edad = etEdad.getText().toString();
        String correo = etCorreo.getText().toString();
        String celular = etCelular.getText().toString();

        if (dni.isEmpty() || nombres.isEmpty() || apellidos.isEmpty() || nomUser.isEmpty() || contrasenia.isEmpty()|| edad.isEmpty()  || correo.isEmpty() || celular.isEmpty()) {
            // Mostrar un mensaje de error al usuario
            Toast.makeText(this, "Por favor, complete todos los campos.", Toast.LENGTH_SHORT).show();
            return; // Salir del método sin realizar la llamada a la API
        }

        // Resto del código para realizar la llamada a Retrofit
        usuario.setDni(dni);
        usuario.setNombres(nombres);
        usuario.setApellidos(apellidos);
        usuario.setNomUser(nomUser);
        usuario.setContrasenia(contrasenia);
        usuario.setEdad(Integer.parseInt(edad));
        usuario.setCorreo(correo);
        usuario.setCelular(celular);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constans.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        CRUDInterface crudInterface = retrofit.create(CRUDInterface.class);

        Call<Usuario> call = crudInterface.registrarUsuario(usuario);

        call.enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                if (response.isSuccessful()) {
                    Usuario usuario = response.body();
                    if (usuario != null) {
                        // Registro exitoso
                        Toast.makeText(getApplicationContext(), "Registro Exitoso. ID: " + usuario.getId(), Toast.LENGTH_LONG).show();
                        Log.i("Clase", usuario.toString());
                        LimpiarForm();
                        IrInicio(usuario);

                    } else {
                        // El servidor no devolvió un usuario válido, indica un problema en el servidor
                        Toast.makeText(getApplicationContext(), "Error en el servidor. Inténtalo de nuevo más tarde.", Toast.LENGTH_LONG).show();
                    }
                }else {
                    // Otro código de estado de respuesta
                    // Maneja otros códigos de estado según sea necesario
                    // Por ejemplo, puedes mostrar un mensaje genérico aquí
                    Toast.makeText(getApplicationContext(), "Error en el servidor. Inténtalo de nuevo más tarde.", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {
                Log.e("THROWS ERROR", t.getMessage());
                Toast toast = Toast.makeText(getApplicationContext(), "Error al Registrar Usuario ", Toast.LENGTH_LONG);
                toast.show();
            }
        });


    }

    public void Limpiar(View view){
        LimpiarForm();
    }

    public void Volver(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void LimpiarForm(){
        etDni.setText("");
        etNombres.setText("");
        etApellidos.setText("");
        etNomUser.setText("");
        etContrasenia.setText("");
        etEdad.setText("");
        etCorreo.setText("");
        etCelular.setText("");
    }

    public void IrInicio(Usuario usuario){
        startActivity(new Intent(this, MenuActivity.class).putExtra("usuario", usuario));
    }



}