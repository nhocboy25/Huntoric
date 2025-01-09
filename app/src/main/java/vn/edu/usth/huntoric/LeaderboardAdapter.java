package vn.edu.usth.huntoric;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class LeaderboardAdapter extends RecyclerView.Adapter<LeaderboardAdapter.LeaderboardViewHolder> {

    private List<LeaderboardItem> leaderboardList;

    public LeaderboardAdapter(List<LeaderboardItem> leaderboardList) {
        this.leaderboardList = leaderboardList;
    }

    @Override
    public LeaderboardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.leaderboard_item, parent, false);
        return new LeaderboardViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(LeaderboardViewHolder holder, int position) {
        LeaderboardItem item = leaderboardList.get(position);
        holder.playerNameTextView.setText(item.getPlayerName());
        holder.scoreTextView.setText(String.valueOf(item.getScore()));
    }

    @Override
    public int getItemCount() {
        return leaderboardList.size();
    }

    public static class LeaderboardViewHolder extends RecyclerView.ViewHolder {

        public TextView playerNameTextView;
        public TextView scoreTextView;

        public LeaderboardViewHolder(View itemView) {
            super(itemView);
            playerNameTextView = itemView.findViewById(R.id.playerNameTextView);
            scoreTextView = itemView.findViewById(R.id.scoreTextView);
        }
    }
}
