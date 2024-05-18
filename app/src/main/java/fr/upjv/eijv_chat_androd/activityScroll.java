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

public class activityScroll extends AppCompatActivity {
    private List<messageFictif> lesMessages;
    private RecyclerView monRecycleView;
    private EditText editTextMessage;
    private ActivitySendMessage sendMessage;
    private ReceptionMessage receptionMessage;
    private MessageAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chatbox);
        monRecycleView = findViewById(R.id.idRecyclerView);
        editTextMessage = findViewById(R.id.id_messageToSend);

        lesMessages = new ArrayList<>();
        receptionMessage = new ReceptionMessage();

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

        sendMessage = new ActivitySendMessage(this, editTextMessage);

        Button buttonSendMessage = findViewById(R.id.id_envoyer_messsage);
        buttonSendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage.onClickMessageToSend(v);
            }
        });
    }
}
