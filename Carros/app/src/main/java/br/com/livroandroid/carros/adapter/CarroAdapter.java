package br.com.livroandroid.carros.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import br.com.livroandroid.carros.R;
import br.com.livroandroid.carros.domain.Carro;

public class CarroAdapter extends RecyclerView.Adapter<CarroAdapter.CarrosViewHolder> {
    protected static final String TAG="livroandroid";
    private final Context context;
    private final List<Carro> carros;
    private CarroOnClickListener carroOnClickListener;

    public CarroAdapter(Context context, List<Carro> carros, CarroOnClickListener carroOnClickListener){
        this.context = context;
        this.carros = carros;
        this.carroOnClickListener = carroOnClickListener;
    }
    @Override
    public int getItemCount(){
        return this.carros != null ? this.carros.size() : 0;
    }

    @Override
    public CarrosViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType){
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_carro, viewGroup, false);
        CarrosViewHolder holder = new CarrosViewHolder(view);
        return holder;
    }
    @Override
    public void onBindViewHolder(final CarrosViewHolder holder, final int position){
        Carro c = carros.get(position);

        holder.tNome.setText(c.nome);
        holder.progress.setVisibility(View.VISIBLE);

        Picasso.get().load(c.urlFoto).fit().into(holder.img, new com.squareup.picasso.Callback() {
            @Override
            public void onSuccess() {
                holder.progress.setVisibility(View.GONE);
            }

            @Override
            public void onError(Exception e) {
                holder.progress.setVisibility(View.GONE);
            }
        });

        if(carroOnClickListener != null){
            holder.itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    carroOnClickListener.onClickCarro(holder.itemView, position);
                }
           });
        }
    }

    public interface CarroOnClickListener{
        public void onClickCarro(View view, int idx);
    }

    public static class CarrosViewHolder extends RecyclerView.ViewHolder{
        TextView tNome;
        ImageView img;
        ProgressBar progress;
        CardView cardView;

        public CarrosViewHolder(View view){
            super(view);
            tNome = view.findViewById(R.id.text);
            img = view.findViewById(R.id.img);
            progress = view.findViewById(R.id.progressImg);
            cardView = view.findViewById(R.id.card_view);
        }
    }
}
