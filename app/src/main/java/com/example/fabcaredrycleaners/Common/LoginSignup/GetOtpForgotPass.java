package com.example.fabcaredrycleaners.Common.LoginSignup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fabcaredrycleaners.R;
import com.example.fabcaredrycleaners.User.HomePage;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.FirebaseException;
import com.google.firebase.FirebaseTooManyRequestsException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class GetOtpForgotPass extends AppCompatActivity {

    TextInputEditText otpFG;
    TextView phoneNoFromIntentFG;
    Button buttonGetOtpFG, buttonOtpSubmitFG;
    FirebaseAuth mAuth;
    String codeSentFG;
    String userNameFG, phoneNumberFG;
    RelativeLayout progressBarGetOtpFG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_otp_forgot_pass);

        otpFG=findViewById(R.id.otpForgot);
        phoneNoFromIntentFG=findViewById(R.id.phoneNumberFromIntentForgot);
        buttonGetOtpFG=findViewById(R.id.buttonGetOtpForgot);
        buttonOtpSubmitFG=findViewById(R.id.buttonOtpSubmitForgot);
        progressBarGetOtpFG=findViewById(R.id.progressbarGetOtpForgot);


        Intent i = getIntent();

        phoneNumberFG = i.getStringExtra("phoneNumber");
        //whatToDoFG = i.getStringExtra("whatToDo");

        phoneNoFromIntentFG.setText("+91"+phoneNumberFG);

        mAuth = FirebaseAuth.getInstance();

        buttonGetOtpFG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                buttonGetOtpFG.setBackgroundColor(000000);

                buttonGetOtpFG.setEnabled(false);

                getVerificationOtp();
            }
        });


        buttonOtpSubmitFG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String codeText = otpFG.getText().toString();
                if (codeText.isEmpty()){
                    otpFG.setError("Enter Valid OTP");
                    otpFG.requestFocus();
                    return;
                }
                else {
                    otpVerification();
                }
            }
        });

    }


    public void getVerificationOtp(){
        String phoneNumber = phoneNoFromIntentFG.getText().toString();
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
            codeSentFG = verificationId;
        }
    };

    public void otpVerification(){
        String code = otpFG.getText().toString();
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(codeSentFG, code);
        signInWithPhoneAuthCredential(credential);

    }

    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            //CHECK WHAT TO DO


                                updateOldUsersData();



                        }
                        else {
                            Toast.makeText(GetOtpForgotPass.this, "Login Failed", Toast.LENGTH_SHORT).show();

                            if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
                                // The verification code entered was invalid
                                Toast.makeText(GetOtpForgotPass.this, "Wrong OTP Entered!", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                });
    }

    private void updateOldUsersData() {
        Intent intent = new Intent(getApplicationContext(), SetNewPassPage.class);
        intent.putExtra("phoneNumber", phoneNumberFG);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
        finish();
    }







    public void goBackToRegPageForForgot(View view){
        Intent i = new Intent(getApplicationContext(), RegisterPage.class);
        startActivity(i);
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
        finish();
    }

}