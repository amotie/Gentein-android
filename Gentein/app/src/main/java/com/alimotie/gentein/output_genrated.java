package com.alimotie.gentein;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import javax.xml.transform.Templates;

public class output_genrated extends AppCompatActivity {
    TextView Frame;
    TextView Output;
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
    String Outp1;
    String Outp2;
    String Outp3;
    String Outp4;
    String Outp5;
    String Outp6;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_output_genrated);
        Frame = (TextView) findViewById(R.id.Frame);
        Output = (TextView) findViewById(R.id.output1);
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

        if (intent1.hasExtra("OUTPUT1")) {
            Outp1 = intent1.getStringExtra("OUTPUT1");
            Output.setText(Outp1);

        }
        if (intent1.hasExtra("OUTPUT2")) {
            Frame2.setText("5'3 Frame 2");
            Outp2 = intent1.getStringExtra("OUTPUT2");
            Output2.setText(Outp2);


        }
        if (intent1.hasExtra("OUTPUT3")) {
            Frame3.setText("5'3 Frame 3");
            Outp3 = intent1.getStringExtra("OUTPUT3");
            Output3.setText(Outp3);


        }
        if (intent1.hasExtra("OUTPUT4")) {
            Frame4.setText("3'5 Frame 1");
            Outp4 = intent1.getStringExtra("OUTPUT4");
            Output4.setText(Outp4);


        }
        if (intent1.hasExtra("OUTPUT5")) {
            Frame5.setText("3'5 Frame 2");
            Outp5 = intent1.getStringExtra("OUTPUT5");
            Output5.setText(Outp5);


        }

        if (intent1.hasExtra("OUTPUT6")) {
            Frame6.setText("3'5 Frame 3");
            Outp6 = intent1.getStringExtra("OUTPUT6");
            Output6.setText(Outp6);
        }
if(intent1.hasExtra("ARRAYLIST1")) {

    ArrayList<String> arrayList1 = intent1.getStringArrayListExtra("ARRAYLIST1");
if(arrayList1.size()!=0) {
    int j=1;
    for (int i = 0; i < arrayList1.size(); i++) {

        R_FRAME1.append("["+j+"]"+arrayList1.get(i) + "\n");
        j++;
    }
}

}


if(intent1.hasExtra("ARRAYLIST2")) {
    ArrayList<String> arrayList2 = new ArrayList<String>();
    arrayList2 = intent1.getStringArrayListExtra("ARRAYLIST2");
    int j=1;
    for (int i = 0; i < arrayList2.size(); i++) {

    R_FRAME2.append("["+j+"]"+arrayList2.get(i) + "\n");
    j++;
    }
}
if(intent1.hasExtra("ARRAYLIST3")) {
    ArrayList<String> arrayList3 = new ArrayList<>();
    arrayList3 = intent1.getStringArrayListExtra("ARRAYLIST3");
    int j=1;
    for (int i = 0; i < arrayList3.size(); i++) {

    R_FRAME3.append("["+j+"]"+arrayList3.get(i) + "\n");
        j++;
      }}

if(intent1.hasExtra("ARRAYLIST4")) {

    ArrayList<String> arrayList4 = new ArrayList<>();
    arrayList4 = intent1.getStringArrayListExtra("ARRAYLIST4");
    int j=1;
       for (int i = 0; i < arrayList4.size(); i++) {

    R_FRAME4.append("["+j+"]"+arrayList4.get(i) + "\n");
j++;
     }
}
if(intent1.hasExtra("ARRAYLIST5")) {
    ArrayList<String> arrayList5 = new ArrayList<>();
    arrayList5 = intent1.getStringArrayListExtra("ARRAYLIST5");
    int j=1;
      for (int i = 0; i < arrayList5.size(); i++) {

    R_FRAME5.append("["+j+"]"+arrayList5.get(i) + "\n");
j++;
    }
}
if(intent1.hasExtra("ARRAYLIST6")) {

    ArrayList<String> arrayList6 = new ArrayList<>();
    arrayList6 = intent1.getStringArrayListExtra("ARRAYLIST6");
    int j=1;
      for (int i = 0; i < arrayList6.size(); i++) {

    R_FRAME6.append("["+j+"]"+arrayList6.get(i) + "\n");
j++;
    }
}
}


}






