package cegeka.scoaladevalori.ro.taskao;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AddActivity extends AppCompatActivity {

    private EditText titleActivity, descriptionActivity, dateActivity;
    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase;
    private ProgressDialog progressDialog;
    Button AddActivityToList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        titleActivity = findViewById(R.id.etTitleActivity);
        descriptionActivity = findViewById(R.id.etDescriptionActivity);
        dateActivity = findViewById(R.id.etDueDate);
        AddActivityToList = findViewById(R.id.btnAddActivityMain);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();

        DatabaseReference databaseReference = firebaseDatabase.getReference(firebaseAuth.getUid());

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                UserActivities userActivities = dataSnapshot.getValue(UserActivities.class);
                titleActivity.setText("Title: " + userActivities.getUserActivityTitile());
                descriptionActivity.setText("Description: " + userActivities.getUserActivityDescription());
                dateActivity.setText("Date: " + userActivities.getUserActivityDate());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(AddActivity.this, databaseError.getCode(), Toast.LENGTH_SHORT).show();            }
        });
    }

}
