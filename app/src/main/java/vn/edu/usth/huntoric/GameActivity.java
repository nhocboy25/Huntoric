package vn.edu.usth.huntoric;

import android.os.Bundle;
import android.content.Context;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class GameActivity extends AppCompatActivity {

    private static Context gameContext;

    // Declaration of UI components
    private Button buttonYes, buttonNo, buttonDontKnow, buttonRather,
            buttonRatherNot, buttonMusic;
    private TextView textViewQuestionRequest;
    private ImageView imageViewGenie;

    // Game-related variables
    private String actualQuestion;
    private String actualKey;
    private int inverseResponse;
    private int nbQuestionsAsked = 0;
    private boolean isAlreadyIDontKnow = true;
    private int countForGeniePicture = 0;
    private int iDontKnowCounter = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Enable Edge-to-Edge UI
        EdgeToEdge.enable(this);

        // Set the layout
        setContentView(R.layout.activity_game);

        // Handle window insets for padding
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize UI components
        buttonYes = findViewById(R.id.buttonYes);
        buttonNo = findViewById(R.id.buttonNo);
        buttonDontKnow = findViewById(R.id.buttonDontKnow);
        buttonRather = findViewById(R.id.buttonRather);
        buttonRatherNot = findViewById(R.id.buttonRatherNot);
        textViewQuestionRequest = findViewById(R.id.textViewQuestionRequest);
        imageViewGenie = findViewById(R.id.imageViewGenie);

        // Add event listeners if needed
        setupButtonListeners();
    }

    private void setupButtonListeners() {
        buttonYes.setOnClickListener(v -> handleYesButtonClick());
        buttonNo.setOnClickListener(v -> handleNoButtonClick());
        buttonDontKnow.setOnClickListener(v -> handleDontKnowButtonClick());
        buttonRather.setOnClickListener(v -> handleRatherButtonClick());
        buttonRatherNot.setOnClickListener(v -> handleRatherNotButtonClick());
    }

    // Placeholder methods for button actions
    private void handleYesButtonClick() {
        // Logic for Yes button click
    }

    private void handleNoButtonClick() {
        // Logic for No button click
    }

    private void handleDontKnowButtonClick() {
        // Logic for Don't Know button click
    }

    private void handleRatherButtonClick() {
        // Logic for Rather button click
    }

    private void handleRatherNotButtonClick() {
        // Logic for Rather Not button click
    }
}
