package com.example.rosinek.scoreapp.ui.scores;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.rosinek.scoreapp.R;
import com.example.rosinek.scoreapp.model.Api.GSMRS.GameMatch;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Grzegorz Rosinski on 25.09.2018.
 */
public class ScoresAdapter extends RecyclerView.Adapter<ScoresAdapter.ViewHolder> {

    private List<GameMatch> gameList;
    private Context context;

    private final int DARK = 0;
    private final int LIGHT = 1;

    public ScoresAdapter(List<GameMatch> gameList, Context context) {
        this.gameList = gameList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_scores, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint("NewApi")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        GameMatch game = gameList.get(position);

        holder.tvscoreAway.setText(game.getFs_B());
        holder.tvscoreHome.setText(game.getFs_A());
        holder.tvTeamAway.setText(game.getTeam_B_name());
        holder.tvteamHome.setText(game.getTeam_A_name());

        if(getItemViewType(position)!=LIGHT){
            holder.item.setBackgroundColor(context.getColor(R.color.white));
        }

    }

    @Override
    public int getItemViewType(int position) {
        return position%2 == 0 ? DARK : LIGHT;
    }

    @Override
    public int getItemCount() {
        return gameList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_score_home)
        TextView tvscoreHome;

        @BindView(R.id.tv_score_away)
        TextView tvscoreAway;

        @BindView(R.id.tv_team_home)
        TextView tvteamHome;

        @BindView(R.id.tv_team_away)
        TextView tvTeamAway;

        @BindView(R.id.item_container)
        ConstraintLayout item;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
