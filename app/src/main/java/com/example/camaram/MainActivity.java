package com.example.camaram;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    ProgressBar progressBar;
    Button btneliminar;
    Button btnEditar;
    Button btnGrabar;
    EditText nombre,id,descripcion,costo,precio,stock,fecha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar=(ProgressBar) findViewById(R.id.progressBar);
        ImageButton buttonCamara=findViewById(R.id.buttonCamara);
        progressBar.setVisibility(View.INVISIBLE);
        new Hilo1().start();
        buttonCamara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentCamara= new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                System.out.println(" aquiiiiii");

                if(intentCamara.resolveActivity(getPackageManager())!=null){
                    System.out.println("holaaaaaa");;
                    startActivityForResult(intentCamara,1);
                }
            }
        });

        btnGrabar = findViewById(R.id.btn_grabar);
        btnEditar = findViewById(R.id.btn_editar);
        btneliminar = findViewById(R.id.btn_eliminar);
        nombre=findViewById(R.id.txt_Nombre);
        id=findViewById(R.id.txt_id);
        descripcion=findViewById(R.id.txt_descripcion);
        costo=findViewById(R.id.txt_costo);
        precio=findViewById(R.id.txt_precio);
        stock=findViewById(R.id.txt_fecha);
        
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1 && resultCode==RESULT_OK){
            Bundle bundle =data.getExtras();
            Bitmap imagen= (Bitmap) bundle.get("data");
            ImageView imageView=findViewById(R.id.imageView);
            imageView.setImageBitmap(imagen);
        }

    }

    class Hilo1 extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(5000);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        progressBar.setVisibility(View.INVISIBLE);
                    }
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }






}