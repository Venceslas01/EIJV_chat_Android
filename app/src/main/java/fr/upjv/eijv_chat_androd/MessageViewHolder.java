package fr.upjv.eijv_chat_androd;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import fr.upjv.eijv_chat_androd.messageFictif;
import fr.upjv.eijv_chat_androd.R;

public class MessageViewHolder extends RecyclerView.ViewHolder {
    private final TextView contentTextView;
    private final TextView senderTextView;
    private final TextView timestampTextView;

    public MessageViewHolder(@NonNull View itemView) {
        super(itemView);
        this.contentTextView = itemView.findViewById(R.id.contentTextView);
        this.senderTextView = itemView.findViewById(R.id.senderTextView);
        this.timestampTextView = itemView.findViewById(R.id.timestampTextView);
    }

    public void bind(messageFictif message) {
        this.contentTextView.setText(message.getContent());
        this.senderTextView.setText(message.getSender());
        this.timestampTextView.setText(message.getTimestamp().toString());
    }
}
