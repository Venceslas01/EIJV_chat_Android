package fr.upjv.eijv_chat_androd;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

// Déclaration de la classe activityScroll qui hérite de AppCompatActivity
public class activityScroll extends AppCompatActivity {
    // Déclaration des variables
    // Liste des messages
    private List<messageFictif> lesMessages;
    // Vue pour afficher les messages
    private RecyclerView monRecycleView;
    // Champ de texte pour entrer un nouveau message
    private EditText editTextMessage;
    // Objet pour envoyer un message
    private ActivitySendMessage sendMessage;
    // Objet pour recevoir un message
    private ReceptionMessage receptionMessage;
    // Adaptateur pour afficher les messages
    private MessageAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chatbox);
        monRecycleView = findViewById(R.id.idRecyclerView);
        editTextMessage = findViewById(R.id.id_messageToSend);

        //// Initialisation de la liste des messages et de l'objet pour recevoir des messages
        lesMessages = new ArrayList<>();
        receptionMessage = new ReceptionMessage();

        // Initialisation de l'adaptateur pour afficher les messages
        adapter = new MessageAdapter(lesMessages);
        monRecycleView.setLayoutManager(new LinearLayoutManager(this));
        monRecycleView.setAdapter(adapter);

        // Récupérer les messages de manière asynchrone
        receptionMessage.getMessages(messages -> {
            runOnUiThread(() -> {
                lesMessages.clear();
                lesMessages.addAll(messages);
                adapter.notifyDataSetChanged();
            });
        });

        // Écouter les nouveaux messages
        receptionMessage.startListeningForMessages(messages -> {
            runOnUiThread(() -> {
                lesMessages.clear();
                lesMessages.addAll(messages);
                adapter.notifyDataSetChanged();
            });
        });

        //initialisation de l'objet pour envoyer un message
        sendMessage = new ActivitySendMessage(this, editTextMessage);

        // Écouter le clic sur le bouton pour envoyer un message
        Button buttonSendMessage = findViewById(R.id.id_envoyer_messsage);
        buttonSendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage.onClickMessageToSend(v);
            }
        });
    }
}
