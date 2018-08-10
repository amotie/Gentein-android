package com.alimotie.gentein;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.ClipboardManager;
import android.widget.TextView;
import android.widget.Toast;


public class output_genrated extends AppCompatActivity {
    TextView Frame;
    TextView Output1;
    TextView Frame2;
    TextView Output2;
    TextView Frame3;
    TextView Output3;
    TextView Frame4;
    TextView Output4;
    TextView Frame5;
    TextView Output5;
    TextView Frame6;
    TextView Output6;
    TextView R_FRAME1;
    TextView R_FRAME2;
    TextView R_FRAME3;
    TextView R_FRAME4;
    TextView R_FRAME5;
    TextView R_FRAME6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_output_genrated);
        Frame = (TextView) findViewById(R.id.Frame);
        Output1 = (TextView) findViewById(R.id.output1);
        Frame2 = (TextView) findViewById(R.id.Frame2);
        Output2 = (TextView) findViewById(R.id.output2);
        Frame3 = (TextView) findViewById(R.id.Frame3);
        Output3 = (TextView) findViewById(R.id.output3);
        Frame4 = (TextView) findViewById(R.id.Frame4);
        Output4 = (TextView) findViewById(R.id.output4);
        Frame5 = (TextView) findViewById(R.id.Frame5);
        Output5 = (TextView) findViewById(R.id.output5);
        Frame6 = (TextView) findViewById(R.id.Frame6);
        Output6 = (TextView) findViewById(R.id.output6);
        R_FRAME1 = (TextView) findViewById(R.id.OPEN_REDING1);
        R_FRAME2 = (TextView) findViewById(R.id.OPEN_REDING2);
        R_FRAME3 = (TextView) findViewById(R.id.OPEN_REDING3);
        R_FRAME4 = (TextView) findViewById(R.id.OPEN_REDING4);
        R_FRAME5 = (TextView) findViewById(R.id.OPEN_REDING5);
        R_FRAME6 = (TextView) findViewById(R.id.OPEN_REDING6);


        Intent intent1 = getIntent();
        if (intent1.hasExtra("OutPut")) {
            String[] Output = intent1.getStringArrayExtra("OutPut");
            Frame.setText("5'3' Frame 1");
            Output1.setText(Output[0]);
            R_FRAME1.setText(Output[6]);
            Frame2.setText("5'3' Frame 2");
            Output2.setText(Output[1]);
            R_FRAME2.setText(Output[7]);
            Frame3.setText("5'3' Frame 3");
            Output3.setText(Output[2]);
            R_FRAME3.setText(Output[8]);
            Frame4.setText("3'5' Frame 1");
            Output4.setText(Output[3]);
            R_FRAME4.setText(Output[9]);
            Frame5.setText("3'5' Frame 2");
            Output5.setText(Output[4]);
            R_FRAME5.setText(Output[10]);
            Frame6.setText("3'5' Frame 3");
            Output6.setText(Output[5]);
            R_FRAME6.setText(Output[11]);
        }

    }
    public void Copy1(View view){
ClipboardManager clipboardManager=(ClipboardManager)getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clipData=ClipData.newPlainText("PROTEIN_DATA",Output1.getText().toString());
        clipboardManager.setPrimaryClip(clipData);
        Toast.makeText(getApplicationContext(), "Copied", Toast.LENGTH_SHORT).show();
    }
    public void Copy2(View view){
        ClipboardManager clipboardManager=(ClipboardManager)getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clipData=ClipData.newPlainText("PROTEIN_DATA",Output2.getText().toString());
        clipboardManager.setPrimaryClip(clipData);
        Toast.makeText(getApplicationContext(), "Copied", Toast.LENGTH_SHORT).show();
    }
    public void Copy3(View view){
        ClipboardManager clipboardManager=(ClipboardManager)getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clipData=ClipData.newPlainText("PROTEIN_DATA",Output3.getText().toString());
        clipboardManager.setPrimaryClip(clipData);
    }
    public void Copy4(View view){
        ClipboardManager clipboardManager=(ClipboardManager)getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clipData=ClipData.newPlainText("PROTEIN_DATA",Output4.getText().toString());
        clipboardManager.setPrimaryClip(clipData);
        Toast.makeText(getApplicationContext(), "Copied", Toast.LENGTH_SHORT).show();
    }
    public void Copy5(View view){
        ClipboardManager clipboardManager=(ClipboardManager)getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clipData=ClipData.newPlainText("PROTEIN_DATA",Output5.getText().toString());
        clipboardManager.setPrimaryClip(clipData);
        Toast.makeText(getApplicationContext(), "Copied", Toast.LENGTH_SHORT).show();
    }
    public void Copy6(View view){
        ClipboardManager clipboardManager=(ClipboardManager)getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clipData=ClipData.newPlainText("PROTEIN_DATA",Output6.getText().toString());
        clipboardManager.setPrimaryClip(clipData);
        Toast.makeText(getApplicationContext(), "Copied", Toast.LENGTH_SHORT).show();
    }
}






