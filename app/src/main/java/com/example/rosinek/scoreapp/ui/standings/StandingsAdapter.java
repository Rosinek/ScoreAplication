package com.example.rosinek.scoreapp.ui.standings;

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
import com.example.rosinek.scoreapp.model.Api.GSMRS.RankingObject;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Grzegorz Rosinski on 25.09.2018.
 */
public class StandingsAdapter extends RecyclerView.Adapter<StandingsAdapter.ViewHolder> {

    private ArrayList<RankingObject> rankingList;
    private Context context;
    private final int DARK = 0;
    private final int LIGHT = 1;

    public StandingsAdapter(ArrayList<RankingObject> ranking, Context context) {
        this.rankingList = ranking;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_standings, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint("NewApi")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        RankingObject object = rankingList.get(position);
        holder.tvRank.setText(prepareClubRankNumber(object));
        holder.tvName.setText(prepareClubName(object));
        holder.tvPlayed.setText(object.getMatches_total());
        holder.tvWins.setText(object.getMatches_won());
        holder.tvLoses.setText(object.getMatches_lost());
        holder.tvDraws.setText(object.getMatches_draw());
        holder.tvGoalsDiff.setText(getGoalsDiff(object));
        holder.tvPoints.setText(object.getPoints());
        checkForTeamQualifier(object,holder);
    }

    private String prepareClubName(RankingObject object) {
        if(object.getClub_name().equals("Manchester United")){
            return "Man Utd";
        }else if(object.getClub_name().equals("Manchester City")){
            return "Man City";
        }
        else return object.getClub_name();

    }

    @SuppressLint("NewApi")
    private void checkForTeamQualifier(RankingObject object, ViewHolder holder) {
        int rank = Integer.parseInt(object.getRank());
        if(rank<4){
            holder.item.setBackgroundColor(context.getColor(R.color.CF));
        }else if (rank==4){
            holder.item.setBackgroundColor(context.getColor(R.color.CLQF));
        }else if(rank == 5){
            holder.item.setBackgroundColor(context.getColor(R.color.EuroL));
        }else if(rank>=18){
            holder.item.setBackgroundColor(context.getColor(R.color.Releg));
        }
        else{
            if(rank%2!=0){
                holder.item.setBackgroundColor(context.getColor(R.color.white));
            }
        }
    }

    @SuppressLint("DefaultLocale")
    private String prepareClubRankNumber(RankingObject object) {
        int rank = Integer.parseInt(object.getRank());
        return String.format("%02d", rank);
    }

    private String getGoalsDiff(RankingObject object) {
      int a = Integer.parseInt(object.getGoals_against());
      int b = Integer.parseInt(object.getGoals_pro());
      return String.valueOf(b-a);
    }

    @Override
    public int getItemViewType(int position) {
        return position%2 == 0 ? DARK : LIGHT;
    }

    @Override
    public int getItemCount() {
        return rankingList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.item_container)
        ConstraintLayout item;

        @BindView(R.id.tv_rank)
        TextView tvRank;

        @BindView(R.id.tv_name)
        TextView tvName;

        @BindView(R.id.tv_played)
        TextView tvPlayed;

        @BindView(R.id.tv_wins)
        TextView tvWins;

        @BindView(R.id.tv_loses)
        TextView tvLoses;

        @BindView(R.id.tv_draws)
        TextView tvDraws;

        @BindView(R.id.tv_goals_diff)
        TextView tvGoalsDiff;

        @BindView(R.id.tv_points)
        TextView tvPoints;


        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
