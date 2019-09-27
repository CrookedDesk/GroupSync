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
        Date today = Calendar.getInstance().getTime();
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

        // don't forget to change the name of these variables
//        twelveAm = (Button) view.findViewById(R.id.Time6am);
//        twelveAm = (Button) view.findViewById(R.id.Time7am);
//        twelveAm = (Button) view.findViewById(R.id.Time8am);
//        twelveAm = (Button) view.findViewById(R.id.Time9am);
//        twelveAm = (Button) view.findViewById(R.id.Time10am);
//        twelveAm = (Button) view.findViewById(R.id.Time11am);
//        twelveAm = (Button) view.findViewById(R.id.Time12pm);
//        twelveAm = (Button) view.findViewById(R.id.Time1pm);
//        twelveAm = (Button) view.findViewById(R.id.Time2pm);
//        twelveAm = (Button) view.findViewById(R.id.Time3pm);
//        twelveAm = (Button) view.findViewById(R.id.Time4pm);
//        twelveAm = (Button) view.findViewById(R.id.Time5pm);
//        twelveAm = (Button) view.findViewById(R.id.Time6pm);
//        twelveAm = (Button) view.findViewById(R.id.Time7pm);
//        twelveAm = (Button) view.findViewById(R.id.Time8pm);
//        twelveAm = (Button) view.findViewById(R.id.Time9pm);
//        twelveAm = (Button) view.findViewById(R.id.Time10pm);
//        twelveAm = (Button) view.findViewById(R.id.Time11pm);
//        twelveAm = (Button) view.findViewById(R.id.Time12pm);

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
                appointmentName = userAppointment.getText().toString();

                userNote = createAppointment.getContentView().findViewById(R.id.notes);
                notes = userNote.getText().toString();

                // gets the alarm value (Hopefully)
                Switch hasAlarm = createAppointment.getContentView().findViewById(R.id.Alarm);
                Boolean alarmState = hasAlarm.isChecked();

//                test = new User();
//                // GOAL: save in data to timetable class
//                Appointment appointment = new Appointment(currentDate, notes, alarmState, appointmentName);
//                test.getTimetable().getWeek().getDays().get(1).addAppointment(appointment);

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
            }
        });
    }
}