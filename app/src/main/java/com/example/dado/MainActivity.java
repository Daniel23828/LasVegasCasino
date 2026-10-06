package com.example.dado;

import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ImageView dice1;
    ImageView dice2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        dice1 = findViewById(R.id.imageView);
        dice2 = findViewById(R.id.imageView2);
    }

    public void onRoll(View view) {
        Random randomNumberGenerator = new Random();
        int number = randomNumberGenerator.nextInt(6);
        Log.d("Dicee","The random number is : " + number);
        int[] diceArray = {R.drawable.dice1, R.drawable.dice2, R.drawable.dice3,R.drawable.dice4, R.drawable.dice5, R.drawable.dice6};
        dice1.setImageResource(diceArray[number]);
        number = randomNumberGenerator.nextInt(6);
        dice2.setImageResource(diceArray[number]);
    }
}