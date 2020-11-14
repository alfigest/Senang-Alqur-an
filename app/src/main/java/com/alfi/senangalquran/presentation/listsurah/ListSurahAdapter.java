package com.alfi.senangalquran.presentation.listsurah;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.alfi.senangalquran.R;
import com.alfi.senangalquran.model.Surah;

import java.util.List;

import butterknife.BindViews;
import butterknife.ButterKnife;



class ListSurahAdapter extends ListAdapter<Surah, ListSurahAdapter.SurahHolder> {

    private OnSurahItemClick click;

    ListSurahAdapter(@NonNull DiffUtil.ItemCallback<Surah> diffCallback, OnSurahItemClick click) {
        super(diffCallback);
        this.click = click;
    }

    @Override
    public SurahHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_list_surah, parent, false);
        return new SurahHolder(view);
    }

    @Override
    public void onBindViewHolder(SurahHolder holder, int position) {
        holder.setContent(getItem(position), click);
    }

    class SurahHolder extends RecyclerView.ViewHolder {

        @BindViews({R.id.rowSurah, R.id.rowAyat, R.id.rowTerjemahanSurah, R.id.rowJumlahAyat})
        List<TextView> rowSurah;

        SurahHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
        }

        void setContent(final Surah surah, final OnSurahItemClick click) {
            rowSurah.get(0).setText(surah.getSurah());
            rowSurah.get(1).setText(surah.getAyat());
            rowSurah.get(2).setText(surah.getTerjemahan());
            rowSurah.get(3).setText(surah.getJumlahAyat());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    click.onCLick(surah);
                }
            });

        }

    }

    interface OnSurahItemClick {
        void onCLick(Surah surah);
    }
}
