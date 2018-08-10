package com.alimotie.gentein;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;
import java.lang.ref.WeakReference;
import java.util.Hashtable;
import java.util.Random;
import org.biojava.bio.seq.Sequence;
import org.biojava.bio.seq.db.GenbankSequenceDB;
import java.lang.Exception;
public class MainActivity extends AppCompatActivity {
    EditText Atg;
    LinearLayout ll;
    ProgressBar pr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pr=(ProgressBar)findViewById(R.id.Prog);
        Atg=(EditText)findViewById(R.id.Atg);
        ll=(LinearLayout)findViewById(R.id.Linear);

    }
    public void Translate_Seq(View view){
        String Atg_DATA = Atg.getText().toString();
        if (Atg_DATA.isEmpty()) {

            Toast.makeText(getApplicationContext(), "Enter DNA Sequence", Toast.LENGTH_SHORT).show();
        } else {
            Atg_DATA = Atg_DATA.toUpperCase();
            Translate_AsyncTask translate_asyncTask=new Translate_AsyncTask(this);
            translate_asyncTask.execute(Atg_DATA);

        }
    }
    public  void Random_DNA_Seq(View view){
        AlertDialog.Builder mbelder = new AlertDialog.Builder(MainActivity.this);
        View view1 = getLayoutInflater().inflate(R.layout.genrate_rondom_dna, null);


        final EditText Length = (EditText) view1.findViewById(R.id.Enter_Length);
        Button Generate = (Button) view1.findViewById(R.id.Genratebtn);
        final Button Close = (Button) view1.findViewById(R.id.Close);
        mbelder.setView(view1);
        final AlertDialog dialog = mbelder.create();

        dialog.show();


        Generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String idx = Length.getText().toString();

                if (idx.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Enter Length of DNA Sequence", Toast.LENGTH_SHORT).show();
                } else {

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
    public void retrieve_from_genbank(View view){
       AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
       final View view1 = getLayoutInflater().inflate(R.layout.genbank, null);
       final EditText AssonNumber = (EditText) view1.findViewById(R.id.Enter_AssatioNumber);
       Button Retrieve = (Button) view1.findViewById(R.id.RETREVEBTN);
       final Button Close = (Button) view1.findViewById(R.id.Close);
       builder.setView(view1);
       final AlertDialog dialog = builder.create();
       dialog.show();
       Close.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               dialog.cancel();
           }
       });
       Retrieve.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Genbank_AsyncTask genbank_asyncTask=new Genbank_AsyncTask(MainActivity.this);
               genbank_asyncTask.execute(AssonNumber.getText().toString());



               dialog.cancel();

           }
       });
    }
    private static class Genbank_AsyncTask extends AsyncTask<String,String,String[]>{
        private WeakReference<MainActivity> activityWeakReference;
        Genbank_AsyncTask(MainActivity activity){
            activityWeakReference=new WeakReference<MainActivity>(activity);
        }


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            MainActivity activity=activityWeakReference.get();
            if(activity==null||activity.isFinishing()){
                return;
            }
           activity.pr.setVisibility(View.VISIBLE);
           activity. ll.setVisibility(View.INVISIBLE);
        }

        @Override
        protected String[] doInBackground(String... strings) {
            Sequence sequence;
            GenbankSequenceDB genbankSequenceDB=new GenbankSequenceDB();
            try {


                sequence = genbankSequenceDB.getSequence(strings[0]);
               strings[0]= sequence.seqString();
            }
            catch (Exception e){
                e.printStackTrace();
            }
            return strings ;
        }

        @Override
        protected void onPostExecute(String[] s) {
            super.onPostExecute(s);
            MainActivity activity=activityWeakReference.get();
            if(activity==null||activity.isFinishing()){
                return;
            }
           activity. pr.setVisibility(View.INVISIBLE);
          activity.  ll.setVisibility(View.VISIBLE);
         activity. Atg.setText(s[0]);
        }
    }
    private static class Translate_AsyncTask extends AsyncTask<String,String,String[]>{
        private WeakReference<MainActivity> activityWeakReference;
        Hashtable<String,String> hashtable=new Hashtable<String, String>();

        Translate_AsyncTask(MainActivity activity){
            activityWeakReference=new WeakReference<MainActivity>(activity);
        }
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            MainActivity activity=activityWeakReference.get();
            if(activity==null||activity.isFinishing()){
                return;
            }
            activity.pr.setVisibility(View.VISIBLE);
            activity.ll.setVisibility(View.GONE);

        }
        @Override
        protected String [] doInBackground(String... strings) {
            hashtable.put("AAA", "k");
            hashtable.put("AAG", "K");
            hashtable.put("AAC", "N");
            hashtable.put("AAT", "N");
            hashtable.put("AGA", "R");
            hashtable.put("AGG", "R");
            hashtable.put("CGA", "R");
            hashtable.put("CGG", "R");
            hashtable.put("CGI", "R");
            hashtable.put("CGC", "R");
            hashtable.put("AGC", "S");
            hashtable.put("AGT", "S");
            hashtable.put("TCT", "S");
            hashtable.put("TCC", "S");
            hashtable.put("TCA", "S");
            hashtable.put("TCG", "S");
            hashtable.put("ACG", "T");
            hashtable.put("ACC", "T");
            hashtable.put("ACT", "T");
            hashtable.put("ACA", "T");
            hashtable.put("ATC", "I");
            hashtable.put("ATT", "I");
            hashtable.put("ATA", "I");
            hashtable.put("ATG", "Met");
            hashtable.put("GAA", "E");
            hashtable.put("GAG", "E");
            hashtable.put("GAC", "D");
            hashtable.put("GAT", "D");
            hashtable.put("GGA", "G");
            hashtable.put("GGC", "G");
            hashtable.put("GGG", "G");
            hashtable.put("GGT", "G");
            hashtable.put("GCG", "A");
            hashtable.put("GCA", "A");
            hashtable.put("GCT", "A");
            hashtable.put("GCC", "A");
            hashtable.put("GTA", "V");
            hashtable.put("GTT", "V");
            hashtable.put("GTC", "V");
            hashtable.put("GTG", "V");
            hashtable.put("CAA", "Q");
            hashtable.put("CAG", "Q");
            hashtable.put("CAC", "H");
            hashtable.put("CAT", "H");
            hashtable.put("CCA", "P");
            hashtable.put("CCT", "P");
            hashtable.put("CCG", "P");
            hashtable.put("CCC", "P");
            hashtable.put("CTA", "L");
            hashtable.put("CTG", "L");
            hashtable.put("CTT", "L");
            hashtable.put("CTC", "L");
            hashtable.put("TAA", "STOP");
            hashtable.put("TAG", "STOP");
            hashtable.put("TGA", "STOP");
            hashtable.put("TAC", "Y");
            hashtable.put("TAT", "Y");
            hashtable.put("TGG", "W");
            hashtable.put("TGT", "C");
            hashtable.put("TGC", "C");
            hashtable.put("TTA", "L");
            hashtable.put("TTG", "L");
            hashtable.put("TTC", "F");
            hashtable.put("TTT", "F");
            hashtable.put("CGT", "R");
            String []Output=new String[12];
            String x;
for(int j=0;j<3;j++){
    Output[j]=" ";
            for (int i = 0; i <= (strings[0].length()) -3; i += 3) {
                int v = i + 3;
                if(v<=strings[0].length()) {
                    x = strings[0].substring(i, v);
                    System.out.println(x);
                    if(hashtable.get(x)!=null) {
                        Output[j] += hashtable.get(x) + " ";
                        System.out.println(Output[j]);
                    }
                }
                else{
                    break;
                }
            }

        }
            int j = 0;
String st=strings[0];
            char[] Array_Rev = new char[st.length()];
            char []Array=st.toCharArray();
            for (int i =st.length() - 1; i >= 0; i--) {
                Array_Rev[j] = Array[i];
                j++;
            }
            String q=new String(Array_Rev);
            for(int z=0;z<3;z++){
                int f=z+3;
                Output[f]=" ";
                for (int i = 0; i <= (q.length()) -3; i += 3) {
                    int v = i + 3;
                    if(v<=q.length()) {
                        String a = q.substring(i, v);
                        System.out.println(q);
                        if(hashtable.get(a)!=null) {
                            Output[f] += hashtable.get(a) + " ";
                            System.out.println(Output[f]);
                        }
                    }
                    else{
                        break;
                    }
                }

            }
            for(int g=0;g<6;g++){
                char[]array_of_Inputs=Output[g].toCharArray();
                String y="";

                int i=0;
                int z=0;
                int c=1;
                int s=g+6;
                Output[s]=" ";
                while(i<array_of_Inputs.length){
                    y=" ";

                    if(array_of_Inputs[i]=='M'){
                        z=i;




                        while (true ||z<array_of_Inputs.length)   {

                            y +=(array_of_Inputs[z]);
                            if(array_of_Inputs.length-1==z){
                                break;
                            }
                            z++;

                            if (array_of_Inputs[z] == 'S') {
                                y+=array_of_Inputs[z];
                                if(array_of_Inputs.length-1==z){
                                    break;}
                                z++;

                                if (array_of_Inputs[z] == 'T'){
                                    y+=array_of_Inputs[z];
                                    if(array_of_Inputs.length-1==z){
                                        break;
                                    }
                                    z++;
                                    if (array_of_Inputs[z] == 'O') {
                                        y += "OP";

                                        Output[s]+="["+c+"]"+y+"\n";
                                            c++;
                                        break;
                                    }
                                }
                            }
                        }
                    }


                    i++;




                }

            }
            return Output;
        }
        @Override
        protected void onPostExecute(String[] s) {
            super.onPostExecute(s);
            MainActivity activity=activityWeakReference.get();
            if(activity==null||activity.isFinishing()){
                return;
            }
            Intent intent=new Intent(activity,output_genrated.class);
            intent.putExtra("OutPut",s);
          activity.startActivity(intent);
            activity.pr.setVisibility(View.GONE);
            activity.ll.setVisibility(View.VISIBLE);

        }
    }




}
