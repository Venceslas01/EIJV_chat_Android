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
    private FirebaseFirestore db;  //connexion à la base de données Firestore

    // Constructeur de la classe ReceptionMessage
    public ReceptionMessage() {
        db = FirebaseFirestore.getInstance();
    }

    // Méthode pour récupérer les messages
    public void getMessages(Consumer<List<messageFictif>> onMessagesReceived) {
        // Récupérer les messages de la base de données Firestore dans la collection "CHAT"
        db.collection("CHAT")
                .get()
                // Ajouter un écouteur pour traiter le résultat de la requête
                .addOnCompleteListener(task -> {
                    // Vérifier si la requête a réussi
                    if (task.isSuccessful()) {
                        List<messageFictif> messages = new ArrayList<>(); // Liste des messages reçus
                        QuerySnapshot querySnapshot = task.getResult(); // Résultat de la requête
                        if (querySnapshot != null) { // Vérifier si le résultat n'est pas nul
                            // Parcourir les documents de la collection "CHAT" pour extraire les données des documents
                            for (QueryDocumentSnapshot document : querySnapshot) {
                                String content = document.getString("contenu");
                                String sender = document.getString("sender");
                                Long timestampLong = document.getLong("timestamp");

                                if (content != null && sender != null && timestampLong != null) {
                                    // Convertir le timestamp en LocalDateTime
                                    LocalDateTime timestamp = LocalDateTime.ofInstant(Instant.ofEpochMilli(timestampLong), ZoneId.systemDefault());
                                    // Ajouter le message à la liste des messages
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
                        // Afficher l'erreur si la requête a échoué
                        task.getException().printStackTrace();
                    }
                });
    }

    // Méthode pour écouter les nouveaux messages
    public void startListeningForMessages(Consumer<List<messageFictif>> onMessagesUpdated) {
        // Ajouter un écouteur pour écouter les changements dans la collection "CHAT"
        db.collection("CHAT").addSnapshotListener(new EventListener<QuerySnapshot>() {
            // Méthode appelée lorsqu'un événement est reçu
            @Override
            public void onEvent(QuerySnapshot snapshots, FirebaseFirestoreException e) {
                // Vérifier s'il y a une erreur
                if (e != null) {
                    e.printStackTrace();
                    return;
                }

                // Vérifier si des documents ont été reçus, puis les traiter, les trier et les envoyer à l'activité
                if (snapshots != null && !snapshots.isEmpty()) {
                    List<messageFictif> messages = new ArrayList<>();
                    for (QueryDocumentSnapshot document : snapshots) {
                        String content = document.getString("contenu");
                        String sender = document.getString("sender");
                        Long timestampLong = document.getLong("timestamp");

                        // Vérifier si les données sont valides
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
