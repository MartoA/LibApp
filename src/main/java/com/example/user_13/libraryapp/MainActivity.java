package com.example.user_13.libraryapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {


    private ImageView firstBookPictureImageView;
    private ImageView secondBookPictureImageView;
    private ImageView thirdBookPictureImageView;

    private TextView firstBookNameTextView;
    private TextView secondBookNameTextView;
    private TextView thirdBookNameTextView;
    private TextView firstBookCurrencyTextView;
    private TextView secondBookCurrencyTextView;
    private TextView thirdBookCurrencyTextView;
    private TextView firstBookQuantityTextView;
    private TextView secondBookQuantityTextView;
    private TextView thirdBookQuantityTextView;
    private TextView price1;
    private TextView price2;
    private TextView price3;

    private Button firstPlusButton;
    private Button secondPlusButton;
    private Button thirdPlusButton;
    private Button firstMinusButton;
    private Button secondMinusButton;
    private Button thirdMinusButton;
    private Button firstViewButton;
    private Button secondViewButton;
    private Button thirdViewButton;
    private Button firstBuyButton;
    private Button secondBuyButton;
    private Button thirdBuyButton;

    private Spinner firstSpinner;
    private Spinner secondSpinner;
    private Spinner thirdSpinner;

    private static boolean isLogged;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Book warcraft1 = new Book("Warcraft: Day of the dragon", "Richard A. Knaak", getResources().getIdentifier("com.example.user_13.libraryapp:drawable/wcb1",null, null ), 571, 30.5);
        final Book warcraft2 = new Book("Warcraft: Lord of the clans", "Christie Golden", getResources().getIdentifier("com.example.user_13.libraryapp:drawable/wcb2",null, null ), 665, 20.83);
        final Book warcraft3 = new Book("Warcraft: The last guardian", "Jeff Grubb", getResources().getIdentifier("com.example.user_13.libraryapp:drawable/wcb3",null, null ), 699, 33.09);

        Intent loggedIn = getIntent();

        isLogged = PreferenceManager.getDefaultSharedPreferences(this).getBoolean("IsLoggedIn", false);

        firstBookPictureImageView = (ImageView) findViewById(R.id.firstiv);
        firstBookPictureImageView.setImageResource(warcraft1.getPicID());
        secondBookPictureImageView = (ImageView) findViewById(R.id.secondiv);
        secondBookPictureImageView.setImageResource(warcraft2.getPicID());
        thirdBookPictureImageView = (ImageView) findViewById(R.id.thirdiv);
        thirdBookPictureImageView.setImageResource(warcraft3.getPicID());

        firstBookNameTextView = (TextView) findViewById(R.id.firstbooktv);
        firstBookNameTextView.setText(warcraft1.getTitle());
        secondBookNameTextView = (TextView) findViewById(R.id.secondbooktv);
        secondBookNameTextView.setText(warcraft2.getTitle());
        thirdBookNameTextView = (TextView) findViewById(R.id.thirdbooktv);
        thirdBookNameTextView.setText(warcraft3.getTitle());

        price1 = (TextView) findViewById(R.id.price1);
        price1.setText(Double.toString(warcraft1.getPrice()));
        price2 = (TextView) findViewById(R.id.price2);
        price2.setText(Double.toString(warcraft2.getPrice()));
        price3 = (TextView) findViewById(R.id.price3);
        price3.setText(Double.toString(warcraft3.getPrice()));

        firstBookCurrencyTextView = (TextView) findViewById(R.id.firstcurrencytv);
        secondBookCurrencyTextView = (TextView) findViewById(R.id.secondcurrencytv);
        thirdBookCurrencyTextView = (TextView) findViewById(R.id.thirdcurrencytv);
        firstBookQuantityTextView = (TextView) findViewById(R.id.firstquantitytv);
        secondBookQuantityTextView = (TextView) findViewById(R.id.secondquantitytv);
        thirdBookQuantityTextView = (TextView) findViewById(R.id.thirdquantitytv);

        firstPlusButton = (Button) findViewById(R.id.firstPlusButton);
        secondPlusButton = (Button) findViewById(R.id.secondPlusButton);
        thirdPlusButton = (Button) findViewById(R.id.thirdPlusButton);
        firstMinusButton = (Button) findViewById(R.id.firstMinusButton);
        secondMinusButton = (Button) findViewById(R.id.secondMinusButton);
        thirdMinusButton = (Button) findViewById(R.id.thirdMinusButton);

        firstViewButton = (Button) findViewById(R.id.firstViewButton);
        secondViewButton = (Button) findViewById(R.id.secondViewButton);
        thirdViewButton = (Button) findViewById(R.id.thirdViewButton);

        firstBuyButton = (Button) findViewById(R.id.firstBuyButton);
        secondBuyButton = (Button) findViewById(R.id.secondBuyButton);
        thirdBuyButton = (Button) findViewById(R.id.thirdBuyButton);

        firstSpinner = (Spinner) findViewById(R.id.firstSpinner);
        secondSpinner = (Spinner) findViewById(R.id.secondSpinner);
        thirdSpinner = (Spinner) findViewById(R.id.thirdSpinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.currency, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        firstSpinner.setAdapter(adapter);
        secondSpinner.setAdapter(adapter);
        thirdSpinner.setAdapter(adapter);

        View.OnClickListener listener =new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int itemId = v.getId();
                switch(itemId){
                    case R.id.firstPlusButton:
                        int x = Integer.parseInt(firstBookQuantityTextView.getText().toString());
                        x = x+1;
                        String xs = ""+x;
                        firstBookQuantityTextView.setText(xs);
                        break;
                    case R.id.secondPlusButton:
                        x = Integer.parseInt(secondBookQuantityTextView.getText().toString());
                        x = x+1;
                        xs = ""+x;
                        secondBookQuantityTextView.setText(xs);
                        break;
                    case R.id.thirdPlusButton:
                        x = Integer.parseInt(thirdBookQuantityTextView.getText().toString());
                        x = x+1;
                        xs = ""+x;
                        thirdBookQuantityTextView.setText(xs);
                        break;
                    case R.id.firstMinusButton:
                        x = Integer.parseInt(firstBookQuantityTextView.getText().toString());
                        if(x>0){
                            x=x-1;
                            xs = ""+x;
                            firstBookQuantityTextView.setText(xs);
                        }
                        else{
                            Toast.makeText(MainActivity.this, "You cant go under 0", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case R.id.secondMinusButton:
                        x = Integer.parseInt(secondBookQuantityTextView.getText().toString());
                        if(x>0){
                            x=x-1;
                            xs = ""+x;
                            secondBookQuantityTextView.setText(xs);
                        }
                        else{
                            Toast.makeText(MainActivity.this, "You cant go under 0", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case R.id.thirdMinusButton:
                        x = Integer.parseInt(thirdBookQuantityTextView.getText().toString());
                        if(x>0){
                            x=x-1;
                            xs = ""+x;
                            thirdBookQuantityTextView.setText(xs);
                        }
                        else{
                            Toast.makeText(MainActivity.this, "You cant go under 0", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case R.id.firstViewButton:
                        Intent intent = new Intent(MainActivity.this, ViewActivity.class);
                        intent.putExtra("b", warcraft1);
                        startActivity(intent);
                        break;
                    case R.id.secondViewButton:
                        intent = new Intent(MainActivity.this, ViewActivity.class);
                        intent.putExtra("b", warcraft2);
                        startActivity(intent);
                        break;
                    case R.id.thirdViewButton:
                        intent = new Intent(MainActivity.this, ViewActivity.class);
                        intent.putExtra("b", warcraft3);
                        startActivity(intent);
                        break;
                    case R.id.firstBuyButton:
                        if(isLogged){
                            intent = new Intent(MainActivity.this, BougthActivity.class);
                            intent.putExtra("b", warcraft1.getTitle());
                            startActivity(intent);
                            break;
                        }
                        else{
                            intent = new Intent(MainActivity.this, SignupActivity.class);
                            startActivity(intent);
                            break;
                        }

                    case R.id.secondBuyButton:
                        if(isLogged){
                            intent = new Intent(MainActivity.this, BougthActivity.class);
                            intent.putExtra("b", warcraft2.getTitle());
                            startActivity(intent);
                            break;
                        }
                        else{
                            intent = new Intent(MainActivity.this, SignupActivity.class);
                            startActivity(intent);
                            break;
                        }
                    case R.id.thirdBuyButton:
                        if(isLogged){
                            intent = new Intent(MainActivity.this, BougthActivity.class);
                            intent.putExtra("b", warcraft3.getTitle());
                            startActivity(intent);
                            break;
                        }
                        else{
                            intent = new Intent(MainActivity.this, SignupActivity.class);
                            startActivity(intent);
                            break;
                        }
                }
            }
        };



        firstViewButton.setOnClickListener(listener);
        secondViewButton.setOnClickListener(listener);
        thirdViewButton.setOnClickListener(listener);

        firstSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int x = parent.getSelectedItemPosition();
                switch(x){
                    case 0:
                        double y = (warcraft1.getPrice())*(Double.parseDouble((firstBookQuantityTextView.getText().toString())));
                        price2.setText(String.format("%.2f", y));
                        break;
                    case 1:
                        y = (warcraft1.getPrice()/1.75)*(Double.parseDouble((firstBookQuantityTextView.getText().toString())));
                        price1.setText(String.format("%.2f", y));
                        break;
                    case 2:
                        y = (warcraft1.getPrice()/1.95)*Double.parseDouble((firstBookQuantityTextView.getText().toString()));
                        price1.setText(String.format("%.2f", y));
                        break;
                    case 3:
                        y = (warcraft1.getPrice()/0.027)*Double.parseDouble((firstBookQuantityTextView.getText().toString()));
                        price1.setText(String.format("%.2f", y));
                        break;
                    case 4:
                        y = (warcraft1.getPrice()/0.59)*Double.parseDouble((firstBookQuantityTextView.getText().toString()));
                        price1.setText(String.format("%.2f", y));
                        break;
                    case 5:
                        y = (warcraft1.getPrice()/0.017)*Double.parseDouble((firstBookQuantityTextView.getText().toString()));
                        price1.setText(String.format("%.2f", y));
                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });
        secondSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int x = parent.getSelectedItemPosition();
                switch(x){
                    case 0:
                        double y = (warcraft2.getPrice())*Double.parseDouble((secondBookQuantityTextView.getText().toString()));
                        price2.setText(String.format("%.2f", y));
                        break;
                    case 1:
                        y = (warcraft2.getPrice()/1.75)*Double.parseDouble((secondBookQuantityTextView.getText().toString()));
                        price2.setText(String.format("%.2f", y));
                        break;
                    case 2:
                        y = Double.parseDouble(price1.getText().toString());
                        y = (warcraft2.getPrice()/1.95)*Double.parseDouble((secondBookQuantityTextView.getText().toString()));
                        price2.setText(String.format("%.2f", y));
                        break;
                    case 3:
                        y = Double.parseDouble(price1.getText().toString());
                        y = (warcraft2.getPrice()/0.027)*Double.parseDouble((secondBookQuantityTextView.getText().toString()));
                        price2.setText(String.format("%.2f", y));
                        break;
                    case 4:
                        y = Double.parseDouble(price1.getText().toString());
                        y = (warcraft2.getPrice()/0.59)*Double.parseDouble((secondBookQuantityTextView.getText().toString()));
                        price2.setText(String.format("%.2f", y));
                        break;
                    case 5:
                        y = Double.parseDouble(price1.getText().toString());
                        y = (warcraft2.getPrice()/0.017)*Double.parseDouble((secondBookQuantityTextView.getText().toString()));
                        price2.setText(String.format("%.2f", y));
                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });
        thirdSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int x = parent.getSelectedItemPosition();
                switch(x){
                    case 0:
                        double y = (warcraft3.getPrice())*Double.parseDouble((thirdBookQuantityTextView.getText().toString()));;
                        price3.setText(String.format("%.2f", y));
                        break;
                    case 1:
                        y = (warcraft3.getPrice()/1.75)*Double.parseDouble((thirdBookQuantityTextView.getText().toString()));
                        price3.setText(String.format("%.2f", y));
                        break;
                    case 2:
                        y = Double.parseDouble(price1.getText().toString());
                        y = (warcraft3.getPrice()/1.95)*Double.parseDouble((thirdBookQuantityTextView.getText().toString()));
                        price3.setText(String.format("%.2f", y));
                        break;
                    case 3:
                        y = Double.parseDouble(price1.getText().toString());
                        y = (warcraft3.getPrice()/0.027)*Double.parseDouble((thirdBookQuantityTextView.getText().toString()));
                        price3.setText(String.format("%.2f", y));
                        break;
                    case 4:
                        y = Double.parseDouble(price1.getText().toString());
                        y = (warcraft3.getPrice()/0.59)*Double.parseDouble((thirdBookQuantityTextView.getText().toString()));
                        price3.setText(String.format("%.2f", y));
                        break;
                    case 5:
                        y = Double.parseDouble(price1.getText().toString());
                        y = (warcraft3.getPrice()/0.017)*Double.parseDouble((thirdBookQuantityTextView.getText().toString()));
                        price3.setText(String.format("%.2f", y));
                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });

        firstPlusButton.setOnClickListener(listener);
        secondPlusButton.setOnClickListener(listener);
        thirdPlusButton.setOnClickListener(listener);

        firstMinusButton.setOnClickListener(listener);
        secondMinusButton.setOnClickListener(listener);
        thirdMinusButton.setOnClickListener(listener);

        firstBuyButton.setOnClickListener(listener);
        secondBuyButton.setOnClickListener(listener);
        thirdBuyButton.setOnClickListener(listener);




        warcraft1.setDescription("In the mist-shrouded haze of the past, the world of Azeroth teemed with wondrous creatures of every kind. Mysterious Elves and hardy Dwarves walked among tribes of man in relative peace and harmony—until the arrival of the demonic army known as Burning Legion shattered the world's tranquillity forever. Now Orcs, Dragons, Goblins, and Trolls all vie for supremacy over the scattered, warring kingdoms—part of a grand, malevolent scheme that will determine the fate of the world of\n" +
                "\n" +
                "WARCRAFT\n" +
                "\n" +
                "A terrifying upheaval amongst the wizards of Dalaran sends the maverick mage Rhonin on a perilous journey into orc-controlled lands. Rhonin uncovers a dark, far-reaching conspiracy that will lead him into a dangerous alliance with ancient creatures of air and fire if the world of Azeroth is to see another dawn.[2]\n" +
                "\n" +
                "DAY OF THE DRAGON\n" +
                "\n" +
                "\"To free the Dragon Queen…\n" +
                "\n" +
                "An impossible task to some, certain death to most. Dragonmaw clan would forever retain its hold on Khaz Modan unless Alexstrasza was freed, and so long as the orcs continued the work of the Horde, they remained a possible rallying point for those in the guarded enclaves.\n" +
                "\n" +
                "A brief rumble of thunder disturbed Rhonin's contemplations. He looked up but saw only a few cottony clouds.\n" +
                "\n" +
                "A second, more menacing rumble set every muscle taut as a massive shadow covered their surroundings.\n" +
                "\n" +
                "An ear-shattering roar shook the vicinity and a force akin to a tornado ripped at the landscape. Rhonin twisted around so as to see the heavens--and saw instead a hellish sight.\n" +
                "\n" +
                "A dragon the color of raging fire filled the sky above and in its forepaws it held what remained of his horse and his costly and carefully chosen supplies. The crimson leviathan consumed in one gulp the rest of the carcass, eyes already fixed on the tiny, pathetic figures below.\n" +
                "\n" +
                "And seated atop the shoulders of the beast, a grotesque, greenish figure with tusks and a battle axe barked orders in some harsh tongue and pointed directly at Rhonin.\n" +
                "\n" +
                "Maw gaping and talons bared, the dragon dove toward him.");

        warcraft2.setDescription("Slave. Gladiator. Shaman. Warchief. The enigmatic orc known as Thrall has " +
                "been all of these. Raised from infancy by cruel human masters who sought to mold him into their perfect pawn, Thrall was driven by both " +
                "the savagery in his heart and the cunning of his upbringing to pursue a destiny he was only beginning to understand—to break his bondage and rediscover the ancient traditions of his people. Now the tumultuous tale of his life's " +
                "journey—a saga of honor, hatred, and hope—can at last be told....");

        warcraft3.setDescription("In the mist-shrouded haze of the past, long before the beginning of recorded time, there stood the world of Azeroth. Every kind of magical being strode the countryside among the tribes of man, and all was at peace — until the arrival of the demons and horrors of the Burning Legion and their baneful Lord Sargeras, dark god of chaotic magic. Now Dragons, Dwarves, Elves, Goblins, Humans, and Orcs all vie for supremacy across the scattered kingdoms—part of a grand, malevolent scheme that will determine the fate of the world of\n" +
                "\n" +
                "WARCRAFT\n" +
                "\n" +
                "The Guardians of Tirisfal: a line of champions imbued with godlike powers, each one through the ages charged with fighting a lonely secret war against the Burning Legion. Medivh was fated from birth to become the greatest and most powerful of this noble order. But from the beginning a darkness tainted his soul, corrupting his innocence and turning to evil the powers that should have fought for good. Torn by two destinies, Medivh's struggle against the malice within him became one with the fate of Azeroth itself...and changed the world forever.\n" +
                "\n" +
                "THE LAST GUARDIAN\n" +
                "\n" +
                "An original tale of magic, warfare, and heroism based on the bestselling, award-winning electronic game from Blizzard Entertainment");
    }

}
