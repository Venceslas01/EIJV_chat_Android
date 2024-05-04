package fr.upjv.eijv_chat_androd;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import fr.upjv.eijv_chat_androd.MessageAdapter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class activityScroll extends AppCompatActivity {
    private List<messageFictif> lesMessages;
    private RecyclerView monRecycleView;
    private EditText editTextMessage;
    private ActivitySendMessage sendMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chatbox);
        monRecycleView = findViewById(R.id.idRecyclerView);
        editTextMessage = findViewById(R.id.id_messageToSend);

        lesMessages = new ArrayList<>();
        initMessages();

        MessageAdapter adapter = new MessageAdapter(lesMessages);
        monRecycleView.setLayoutManager(new LinearLayoutManager(this));
        monRecycleView.setAdapter(adapter);

        sendMessage = new ActivitySendMessage(this, editTextMessage);

        Button buttonSendMessage = findViewById(R.id.id_envoyer_messsage);
        buttonSendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage.onClickMessageToSend(v);
            }
        });
    }

    private void initMessages() {
        lesMessages.add(new messageFictif("Bonjour", "Moi", LocalDateTime.now()));
        lesMessages.add(new messageFictif("Salut", "Toi", LocalDateTime.now().minusHours(1)));
        lesMessages.add(new messageFictif("Comment ça va ?", "Moi", LocalDateTime.now().minusHours(2)));
        lesMessages.add(new messageFictif("Bien et toi ?", "Toi", LocalDateTime.now().minusHours(3)));
        lesMessages.add(new messageFictif("Ça va", "Moi", LocalDateTime.now().minusHours(4)));
        lesMessages.add(new messageFictif("Bonjour", "Moi", LocalDateTime.now()));
        lesMessages.add(new messageFictif("Salut", "Toi", LocalDateTime.now().minusHours(1)));
        lesMessages.add(new messageFictif("Comment ça va ?", "Moi", LocalDateTime.now().minusHours(2)));
        lesMessages.add(new messageFictif("Bien et toi ?", "Toi", LocalDateTime.now().minusHours(3)));
        lesMessages.add(new messageFictif("Ça va", "Moi", LocalDateTime.now().minusHours(4)));
        lesMessages.add(new messageFictif("Bonjour", "Moi", LocalDateTime.now()));
        lesMessages.add(new messageFictif("Salut", "Toi", LocalDateTime.now().minusHours(1)));
        lesMessages.add(new messageFictif("Comment ça va ?", "Moi", LocalDateTime.now().minusHours(2)));
        lesMessages.add(new messageFictif("Bien et toi ?", "Toi", LocalDateTime.now().minusHours(3)));
        lesMessages.add(new messageFictif("Ça va", "Moi", LocalDateTime.now().minusHours(4)));
        lesMessages.add(new messageFictif("Bonjour", "Moi", LocalDateTime.now()));
        lesMessages.add(new messageFictif("Salut", "Toi", LocalDateTime.now().minusHours(1)));
        lesMessages.add(new messageFictif("Comment ça va ?", "Moi", LocalDateTime.now().minusHours(2)));
        lesMessages.add(new messageFictif("Bien et toi ?", "Toi", LocalDateTime.now().minusHours(3)));
        lesMessages.add(new messageFictif("Ça va", "Moi", LocalDateTime.now().minusHours(4)));
        lesMessages.add(new messageFictif("Bonjour", "Moi", LocalDateTime.now()));
        lesMessages.add(new messageFictif("Salut", "Toi", LocalDateTime.now().minusHours(1)));
        lesMessages.add(new messageFictif("Comment ça va ?", "Moi", LocalDateTime.now().minusHours(2)));
        lesMessages.add(new messageFictif("Bien et toi ?", "Toi", LocalDateTime.now().minusHours(3)));
        lesMessages.add(new messageFictif("Ça va", "Moi", LocalDateTime.now().minusHours(4)));
        lesMessages.add(new messageFictif("Bonjour", "Moi", LocalDateTime.now()));
        lesMessages.add(new messageFictif("Salut", "Toi", LocalDateTime.now().minusHours(1)));
        lesMessages.add(new messageFictif("Comment ça va ?", "Moi", LocalDateTime.now().minusHours(2)));
        lesMessages.add(new messageFictif("Bien et toi ?", "Toi", LocalDateTime.now().minusHours(3)));
        lesMessages.add(new messageFictif("Ça va", "Moi", LocalDateTime.now().minusHours(4)));
        lesMessages.add(new messageFictif("Bonjour", "Moi", LocalDateTime.now()));
        lesMessages.add(new messageFictif("Salut", "Toi", LocalDateTime.now().minusHours(1)));
        lesMessages.add(new messageFictif("Comment ça va ?", "Moi", LocalDateTime.now().minusHours(2)));
        lesMessages.add(new messageFictif("Bien et toi ?", "Toi", LocalDateTime.now().minusHours(3)));
        lesMessages.add(new messageFictif("Ça va", "Moi", LocalDateTime.now().minusHours(4)));
        lesMessages.add(new messageFictif("Bonjour", "Moi", LocalDateTime.now()));
        lesMessages.add(new messageFictif("Salut", "Toi", LocalDateTime.now().minusHours(1)));
        lesMessages.add(new messageFictif("Comment ça va ?", "Moi", LocalDateTime.now().minusHours(2)));
        lesMessages.add(new messageFictif("Bien et toi ?", "Toi", LocalDateTime.now().minusHours(3)));
        lesMessages.add(new messageFictif("Ça va", "Moi", LocalDateTime.now().minusHours(4)));
        lesMessages.add(new messageFictif("Bonjour", "Moi", LocalDateTime.now()));
        lesMessages.add(new messageFictif("Salut", "Toi", LocalDateTime.now().minusHours(1)));
        lesMessages.add(new messageFictif("Comment ça va ?", "Moi", LocalDateTime.now().minusHours(2)));
        lesMessages.add(new messageFictif("Bien et toi ?", "Toi", LocalDateTime.now().minusHours(3)));
        lesMessages.add(new messageFictif("Ça va", "Moi", LocalDateTime.now().minusHours(4)));
        lesMessages.add(new messageFictif("Bonjour", "Moi", LocalDateTime.now()));
        lesMessages.add(new messageFictif("Salut", "Toi", LocalDateTime.now().minusHours(1)));
        lesMessages.add(new messageFictif("Comment ça va ?", "Moi", LocalDateTime.now().minusHours(2)));
        lesMessages.add(new messageFictif("Bien et toi ?", "Toi", LocalDateTime.now().minusHours(3)));
        lesMessages.add(new messageFictif("Ça va", "Moi", LocalDateTime.now().minusHours(4)));
    }
}
