package com.example.androidassignments;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;

public class ChatWindow extends AppCompatActivity {

    protected static final String ACTIVITY_NAME = "ChatWindow";

    ListView view;
    EditText text;
    Button send;
    ArrayList<String> list = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_window);
        Log.i(ACTIVITY_NAME, "In onCreate()");

        view = (ListView) findViewById(R.id.chatView);
        text = (EditText) findViewById(R.id.text);
        send = (Button) findViewById(R.id.sendButton);

        ChatAdapter messageAdapter = new ChatAdapter( this );
        view.setAdapter(messageAdapter);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String word = (text.getText()).toString();
                list.add(word);
                int position = messageAdapter.getCount();
                messageAdapter.notifyDataSetChanged();
                messageAdapter.getView(position - 1, null, null);
                text.setText("");
            }
        });

    }

    protected void onResume() {
        super.onResume();
        Log.i(ACTIVITY_NAME, "In onResume()");
    }

    protected void onStart() {
        super.onStart();
        Log.i(ACTIVITY_NAME, "In onStart()");
    }

    protected void onPause() {
        super.onPause();
        Log.i(ACTIVITY_NAME, "In onPause()");
    }

    protected void onStop() {
        super.onStop();
        Log.i(ACTIVITY_NAME, "In onStop()");
    }

    protected void onDestroy() {
        super.onDestroy();
        Log.i(ACTIVITY_NAME, "In onDestroy()");
    }



    private class ChatAdapter extends ArrayAdapter<String> {
        public ChatAdapter(Context ctx) { super(ctx,0); }

        public int getCount() { return list.size(); }

        public String getItem(int positions){ return (list.get(positions)); }

        public View getView(int position, View convertView, ViewGroup parent){
            LayoutInflater inflater = ChatWindow.this.getLayoutInflater();
            View result = null ;

            if(position % 2 == 0){
                result = inflater.inflate(R.layout.chat_row_outgoing, null);}
            else{
                result = inflater.inflate(R.layout.chat_row_incoming, null);}

            TextView message = (TextView)result.findViewById(R.id.messageText);
            message.setText(getItem(position));
            return result;
        }

    }

}


