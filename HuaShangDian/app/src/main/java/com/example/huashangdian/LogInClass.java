package com.example.huashangdian;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.huashangdian.views.DialogSignUpView;
import com.example.huashangdian.views.Users;

import java.util.ArrayList;

public class LogInClass extends AppCompatActivity implements DialogSignUpView.DialogViewSignUpListener {

//    MyCallback myCallback = null;
//
//    public LogInClass (){
//    }
//
//    public LogInClass (MyCallback callback){
//        this.myCallback = callback;
//    }
//
//    public void SetUserNameInProfile(){
//        Editable myString = email.getText();
//
//        if (myCallback!=null){
//            myCallback.updateMyText(String.valueOf(myString));
//        }
//    }

    public static ArrayList<Users> users = new ArrayList<Users>();

    public static ArrayList<Users> getUsers() {
        return users;
    }

//    public static String Loginemail = "";
      EditText email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

//      Adding default user to thesystemm to login
        Users u = new Users("Tevin","1234");
        users.add(u);

        Users u1 = new Users("","");
        users.add(u1);

        Button login = findViewById(R.id.login);
        Button signUp = findViewById(R.id.signup);
        email = findViewById(R.id.UserName);
        final EditText password = findViewById(R.id.pass);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog();
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                for (Users user: users){
//                    String pass = "1234";
//                    String user = "Tevin";

                    String givenEmail;
                    String givenPassword;
//                  Test statement to make sure elements are being added to the array
//                    System.out.println("-----------------------------------------------------"+users.toString());
//                    System.out.println("-----------------------------------------------------"+user.getPassword()+user.getUserName());

                    givenPassword = String.valueOf(password.getText());
                    givenEmail = String.valueOf(email.getText());

                    String myString = "Welcome " + givenEmail + " Enjoy your stay";

                    if (givenEmail.equals((user.getEmail())) && givenPassword.equals(user.getPassword())) {
                        //      code to open fragment
//                        FragmentManager fm = getSupportFragmentManager();
//                        DrawerLayoutClass pfrag = new DrawerLayoutClass();
//                        fm.beginTransaction().replace(R.id.container,pfrag).commit();

//                        code to go to appdrawer screen

                          OpenShop();

                        Toast.makeText(getApplicationContext(), myString, Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Invalid Credentials try again", Toast.LENGTH_LONG).show();
                    }
                }

            }
        });

    }
//    public void  openSignUp(){
//        Intent intent = new Intent(this,SignUpPage.class);
//        startActivity(intent);
//    }

    public void OpenShop(){
        Intent intent = new Intent(this, MainPageClass.class);
        String st=email.getText().toString();
        intent.putExtra("username",st);
        startActivity(intent);
        finish();
    }

    @Override
    public void SignUp (String username, String passWord){
        Users user = new Users(username,passWord);
        users.add(user);
        Toast.makeText(getApplicationContext(), "Successfully signed up enter credentials to login", Toast.LENGTH_LONG).show();
    }

    public void openDialog () {
        DialogSignUpView dialogViewSignUp = new DialogSignUpView();
        dialogViewSignUp.show(getSupportFragmentManager(), "sign up inforamtion");
    }



}
