package fr.unicaen.info.users.a21606807.ventesimmobilires.view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import fr.unicaen.info.users.a21606807.ventesimmobilires.R;
import fr.unicaen.info.users.a21606807.ventesimmobilires.model.Propriete;

public class MainAnnonceAdapter extends RecyclerView.Adapter<AnnonceViewHolder> {

    private MainActivity mainActivity;
    private List<Propriete> list;

    public MainAnnonceAdapter(MainActivity mainActivity, List<Propriete> list) {
        this.mainActivity = mainActivity;
        this.list = list;
    }

    @Override
    public AnnonceViewHolder onCreateViewHolder(ViewGroup viewGroup, int itemType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_annonces_list_element, viewGroup,false);
        return new AnnonceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AnnonceViewHolder annonce_view_holder, final int position) {
        Propriete propriete = list.get(position);
        annonce_view_holder.bind(propriete);

        annonce_view_holder.layout_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivity.openAnnonce(view, list.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
