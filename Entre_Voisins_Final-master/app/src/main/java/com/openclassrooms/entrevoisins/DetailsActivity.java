package com.openclassrooms.entrevoisins;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.ArrayList;
import java.util.List;

public class DetailsActivity extends AppCompatActivity {





    private ImageButton mReturnButton;
    private FloatingActionButton mFavoriteButton;
    private ImageView mProfilePic;
    private TextView mName;
    private TextView mLocation;
    private TextView mFacebookAccount;
    private TextView mPhoneNumber;
    private TextView mAproposDeMoi;
    private TextView mDescription;

    private String neighbourName;
    private String neighbourAvatar;
    private Integer neighbourId;
    private String neibourFacebookAccount;
    private String neighbourLocation;
    private String neighbourDescription;
    private String neighbourPhoneNumber;











    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);




        mReturnButton = findViewById(R.id.ReturnImageButton);
        mFavoriteButton = findViewById(R.id.favoriteButton);
        mProfilePic = findViewById(R.id.profilImageView);
        mName = findViewById(R.id.Name_txt);
        mLocation = findViewById(R.id.Location_txt);
        mFacebookAccount = findViewById(R.id.facebook_txt);
        mPhoneNumber = findViewById(R.id.phone_txt);
        mAproposDeMoi = findViewById(R.id.Apropos_txt);
        mDescription = findViewById(R.id.description_txt);



         neighbourName= getIntent().getStringExtra("name");
         neighbourAvatar= getIntent().getStringExtra("avatar");
         neighbourId = getIntent().getIntExtra("Id", 0);
         neibourFacebookAccount= getIntent().getStringExtra("facebookAccount");
         neighbourLocation= getIntent().getStringExtra("Location");
         neighbourDescription= getIntent().getStringExtra("Description");
         neighbourPhoneNumber= getIntent().getStringExtra("PhoneNumber");

         Neighbour newNeighbour = new Neighbour(neighbourId, neighbourName, neighbourAvatar, neibourFacebookAccount,neighbourLocation, neighbourDescription, neighbourPhoneNumber);
        if (DI.getNeighbourApiService().getFavoriteNeighboursList().contains(newNeighbour)) {
            mFavoriteButton.setImageResource(R.drawable.favoritebutton);

        }else
            mFavoriteButton.setImageResource(R.drawable.ic_star_white_24dp);



        mName.setText(neighbourName);
        mLocation.setText(neighbourLocation);
        mDescription.setText(neighbourDescription);
        mFacebookAccount.setText(neibourFacebookAccount);
        mPhoneNumber.setText(neighbourPhoneNumber);
        Glide.with(this).load(neighbourAvatar).into(mProfilePic);







        mFavoriteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (DI.getNeighbourApiService().getFavoriteNeighboursList().contains(newNeighbour)) {
                    mFavoriteButton.setImageResource(R.drawable.ic_star_white_24dp);
                    Toast.makeText(view.getContext(), neighbourName + " " + "est supprimé(e) des favoris", Toast.LENGTH_SHORT).show();
                }else {
                    mFavoriteButton.setImageResource(R.drawable.favoritebutton);
                    Toast.makeText(view.getContext(), neighbourName + " " + "est ajouté(e) aux favoris", Toast.LENGTH_SHORT).show();
                }

                DI.getNeighbourApiService().addToNeighbourFavoriteList(neighbourId);







            }
        });

        mReturnButton.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick (View view){
                    saveFavoriteList();

                returnToMainPage();
            }

            });
    }
    public void saveFavoriteList(){
        SharedPreferences sharedPreferences = getSharedPreferences("myprefernces", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(DI.getNeighbourApiService().getFavoriteNeighboursList());
        editor.putString("favorite_list",json );
        editor.apply();
    }






            public void returnToMainPage() {
                finish();
            }







    }

