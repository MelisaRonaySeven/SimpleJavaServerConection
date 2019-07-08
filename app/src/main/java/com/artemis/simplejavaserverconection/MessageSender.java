package com.artemis.simplejavaserverconection;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class MessageSender extends AsyncTask<String, Context, String> {
    private Socket socket;
    private static PrintWriter printWriter;
    private DataInputStream input = null;
    String receivedText;

    private static String ip = "10.253.89.47";

    @Override
    protected String doInBackground(String... strings) {
        String message = strings[0];
        try {
            socket = new Socket(ip, 5000);

            input = new DataInputStream(socket.getInputStream());

            receivedText = input.readUTF();

            Log.d("preferences ", receivedText);

            printWriter = new PrintWriter(socket.getOutputStream());

            printWriter.write(message);
            printWriter.flush();
            printWriter.close();
            socket.close();

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return receivedText;
    }
}
