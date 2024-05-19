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
    private final String mySenderIdentifier; // Identifier de l'utilisateur actuel
    private static final int VIEW_TYPE_ME = 1; // Type de vue pour les messages de l'utilisateur actuel
    private static final int VIEW_TYPE_OTHER = 2; // Type de vue pour les messages des autres utilisateurs

    // Constructeur de la classe MessageAdapter
    public MessageAdapter(List<messageFictif> lesMessages, String email) {
        this.lesMessages = lesMessages;
        this.mySenderIdentifier = email;
    }


    // Méthode pour obtenir le type de vue en fonction de l'expéditeur du message
    @Override
    public int getItemViewType(int position) {
        messageFictif message = lesMessages.get(position);
        if (message.getSender() != null && message.getSender().equals(mySenderIdentifier)) {
            return VIEW_TYPE_ME;
        } else {
            return VIEW_TYPE_OTHER;
        }
    }

// Méthode pour créer un MessageViewHolder en fonction du type de vue
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

    // Méthode pour lier un MessageViewHolder à un message
    @Override
    public void onBindViewHolder(@NonNull MessageViewHolder holder, int position) {
        messageFictif message = lesMessages.get(position);
        holder.bind(message);
    }

    // Méthode pour obtenir le nombre de messages
    @Override
    public int getItemCount() {
        return lesMessages.size();
    }
}



