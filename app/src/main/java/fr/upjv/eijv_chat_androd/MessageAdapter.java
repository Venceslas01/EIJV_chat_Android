//MessageAdapter
package fr.upjv.eijv_chat_androd;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter<MessageViewHolder> {
    private final List<messageFictif> lesMessages;
    private final String mySenderIdentifier = "Moi"; // Identifier de l'utilisateur actuel
    private static final int VIEW_TYPE_ME = 1;
    private static final int VIEW_TYPE_OTHER = 2;

    public MessageAdapter(List<messageFictif> lesMessages) {
        this.lesMessages = lesMessages;
    }

    @Override
    public int getItemViewType(int position) {
        messageFictif message = lesMessages.get(position);
        return message.getSender().equals(mySenderIdentifier) ? VIEW_TYPE_ME : VIEW_TYPE_OTHER;
    }

    @NonNull
    @Override
    public MessageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view;
        if (viewType == VIEW_TYPE_ME) {
            view = inflater.inflate(R.layout.messageligne, parent, false);
        } else {
            view = inflater.inflate(R.layout.messageautre, parent, false);
        }
        return new MessageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MessageViewHolder holder, int position) {
        messageFictif message = lesMessages.get(position);
        holder.bind(message);
    }

    @Override
    public int getItemCount() {
        return lesMessages.size();
    }
}



/*public class MessageAdapter extends RecyclerView.Adapter<MessageViewHolder> {
    private final List<messageFictif> lesMessages;

    public MessageAdapter(List<messageFictif> lesMessages) {
        this.lesMessages = lesMessages;
    }

    @NonNull
    public MessageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.messageligne, parent, false);
        return new MessageViewHolder(view);
    }


    public void onBindViewHolder(@NonNull MessageViewHolder holder, int position) {
        messageFictif message = lesMessages.get(position);
        holder.bind(message);
    }

    public int getItemCount() {
        return lesMessages.size();
    }
}*/