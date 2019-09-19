package aut.groupsync;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.util.ArrayList;
import java.util.List;

import aut.groupsync.data.model.UserInfo;
import aut.groupsync.services.IUserService;

public class Account extends Fragment {
    private boolean signingUp;
    private UserInfo userInfo;
    private Timetable timetable;
    private List<Group> groups = new ArrayList<Group>();
    private GoogleSignInClient googleSignInClient;
    private static final String TAG = "Account";
    private TextView profileName, profileEmail;
    private IUserService userService;
    private EditText inputPassword;
    private EditText inputEmail;
    private View userDetails;
    private View signInForm;
    private TextView signInErrorMessage;
    private EditText signUpUserDispalyName;
    private EditText signUpEmail;
    private EditText signUpPassword;
    private EditText signUpPassword2;
    private TextView signUpErrorMessage;
    private View signUpForm;


    public Account(IUserService userService) {
        this.userService = userService;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.account_details, container, false);

        SignInButton googleSignInButton = view.findViewById(R.id.google_sign_in_button);
        profileName = view.findViewById(R.id.profile_text);
        profileEmail = view.findViewById(R.id.profile_email);
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken("862018706594-m8rp1jao3qktbr940bp9c8bal13dt14g.apps.googleusercontent.com")
                .requestEmail()
                .build();

        googleSignInClient = GoogleSignIn.getClient(getActivity(), gso);

        googleSignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSignInWithGoogleButtonClick();
            }
        });

        Button signOutButton = view.findViewById(R.id.sign_out_button);
        signOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSignoutButtonOnClick();
            }
        });

        Button signInButton = view.findViewById(R.id.sign_in_button);
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSignInButtonOnClick();
            }
        });
        inputPassword = view.findViewById(R.id.input_password);
        inputEmail = view.findViewById(R.id.input_email);

        userDetails = view.findViewById(R.id.user_details);
        signInForm = view.findViewById(R.id.sign_in_form);
        signInErrorMessage = view.findViewById(R.id.sign_in_error_message);

        signUpForm = view.findViewById(R.id.sign_up_form);
        signUpUserDispalyName = view.findViewById(R.id.sign_up_display_name);
        signUpEmail = view.findViewById(R.id.sign_up_input_email);
        signUpPassword = view.findViewById(R.id.sign_up_input_password);
        signUpPassword2 = view.findViewById(R.id.sign_up_input_password2);
        signUpErrorMessage = view.findViewById(R.id.sign_up_error_message);


        Button signUpIntiateButton = view.findViewById(R.id.sign_up_initiate_button);
        signUpIntiateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSignUpIntiateButtonClick();
            }
        });
        Button signUpConfirmButton = view.findViewById(R.id.sign_up_confirm);
        signUpConfirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSignUpConfirmButtonClick();
            }
        });
        Button signUpCancelButton = view.findViewById(R.id.sign_up_cancel);
        signUpCancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSignUpCancelButtonClick();
            }
        });
        GoogleSignInAccount alreadyloggedAccount = GoogleSignIn.getLastSignedInAccount(getActivity());

        this.setUserInfoUsingGoogleSignIn(alreadyloggedAccount);

        return view;
    }

    private void onSignUpIntiateButtonClick() {
        this.signingUp = true;
        render();
    }

    private void onSignUpConfirmButtonClick() {
        String displayName = signUpUserDispalyName.getText().toString();
        String password = signUpPassword.getText().toString();
        String password2 = signUpPassword2.getText().toString();
        String email = signUpEmail.getText().toString();

        UserInfo userInfo = userService.signUp(displayName, email, password, password2);

        if (userInfo.getError() == null) {
            this.signingUp = false;
        }
        this.setUserInfo(userInfo);
    }

    private void onSignUpCancelButtonClick() {
        this.signingUp = false;
        this.setUserInfo(null);
    }

    private void onSignInButtonOnClick() {
        String password = inputPassword.getText().toString();
        String email = inputEmail.getText().toString();
        UserInfo userInfo = userService.login(email, password);
        this.setUserInfo(userInfo);
    }


    private void onSignInWithGoogleButtonClick() {
        Intent signInIntent = googleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, 101);
    }

    private void onSignoutButtonOnClick() {
        googleSignInClient.signOut().addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                onSignoutComplete();
            }
        });
    }

    private void onSignoutComplete() {
        inputEmail.setText(null);
        inputPassword.setText(null);
        this.setUserInfo(null);
    }

    private void render() {
        if (!this.signingUp) {
            signUpUserDispalyName.setText("");
            signUpPassword.setText("");
            signUpPassword2.setText("");
            signUpEmail.setText("");
            signUpErrorMessage.setText("");

        }
        String email = this.userInfo != null ? this.userInfo.getEmail() : null;
        boolean signedIn = email != null;
        String username = this.userInfo != null ? this.userInfo.getDisplayName() : null;
        profileName.setText(username);
        profileEmail.setText(email);
        String error = this.userInfo != null ? this.userInfo.getError() : null;

        if (signedIn) {
            userDetails.setVisibility(View.VISIBLE);
            signInForm.setVisibility(View.INVISIBLE);
            signUpForm.setVisibility(View.INVISIBLE);
        } else if (this.signingUp) {
            userDetails.setVisibility(View.INVISIBLE);
            signInForm.setVisibility(View.INVISIBLE);
            signUpForm.setVisibility(View.VISIBLE);

            if (error == null) {
                signUpErrorMessage.setVisibility(View.INVISIBLE);
            } else {

                signUpErrorMessage.setText(error);
                signUpErrorMessage.setVisibility(View.VISIBLE);
            }

        } else {


            if (error == null) {
                signInErrorMessage.setVisibility(View.INVISIBLE);
            } else {

                signInErrorMessage.setText(error);
                signInErrorMessage.setVisibility(View.VISIBLE);
            }

            userDetails.setVisibility(View.INVISIBLE);
            signInForm.setVisibility(View.VISIBLE);
            signUpForm.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK)
            switch (requestCode) {
                case 101:
                    try {
                        // The Task returned from this call is always completed, no need to attach
                        // a listener.
                        Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
                        GoogleSignInAccount account = task.getResult(ApiException.class);
                        this.setUserInfoUsingGoogleSignIn(account);
                    } catch (ApiException e) {
                        // The ApiException status code indicates the detailed failure reason.
                        Log.w(TAG, "signInResult:failed code=" + e.getStatusCode());
                    }
                    break;
            }
    }

    private void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
        render();
    }

    private void setUserInfoUsingGoogleSignIn(GoogleSignInAccount googleSignInAccount) {
        if (googleSignInAccount == null) {
            this.setUserInfo(null);
        } else {
            this.setUserInfo(new UserInfo(googleSignInAccount.getDisplayName(), googleSignInAccount.getEmail()));
        }
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

