package fr.upjv.eijv_chat_androd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;
import fr.upjv.eijv_chat_androd.activityScroll;

public class MainActivity extends AppCompatActivity {

    private Button bouttonLancerScrol;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.accueil_app);
        bouttonLancerScrol = findViewById(R.id.idButtonScrol);

         FirebaseAuth mAuth;

        FirebaseFirestore db = FirebaseFirestore.getInstance();

        bouttonLancerScrol.setOnClickListener(view -> {
            Intent monIntent = new Intent(this, activityScroll.class);
            startActivity(monIntent);
        });

    }

}