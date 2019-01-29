package com.example.layoutingme;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    TextView tvPilih;
    Spinner spKota;
    @BindView(R.id.btn_loginr)
    Button btnLoginr;
    @BindView(R.id.edt_username)
    TextInputEditText edtUsername;
    @BindView(R.id.edt_password)
    TextInputEditText edtPassword;
    private String[] listKota = {
            "-Pilih-", "Jakarta", "Semarang", "Bandung", "Yogyakarta", "Denpasar", "Makassar"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);

        tvPilih = findViewById(R.id.tv_pilih);
        spKota = findViewById(R.id.sp_kota);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, listKota);
        spKota.setAdapter(adapter);
        spKota.setOnItemSelectedListener(this);
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        tvPilih.setText("");
    }

    @OnClick(R.id.btn_loginr)
    public void onViewClicked() {
        if (edtUsername.getText().toString().trim().length() == 0) {
            edtUsername.setError("Jangan Kosong");
        } else if (edtPassword.getText().toString().trim().length() == 0) {
            edtPassword.setError("Jangan Kosong");
        } else if (edtPassword.getText().length() < 6 ) {
            edtPassword.setError("Password harus lebih dari 6 karakter");
        } else {
//                    Put Intent Here
            Toast.makeText(this, "Intent", Toast.LENGTH_SHORT).show();
        }
    }
}
