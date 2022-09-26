package com.example.livedatacomponent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // object of MainViewMode
    MainViewModel mainViewModel;
    TextView textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // referencing the textview
        textview = findViewById(R.id.textview);

        // let access the ViewModel
        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);

        // create the observer to update the ui
        // this observer will automatically called when the LiveDdta changed
        final Observer<String> nameObserver = new Observer<String>() {
            @Override
            public void onChanged(String changedName) {
                textview.setText(changedName);
            }
        };

        // let's announce who is the observer and who is going to observe(Activity)
        mainViewModel.myName.observe(this,nameObserver);
    }

    // to better understand see previous commit then this
    // now we are using LiveData so we can use setValue methods
    // only getValue are present
    public void updateData(View view) {
        mainViewModel.updateMutableLiveData("kanha");
    }
}