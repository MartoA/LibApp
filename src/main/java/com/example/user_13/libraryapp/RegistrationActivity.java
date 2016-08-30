package com.example.user_13.libraryapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrationActivity extends AppCompatActivity {

    private static EditText username;
    private static EditText pass1;
    private static EditText pass2;
    private static EditText email;
    private static EditText name;
    private static Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        Intent toRegister = getIntent();

        username = (EditText) findViewById(R.id.usernameET);
        pass1 = (EditText) findViewById(R.id.passwordET1);
        pass2 = (EditText) findViewById(R.id.passwordET2);
        email = (EditText) findViewById(R.id.emailET);
        name = (EditText) findViewById(R.id.nameET);
        register = (Button) findViewById(R.id.registrationButton);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uName = username.getText().toString();
                String password1 = pass1.getText().toString();
                String password2 = pass2.getText().toString();
                String mail = email.getText().toString();
                String nameOfUser = name.getText().toString();

                if(validateRegistration(uName, password1, password2, mail, nameOfUser)){
                    User user = new User(uName, nameOfUser, password1, mail);
                    UsersContainer.getInstance().addUser(user);
                    Intent intent = new Intent(RegistrationActivity.this, SignupActivity.class);
                    startActivity(intent);
                }

            }
        });

    }

    public boolean validateRegistration(String username, String password1, String password2, String email, String name){
        if(username==null||username.isEmpty()||UsersContainer.getInstance().contains(username)){
            RegistrationActivity.username.setError("User already exists");
            return false;
        }
        else{
            if(password1==null||password2==null||password1.isEmpty()||password2.isEmpty()){
                if(password1.equals(password2)) {
                    RegistrationActivity.pass1.setError("Passwords does not match");
                    RegistrationActivity.pass2.setError("Passwords does not match");
                    return false;
                }
                else{
                    Toast.makeText(RegistrationActivity.this, "Invalid password please try again", Toast.LENGTH_SHORT).show();
                    RegistrationActivity.pass1.setText("");
                    RegistrationActivity.pass2.setText("");
                    return false;
                }
            }
            if(email==null||email.isEmpty()||!(android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches())){
                if(UsersContainer.getInstance().containsMail(email)){
                    Toast.makeText(RegistrationActivity.this, "User with this email already exists", Toast.LENGTH_SHORT).show();
                    return false;
                }
                else{
                    RegistrationActivity.email.setError("Invalid email");
                    RegistrationActivity.email.setText("");
                    return false;
                }

            }
            if(name==null||name.isEmpty()){
                RegistrationActivity.name.setError("Please enter yout name");
                return false;
            }
        }

        return true;
    }
}
