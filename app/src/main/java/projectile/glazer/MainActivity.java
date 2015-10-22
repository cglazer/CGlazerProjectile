package projectile.glazer;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    private EditText angle;
    private EditText velocity;
    private EditText time;
    private TextView resultY;
    private TextView resultX;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        Picasso.with(this).load("https://1millionmonkeystyping.files.wordpress.com/2013/11/projectile-motion1.jpg").into(imageView);
        button= (Button) findViewById(R.id.button1);
        angle= (EditText) findViewById(R.id.editText1);
        velocity= (EditText) findViewById(R.id.editText2);
        time= (EditText) findViewById(R.id.editText3);
        resultY=(TextView) findViewById(R.id.text4);
        resultX=(TextView) findViewById(R.id.text5);
        button.setOnClickListener(new View.OnClickListener() {
                       @Override
                      public void onClick(View v) {
                           calculate();
                           }
                   });
    }
    public void calculate(){
        Intent intent = new Intent(this, AnswerActivity.class);

        Double valueAngle = Double.parseDouble(angle.getText().toString());
        Double valueVelocity = Double.parseDouble(velocity.getText().toString());
        Double valueTime = Double.parseDouble(time.getText().toString());


        intent.putExtra("ANGLE",  valueAngle);
        intent.putExtra("Velocity", valueVelocity);
        intent.putExtra("TIME", valueTime);
        startActivity(intent);
            }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
