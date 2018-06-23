package cegeka.scoaladevalori.ro.taskao;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class DetailActivity extends AppCompatActivity {
    TextView actTitle,actDesc, actDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        actTitle = (TextView) findViewById(R.id.nameDetailTxt);
        actDesc = (TextView) findViewById(R.id.descDetailTxt);
        actDate = (TextView) findViewById(R.id.descDetailTxt);
        //propTxt = (TextView) findViewById(R.id.propellantDetailTxt);

        //GET INTENT
        Intent intent=this.getIntent();


        //RECEIVE DATA
        String name=intent.getExtras().getString("NAME_KEY");
        String desc=intent.getExtras().getString("DESC_KEY");
        String date=intent.getExtras().getString("DATE_KEY");
        //String propellant=i.getExtras().getString("PROP_KEY");

        //BIND DATA
        actTitle.setText(name);
        actDesc.setText(desc);
        actDate.setText(date);
        //propTxt.setText(propellant);

        /*
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view, "Replace with your own action", Toast.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }

}
