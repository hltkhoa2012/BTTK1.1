package com.example.hltk_cau1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    EditText edt_a = (EditText) findViewById(R.id.edt_a);
    EditText edt_b = (EditText) findViewById(R.id.edt_b);
    EditText edt_c = (EditText) findViewById(R.id.edt_c);
    TextView txt_KQ = (TextView)findViewById(R.id.txt_KQ);
    Button btn_Giai = (Button) findViewById(R.id.btn_Giai);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_Giai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sa = edt_a.getText().toString();
                String sb = edt_b.getText().toString();
                String sc = edt_c.getText().toString();

                try
                {
                    double a = Double.parseDouble(sa);
                    double b = Double.parseDouble(sb);
                    double c = Double.parseDouble(sc);

                    if (a == 0)
                    {
                        txt_KQ.setText("Phương trình bậc I: ");
                        if (b == 0)
                        {
                            if (c == 0)
                                txt_KQ.setText(txt_KQ.getText() + "Phương trình có vô số nghiệm");
                            else
                                txt_KQ.setText(txt_KQ.getText() + "Phương trình vô nghiệm");
                        }
                        else
                        {
                            txt_KQ.setText(txt_KQ.getText() + "x = " + (-c/b));
                        }
                    }
                    else
                    {
                        double delta = b*b - 4*a*c;

                        if (delta < 0.0)
                        {
                            txt_KQ.setText("Phương trình vô nghiệm\n");
                        }
                        else
                        if (delta == 0)
                        {
                            txt_KQ.setText("Phương trình có nghiệm kép = " + (-b/(2*a)));
                        }
                        else
                        {
                            double delta_sqrt = Math.sqrt(delta);
                            txt_KQ.setText("x1 = " + ((b*b + delta_sqrt)/(2 * a)) + "\n" + "x2 = " + ((b*b - delta_sqrt)/(2 * a)));
                        }
                    }
                } catch (Exception ex) {

                    txt_KQ.setText(ex.toString());
                }
            }
        });
    }
}
