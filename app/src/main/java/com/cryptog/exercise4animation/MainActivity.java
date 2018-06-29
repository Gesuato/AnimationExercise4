package com.cryptog.exercise4animation;

import android.content.Context;
import android.os.CountDownTimer;
import android.support.animation.DynamicAnimation;
import android.support.animation.SpringAnimation;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);

        rollImage();
    }


    public void rollImage(){

                final ImageView imageView = findViewById(R.id.imageView);
                final SpringAnimation anim1 = new SpringAnimation(imageView, DynamicAnimation.TRANSLATION_X,  600 );
                final SpringAnimation anim2 = new SpringAnimation(imageView, DynamicAnimation.TRANSLATION_Y, 600);
                final SpringAnimation anim3 = new SpringAnimation(imageView, DynamicAnimation.TRANSLATION_X,  0 );
                final SpringAnimation anim4 = new SpringAnimation(imageView, DynamicAnimation.TRANSLATION_Y, 0);

                anim1.start();

                anim1.addEndListener(new DynamicAnimation.OnAnimationEndListener() {
                    @Override
                    public void onAnimationEnd(DynamicAnimation animation, boolean canceled, float value, float velocity) {
                        anim2.start();

                    }
                });

        anim2.addEndListener(new DynamicAnimation.OnAnimationEndListener() {
            @Override
            public void onAnimationEnd(DynamicAnimation animation, boolean canceled, float value, float velocity) {
                anim3.start();

            }
        });

        anim3.addEndListener(new DynamicAnimation.OnAnimationEndListener() {
            @Override
            public void onAnimationEnd(DynamicAnimation animation, boolean canceled, float value, float velocity) {
                anim4.start();
            }
        });

        anim4.addEndListener(new DynamicAnimation.OnAnimationEndListener() {
            @Override
            public void onAnimationEnd(DynamicAnimation animation, boolean canceled, float value, float velocity) {
                anim1.start();
            }
        });

    }


}
