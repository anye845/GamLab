package com.example.gamlab;
import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;


    public class ParseApplication extends Application {
        @Override
        public void onCreate() {
            super.onCreate();

            Parse.initialize(new Parse.Configuration.Builder(this)
                    .applicationId("Jtc2Ce54LAlkj7BRtp80vVEywnMaeHpwoLSiuz8T")
                    .clientKey("qc0QlWTDT6GtELA3uZUv5sAmEKirYQdVtm1Tv7hI")
                    .server("https://parseapi.back4app.com")
                    .build());
        }
    }

