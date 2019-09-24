package aut.groupsync;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class PopUpWindow extends Fragment {

    String text;
    Intent intent;
    EditText editText;
    String string;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.appointment_popup, container, false);


        return view;
    }

    //    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.appointment_popup);
//
//        // Setting the size of the pop up view
//        DisplayMetrics dm = new DisplayMetrics();
//        getWindowManager().getDefaultDisplay().getMetrics(dm);
//        int width = dm.widthPixels;
//        int height = dm.heightPixels;
//        getWindow().setLayout((int) (width * .6), (int) (height * .6));
//
//        // copy passing method at third activity and change button IDs
//        Button confirmButton = (Button) findViewById(R.id.confirmButton);
//        confirmButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                editText = (EditText) findViewById(R.id.appointmentText);
//                string = editText.getText().toString();
//
//                Intent resultIntent = new Intent();
//                resultIntent.putExtra("result", string);
//                setResult(RESULT_OK, resultIntent);
//                finish();
//            }
//        });
//    }
}
