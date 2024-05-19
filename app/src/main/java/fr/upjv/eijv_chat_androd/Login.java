package fr.upjv.eijv_chat_androd;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.annotation.NonNull;
import android.content.Intent;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
    private FirebaseAuth auth;
    private EditText loginEmail, loginMDP;

    @SuppressLint("MissingInflatedId")
    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //On se connecte à la base de données
        auth = FirebaseAuth.getInstance();
        //On récupere les variable du formulaire de connexion
        loginEmail = findViewById(R.id.login_email);
        loginMDP= findViewById(R.id.login_password);
        Button boutonLogin = findViewById(R.id.login_button);
        TextView inscriptionRedirection = findViewById(R.id.signUpRedirectText);
        boutonLogin.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                String email = loginEmail.getText().toString();
                String pass = loginMDP.getText().toString();
                if(!email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    if (!pass.isEmpty()) {
                        auth.signInWithEmailAndPassword(email, pass) .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                            @Override public void onSuccess(AuthResult authResult) {
                                //Si le login est validé on redirige vers la messagerie
                                Toast.makeText(Login.this, "Login Successful", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(Login.this, activityScroll.class);
                                intent.putExtra("email", email);
                                startActivity(intent);
                                finish();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override public void onFailure(@NonNull Exception e) {
                                Toast.makeText(Login.this, "Login Failed", Toast.LENGTH_SHORT).show();
                            }
                        });
                    } else {
                        loginMDP.setError("Le mot de passe ne peut pas être vide");
                    }
                } else if (email.isEmpty()) {
                    loginEmail.setError("L'email ne peut pas être vide");
                } else {
                    loginEmail.setError("Entrez une email correct");
                }
            }
        });
        //Redirection type url
        inscriptionRedirection.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                startActivity(new Intent(Login.this, Inscription.class));
            }
        });
    }
}