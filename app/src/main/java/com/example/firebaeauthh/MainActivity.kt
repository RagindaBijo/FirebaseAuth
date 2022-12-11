package com.example.firebaeauthh

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()


        button.setOnClickListener {

            val email=editTextEmailAddress.text.toString()
            val password=editTextPassword.text.toString()

            if (email.isEmpty()||password.isEmpty()){
                Toast.makeText(this,"Empty!",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }


            FirebaseAuth.getInstance()
                .createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener {task->
                    if (task.isSuccessful){
                        Toast.makeText(this,"მომხმარებელი წარმატებით შეიქმნა",Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(this,"Error!",Toast.LENGTH_SHORT).show()

                    }

                }




        }






    }
}