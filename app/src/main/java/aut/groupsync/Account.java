package aut.groupsync;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class Account extends Fragment {
    private String username;
	private String email;
	private Timetable timetable;
	private List<Group> groups = new ArrayList<Group>();

/*    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.account_details, container, false);
    }*/
    
    public Account(String username, String email) {
		this.username = username;
		this.email = email;
	}

	public Timetable getTimetable() {
		return this.timetable;
	}

	public void setTimetable(Timetable timetable) {
		this.timetable = timetable;
	}

	public List<Group> getGroups() {
		return this.groups;
	}
}

