package ru.myitschool.lab23;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.snackbar.Snackbar;

import ru.myitschool.lab23.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Button btn = binding.content.btn;
        EditText titleET = binding.content.eventTitleUserInput;
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data = titleET.getText().toString();
                if(data.isEmpty()){
                    Snackbar.make(view,"OK", Snackbar.LENGTH_LONG).show();
                }else{
                    DiaryDialog dialog = new DiaryDialog();
                    FragmentManager manager = getSupportFragmentManager();
                    Bundle bundle = new Bundle();
                    bundle.putString("title", data);
                    dialog.setArguments(bundle);
                    dialog.show(manager, "alert");
                }

            }
        });


    }
}

