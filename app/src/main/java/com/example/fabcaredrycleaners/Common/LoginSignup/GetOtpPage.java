package com.example.fabcaredrycleaners.Common.LoginSignup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fabcaredrycleaners.Databases.UserHelperClass;
import com.example.fabcaredrycleaners.R;
import com.example.fabcaredrycleaners.User.HomePage;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.FirebaseException;
import com.google.firebase.FirebaseTooManyRequestsException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.concurrent.TimeUnit;

public class GetOtpPage extends AppCompatActivity {

    TextInputEditText otp;
    TextView phoneNoFromIntent;
    Button buttonGetOtp, buttonOtpSubmit;
    FirebaseAuth mAuth;
    String codeSent;
    String userName, phoneNumber, address, email, password, whatToDo;
    RelativeLayout progressBarGetOtp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_otp_page);

        progressBarGetOtp=findViewById(R.id.progressbarGetOtp);

        //TRIAL


        phoneNoFromIntent=findViewById(R.id.phoneNumberFromIntent);

        Intent i = getIntent();
        userName = i.getStringExtra("userName");
        phoneNumber = i.getStringExtra("phoneNumber");
        address = i.getStringExtra("address");
        email = i.getStringExtra("email");
        password = i.getStringExtra("password");
        //whatToDo = i.getStringExtra("whatToDo");



        phoneNoFromIntent.setText("+91"+phoneNumber);

        buttonGetOtp=findViewById(R.id.buttonGetOtp);
        buttonOtpSubmit=findViewById(R.id.buttonOtpSubmit);
        otp=findViewById(R.id.otp);

        mAuth = FirebaseAuth.getInstance();

        buttonGetOtp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                buttonGetOtp.setBackgroundColor(000000);

                buttonGetOtp.setEnabled(false);

                getVerificationOtp();
            }
        });

        buttonOtpSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String codeText = otp.getText().toString();
                if (codeText.isEmpty()){
                    otp.setError("Enter Valid OTP");
                    otp.requestFocus();
                    return;
                }
                else {
                    otpVerification();
                }
            }
        });


    }







    public void getVerificationOtp(){
        String phoneNumber = phoneNoFromIntent.getText().toString();
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                phoneNumber,        // Phone number to verify
                60,                 // Timeout duration
                TimeUnit.SECONDS,   // Unit of timeout
                this,               // Activity (for callback binding)
                mCallbacks);        // OnVerificationStateChangedCallbacks

    }

    PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
        @Override
        public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {

        }

        @Override
        public void onVerificationFailed(FirebaseException e) {

            if (e instanceof FirebaseAuthInvalidCredentialsException) {


            } else if (e instanceof FirebaseTooManyRequestsException) {


            }
        }

        @Override
        public void onCodeSent(@NonNull String verificationId,
                               @NonNull PhoneAuthProvider.ForceResendingToken token) {
                codeSent = verificationId;
        }
    };


    public void otpVerification(){
        String code = otp.getText().toString();
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(codeSent, code);
        signInWithPhoneAuthCredential(credential);

    }

    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            //CHECK WHAT TO DO

                            //if(whatToDo.equals("updateData")){
                            //    updateOldUsersData();
                            //}
                            //else{
                                storeNewUserData();
                                Toast.makeText(GetOtpPage.this, "Successfully registered", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(getApplicationContext(), HomePage.class));
                            //}


                        }
                        else {
                            Toast.makeText(GetOtpPage.this, "Login Failed", Toast.LENGTH_SHORT).show();

                            if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
                                // The verification code entered was invalid
                                Toast.makeText(GetOtpPage.this, "Wrong OTP Entered!", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                });
    }

//    private void updateOldUsersData() {
//        Intent intent = new Intent(getApplicationContext(), SetNewPassPage.class);
//        intent.putExtra("phoneNumber", phoneNumber);
//        startActivity(intent);
//        finish();
//    }

    private void storeNewUserData(){
        FirebaseDatabase rootNode = FirebaseDatabase.getInstance();
        DatabaseReference reference = rootNode.getReference("Users");

        UserHelperClass addNewUser = new UserHelperClass(userName, phoneNumber, address, email, password);

        reference.child(phoneNumber).setValue(addNewUser);

    }

    public void goBackToRegPage(View view){
        Intent i = new Intent(getApplicationContext(), RegisterPage.class);
        startActivity(i);
        finish();
    }
}