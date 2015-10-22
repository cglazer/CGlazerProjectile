package projectile.glazer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by student1 on 10/15/2015.
 */
public class AnswerActivity extends AppCompatActivity {
    private TextView answer;
    private double angle;
    private double velocity;
    private double time;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.answer_activity);
        answer = (TextView) findViewById(R.id.answer);
        Intent intent = getIntent();
        double angle = intent.getDoubleExtra("ANGLE", 0.0);
        double velocity = intent.getDoubleExtra("VELOCITY", 0.0);
        double time = intent.getDoubleExtra("TIME", 0.0);
        answer.setText(getX() + " ," + getY());
    }
    public double getY(){
         double radians = Math.toRadians(angle);
         return (Math.cos(radians)*time*velocity-(.5*9.8*time*time));
    }

    public double getX(){
        double radians = Math.toRadians(angle);
        return (Math.sin(radians)*time*velocity);
    }
}

