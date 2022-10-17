package com.if3a.formlombaprogramming;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    private EditText etNama,etNoWhatsapp,etPassword,etAlamat,etPin;
    private RadioGroup rg_JenisKelamin;
    private RadioButton rb_JenisKelamin;
    private Button btnDaftar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = findViewById(R.id.et_nama);
        etNoWhatsapp = findViewById(R.id.et_no_whatsapp);
        etPassword = findViewById(R.id.et_password);
        etAlamat = findViewById(R.id.et_alamat);
        etPin = findViewById(R.id.et_pin);

        rg_JenisKelamin = findViewById(R.id.rg_jk);
        btnDaftar = findViewById(R.id.btn_daftar);

        btnDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nama = etNama.getText().toString();
                String nowhatsapp = etNoWhatsapp.getText().toString();
                String alamat = etAlamat.getText().toString();
                String password = etPassword.getText().toString();
                String Pin = etPin.getText().toString();

                int jeniskelaminID = rg_JenisKelamin.getCheckedRadioButtonId();
                rb_JenisKelamin=findViewById(jeniskelaminID);

                String jenisKelamin = rb_JenisKelamin.getText().toString();
                if(nama.trim().equals(""))
                {
                    etNama.setError("Nama Tidak Boleh Kosong!");
                }
                else if(nowhatsapp.trim().equals(""))
                {
                    etNama.setError("Nomor Whatsapp Tidak Boleh Kosong!");
                }
                else if(alamat.trim().equals(""))
                {
                    etNama.setError("Alamat Tidak Boleh Kosong!");
                }
                else if(password.trim().equals(""))
                {
                    etNama.setError("Password Tidak Boleh Kosong!");
                }
                else if(Pin.trim().equals(""))
                {
                    etNama.setError("Pin Tidak Boleh Kosong!");
                }
                else
                {
                    Intent intent = new Intent(MainActivity.this, ConfirmActivity.class);
                    intent.putExtra("varnama",nama);
                    intent.putExtra("varAlamat",alamat);
                    intent.putExtra("varjeniskelamin",jenisKelamin);
                    intent.putExtra("varWhatsapp",nowhatsapp);
                    startActivity(intent);
                }

            }
        });
    }
}