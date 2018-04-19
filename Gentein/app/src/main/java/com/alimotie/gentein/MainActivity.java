package com.alimotie.gentein;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Fade;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.Toast;
import java.util.Random;

import java.util.ArrayList;

import static android.transition.Fade.IN;

public class MainActivity extends AppCompatActivity {
    EditText Atg;
    Button Translate_Seq;
    Button Genrate_Seq;
    Animation uptodown,downtoup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Atg = (EditText) findViewById(R.id.Atg);
        Translate_Seq = (Button) findViewById(R.id.tran_sq);
        Genrate_Seq = (Button) findViewById(R.id.Genrate_Rondom_dna_seq_);

        uptodown= AnimationUtils.loadAnimation(this,R.anim.uptodown);
        downtoup=AnimationUtils.loadAnimation(this,R.anim.downtoup);

        Animation fadeIn = new AlphaAnimation(0, 1);
        fadeIn.setInterpolator(new DecelerateInterpolator()); //add this
        fadeIn.setDuration(3000);
        Atg.setAnimation(fadeIn);
        Genrate_Seq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                AlertDialog.Builder mbelder = new AlertDialog.Builder(MainActivity.this);
                View view1 = getLayoutInflater().inflate(R.layout.genrate_rondom_dna, null);


                final EditText Length = (EditText) view1.findViewById(R.id.Enter_Length);
                Button Genrate = (Button) view1.findViewById(R.id.Genratebtn);
                final Button Close = (Button) view1.findViewById(R.id.Close);
                mbelder.setView(view1);
                final AlertDialog dialog = mbelder.create();

                dialog.show();


                Genrate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String idx = Length.getText().toString();

                        if(idx.isEmpty()){
                            Toast.makeText(getApplicationContext(),"Enter Lemgth of DNA Sequance",Toast.LENGTH_SHORT).show();
                          }
                        else{
                            int indx = Integer.parseInt(idx);
                            Random random = new Random();

                            char[] x = {'G', 'T', 'C', 'A'};
                            char[] R_SEQ = new char[indx];
                            for (int i = 0; i < R_SEQ.length; i++) {
                                R_SEQ[i] = x[random.nextInt(x.length)];
                            }
                            String Ron_seq = new String(R_SEQ);
                            Atg.setText(Ron_seq);
                            dialog.cancel();

                        }
                    }
                });
                Close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.cancel();
                    }
                });


            }
        });
        Translate_Seq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String Atg_DATA = Atg.getText().toString();
                if(Atg_DATA.isEmpty()){

                    Toast.makeText(getApplicationContext(),"Enter DNA Sequance",Toast.LENGTH_SHORT).show();
                }
                else{
                    char[] Seq_Array = Atg_DATA.toCharArray();
                    String OUTPUT = GENTEN_SEQ(Seq_Array);

                    Seq_Array = MOVE_ONE_CHAR(Seq_Array);
                    String OUTPUT2 = GENTEN_SEQ(Seq_Array);
                    Seq_Array = MOVE_ONE_CHAR(Seq_Array);
                    String OUTPUT3 = GENTEN_SEQ(Seq_Array);
                    Seq_Array = REV_SEQ(Seq_Array);
                    String OUTPUT4 = GENTEN_SEQ(Seq_Array);
                    Seq_Array = MOVE_ONE_CHAR(Seq_Array);
                    String OUTPUT5 = GENTEN_SEQ(Seq_Array);
                    Seq_Array = MOVE_ONE_CHAR(Seq_Array);
                    String OUTPUT6 = GENTEN_SEQ(Seq_Array);
                    ArrayList<String> arrayList = new ArrayList<String>();
                    ArrayList<String> arrayList2 = new ArrayList<String>();
                    ArrayList<String> arrayList3 = new ArrayList<String>();
                    ArrayList<String> arrayList4 = new ArrayList<String>();
                    ArrayList<String> arrayList5 = new ArrayList<String>();
                    ArrayList<String> arrayList6 = new ArrayList<String>();

                    arrayList=OPEN_FRAME_REDING(OUTPUT);

                    arrayList2=OPEN_FRAME_REDING(OUTPUT2);
                    arrayList3=OPEN_FRAME_REDING(OUTPUT3);
                    arrayList4=OPEN_FRAME_REDING(OUTPUT4);
                    arrayList5=OPEN_FRAME_REDING(OUTPUT5);
                    arrayList6=OPEN_FRAME_REDING(OUTPUT6);

                    Intent intent = new Intent(MainActivity.this, output_genrated.class);
                    intent.putExtra("ARRAYLIST1", arrayList);
                    intent.putExtra("ARRAYLIST2", arrayList2);
                    intent.putExtra("ARRAYLIST3", arrayList3);
                    intent.putExtra("ARRAYLIST4", arrayList4);
                    intent.putExtra("ARRAYLIST5", arrayList5);
                    intent.putExtra("ARRAYLIST6", arrayList6);
                    intent.putExtra("OUTPUT1", OUTPUT);
                    intent.putExtra("OUTPUT2", OUTPUT2);
                    intent.putExtra("OUTPUT3", OUTPUT3);
                    intent.putExtra("OUTPUT4", OUTPUT4);
                    intent.putExtra("OUTPUT5", OUTPUT5);
                    intent.putExtra("OUTPUT6", OUTPUT6);
                    startActivity(intent);
                }
            }

        });


    }

    public String GENTEN_SEQ(char[] Array) {
        String OUTPUT = "";
        if (Array.length % 3 == 0) {

            for (int i = 0; i < Array.length; i++) {

                if (Array[i] == 'A' ||Array[i]=='a') {
                    i++;
                    if (Array[i] == 'A' ||Array[i]=='a') {
                        i++;
                        if (Array[i] == 'A' || Array[i] == 'G' ||Array[i]=='a' ||Array[i]=='g') {
                            OUTPUT += "K ";
                        } else {
                            OUTPUT += "N ";
                        }
                    } else if (Array[i] == 'G' ||Array[i]=='g') {
                        i++;
                        if (Array[i] == 'A' || Array[i] == 'G' ||Array[i]=='a' ||Array[i]=='g') {
                            OUTPUT += "R ";
                        } else {
                            OUTPUT += "S ";
                        }
                    } else if (Array[i] == 'C' ||Array[i]=='c') {
                        i++;
                        OUTPUT += "T ";

                    } else if (Array[i] == 'T' ||Array[i]=='t') {
                        i++;
                        if (Array[i] == 'G' ||Array[i]=='g') {
                            OUTPUT += "Met ";
                        } else {
                            OUTPUT += "L ";
                        }
                    }
                }//END OF A
                else if (Array[i] == 'G' ||Array[i]=='g') {
                    i++;
                    if (Array[i] == 'A' ||Array[i]=='a') {
                        i++;
                        if (Array[i] == 'A' || Array[i] == 'G' ||Array[i]=='a' ||Array[i]=='g') {
                            OUTPUT += "E ";
                        } else {
                            OUTPUT += "D ";
                        }
                    } else if (Array[i] == 'G' ||Array[i]=='g') {
                        i++;
                        OUTPUT += "G ";
                    } else if (Array[i] == 'C' ||Array[i]=='c') {
                        i++;
                        OUTPUT += "A ";

                    } else if (Array[i] == 'T' ||Array[i]=='t') {
                        i++;
                        OUTPUT += "V ";
                    }
                }//END OF G
                else if (Array[i] == 'C' ||Array[i]=='c') {
                    i++;
                    if (Array[i] == 'A' ||Array[i]=='a') {
                        i++;
                        if (Array[i] == 'A' || Array[i] == 'G' ||Array[i]=='a' ||Array[i]=='g') {
                            OUTPUT += "Q ";
                        } else {
                            OUTPUT += "H ";
                        }
                    } else if (Array[i] == 'G' ||Array[i]=='g') {
                        i++;
                        OUTPUT += "R ";
                    } else if (Array[i] == 'C' ||Array[i]=='c') {
                        i++;
                        OUTPUT += "P ";

                    } else if (Array[i] == 'T' ||Array[i]=='t') {
                        i++;
                        OUTPUT += "L ";
                    }
                }//END OF C
                else if (Array[i] == 'T' ||Array[i]=='t') {
                    i++;
                    if (Array[i] == 'A' ||Array[i]=='a') {
                        i++;
                        if (Array[i] == 'A' || Array[i] == 'G' ||Array[i]=='a' ||Array[i]=='g') {
                            OUTPUT += "STOP ";
                        } else {
                            OUTPUT += "Y ";
                        }
                    } else if (Array[i] == 'G' ||Array[i]=='g') {
                        i++;
                        if (Array[i] == 'A' ||Array[i]=='a') {
                            OUTPUT += "STOP ";
                        } else if (Array[i] == 'G' ||Array[i]=='g') {
                            OUTPUT += "W ";
                        } else {
                            OUTPUT += "C ";
                        }
                    } else if (Array[i] == 'C' ||Array[i]=='c') {
                        i++;
                        OUTPUT += "S ";

                    } else if (Array[i] == 'T' ||Array[i]=='t') {
                        i++;
                        if (Array[i] == 'A' || Array[i] == 'G' ||Array[i]=='a' ||Array[i]=='g') {
                            OUTPUT += "L ";
                        } else {
                            OUTPUT += "F ";
                        }

                    }//END OF T
                }


            }//END OF FOR LOOP
        } else {
            int x = Array.length % 3;
            for (int i = 0; i < Array.length - x; i++) {

                if (Array[i] == 'A' ||Array[i]=='a') {
                    i++;
                    if (Array[i] == 'A' ||Array[i]=='a') {
                        i++;
                        if (Array[i] == 'A' || Array[i] == 'G' ||Array[i]=='a' ||Array[i]=='g') {
                            OUTPUT += "K ";
                        } else {
                            OUTPUT += "N ";
                        }
                    } else if (Array[i] == 'G' ||Array[i]=='g') {
                        i++;
                        if (Array[i] == 'A' || Array[i] == 'G' ||Array[i]=='a' ||Array[i]=='g') {
                            OUTPUT += "R ";
                        } else {
                            OUTPUT += "S ";
                        }
                    } else if (Array[i] == 'C' ||Array[i]=='c') {
                        i++;
                        OUTPUT += "T ";

                    } else if (Array[i] == 'T' ||Array[i]=='t') {
                        i++;
                        if (Array[i] == 'G' ||Array[i]=='g') {
                            OUTPUT += "Met ";
                        } else {
                            OUTPUT += "L ";
                        }
                    }
                }//END OF A
                else if (Array[i] == 'G' ||Array[i]=='g') {
                    i++;
                    if (Array[i] == 'A' ||Array[i]=='a') {
                        i++;
                        if (Array[i] == 'A' || Array[i] == 'G' ||Array[i]=='a' ||Array[i]=='g') {
                            OUTPUT += "E ";
                        } else {
                            OUTPUT += "D ";
                        }
                    } else if (Array[i] == 'G' ||Array[i]=='g') {
                        i++;
                        OUTPUT += "G ";
                    } else if (Array[i] == 'C' ||Array[i]=='c') {
                        i++;
                        OUTPUT += "A ";

                    } else if (Array[i] == 'T' ||Array[i]=='t') {
                        i++;
                        OUTPUT += "V ";
                    }
                }//END OF G
                else if (Array[i] == 'C' ||Array[i]=='c') {
                    i++;
                    if (Array[i] == 'A' ||Array[i]=='a') {
                        i++;
                        if (Array[i] == 'A' || Array[i] == 'G' ||Array[i]=='a' ||Array[i]=='g') {
                            OUTPUT += "Q ";
                        } else {
                            OUTPUT += "H ";
                        }
                    } else if (Array[i] == 'G' ||Array[i]=='g') {
                        i++;
                        OUTPUT += "R ";
                    } else if (Array[i] == 'C' ||Array[i]=='c') {
                        i++;
                        OUTPUT += "P ";

                    } else if (Array[i] == 'T' ||Array[i]=='t') {
                        i++;
                        OUTPUT += "L ";
                    }
                }//END OF C
                else if (Array[i] == 'T' ||Array[i]=='t') {
                    i++;
                    if (Array[i] == 'A' ||Array[i]=='a') {
                        i++;
                        if (Array[i] == 'A' || Array[i] == 'G' ||Array[i]=='a' ||Array[i]=='g') {
                            OUTPUT += "STOP ";
                        } else {
                            OUTPUT += "Y ";
                        }
                    } else if (Array[i] == 'G' ||Array[i]=='g') {
                        i++;
                        if (Array[i] == 'A' ||Array[i]=='a') {
                            OUTPUT += "STOP ";
                        } else if (Array[i] == 'G' ||Array[i]=='g') {
                            OUTPUT += "W ";
                        } else {
                            OUTPUT += "C ";
                        }
                    } else if (Array[i] == 'C' ||Array[i]=='c') {
                        i++;
                        OUTPUT += "S ";

                    } else if (Array[i] == 'T' ||Array[i]=='t') {
                        i++;
                        if (Array[i] == 'A' || Array[i] == 'G' ||Array[i]=='a' ||Array[i]=='g') {
                            OUTPUT += "L ";
                        } else {
                            OUTPUT += "F ";
                        }

                    }//END OF T
                }


            }//END OF FOR LOOP
        }

        return OUTPUT;
    }

    public char[] MOVE_ONE_CHAR(char[] Array) {
        char[] Seq_Array2 = new char[Array.length];

        int j = 0;
        for (int i = 1; i < Array.length; i++) {
            Seq_Array2[j] = Array[i];
            j++;
        }
        Seq_Array2[j] = Array[0];
        return Seq_Array2;
    }

    public char[] REV_SEQ(char[] Array) {
        int j = 0;
        char[] Array_Rev = new char[Array.length];
        for (int i = Array.length - 1; i >= 0; i--) {
            Array_Rev[j] = Array[i];
            j++;
        }
        return Array_Rev;
    }


    public static ArrayList<String> OPEN_FRAME_REDING(String x){
        char[]array_of_Inputs=x.toCharArray();
        String y="";
        ArrayList<String> arrayList=new ArrayList<>();
        int i=0;
        int j=0;
        while(i<array_of_Inputs.length){
            y="";
            if(array_of_Inputs[i]=='M'){
                j=i;



                while (true ||j<array_of_Inputs.length)   {

                    y += (array_of_Inputs[j]);
                    if(array_of_Inputs.length-1==j){
                        break;
                    }
                    j++;

                    if (array_of_Inputs[j] == 'S') {
                        y+=array_of_Inputs[j];
                        if(array_of_Inputs.length-1==j){
                            break;}
                        j++;

                        if (array_of_Inputs[j] == 'T'){
                            y+=array_of_Inputs[j];
                            if(array_of_Inputs.length-1==j){
                                break;
                            }

                            j++;
                            if (array_of_Inputs[j] == 'O') {
                                y += "OP";
                                arrayList.add(y);

                                break;
                            }



                        }



                    }

                }

            }


            i++;




        }
        return arrayList;

    }
}
