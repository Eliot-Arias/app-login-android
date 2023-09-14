package com.app.loginusuario.interfaces;

import com.app.loginusuario.Entidad.Usuario;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface CRUDInterface {


    @GET("listar")
    Call<List<Usuario>> getAll();

    @POST("validarUsuario")
    @FormUrlEncoded
    Call<Usuario> validarUsuario(
            @Field("nomUser") String nomUser,
            @Field("contrasenia") String contrasenia
    );

    @POST("registrarUsuario")
    Call<Usuario> registrarUsuario(@Body Usuario usuario);

    @DELETE("EliminarUsuario/{id}")
    Call<Void> eliminarUsuario(@Path("id") Integer id);
}
