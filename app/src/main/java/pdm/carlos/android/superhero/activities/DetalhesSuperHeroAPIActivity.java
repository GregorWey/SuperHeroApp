package pdm.carlos.android.superhero.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

import pdm.carlos.android.superhero.R;
import pdm.carlos.android.superhero.model.SuperHero;

public class DetalhesSuperHeroAPIActivity extends AppCompatActivity {

    private int idSuperHero;
    private TextView superhero_nome;
    private TextView superhero_slug;
    private TextView superhero_inteligencia;
    private TextView superhero_forca;
    private TextView superhero_veloicidade;
    private TextView superhero_durabilidade;
    private TextView superhero_poder;
    private TextView superhero_combate;
    private TextView superhero_sexo;
    private TextView superhero_raça;
    private TextView superhero_altura;
    private TextView superhero_peso;
    private TextView superhero_corDosOlhos;
    private TextView superhero_corDosCabelos;
    private TextView superhero_nomeCompleto;
    private TextView superhero_alterEgos;
    private TextView superhero_aplidos;
    private TextView superhero_localDeNascimento;
    private TextView superhero_primeiraAparicao;
    private TextView superhero_editora;
    private TextView superhero_alinhamento;
    private TextView superhero_ocupacao;
    private TextView superhero_base;
    private TextView superhero_grupo;
    private TextView superhero_relativos;
    private ImageView superhero_imagem;
    private SuperHero sh;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_detalhes_superhero_api);

        superhero_nome = (TextView) this.findViewById(R.id.superHero_nome);
        superhero_slug = (TextView) this.findViewById(R.id.superHero_slug);
        superhero_inteligencia = (TextView) this.findViewById(R.id.superHero_inteligencia);
        superhero_forca = (TextView) this.findViewById(R.id.superHero_forca);
        superhero_veloicidade = (TextView) this.findViewById(R.id.superHero_velocidade);
        superhero_durabilidade = (TextView) this.findViewById(R.id.superHero_durabilidade);
        superhero_poder = (TextView) this.findViewById(R.id.superHero_poder);
        superhero_combate = (TextView) this.findViewById(R.id.superHero_combate);
        superhero_sexo = (TextView) this.findViewById(R.id.superHero_sexo);
        superhero_raça = (TextView) this.findViewById(R.id.superHero_raca);
        superhero_altura = (TextView) this.findViewById(R.id.superHero_altura);
        superhero_peso = (TextView) this.findViewById(R.id.superHero_peso);
        superhero_corDosOlhos = (TextView) this.findViewById(R.id.superHero_corDosOlhos);
        superhero_corDosCabelos = (TextView) this.findViewById(R.id.superHero_corDoCabelo);
        superhero_nomeCompleto = (TextView) this.findViewById(R.id.superHero_nomeCompleto);
        superhero_alterEgos = (TextView) this.findViewById(R.id.superHero_alterHegos);
        superhero_aplidos = (TextView) this.findViewById(R.id.superHero_apelidos);
        superhero_localDeNascimento = (TextView) this.findViewById(R.id.superHero_localDeNascimento);
        superhero_primeiraAparicao = (TextView) this.findViewById(R.id.superHero_primeiraAparicao);
        superhero_editora = (TextView) this.findViewById(R.id.superHero_editora);
        superhero_alinhamento = (TextView) this.findViewById(R.id.superHero_Alinhamento);
        superhero_ocupacao = (TextView) this.findViewById(R.id.superHero_ocupacao);
        superhero_base = (TextView) this.findViewById(R.id.superHero_base);
        superhero_grupo = (TextView) this.findViewById(R.id.superHero_grupo);
        superhero_relativos = (TextView) this.findViewById(R.id.superHero_relativos);
        superhero_imagem = (ImageView) this.findViewById(R.id.superHero_imagem);

        Intent intentSuperHero = getIntent();
        idSuperHero = intentSuperHero.getIntExtra("ID",0);
    }

    protected void onStart(){
        super.onStart();

        for(SuperHero superHero: MainActivity.lista_SuperHeroes_API){
            if(superHero.getId() == idSuperHero){
                sh = superHero;
            }
        }

        //get
        superhero_nome.setText(sh.getName());
        superhero_slug.setText(sh.getSlug());

        //getPowerstats
        superhero_inteligencia.setText(Integer.toString(sh.getPowerstats().getIntelligence()));
        superhero_forca.setText(Integer.toString(sh.getPowerstats().getStrength()));
        superhero_veloicidade.setText(Integer.toString(sh.getPowerstats().getSpeed()));
        superhero_durabilidade.setText(Integer.toString(sh.getPowerstats().getDurability()));
        superhero_poder.setText(Integer.toString(sh.getPowerstats().getPower()));
        superhero_combate.setText(Integer.toString(sh.getPowerstats().getCombat()));

        //getAppearance
        superhero_sexo.setText(sh.getAppearance().getGender());
        superhero_raça.setText(sh.getAppearance().getRace());
        superhero_altura.setText(sh.getAppearance().getHeight().toString());
        superhero_peso.setText(sh.getAppearance().getWeight().toString());
        superhero_corDosOlhos.setText(sh.getAppearance().getEyeColor());
        superhero_corDosCabelos.setText(sh.getAppearance().getHairColor());

        //getBiography
        superhero_nomeCompleto.setText(sh.getBiography().getFullName());
        superhero_alterEgos.setText(sh.getBiography().getAlterEgos());
        superhero_aplidos.setText(sh.getBiography().getAliases().toString());
        superhero_localDeNascimento.setText(sh.getBiography().getPlaceOfBirth());
        superhero_primeiraAparicao.setText(sh.getBiography().getFirstAppearance());
        superhero_editora.setText(sh.getBiography().getPublisher());
        superhero_alinhamento.setText(sh.getBiography().getAlignment());

        //getWork
        superhero_ocupacao.setText(sh.getWork().getOccupation());
        superhero_base.setText(sh.getWork().getBase());

        //getConnections
        superhero_grupo.setText(sh.getConnections().getGroupAffiliation());
        superhero_relativos.setText(sh.getConnections().getRelatives());

        //getImage
        Picasso.get().load(sh.getImages().getSm()).resize(160,160).into(superhero_imagem);
    }
}
