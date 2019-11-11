package com.example.u3175008.capture_faster;

/**
 * Created by u3175008 on 1/04/2018.
 */
import java.util.Date;
class Business_Card {

        String title;
        int imageResource;
        Date date;

        public Business_Card(String title, int imageResource, Date date) {
            this.title = title;
            this.imageResource = imageResource;
            this.date = date;
        }

        public String getTitle(){
            return this.title;
        }

        public int getImageResource(){
            return this.imageResource;
        }

        public String getDateString(){
            return this.date.toString();
        }

        @Override
        public String toString(){
            return title;
        }
    }

