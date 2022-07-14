package pdm.carlos.android.superhero.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import pdm.carlos.android.superhero.R;
import pdm.carlos.android.superhero.banco.SuperheroBancoDados;

public class SuperHeroListBancoAdapter extends RecyclerView.Adapter<SuperHeroListBancoAdapter.SuperHeroViewHolder> {

    private List<SuperheroBancoDados> superhero;
    private int rowLayout;
    private Context context;
    private ItemClickListener clickListener;

    public SuperHeroListBancoAdapter(List<SuperheroBancoDados> superhero, int rowLayout, Context context) {
        this.superhero = superhero;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public SuperHeroListBancoAdapter.SuperHeroViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new SuperHeroListBancoAdapter.SuperHeroViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SuperHeroViewHolder holder, int position) {
        Picasso.get().load(superhero.get(position).getUrlimagem4()).resize(100, 100).into(holder.image_superhero);
        holder.id_superhero.setText("#" + superhero.get(position).getIdapi());
        holder.nome_superhero.setText(superhero.get(position).getNome());
    }

    @Override
    public int getItemCount() {
        return superhero.size();
    }

    public void setClickListener(ItemClickListener itemClickListener) {
        this.clickListener = itemClickListener;
    }

    public class SuperHeroViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        LinearLayout layout_superhero;
        TextView id_superhero;
        ImageView image_superhero;
        TextView nome_superhero;

        public SuperHeroViewHolder(View itemView) {
            super(itemView);
            layout_superhero = (LinearLayout) itemView.findViewById(R.id.layout_superhero);
            id_superhero = (TextView) itemView.findViewById(R.id.id_superhero);
            image_superhero = (ImageView) itemView.findViewById(R.id.imagem_superhero);
            nome_superhero = (TextView) itemView.findViewById(R.id.nome_superhero);
            itemView.setTag(itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View itemView) {
            if (clickListener != null) {
                clickListener.onClick(itemView, getAdapterPosition());
            }
        }
    }
}