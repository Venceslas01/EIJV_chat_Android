package fr.upjv.eijv_chat_androd;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import fr.upjv.eijv_chat_androd.MessageViewHolder;
import fr.upjv.eijv_chat_androd.messageFictif;
import fr.upjv.eijv_chat_androd.R;

public class MessageAdapter extends RecyclerView.Adapter<MessageViewHolder> {
    private final List<messageFictif> lesMessages;

    public MessageAdapter(List<messageFictif> lesMessages) {
        this.lesMessages = lesMessages;
    }

    @NonNull
    @Override
    public MessageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.messageligne, parent, false);
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
