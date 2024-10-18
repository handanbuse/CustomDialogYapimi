package com.example.customdialogyapimi;

import android.app.Dialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


    private Dialog resetpassdialog;
    private Button btnClose, btnReset;
    private EditText editmail;
    private ImageView imgClose;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    //btn işlemleri
    public void showcustom(View v){
        showresetpassworddiallog();
    }


    private void showresetpassworddiallog(){
        resetpassdialog=new Dialog(this);

        //Diyalog penceresinin boyutunu ayarlamak için
        WindowManager.LayoutParams params= new WindowManager.LayoutParams();
        //Genişlik ve yükseklik kopyala
        params.copyFrom(resetpassdialog.getWindow().getAttributes());

        params.width=WindowManager.LayoutParams.WRAP_CONTENT;
        params.height=WindowManager.LayoutParams.WRAP_CONTENT;

        resetpassdialog.setCancelable(false);// kapanmasını önlemek

        resetpassdialog.setContentView(R.layout.customdialogresetpass);// xml kısmını bağla

        //Butonları bağla
        btnClose=resetpassdialog.findViewById(R.id.customdialog_btnClose);
        btnReset=resetpassdialog.findViewById(R.id.customdialog_btnReset);
        imgClose=resetpassdialog.findViewById(R.id.custom_dialog_ımg);
        editmail=resetpassdialog.findViewById(R.id.custom_resetpass_editEmail);


        //btnlere tıklanma ver yani tıklanınca kapansın

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetpassdialog.dismiss();
            }
        });

        imgClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetpassdialog.dismiss();
                if (!TextUtils.isEmpty(editmail.getText().toString()))
                    Toast.makeText(getApplicationContext(),"şifre sıfırlanma gönderildi",Toast.LENGTH_SHORT).show();
            }
        });

    }




}