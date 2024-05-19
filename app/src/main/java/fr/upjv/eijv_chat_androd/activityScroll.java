package fr.upjv.eijv_chat_androd;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.util.ArrayList;
import java.util.List;

public class activityScroll extends AppCompatActivity {
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1;

    private List<messageFictif> lesMessages;
    private RecyclerView monRecycleView;
    private EditText editTextMessage;

    private ActivitySendMessage sendMessage;
    private ReceptionMessage receptionMessage;
    private MessageAdapter adapter;

    private FusedLocationProviderClient fusedLocationClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chatbox);

        Intent intent = getIntent();
        String email = intent.getStringExtra("email");

        monRecycleView = findViewById(R.id.idRecyclerView);
        editTextMessage = findViewById(R.id.id_messageToSend);

        lesMessages = new ArrayList<>();
        receptionMessage = new ReceptionMessage();

        adapter = new MessageAdapter(lesMessages, email);
        monRecycleView.setLayoutManager(new LinearLayoutManager(this));
        monRecycleView.setAdapter(adapter);

        receptionMessage.getMessages(messages -> {
            runOnUiThread(() -> {
                lesMessages.clear();
                lesMessages.addAll(messages);
                adapter.notifyDataSetChanged();
            });
        });

        receptionMessage.startListeningForMessages(messages -> {
            runOnUiThread(() -> {
                lesMessages.clear();
                lesMessages.addAll(messages);
                adapter.notifyDataSetChanged();
            });
        });

        sendMessage = new ActivitySendMessage(this, editTextMessage, email);

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

        Button buttonSendMessage = findViewById(R.id.id_envoyer_messsage);
        Button buttonGPS = findViewById(R.id.gps);

        buttonSendMessage.setOnClickListener(v -> sendMessage.onClickMessageToSend(v));

        buttonGPS.setOnClickListener(v -> {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                    ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION}, LOCATION_PERMISSION_REQUEST_CODE);
            } else {
                getLastLocation(email);
            }
        });
    }

    private void getLastLocation(String email) {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        fusedLocationClient.getLastLocation().addOnCompleteListener(new OnCompleteListener<Location>() {
            @Override
            public void onComplete(@NonNull Task<Location> task) {
                if (task.isSuccessful() && task.getResult() != null) {
                    Location location = task.getResult();
                    String gpsMessage = "Coordonnées GPS de ma position"+"Lat: " + location.getLatitude() + ", Lon: " + location.getLongitude();
                    // Utiliser editTextMessage pour envoyer le message GPS
                    editTextMessage.setText(gpsMessage);
                    sendMessage.onClickMessageToSend(editTextMessage); // Envoyer le message GPS
                } else {
                    Toast.makeText(activityScroll.this, "Unable to get location", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == LOCATION_PERMISSION_REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                getLastLocation(getIntent().getStringExtra("email"));
            } else {
                Toast.makeText(this, "Location permission denied", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
