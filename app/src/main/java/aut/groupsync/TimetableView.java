package aut.groupsync;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class TimetableView extends Fragment {

    // AM buttons
    Button twelveAm, oneAm, twoAm, threeAm, fourAm, fiveAm, sixAm, sevenAm, eightAm, nineAm, tenAm, elevenAm;

    // PM Buttons
    Button twelvePm, onePm, twoPm, threePm, fourPm, fivePm, sixPm, sevenPm, eightPm, ninePm, tenPm, elevenPm;

    public static PopupWindow displayPopupWindow(View popupLayout, View onView){
        final PopupWindow popupWindow = new PopupWindow(popupLayout, LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        popupWindow.showAtLocation(onView, Gravity.CENTER, 0, 0);

        return popupWindow;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.timetable_main, container, false);

        twelveAm = (Button) view.findViewById(R.id.Time12am);
        twelveAm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View addAppointment = inflater.inflate(R.layout.appointment_popup, null);

                final PopupWindow createAppointment = displayPopupWindow(addAppointment, view);

                //working on passing data around

                final Button confirmButton = (Button) view.findViewById(R.id.confirmButton);
                confirmButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //getting text from user input
                        // tried
//                        EditText editText = (EditText) view.findViewById(R.id.appointmentText);
//                        String string = editText.getText().toString();
//
//                        twelveAm.setText(string);
//                        twelveAm.setBackgroundColor(Color.GRAY);
                    }
                });
            }
        });

        return view;
    }

    // Please don't delete below using it as reference for code - John

    //    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        // 12 am button
//        twelveAm = (Button) findViewById(R.id.Time12am);
//        twelveAm.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                // Calls and runs the Pop.java class
//                Intent intent = new Intent(TimetableView.this, PopupWindow.class);
//
//                startActivityForResult(intent, 1);
//            }
//        });
//
//        // 1 am button
//        oneAm = (Button) findViewById(R.id.Time1am);
//        oneAm.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                // Calls and runs the Pop.java class
//                Intent intent = new Intent(TimetableView.this, PopupWindow.class);
//
//                startActivityForResult(intent, 2);
//            }
//        });
//
//        // 2 am button
//        twoAm = (Button) findViewById(R.id.Time2am);
//        twoAm.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                // Calls and runs the Pop.java class
//                Intent intent = new Intent(TimetableView.this, PopupWindow.class);
//
//                startActivityForResult(intent, 3);
//            }
//        });
//
//        // 3 am button
//        threeAm = (Button) findViewById(R.id.Time3am);
//        threeAm.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                // Calls and runs the Pop.java class
//                Intent intent = new Intent(TimetableView.this, PopupWindow.class);
//
//                startActivityForResult(intent, 4);
//            }
//        });
//
//        // 4 am button
//        fourAm = (Button) findViewById(R.id.Time4am);
//        fourAm.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                // Calls and runs the Pop.java class
//                Intent intent = new Intent(TimetableView.this, PopupWindow.class);
//
//                startActivityForResult(intent, 5);
//            }
//        });
//
//        // 5 am button
//        fiveAm = (Button) findViewById(R.id.Time5am);
//        fiveAm.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                // Calls and runs the Pop.java class
//                Intent intent = new Intent(TimetableView.this, PopupWindow.class);
//
//                startActivityForResult(intent, 6);
//            }
//        });
//
//        // 6 am button
//        sixAm = (Button) findViewById(R.id.Time6am);
//        sixAm.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                // Calls and runs the Pop.java class
//                Intent intent = new Intent(TimetableView.this, PopupWindow.class);
//
//                startActivityForResult(intent, 7);
//            }
//        });
//
//        // 7 am button
//        sevenAm = (Button) findViewById(R.id.Time7am);
//        sevenAm.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                // Calls and runs the Pop.java class
//                Intent intent = new Intent(TimetableView.this, PopupWindow.class);
//
//                startActivityForResult(intent, 8);
//            }
//        });
//
//        // 8 am button
//        eightAm = (Button) findViewById(R.id.Time8am);
//        eightAm.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                // Calls and runs the Pop.java class
//                Intent intent = new Intent(TimetableView.this, PopupWindow.class);
//
//                startActivityForResult(intent, 9);
//            }
//        });
//
//
//        nineAm = (Button) findViewById(R.id.Time9am);
//        nineAm.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                // Calls and runs the Pop.java class
//                Intent intent = new Intent(TimetableView.this, PopupWindow.class);
//
//                startActivityForResult(intent, 10);
//            }
//        });
//
//        tenAm = (Button) findViewById(R.id.Time10am);
//        tenAm.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                // Calls and runs the Pop.java class
//                Intent intent = new Intent(TimetableView.this, PopupWindow.class);
//
//                startActivityForResult(intent, 11);
//            }
//        });
//
//
//        elevenAm = (Button) findViewById(R.id.Time11am);
//        elevenAm.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                // Calls and runs the Pop.java class
//                Intent intent = new Intent(TimetableView.this, PopupWindow.class);
//
//                startActivityForResult(intent, 12);
//            }
//        });
//
//        twelvePm = (Button) findViewById(R.id.Time12pm);
//        twelvePm.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                // Calls and runs the Pop.java class
//                Intent intent = new Intent(TimetableView.this, PopupWindow.class);
//
//                startActivityForResult(intent, 13);
//            }
//        });
//
//        onePm = (Button) findViewById(R.id.Time1pm);
//        onePm.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                // Calls and runs the Pop.java class
//                Intent intent = new Intent(TimetableView.this, PopupWindow.class);
//
//                startActivityForResult(intent, 14);
//            }
//        });
//
//        twoPm = (Button) findViewById(R.id.Time2pm);
//        twoPm.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                // Calls and runs the Pop.java class
//                Intent intent = new Intent(TimetableView.this, PopupWindow.class);
//
//                startActivityForResult(intent, 15);
//            }
//        });
//
//        threePm = (Button) findViewById(R.id.Time3pm);
//        threePm.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                // Calls and runs the Pop.java class
//                Intent intent = new Intent(TimetableView.this, PopupWindow.class);
//
//                startActivityForResult(intent, 16);
//            }
//        });
//
//        fourPm = (Button) findViewById(R.id.Time4pm);
//        fourPm.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                // Calls and runs the Pop.java class
//                Intent intent = new Intent(TimetableView.this, PopupWindow.class);
//
//                startActivityForResult(intent, 17);
//            }
//        });
//
//        fivePm = (Button) findViewById(R.id.Time5pm);
//        fivePm.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                // Calls and runs the Pop.java class
//                Intent intent = new Intent(TimetableView.this, PopupWindow.class);
//
//                startActivityForResult(intent, 18);
//            }
//        });
//
//        sixPm = (Button) findViewById(R.id.Time6pm);
//        sixPm.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                // Calls and runs the Pop.java class
//                Intent intent = new Intent(TimetableView.this, PopupWindow.class);
//
//                startActivityForResult(intent, 19);
//            }
//        });
//
//        sevenPm = (Button) findViewById(R.id.Time7pm);
//        sevenPm.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                // Calls and runs the Pop.java class
//                Intent intent = new Intent(TimetableView.this, PopupWindow.class);
//
//                startActivityForResult(intent, 20);
//            }
//        });
//
//        eightPm = (Button) findViewById(R.id.Time8pm);
//        eightPm.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                // Calls and runs the Pop.java class
//                Intent intent = new Intent(TimetableView.this, PopupWindow.class);
//
//                startActivityForResult(intent, 21);
//            }
//        });
//
//        ninePm = (Button) findViewById(R.id.Time9pm);
//        ninePm.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                // Calls and runs the Pop.java class
//                Intent intent = new Intent(TimetableView.this, PopupWindow.class);
//
//                startActivityForResult(intent, 22);
//            }
//        });
//
//        tenPm = (Button) findViewById(R.id.Time10pm);
//        tenPm.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                // Calls and runs the Pop.java class
//                Intent intent = new Intent(TimetableView.this, PopupWindow.class);
//
//                startActivityForResult(intent, 23);
//            }
//        });
//
//        elevenPm = (Button) findViewById(R.id.Time11pm);
//        elevenPm.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                // Calls and runs the Pop.java class
//                Intent intent = new Intent(TimetableView.this, PopupWindow.class);
//
//                startActivityForResult(intent, 24);
//            }
//        });
//    }
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        if (requestCode == 1) {
//            if (resultCode == RESULT_OK) {
//                String result = data.getStringExtra("result");
//                twelveAm.setText(result);
//                twelveAm.setBackgroundColor(Color.GRAY);
//            }
//            if (resultCode == RESULT_CANCELED) {
//
//                twelveAm.setText("Nothing is selected");
//            }
//        }
//
//        if (requestCode == 2) {
//            if (resultCode == RESULT_OK) {
//                String result = data.getStringExtra("result");
//                oneAm.setText(result);
//                oneAm.setBackgroundColor(Color.GRAY);
//            }
//            if (resultCode == RESULT_CANCELED) {
//
//                oneAm.setText("Nothing is selected");
//            }
//        }
//
//        if (requestCode == 3) {
//            if (resultCode == RESULT_OK) {
//                String result = data.getStringExtra("result");
//                twoAm.setText(result);
//                twoAm.setBackgroundColor(Color.GRAY);
//            }
//            if (resultCode == RESULT_CANCELED) {
//
//                twoAm.setText("Nothing is selected");
//            }
//        }
//
//        if (requestCode == 4) {
//            if (resultCode == RESULT_OK) {
//                String result = data.getStringExtra("result");
//                threeAm.setText(result);
//                threeAm.setBackgroundColor(Color.GRAY);
//            }
//            if (resultCode == RESULT_CANCELED) {
//
//                threeAm.setText("Nothing is selected");
//            }
//        }
//
//        if (requestCode == 5) {
//            if (resultCode == RESULT_OK) {
//                String result = data.getStringExtra("result");
//                fourAm.setText(result);
//                fourAm.setBackgroundColor(Color.GRAY);
//            }
//            if (resultCode == RESULT_CANCELED) {
//
//                fourAm.setText("Nothing is selected");
//            }
//        }
//
//        if (requestCode == 6) {
//            if (resultCode == RESULT_OK) {
//                String result = data.getStringExtra("result");
//                fiveAm.setText(result);
//                fiveAm.setBackgroundColor(Color.GRAY);
//            }
//            if (resultCode == RESULT_CANCELED) {
//
//                fiveAm.setText("Nothing is selected");
//            }
//        }
//
//
//        if (requestCode == 7) {
//            if (resultCode == RESULT_OK) {
//                String result = data.getStringExtra("result");
//                sixAm.setText(result);
//                sixAm.setBackgroundColor(Color.GRAY);
//            }
//            if (resultCode == RESULT_CANCELED) {
//
//                sixAm.setText("Nothing is selected");
//            }
//        }
//
//        if (requestCode == 8) {
//            if (resultCode == RESULT_OK) {
//                String result = data.getStringExtra("result");
//                sevenAm.setText(result);
//                sevenAm.setBackgroundColor(Color.GRAY);
//            }
//            if (resultCode == RESULT_CANCELED) {
//
//                sevenAm.setText("Nothing is selected");
//            }
//        }
//
//        if (requestCode == 9) {
//            if (resultCode == RESULT_OK) {
//                String result = data.getStringExtra("result");
//                eightAm.setText(result);
//                eightAm.setBackgroundColor(Color.GRAY);
//            }
//            if (resultCode == RESULT_CANCELED) {
//
//                eightAm.setText("Nothing is selected");
//            }
//        }
//
//        if (requestCode == 10) {
//            if (resultCode == RESULT_OK) {
//                String result = data.getStringExtra("result");
//                nineAm.setText(result);
//                nineAm.setBackgroundColor(Color.GRAY);
//            }
//            if (resultCode == RESULT_CANCELED) {
//
//                nineAm.setText("Nothing is selected");
//            }
//        }
//
//        if (requestCode == 11) {
//            if (resultCode == RESULT_OK) {
//                String result = data.getStringExtra("result");
//                tenAm.setText(result);
//                tenAm.setBackgroundColor(Color.GRAY);
//            }
//            if (resultCode == RESULT_CANCELED) {
//
//                tenAm.setText("Nothing is selected");
//            }
//        }
//
//        if (requestCode == 12) {
//            if (resultCode == RESULT_OK) {
//                String result = data.getStringExtra("result");
//                elevenAm.setText(result);
//                elevenAm.setBackgroundColor(Color.GRAY);
//            }
//            if (resultCode == RESULT_CANCELED) {
//
//                elevenAm.setText("Nothing is selected");
//            }
//        }
//
//        if (requestCode == 13) {
//            if (resultCode == RESULT_OK) {
//                String result = data.getStringExtra("result");
//                twelvePm.setText(result);
//                twelvePm.setBackgroundColor(Color.GRAY);
//            }
//            if (resultCode == RESULT_CANCELED) {
//
//                twelvePm.setText("Nothing is selected");
//            }
//        }
//
//        if (requestCode == 14) {
//            if (resultCode == RESULT_OK) {
//                String result = data.getStringExtra("result");
//                onePm.setText(result);
//                onePm.setBackgroundColor(Color.GRAY);
//            }
//            if (resultCode == RESULT_CANCELED) {
//
//                onePm.setText("Nothing is selected");
//            }
//        }
//
//        if (requestCode == 15) {
//            if (resultCode == RESULT_OK) {
//                String result = data.getStringExtra("result");
//                twoPm.setText(result);
//                twoPm.setBackgroundColor(Color.GRAY);
//            }
//            if (resultCode == RESULT_CANCELED) {
//
//                twoPm.setText("Nothing is selected");
//            }
//        }
//
//        if (requestCode == 16) {
//            if (resultCode == RESULT_OK) {
//                String result = data.getStringExtra("result");
//                threePm.setText(result);
//                threePm.setBackgroundColor(Color.GRAY);
//            }
//            if (resultCode == RESULT_CANCELED) {
//
//                threePm.setText("Nothing is selected");
//            }
//        }
//
//        if (requestCode == 17) {
//            if (resultCode == RESULT_OK) {
//                String result = data.getStringExtra("result");
//                fourPm.setText(result);
//                fourPm.setBackgroundColor(Color.GRAY);
//            }
//            if (resultCode == RESULT_CANCELED) {
//
//                fourPm.setText("Nothing is selected");
//            }
//        }
//
//        if (requestCode == 18) {
//            if (resultCode == RESULT_OK) {
//                String result = data.getStringExtra("result");
//                fivePm.setText(result);
//                fivePm.setBackgroundColor(Color.GRAY);
//            }
//            if (resultCode == RESULT_CANCELED) {
//
//                fivePm.setText("Nothing is selected");
//            }
//        }
//        if (requestCode == 19) {
//            if (resultCode == RESULT_OK) {
//                String result = data.getStringExtra("result");
//                sixPm.setText(result);
//                sixPm.setBackgroundColor(Color.GRAY);
//            }
//            if (resultCode == RESULT_CANCELED) {
//
//                sixPm.setText("Nothing is selected");
//            }
//        }
//
//        if (requestCode == 20) {
//            if (resultCode == RESULT_OK) {
//                String result = data.getStringExtra("result");
//                sevenPm.setText(result);
//                sevenPm.setBackgroundColor(Color.GRAY);
//            }
//            if (resultCode == RESULT_CANCELED) {
//
//                sevenPm.setText("Nothing is selected");
//            }
//        }
//
//        if (requestCode == 21) {
//            if (resultCode == RESULT_OK) {
//                String result = data.getStringExtra("result");
//                eightPm.setText(result);
//                eightPm.setBackgroundColor(Color.GRAY);
//            }
//            if (resultCode == RESULT_CANCELED) {
//
//                eightPm.setText("Nothing is selected");
//            }
//        }
//
//        if (requestCode == 22) {
//            if (resultCode == RESULT_OK) {
//                String result = data.getStringExtra("result");
//                ninePm.setText(result);
//                ninePm.setBackgroundColor(Color.GRAY);
//            }
//            if (resultCode == RESULT_CANCELED) {
//
//                ninePm.setText("Nothing is selected");
//            }
//        }
//
//        if (requestCode == 23) {
//            if (resultCode == RESULT_OK) {
//                String result = data.getStringExtra("result");
//                tenPm.setText(result);
//                tenPm.setBackgroundColor(Color.GRAY);
//            }
//            if (resultCode == RESULT_CANCELED) {
//
//                tenPm.setText("Nothing is selected");
//            }
//        }
//
//        if (requestCode == 24) {
//            if (resultCode == RESULT_OK) {
//                String result = data.getStringExtra("result");
//                elevenPm.setText(result);
//                elevenPm.setBackgroundColor(Color.GRAY);
//            }
//            if (resultCode == RESULT_CANCELED) {
//
//                elevenPm.setText("Nothing is selected");
//            }
//        }
//    }
}
