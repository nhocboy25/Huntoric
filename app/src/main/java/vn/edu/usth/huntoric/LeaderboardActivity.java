package vn.edu.usth.huntoric;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LeaderboardActivity extends AppCompatActivity {

    private RecyclerView leaderboardRecyclerView;
    private LeaderboardAdapter leaderboardAdapter;
    private ArrayList<LeaderboardItem> leaderboardList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard);

        // Khởi tạo RecyclerView và Adapter
        leaderboardRecyclerView = findViewById(R.id.leaderboardRecyclerView);
        leaderboardRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Tạo dữ liệu mẫu cho leaderboard
        leaderboardList = new ArrayList<>();
        leaderboardList.add(new LeaderboardItem("Player 1", 100));
        leaderboardList.add(new LeaderboardItem("Player 2", 90));
        leaderboardList.add(new LeaderboardItem("Player 3", 80));
        leaderboardList.add(new LeaderboardItem("Player 4", 70));
        leaderboardList.add(new LeaderboardItem("Player 5", 60));

        // Thiết lập adapter cho RecyclerView
        leaderboardAdapter = new LeaderboardAdapter(leaderboardList);
        leaderboardRecyclerView.setAdapter(leaderboardAdapter);
    }
}