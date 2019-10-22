package aut.groupsync;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.io.Serializable;

import java.util.Calendar;
import java.util.Date;

public class TimetableView extends Fragment implements Serializable {

    // AM buttons
    Button twelveAm, oneAm, twoAm, threeAm, fourAm, fiveAm, sixAm, sevenAm, eightAm, nineAm, tenAm, elevenAm;

    // PM Buttons
    Button twelvePm, onePm, twoPm, threePm, fourPm, fivePm, sixPm, sevenPm, eightPm, ninePm, tenPm, elevenPm;

    EditText userAppointment, userNote;
    TextView currentDate;
    String appointmentName, notes, currentDateTimeString;
    Button confirmButton, deleteButton;
    View addAppointment, view;
    User currentUser = new User("Name Nameson", "E@mail.com");
    Date today;

    public static PopupWindow displayPopupWindow(View popupLayout, View onView) {
        final PopupWindow popupWindow = new PopupWindow(popupLayout, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        popupWindow.showAtLocation(onView, Gravity.TOP, 0, 0);

        return popupWindow;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.timetable_main, container, false);
//
        // Gets the current date and sets it in the app
        currentDate = (TextView) view.findViewById(R.id.cDate);
        today = Calendar.getInstance().getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        currentDateTimeString = formatter.format(today);
        currentDate.setText(currentDateTimeString);

        // find and saves in the id of the buttons in the variable
        twelveAm = (Button) view.findViewById(R.id.Time12am);
        oneAm = (Button) view.findViewById(R.id.Time1am);
        twoAm = (Button) view.findViewById(R.id.Time2am);
        threeAm = (Button) view.findViewById(R.id.Time3am);
        fourAm = (Button) view.findViewById(R.id.Time4am);
        fiveAm = (Button) view.findViewById(R.id.Time5am);
        sixAm = (Button) view.findViewById(R.id.Time6am);
        sevenAm = (Button) view.findViewById(R.id.Time7am);
        eightAm = (Button) view.findViewById(R.id.Time8am);
        nineAm = (Button) view.findViewById(R.id.Time9am);
        tenAm = (Button) view.findViewById(R.id.Time10am);
        elevenAm = (Button) view.findViewById(R.id.Time11am);
        twelvePm = (Button) view.findViewById(R.id.Time12pm);
        onePm = (Button) view.findViewById(R.id.Time1pm);
        twoPm = (Button) view.findViewById(R.id.Time2pm);
        threePm = (Button) view.findViewById(R.id.Time3pm);
        fourPm = (Button) view.findViewById(R.id.Time4pm);
        fivePm = (Button) view.findViewById(R.id.Time5pm);
        sixPm = (Button) view.findViewById(R.id.Time6pm);
        sevenPm = (Button) view.findViewById(R.id.Time7pm);
        eightPm = (Button) view.findViewById(R.id.Time8pm);
        ninePm = (Button) view.findViewById(R.id.Time9pm);
        tenPm = (Button) view.findViewById(R.id.Time10pm);
        elevenPm = (Button) view.findViewById(R.id.Time11pm);
        twelvePm = (Button) view.findViewById(R.id.Time12pm);



        twelveAm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addAppointment = inflater.inflate(R.layout.appointment_popup, null);

                // calls the appointmentButton
                appointmentButton(twelveAm);
            }
        });

        oneAm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addAppointment = inflater.inflate(R.layout.appointment_popup, null);

                // calls the appointment Button
                appointmentButton(oneAm);
            }
        });

        twoAm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addAppointment = inflater.inflate(R.layout.appointment_popup, null);

                // calls the appointment Button
                appointmentButton(twoAm);
            }
        });

        threeAm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addAppointment = inflater.inflate(R.layout.appointment_popup, null);

                // calls the appointment Button
                appointmentButton(threeAm);
            }
        });

        fourAm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addAppointment = inflater.inflate(R.layout.appointment_popup, null);

                // calls the appointment Button
                appointmentButton(fourAm);
            }
        });

        fiveAm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addAppointment = inflater.inflate(R.layout.appointment_popup, null);

                // calls the appointment Button
                appointmentButton(fiveAm);
            }
        });

        sixAm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addAppointment = inflater.inflate(R.layout.appointment_popup, null);

                // calls the appointment Button
                appointmentButton(sixAm);
            }
        });

        sevenAm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addAppointment = inflater.inflate(R.layout.appointment_popup, null);

                // calls the appointment Button
                appointmentButton(sevenAm);
            }
        });

        eightAm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addAppointment = inflater.inflate(R.layout.appointment_popup, null);

                // calls the appointment Button
                appointmentButton(eightAm);
            }
        });

        nineAm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addAppointment = inflater.inflate(R.layout.appointment_popup, null);

                // calls the appointment Button
                appointmentButton(nineAm);
            }
        });

        tenAm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addAppointment = inflater.inflate(R.layout.appointment_popup, null);

                // calls the appointment Button
                appointmentButton(tenAm);
            }
        });

        elevenAm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addAppointment = inflater.inflate(R.layout.appointment_popup, null);

                // calls the appointment Button
                appointmentButton(elevenPm);
            }
        });

        twelvePm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addAppointment = inflater.inflate(R.layout.appointment_popup, null);

                // calls the appointment Button
                appointmentButton(twelvePm);
            }
        });

        onePm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addAppointment = inflater.inflate(R.layout.appointment_popup, null);

                // calls the appointment Button
                appointmentButton(onePm);
            }
        });

        twoPm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addAppointment = inflater.inflate(R.layout.appointment_popup, null);

                // calls the appointment Button
                appointmentButton(twoPm);
            }
        });

        threePm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addAppointment = inflater.inflate(R.layout.appointment_popup, null);

                // calls the appointment Button
                appointmentButton(threePm);
            }
        });

        fourPm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addAppointment = inflater.inflate(R.layout.appointment_popup, null);

                // calls the appointment Button
                appointmentButton(fourPm);
            }
        });

        fivePm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addAppointment = inflater.inflate(R.layout.appointment_popup, null);

                // calls the appointment Button
                appointmentButton(fivePm);
            }
        });

        sixPm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addAppointment = inflater.inflate(R.layout.appointment_popup, null);

                // calls the appointment Button
                appointmentButton(sixPm);
            }
        });

        sevenPm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addAppointment = inflater.inflate(R.layout.appointment_popup, null);

                // calls the appointment Button
                appointmentButton(sevenPm);
            }
        });

        eightPm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addAppointment = inflater.inflate(R.layout.appointment_popup, null);

                // calls the appointment Button
                appointmentButton(eightPm);
            }
        });

        ninePm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addAppointment = inflater.inflate(R.layout.appointment_popup, null);

                // calls the appointment Button
                appointmentButton(ninePm);
            }
        });

        tenPm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addAppointment = inflater.inflate(R.layout.appointment_popup, null);

                // calls the appointment Button
                appointmentButton(tenPm);
            }
        });

        elevenPm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addAppointment = inflater.inflate(R.layout.appointment_popup, null);

                // calls the appointment Button
                appointmentButton(elevenPm);
            }
        });

        twelvePm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addAppointment = inflater.inflate(R.layout.appointment_popup, null);

                // calls the appointment Button
                appointmentButton(twelvePm);
            }
        });

        return view;
    }

    public void appointmentButton(final Button clickedButton) {
        // saves in the users clicked button
        final Button clicked = clickedButton;

        // finds and saves the id of the buttons to a variable
        confirmButton = addAppointment.findViewById(R.id.confirmButton);
        deleteButton = addAppointment.findViewById(R.id.deleteButton);

        // creates a pop up view and calls the appointment_pop.xml
        final PopupWindow createAppointment = displayPopupWindow(addAppointment, view);
        createAppointment.setFocusable(true);
        createAppointment.update();

        // confirms the user appointment and saves in ui (for now)
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vi) {
                userAppointment = createAppointment.getContentView().findViewById(R.id.appointmentText);
                appointmentName = cleanInput(userAppointment.getText().toString());

                userNote = createAppointment.getContentView().findViewById(R.id.notes);
                notes = cleanInput(userNote.getText().toString());
                Note uNote = new Note(notes);
                //gets the alarm value (Hopefully)
                Switch hasAlarm = createAppointment.getContentView().findViewById(R.id.Alarm);
                Boolean alarmState = hasAlarm.isChecked();

                // WIP?: save in data to timetable class
                Appointment appointment = new Appointment(today, uNote, alarmState, appointmentName, true);
                currentUser.getTimetable().getCurrentDay().addAppointment(appointment);

                // Just saving this to ui not to the timetable yet
                clicked.setText(appointmentName);
                createAppointment.dismiss();
            }
        });

        // deletes the user appointment and replaces the text of the button to just a space
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View viee) {
                clicked.setText(" ");
                createAppointment.dismiss();
                //currentUser.getTimetable().getCurrentDay().removeAppointment(/*FORMAT INTO TIME SOMEHOW today.toString()*/);
            }
        });
    }

    //remove characters used in code to try and prevent injections
    public String cleanInput(String input) {
        String output = input;
        boolean contains = (input.contains("<") || input.contains(">") || input.contains("{") || input.contains("}"));
        if (contains) {
            output = "";
            for (char c : input.toCharArray()) {
                if (c == '<' || c == '>' || c == '{' || c == '}') {/*DO NOT ADD TO OUTPUT*/}
                else {
                    output += c;
                }
            }
        }
        return output;
    }
}