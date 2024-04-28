package fr.upjv.eijv_chat_androd;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class messageFictif {
    private String content;
    private String sender;
    private LocalDateTime timestamp;

    // Constructeur
    public messageFictif(String content, String sender, LocalDateTime timestamp) {
        this.content = content;
        this.sender = sender;
        this.timestamp = timestamp;
    }

    // Getters et setters
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}



