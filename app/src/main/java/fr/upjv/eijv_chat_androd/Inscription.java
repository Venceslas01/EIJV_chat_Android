package fr.upjv.eijv_chat_androd;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import android.os.Bundle;

public class Inscription extends AppCompatActivity {
    // Declare any other necessary variables. p
    private FirebaseAuth auth;
    private EditText inscriptionEmail, inscriptionMDP;
    private Button inscriptionBouton;
    private TextView redirectionLogin;
    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);
        //Initialize the FirebaseAuth instance in the onCreate()
        auth = FirebaseAuth.getInstance();
        //On recupere les variables de nos bouton et editText
        inscriptionEmail = findViewById(R.id.signup_email);
        inscriptionMDP = findViewById(R.id.signup_password);
        inscriptionBouton = findViewById(R.id.signup_button);
        redirectionLogin = findViewById(R.id.loginRedirectText);
        inscriptionBouton.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                //On verifie que les champs sont bien rempli
                //On recupere des chaines de caractere et on supprime les caractere invisible potentiellement genant avec trim
                String user = inscriptionEmail.getText().toString().trim();
                String pass = inscriptionMDP.getText().toString().trim();
                if (user.isEmpty()){
                   inscriptionEmail.setError("Email cannot be empty");
                }
                if(pass.isEmpty()){
                    inscriptionMDP.setError("Password cannot be empty");
                }
                else{
                    //On ajoute le mail et le mp sur la base d'authentification
                    auth.createUserWithEmailAndPassword(user, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override public void onComplete(@NonNull Task<AuthResult> task) {
                            //Si cote bdd c'est valide, on redirige vers la page de login
                            if(task.isSuccessful()){ Toast.makeText(Inscription.this, "Signup Successful", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(Inscription.this, Login.class));
                            }
                            else{
                                Toast.makeText(Inscription.this, "Signup Failed" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });
        redirectionLogin.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) { startActivity(new Intent(Inscription.this, Login.class)); } });
    }
}