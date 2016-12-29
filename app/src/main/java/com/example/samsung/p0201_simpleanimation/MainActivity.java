package com.example.samsung.p0201_simpleanimation;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    final int MENU_ALPHA_ID = 1,
              MENU_SCALE_ID = 2,
              MENU_TRANSLATE_ID = 3,
              MENU_ROTATE_ID = 4,
              MENU_COMBO_ID = 5;

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView) findViewById(R.id.tv);
        registerForContextMenu(tv);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {

        switch (v.getId()) {

            case R.id.tv :
                menu.add(0, MENU_ALPHA_ID, 0, R.string.alpha);
                menu.add(0, MENU_SCALE_ID, 0, R.string.scale);
                menu.add(0, MENU_TRANSLATE_ID, 0, R.string.translate);
                menu.add(0, MENU_ROTATE_ID, 0, R.string.rotate);
                menu.add(0, MENU_COMBO_ID, 0, R.string.combo);
                break;
            default:
                break;
        }

        super.onCreateContextMenu(menu, v, menuInfo);

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        Animation anim = null;

        switch (item.getItemId()) {

            case MENU_ALPHA_ID :
                anim = AnimationUtils.loadAnimation(this, R.anim.myalpha);
                break;
            case MENU_SCALE_ID :
                anim = AnimationUtils.loadAnimation(this, R.anim.myscale);
                break;
            case MENU_COMBO_ID :
                anim = AnimationUtils.loadAnimation(this, R.anim.mycombo);
                break;
            case MENU_ROTATE_ID :
                anim = AnimationUtils.loadAnimation(this, R.anim.myrotate);
                break;
            case MENU_TRANSLATE_ID :
                anim = AnimationUtils.loadAnimation(this, R.anim.mytrans);
                break;
            default:
                break;
        }

        tv.startAnimation(anim);

        return super.onContextItemSelected(item);

    }
}
