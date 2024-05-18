package fr.upjv.eijv_chat_androd;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.time.format.DateTimeFormatter;

import fr.upjv.eijv_chat_androd.messageFictif;
import fr.upjv.eijv_chat_androd.R;

public class MessageViewHolder extends RecyclerView.ViewHolder {
    private final TextView contentTextView;
    private final TextView senderTextView;
    private final TextView timestampTextView;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    // Constructeur de la classe MessageViewHolder
    public MessageViewHolder(@NonNull View itemView) {
        super(itemView);
        this.contentTextView = itemView.findViewById(R.id.contentTextView);
        this.senderTextView = itemView.findViewById(R.id.senderTextView);
        this.timestampTextView = itemView.findViewById(R.id.timestampTextView);
    }

    // Méthode pour lier un message à un MessageViewHolder
    public void bind(messageFictif message) {
        this.contentTextView.setText(message.getContent());
        this.senderTextView.setText(message.getSender());
        this.timestampTextView.setText(message.getTimestamp().format(formatter));
    }
}
