package com.artemis.simplejavaserverconection;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText sendText;
    TextView receiveText;
    Button sendButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sendText = findViewById(R.id.textToSend);
        receiveText = findViewById(R.id.receivedText);
        sendButton = findViewById(R.id.sendButton);

        sendButton.setOnClickListener(this);
    }

    public void sendText(View v) {
        MessageSender mSender = new MessageSender();
        try {
            receiveText.setText(mSender.execute(sendText.getText().toString()).get());
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.sendButton) {
            sendText(v);
        }
    }
}
