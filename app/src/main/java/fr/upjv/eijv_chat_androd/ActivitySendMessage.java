package fr.upjv.eijv_chat_androd;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ActivitySendMessage {

    private FirebaseFirestore maBase;
    private EditText editTextMessage;

    public ActivitySendMessage(Context context, EditText editTextMessage) {
        maBase = FirebaseFirestore.getInstance();
        this.editTextMessage = editTextMessage;
    }

    public void onClickMessageToSend(View view) {

        Map<String, Object> maMap = new HashMap<>();

        String contenuMessage = editTextMessage.getText().toString().trim();

        if (contenuMessage.isEmpty()) {
            return;
        }

        long timestamp = System.currentTimeMillis();

        maMap.put("timestamp", timestamp);
        maMap.put("contenu", contenuMessage);
        maMap.put("sender", "Melvin");

        maBase.collection("CHAT").add(maMap)
                .addOnSuccessListener(documentReference -> {
                    editTextMessage.setText("");
                    showToast("Envoyé");
                    return;
                });

        String text = "Envoyé !";
        int duree = Toast.LENGTH_SHORT;
        Toast toastSendMessage = Toast.makeText(view.getContext(), text, duree);
        toastSendMessage.show();
    }

    private void showToast(String message) {
        Toast.makeText(editTextMessage.getContext(), message, Toast.LENGTH_SHORT).show();
    }

}
