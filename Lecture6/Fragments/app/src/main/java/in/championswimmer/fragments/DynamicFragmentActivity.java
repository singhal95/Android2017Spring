package in.championswimmer.fragments;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DynamicFragmentActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnRed, btnBlue;
    FragmentManager fragManager;
    FragmentTransaction fragTxn;

    public static final int FRAG_RED = 0;
    public static final int FRAG_BLUE = 1;

    int fragType = FRAG_BLUE;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_fragment);

        btnBlue = (Button) findViewById(R.id.btnBlue);
        btnRed = (Button) findViewById(R.id.btnRed);
        btnBlue.setOnClickListener(this);
        btnRed.setOnClickListener(this);

        fragManager = getSupportFragmentManager();

        if (savedInstanceState != null) {
            fragType = savedInstanceState.getInt("fragType");
        }


        setFragment(fragType);


    }



    @Override
    protected void onSaveInstanceState(Bundle outState) {

        outState.putInt("fragType", fragType);

        super.onSaveInstanceState(outState);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnBlue:
                // attach fragment blue
                setFragment(FRAG_BLUE);
                break;
            case R.id.btnRed:
                // attach fragment red
                setFragment(FRAG_RED);
                break;
        }
    }

    void setFragment (int fragmentType) {

        fragType  = fragmentType;

        switch (fragmentType) {
            case FRAG_BLUE:
                fragManager.beginTransaction()
                        .replace(R.id.flFragContainer, new BlueFragment())
                        .commit();
                break;

            case FRAG_RED:
                fragManager.beginTransaction()
                        .replace(R.id.flFragContainer, new RedFragment())
                        .commit();
                break;
        }
    }
}
