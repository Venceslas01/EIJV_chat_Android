package fr.upjv.eijv_chat_androd;

import android.os.Bundle;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chatbox);
        monRecycleView = findViewById(R.id.idRecyclerView);
        lesMessages = new ArrayList<>();
        initMessages();

        MessageAdapter adapter = new MessageAdapter(lesMessages);
        monRecycleView.setLayoutManager(new LinearLayoutManager(this));
        monRecycleView.setAdapter(adapter);
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
