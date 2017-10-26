package prithwimig16.visitnortheast.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import prithwimig16.visitnortheast.R;
import prithwimig16.visitnortheast.models.Users;

public class SignUpActivity extends AppCompatActivity {

    protected EditText passwordEditText;
    protected EditText emailEditText, nameEditText;
    protected Button signUpButton;
    String strName, strPassword, strEmail;
    private FirebaseAuth mFirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        // Initialize FirebaseAuth
        mFirebaseAuth = FirebaseAuth.getInstance();

        passwordEditText = (EditText) findViewById(R.id.passwordField);
        nameEditText = (EditText) findViewById(R.id.input_name);
        emailEditText = (EditText) findViewById(R.id.emailField);
        signUpButton = (Button) findViewById(R.id.btn_signup);

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strPassword = passwordEditText.getText().toString().trim();
                strEmail = emailEditText.getText().toString().trim();
                strName = nameEditText.getText().toString();


                if (strPassword.isEmpty() || strEmail.isEmpty() || strName.isEmpty()) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(SignUpActivity.this);
                    builder.setMessage("signup_error_message")
                            .setTitle("signup_error_message title")
                            .setPositiveButton(android.R.string.ok, null);
                    AlertDialog dialog = builder.create();
                    dialog.show();
                } else {
                    mFirebaseAuth.createUserWithEmailAndPassword(strEmail, strPassword)
                            .addOnCompleteListener(SignUpActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        Intent intent = new Intent(SignUpActivity.this, CityListActivity.class);
                                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                        startActivity(intent);
                                        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference("users:");
                                        String userId = mDatabase.push().getKey();
                                        Users user = new Users(strName, strEmail);
                                        mDatabase.child(userId).setValue(user);

                                    } else {
                                        AlertDialog.Builder builder = new AlertDialog.Builder(SignUpActivity.this);
                                        builder.setMessage(task.getException().getMessage())
                                                .setTitle("login_error_title")
                                                .setPositiveButton(android.R.string.ok, null);
                                        AlertDialog dialog = builder.create();
                                        dialog.show();
                                    }
                                }
                            });
                }
            }
        });
    }


}