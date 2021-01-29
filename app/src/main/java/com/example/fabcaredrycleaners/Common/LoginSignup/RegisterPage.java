package com.example.fabcaredrycleaners.Common.LoginSignup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.fabcaredrycleaners.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class RegisterPage extends AppCompatActivity {

    Button buttonregister, buttonalreadyreg;

    ImageView logoimage;

    TextInputLayout username, phoneNumberToSave, address, email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);

        logoimage=findViewById(R.id.logoimage);

        buttonregister=findViewById(R.id.buttonregister);
        buttonalreadyreg=findViewById(R.id.buttonalreadyreg);

        username=findViewById(R.id.userName);
        phoneNumberToSave=findViewById(R.id.phonenumbertosave);
        address=findViewById(R.id.address);
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);

        buttonalreadyreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(RegisterPage.this, LoginPage.class);
                startActivity(i);
                overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
            }
        });

    }

    private boolean validateUserName(){
        String val= username.getEditText().getText().toString().trim();
        if (val.isEmpty()){
            username.setError("Field cannot be empty");
            return false;
        }
        else{
            username.setError(null);
            username.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validatePhoneNumber(){
        String val= phoneNumberToSave.getEditText().getText().toString().trim();
        String checkPhone = "[0-9]{10}";
        if (val.isEmpty()){
            phoneNumberToSave.setError("Field cannot be empty");
            return false;
        }
        else if(!val.matches(checkPhone)){
            phoneNumberToSave.setError("Invalid phone number");
            return false;
        }
        else{
            phoneNumberToSave.setError(null);
            phoneNumberToSave.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validateEmail(){
        String val= email.getEditText().getText().toString().trim();
        String checkEmail = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        if (val.isEmpty()){
            email.setError("Field cannot be empty");
            return false;
        }
        else if(!val.matches(checkEmail)){
            email.setError("Invalid email");
            return false;
        }
        else{
            email.setError(null);
            email.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validateAddress(){
        String val= address.getEditText().getText().toString().trim();
        if (val.isEmpty()){
            address.setError("Field cannot be empty");
            return false;
        }
        else if (val.length()<15){
            address.setError("Enter more address details");
            return false;
        }
        else{
            address.setError(null);
            address.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validatePassword(){
        String val= password.getEditText().getText().toString().trim();
        if (val.length()>8 || val.length()<4){
            password.setError("Should have 4 to 8 digits");
            return false;
        }
        else{
            password.setError(null);
            password.setErrorEnabled(false);
            return true;
        }
    }

    public void goBackToLoginPage(View view){
        Intent i =new Intent(getApplicationContext(), LoginPage.class);
        startActivity(i);
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
        finish();
    }


    public void callGetOtpScreen(View view){
        if(!validateUserName() | !validatePhoneNumber() | !validateAddress()
        | !validateEmail() | !validatePassword()){
            return;
        }

        String nameString = username.getEditText().getText().toString();
        String phoneString = phoneNumberToSave.getEditText().getText().toString();
        String addressString = address.getEditText().getText().toString();
        String emailString = email.getEditText().getText().toString();
        String passwordString = password.getEditText().getText().toString();


        Intent i = new Intent(getApplicationContext(), GetOtpPage.class);
        i.putExtra("userName", nameString);
        i.putExtra("phoneNumber", phoneString);
        i.putExtra("address", addressString);
        i.putExtra("email", emailString);
        i.putExtra("password", passwordString);
        startActivity(i);
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
    }


}
