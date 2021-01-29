package com.example.fabcaredrycleaners;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class PlaceOrderCard extends AppCompatActivity {


    TextView numberofitemstv;

    ImageView plus_shirt_1, plus_shirt_2, plus_shirt_3, plus_tshirt_1, plus_tshirt_2, plus_tshirt_3, plus_trousers_1, plus_trousers_2, plus_trousers_3, plus_jeans_1, plus_jeans_2, plus_jeans_3
            , plus_suit_1, plus_suit_2, plus_suit_3, plus_saree_1, plus_saree_2, plus_saree_3;

    ImageView minus_shirt_1, minus_shirt_2, minus_shirt_3, minus_tshirt_1, minus_tshirt_2, minus_tshirt_3, minus_trousers_1, minus_trousers_2, minus_trousers_3, minus_jeans_1, minus_jeans_2, minus_jeans_3
            , minus_suit_1, minus_suit_2, minus_suit_3, minus_saree_1, minus_saree_2, minus_saree_3;

    TextView number_shirt_1, number_shirt_2, number_shirt_3, number_tshirt_1, number_tshirt_2, number_tshirt_3, number_trousers_1, number_trousers_2, number_trousers_3, number_jeans_1, number_jeans_2, number_jeans_3
            , number_suit_1, number_suit_2, number_suit_3, number_saree_1, number_saree_2, number_saree_3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_order_card);

        plus_shirt_1 = findViewById(R.id.image_plus_shirt_1);
        plus_shirt_2 = findViewById(R.id.image_plus_shirt_2);
        plus_shirt_3 = findViewById(R.id.image_plus_shirt_3);
        plus_tshirt_1 = findViewById(R.id.image_plus_tshirt_1);
        plus_tshirt_2 = findViewById(R.id.image_plus_tshirt_2);
        plus_tshirt_3 = findViewById(R.id.image_plus_tshirt_3);
        plus_trousers_1 = findViewById(R.id.image_plus_trousers_1);
        plus_trousers_2 = findViewById(R.id.image_plus_trousers_2);
        plus_trousers_3 = findViewById(R.id.image_plus_trousers_3);
        plus_jeans_1 = findViewById(R.id.image_plus_denimjeans_1);
        plus_jeans_2 = findViewById(R.id.image_plus_denimjeans_2);
        plus_jeans_3 = findViewById(R.id.image_plus_denimjeans_3);
        plus_suit_1 = findViewById(R.id.image_plus_formalsuit_1);
        plus_suit_2 = findViewById(R.id.image_plus_formalsuit_2);
        plus_suit_3 = findViewById(R.id.image_plus_formalsuit_3);
        plus_saree_1 = findViewById(R.id.image_plus_saree_1);
        plus_saree_2 = findViewById(R.id.image_plus_saree_2);
        plus_saree_3 = findViewById(R.id.image_plus_saree_3);

        minus_shirt_1 = findViewById(R.id.image_minus_shirt_1);
        minus_shirt_2 = findViewById(R.id.image_minus_shirt_2);
        minus_shirt_3 = findViewById(R.id.image_minus_shirt_3);
        minus_tshirt_1 = findViewById(R.id.image_minus_tshirt_1);
        minus_tshirt_2 = findViewById(R.id.image_minus_tshirt_2);
        minus_tshirt_3 = findViewById(R.id.image_minus_tshirt_3);
        minus_trousers_1 = findViewById(R.id.image_minus_trousers_1);
        minus_trousers_2 = findViewById(R.id.image_minus_trousers_2);
        minus_trousers_3 = findViewById(R.id.image_minus_trousers_3);
        minus_jeans_1 = findViewById(R.id.image_minus_denimjeans_1);
        minus_jeans_2 = findViewById(R.id.image_minus_denimjeans_2);
        minus_jeans_3 = findViewById(R.id.image_minus_denimjeans_3);
        minus_suit_1 = findViewById(R.id.image_minus_formalsuit_1);
        minus_suit_2 = findViewById(R.id.image_minus_formalsuit_2);
        minus_suit_3 = findViewById(R.id.image_minus_formalsuit_3);
        minus_saree_1 = findViewById(R.id.image_minus_saree_1);
        minus_saree_2 = findViewById(R.id.image_minus_saree_2);
        minus_saree_3 = findViewById(R.id.image_minus_saree_3);

        number_shirt_1 = findViewById(R.id.number_shirt_1);
        number_shirt_2 = findViewById(R.id.number_shirt_2);
        number_shirt_3 = findViewById(R.id.number_shirt_3);
        number_tshirt_1 = findViewById(R.id.number_tshirt_1);
        number_tshirt_2 = findViewById(R.id.number_tshirt_2);
        number_tshirt_3 = findViewById(R.id.number_tshirt_3);
        number_trousers_1 = findViewById(R.id.number_trousers_1);
        number_trousers_2 = findViewById(R.id.number_trousers_2);
        number_trousers_3 = findViewById(R.id.number_trousers_3);
        number_jeans_1 = findViewById(R.id.number_denimjeans_1);
        number_jeans_2 = findViewById(R.id.number_denimjeans_2);
        number_jeans_3 = findViewById(R.id.number_denimjeans_3);
        number_suit_1 = findViewById(R.id.number_formalsuit_1);
        number_suit_2 = findViewById(R.id.number_formalsuit_2);
        number_suit_3 = findViewById(R.id.number_formalsuit_3);
        number_saree_1 = findViewById(R.id.number_saree_1);
        number_saree_2 = findViewById(R.id.number_saree_2);
        number_saree_3 = findViewById(R.id.number_saree_3);

        numberofitemstv = findViewById(R.id.numberofitems);

        //trying with function to update the number of items

        updatenumberofitems();





        //DIMAG KHARAB HO GAYA MERA ISTG

//        minus_shirt_1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                int numberinshirtminus = Integer.valueOf(number_shirt_1.getText().toString());
//                if(numberinshirtminus>0){
//                    numberinshirtminus--;
//                }
//                String numberinshirtstrminus = String.valueOf(numberinshirtminus);
//                number_shirt_1.setText(numberinshirtstrminus);
//            }
//        });
//
//        plus_shirt_1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                int numberinshirtplus = Integer.valueOf(number_shirt_1.getText().toString());
//                numberinshirtplus++;
//                String numberinshirtstrplus = String.valueOf(numberinshirtplus);
//                number_shirt_1.setText(numberinshirtstrplus);
//            }
//        });
//



//        int intshirt1 = Integer.valueOf(number_shirt_1.getText().toString());
//        int intshirt2 = Integer.valueOf(number_shirt_2.getText().toString());
//        int intshirt3 = Integer.valueOf(number_shirt_3.getText().toString());
//        int inttshirt1 = Integer.valueOf(number_tshirt_1.getText().toString());
//        int inttshirt2 = Integer.valueOf(number_tshirt_2.getText().toString());
//        int inttshirt3 = Integer.valueOf(number_tshirt_3.getText().toString());
//        int inttrousers1 = Integer.valueOf(number_trousers_1.getText().toString());
//        int inttrousers2 = Integer.valueOf(number_trousers_2.getText().toString());
//        int inttrousers3 = Integer.valueOf(number_trousers_3.getText().toString());
//        int intjeans1 = Integer.valueOf(number_jeans_1.getText().toString());
//        int intjeans2 = Integer.valueOf(number_jeans_2.getText().toString());
//        int intjeans3 = Integer.valueOf(number_jeans_3.getText().toString());
//        int intsuit1 = Integer.valueOf(number_suit_1.getText().toString());
//        int intsuit2 = Integer.valueOf(number_suit_2.getText().toString());
//        int intsuit3 = Integer.valueOf(number_suit_3.getText().toString());
//        int intsaree1 = Integer.valueOf(number_saree_1.getText().toString());
//        int intsaree2 = Integer.valueOf(number_saree_2.getText().toString());
//        int intsaree3 = Integer.valueOf(number_saree_3.getText().toString());

//        int numberofitemstotal = intshirt1
//                + intshirt2 + intshirt3 + inttshirt1 + inttshirt2 + inttshirt3 + inttrousers1 + inttrousers2 + inttrousers3
//                + intjeans1 + intjeans2 + intjeans3 + intsuit1 + intsuit2 + intsuit3 + intsaree1 + intsaree2 + intsaree3;
//
//        String numberofitemsstr = String.valueOf(numberofitemstotal);
        //numberofitemstv.setText(numberofitemsstr);




    }


    //PLUS MINUS FUNCTIONS FOR DRYCLEAN

    public void MinusShirt1(View view) {
        int numberinshirtminus = Integer.valueOf(number_shirt_1.getText().toString());
        if(numberinshirtminus>0){
            numberinshirtminus--;

        }
        String numberinshirtstrminus = String.valueOf(numberinshirtminus);
        number_shirt_1.setText(numberinshirtstrminus);
    }

    public void PlusShirt1(View view) {
        int numberinshirtplus = Integer.valueOf(number_shirt_1.getText().toString());
        numberinshirtplus++;

        String numberinshirtstrplus = String.valueOf(numberinshirtplus);
        number_shirt_1.setText(numberinshirtstrplus);
    }

    public void MinusTshirt1(View view) {
        int numberintshirtminus = Integer.valueOf(number_tshirt_1.getText().toString());
        if(numberintshirtminus>0){
            numberintshirtminus--;

        }
        String numberintshirtstrminus = String.valueOf(numberintshirtminus);
        number_tshirt_1.setText(numberintshirtstrminus);
    }

    public void PlusTshirt1(View view) {
        int numberintshirtplus = Integer.valueOf(number_tshirt_1.getText().toString());
        numberintshirtplus++;

        String numberintshirtstrplus = String.valueOf(numberintshirtplus);
        number_tshirt_1.setText(numberintshirtstrplus);
    }

    public void MinusTrousers1(View view) {
        int numberintrousersminus = Integer.valueOf(number_trousers_1.getText().toString());
        if(numberintrousersminus>0){
            numberintrousersminus--;

        }
        String numberintrouserstrminus = String.valueOf(numberintrousersminus);
        number_trousers_1.setText(numberintrouserstrminus);
    }

    public void PlusTrousers1(View view) {
        int numberintrousersplus = Integer.valueOf(number_trousers_1.getText().toString());
        numberintrousersplus++;

        String numberintrousersstrplus = String.valueOf(numberintrousersplus);
        number_trousers_1.setText(numberintrousersstrplus);
    }

    public void MinusJeans1(View view) {
        int numberinjeansminus = Integer.valueOf(number_jeans_1.getText().toString());
        if(numberinjeansminus>0){
            numberinjeansminus--;

        }
        String numberinjeanstrminus = String.valueOf(numberinjeansminus);
        number_jeans_1.setText(numberinjeanstrminus);
    }

    public void PlusJeans1(View view) {
        int numberinjeansplus = Integer.valueOf(number_jeans_1.getText().toString());
        numberinjeansplus++;

        String numberinjeansstrplus = String.valueOf(numberinjeansplus);
        number_jeans_1.setText(numberinjeansstrplus);
    }

    public void MinusSuit1(View view) {
        int numberinsuitminus = Integer.valueOf(number_suit_1.getText().toString());
        if(numberinsuitminus>0){
            numberinsuitminus--;

        }
        String numberinsuittrminus = String.valueOf(numberinsuitminus);
        number_suit_1.setText(numberinsuittrminus);
    }

    public void PlusSuit1(View view) {
        int numberinsuitplus = Integer.valueOf(number_suit_1.getText().toString());
        numberinsuitplus++;

        String numberinsuitstrplus = String.valueOf(numberinsuitplus);
        number_suit_1.setText(numberinsuitstrplus);
    }

    public void MinusSaree1(View view) {
        int numberinsareeminus = Integer.valueOf(number_saree_1.getText().toString());
        if(numberinsareeminus>0){
            numberinsareeminus--;

        }
        String numberinsareestrminus = String.valueOf(numberinsareeminus);
        number_saree_1.setText(numberinsareestrminus);
    }

    public void PlusSaree1(View view) {
        int numberinsareeplus = Integer.valueOf(number_saree_1.getText().toString());
        numberinsareeplus++;

        String numberinsareestrplus = String.valueOf(numberinsareeplus);
        number_saree_1.setText(numberinsareestrplus);
    }


    //PLUS MINUS FUNCTIONS FOR STEAM IRON

    public void MinusShirt2(View view) {
        int numberinshirtminus = Integer.valueOf(number_shirt_2.getText().toString());
        if(numberinshirtminus>0){
            numberinshirtminus--;

        }
        String numberinshirtstrminus = String.valueOf(numberinshirtminus);
        number_shirt_2.setText(numberinshirtstrminus);
    }

    public void PlusShirt2(View view) {
        int numberinshirtplus = Integer.valueOf(number_shirt_2.getText().toString());
        numberinshirtplus++;

        String numberinshirtstrplus = String.valueOf(numberinshirtplus);
        number_shirt_2.setText(numberinshirtstrplus);
    }

    public void MinusTshirt2(View view) {
        int numberintshirtminus = Integer.valueOf(number_tshirt_2.getText().toString());
        if(numberintshirtminus>0){
            numberintshirtminus--;

        }
        String numberintshirtstrminus = String.valueOf(numberintshirtminus);
        number_tshirt_2.setText(numberintshirtstrminus);
    }

    public void PlusTshirt2(View view) {
        int numberintshirtplus = Integer.valueOf(number_tshirt_2.getText().toString());
        numberintshirtplus++;

        String numberintshirtstrplus = String.valueOf(numberintshirtplus);
        number_tshirt_2.setText(numberintshirtstrplus);
    }

    public void MinusTrousers2(View view) {
        int numberintrousersminus = Integer.valueOf(number_trousers_2.getText().toString());
        if(numberintrousersminus>0){
            numberintrousersminus--;

        }
        String numberintrouserstrminus = String.valueOf(numberintrousersminus);
        number_trousers_2.setText(numberintrouserstrminus);
    }

    public void PlusTrousers2(View view) {
        int numberintrousersplus = Integer.valueOf(number_trousers_2.getText().toString());
        numberintrousersplus++;

        String numberintrousersstrplus = String.valueOf(numberintrousersplus);
        number_trousers_2.setText(numberintrousersstrplus);
    }

    public void MinusJeans2(View view) {
        int numberinjeansminus = Integer.valueOf(number_jeans_2.getText().toString());
        if(numberinjeansminus>0){
            numberinjeansminus--;

        }
        String numberinjeanstrminus = String.valueOf(numberinjeansminus);
        number_jeans_2.setText(numberinjeanstrminus);
    }

    public void PlusJeans2(View view) {
        int numberinjeansplus = Integer.valueOf(number_jeans_2.getText().toString());
        numberinjeansplus++;

        String numberinjeansstrplus = String.valueOf(numberinjeansplus);
        number_jeans_2.setText(numberinjeansstrplus);
    }

    public void MinusSuit2(View view) {
        int numberinsuitminus = Integer.valueOf(number_suit_2.getText().toString());
        if(numberinsuitminus>0){
            numberinsuitminus--;

        }
        String numberinsuittrminus = String.valueOf(numberinsuitminus);
        number_suit_2.setText(numberinsuittrminus);
    }

    public void PlusSuit2(View view) {
        int numberinsuitplus = Integer.valueOf(number_suit_2.getText().toString());
        numberinsuitplus++;

        String numberinsuitstrplus = String.valueOf(numberinsuitplus);
        number_suit_2.setText(numberinsuitstrplus);
    }

    public void MinusSaree2(View view) {
        int numberinsareeminus = Integer.valueOf(number_saree_2.getText().toString());
        if(numberinsareeminus>0){
            numberinsareeminus--;

        }
        String numberinsareestrminus = String.valueOf(numberinsareeminus);
        number_saree_2.setText(numberinsareestrminus);
    }

    public void PlusSaree2(View view) {
        int numberinsareeplus = Integer.valueOf(number_saree_2.getText().toString());
        numberinsareeplus++;

        String numberinsareestrplus = String.valueOf(numberinsareeplus);
        number_saree_2.setText(numberinsareestrplus);
    }

    //PLUS MINUS FUNCTIONS FOR STARCH POLISH

    public void MinusShirt3(View view) {
        int numberinshirtminus = Integer.valueOf(number_shirt_3.getText().toString());
        if(numberinshirtminus>0){
            numberinshirtminus--;

        }
        String numberinshirtstrminus = String.valueOf(numberinshirtminus);
        number_shirt_3.setText(numberinshirtstrminus);
    }

    public void PlusShirt3(View view) {
        int numberinshirtplus = Integer.valueOf(number_shirt_3.getText().toString());
        numberinshirtplus++;

        String numberinshirtstrplus = String.valueOf(numberinshirtplus);
        number_shirt_3.setText(numberinshirtstrplus);
    }

    public void MinusTshirt3(View view) {
        int numberintshirtminus = Integer.valueOf(number_tshirt_3.getText().toString());
        if(numberintshirtminus>0){
            numberintshirtminus--;

        }
        String numberintshirtstrminus = String.valueOf(numberintshirtminus);
        number_tshirt_3.setText(numberintshirtstrminus);
    }

    public void PlusTshirt3(View view) {
        int numberintshirtplus = Integer.valueOf(number_tshirt_3.getText().toString());
        numberintshirtplus++;

        String numberintshirtstrplus = String.valueOf(numberintshirtplus);
        number_tshirt_3.setText(numberintshirtstrplus);
    }

    public void MinusTrousers3(View view) {
        int numberintrousersminus = Integer.valueOf(number_trousers_3.getText().toString());
        if(numberintrousersminus>0){
            numberintrousersminus--;

        }
        String numberintrouserstrminus = String.valueOf(numberintrousersminus);
        number_trousers_3.setText(numberintrouserstrminus);
    }

    public void PlusTrousers3(View view) {
        int numberintrousersplus = Integer.valueOf(number_trousers_3.getText().toString());
        numberintrousersplus++;

        String numberintrousersstrplus = String.valueOf(numberintrousersplus);
        number_trousers_3.setText(numberintrousersstrplus);
    }

    public void MinusJeans3(View view) {
        int numberinjeansminus = Integer.valueOf(number_jeans_3.getText().toString());
        if(numberinjeansminus>0){
            numberinjeansminus--;

        }
        String numberinjeanstrminus = String.valueOf(numberinjeansminus);
        number_jeans_3.setText(numberinjeanstrminus);
    }

    public void PlusJeans3(View view) {
        int numberinjeansplus = Integer.valueOf(number_jeans_3.getText().toString());
        numberinjeansplus++;

        String numberinjeansstrplus = String.valueOf(numberinjeansplus);
        number_jeans_3.setText(numberinjeansstrplus);
    }

    public void MinusSuit3(View view) {
        int numberinsuitminus = Integer.valueOf(number_suit_3.getText().toString());
        if(numberinsuitminus>0){
            numberinsuitminus--;

        }
        String numberinsuittrminus = String.valueOf(numberinsuitminus);
        number_suit_3.setText(numberinsuittrminus);
    }

    public void PlusSuit3(View view) {
        int numberinsuitplus = Integer.valueOf(number_suit_3.getText().toString());
        numberinsuitplus++;

        String numberinsuitstrplus = String.valueOf(numberinsuitplus);
        number_suit_3.setText(numberinsuitstrplus);
    }

    public void MinusSaree3(View view) {
        int numberinsareeminus = Integer.valueOf(number_saree_3.getText().toString());
        if(numberinsareeminus>0){
            numberinsareeminus--;

        }
        String numberinsareestrminus = String.valueOf(numberinsareeminus);
        number_saree_3.setText(numberinsareestrminus);
    }

    public void PlusSaree3(View view) {
        int numberinsareeplus = Integer.valueOf(number_saree_3.getText().toString());
        numberinsareeplus++;

        String numberinsareestrplus = String.valueOf(numberinsareeplus);
        number_saree_3.setText(numberinsareestrplus);
    }


    private void updatenumberofitems() {
        int intshirt1 = Integer.valueOf(number_shirt_1.getText().toString());
        int intshirt2 = Integer.valueOf(number_shirt_2.getText().toString());
        int intshirt3 = Integer.valueOf(number_shirt_3.getText().toString());
        int inttshirt1 = Integer.valueOf(number_tshirt_1.getText().toString());
        int inttshirt2 = Integer.valueOf(number_tshirt_2.getText().toString());
        int inttshirt3 = Integer.valueOf(number_tshirt_3.getText().toString());
        int inttrousers1 = Integer.valueOf(number_trousers_1.getText().toString());
        int inttrousers2 = Integer.valueOf(number_trousers_2.getText().toString());
        int inttrousers3 = Integer.valueOf(number_trousers_3.getText().toString());
        int intjeans1 = Integer.valueOf(number_jeans_1.getText().toString());
        int intjeans2 = Integer.valueOf(number_jeans_2.getText().toString());
        int intjeans3 = Integer.valueOf(number_jeans_3.getText().toString());
        int intsuit1 = Integer.valueOf(number_suit_1.getText().toString());
        int intsuit2 = Integer.valueOf(number_suit_2.getText().toString());
        int intsuit3 = Integer.valueOf(number_suit_3.getText().toString());
        int intsaree1 = Integer.valueOf(number_saree_1.getText().toString());
        int intsaree2 = Integer.valueOf(number_saree_2.getText().toString());
        int intsaree3 = Integer.valueOf(number_saree_3.getText().toString());

        int numberofitemstotal = intshirt1
                + intshirt2 + intshirt3 + inttshirt1 + inttshirt2 + inttshirt3 + inttrousers1 + inttrousers2 + inttrousers3
                + intjeans1 + intjeans2 + intjeans3 + intsuit1 + intsuit2 + intsuit3 + intsaree1 + intsaree2 + intsaree3;

        String numberofitemsstr = String.valueOf(numberofitemstotal);
        numberofitemstv.setText(numberofitemsstr);

    }





}