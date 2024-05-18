package fr.upjv.eijv_chat_androd;

import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class ReceptionMessage {
    private FirebaseFirestore db;

    public ReceptionMessage() {
        db = FirebaseFirestore.getInstance();
    }

    public void getMessages(Consumer<List<messageFictif>> onMessagesReceived) {
        db.collection("CHAT")
                .get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        List<messageFictif> messages = new ArrayList<>();
                        QuerySnapshot querySnapshot = task.getResult();
                        if (querySnapshot != null) {
                            for (QueryDocumentSnapshot document : querySnapshot) {
                                String content = document.getString("contenu");
                                String sender = document.getString("sender");
                                Long timestampLong = document.getLong("timestamp");

                                if (content != null && sender != null && timestampLong != null) {
                                    LocalDateTime timestamp = LocalDateTime.ofInstant(Instant.ofEpochMilli(timestampLong), ZoneId.systemDefault());
                                    messages.add(new messageFictif(content, sender, timestamp));
                                }
                            }

                            // Trier les messages par timestamp
                            Collections.sort(messages, Comparator.comparing(messageFictif::getTimestamp));

                            onMessagesReceived.accept(messages);
                        } else {
                            onMessagesReceived.accept(Collections.emptyList());
                        }
                    } else {
                        task.getException().printStackTrace();
                    }
                });
    }

    public void startListeningForMessages(Consumer<List<messageFictif>> onMessagesUpdated) {
        db.collection("CHAT").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(QuerySnapshot snapshots, FirebaseFirestoreException e) {
                if (e != null) {
                    e.printStackTrace();
                    return;
                }

                if (snapshots != null && !snapshots.isEmpty()) {
                    List<messageFictif> messages = new ArrayList<>();
                    for (QueryDocumentSnapshot document : snapshots) {
                        String content = document.getString("contenu");
                        String sender = document.getString("sender");
                        Long timestampLong = document.getLong("timestamp");

                        if (content != null && sender != null && timestampLong != null) {
                            LocalDateTime timestamp = LocalDateTime.ofInstant(Instant.ofEpochMilli(timestampLong), ZoneId.systemDefault());
                            messages.add(new messageFictif(content, sender, timestamp));
                        }
                    }

                    // Trier les messages par timestamp
                    Collections.sort(messages, Comparator.comparing(messageFictif::getTimestamp));

                    onMessagesUpdated.accept(messages);
                }
            }
        });
    }
}
