package pdm.carlos.android.superhero.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

import java.util.List;

import pdm.carlos.android.superhero.R;
import pdm.carlos.android.superhero.banco.BDSQLiteHelper;
import pdm.carlos.android.superhero.banco.SuperheroBancoDados;

public class DetalhesSuperHeroBancoActivity extends AppCompatActivity {

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
    private SuperheroBancoDados sh;
    private BDSQLiteHelper bd;
    private List<SuperheroBancoDados> lista_SuperHeroes_BD;//lista do banco de dados

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_detalhes_superhero_banco);

        bd = new BDSQLiteHelper(this);
        lista_SuperHeroes_BD = bd.getAllSuperheros();

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
        idSuperHero = intentSuperHero.getIntExtra("ID", 0);

        for (SuperheroBancoDados superHero : lista_SuperHeroes_BD) {
            if (superHero.getId() == idSuperHero) {
                sh = superHero;
            }
        }

        Button botao_AlterarSuperHero = (Button) this.findViewById(R.id.button_AlterarSuperHero);
        botao_AlterarSuperHero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(DetalhesSuperHeroBancoActivity.this, EditarSuperHeroActivity.class);
                i.putExtra("ID", sh.getId());
                startActivity(i);
                finish();
            }
        });

        Button botao_ExcluirSuperHero = (Button) this.findViewById(R.id.button_ExcluirSuperHero);
        botao_ExcluirSuperHero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lista_SuperHeroes_BD.remove(sh);
                bd.deleteSuperhero(sh);
                Intent intent = new Intent(DetalhesSuperHeroBancoActivity.this, MostrarDadosBancoActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    protected void onStart() {
        super.onStart();

        //get
        superhero_nome.setText(sh.getNome());
        superhero_slug.setText(sh.getSlug());

        //getPowerstats
        superhero_inteligencia.setText(Integer.toString(Integer.parseInt(sh.getInteligencia())));
        superhero_forca.setText(Integer.toString(Integer.parseInt(sh.getForca())));
        superhero_veloicidade.setText(Integer.toString(Integer.parseInt(sh.getVelocidade())));
        superhero_durabilidade.setText(Integer.toString(Integer.parseInt(sh.getDurabilidade())));
        superhero_poder.setText(Integer.toString(Integer.parseInt(sh.getPoder())));
        superhero_combate.setText(Integer.toString(Integer.parseInt(sh.getCombate())));

        //getAppearance
        superhero_sexo.setText(sh.getSexo());
        superhero_raça.setText(sh.getRaca());
        superhero_altura.setText(sh.getAltura1() + "," + sh.getAltura2());
        superhero_peso.setText(sh.getPeso1() + "," + sh.getPeso2());
        superhero_corDosOlhos.setText(sh.getCorolhos());
        superhero_corDosCabelos.setText(sh.getCorcabelos());

        //getBiography
        superhero_nomeCompleto.setText(sh.getNomecompleto());
        superhero_alterEgos.setText(sh.getAlteregos());
        superhero_aplidos.setText(sh.getApelidos());
        superhero_localDeNascimento.setText(sh.getLocalnascimento());
        superhero_primeiraAparicao.setText(sh.getPrimeiraaparicao());
        superhero_editora.setText(sh.getEditora());
        superhero_alinhamento.setText(sh.getAlinhamento());

        //getWork
        superhero_ocupacao.setText(sh.getOcupacao());
        superhero_base.setText(sh.getBase());

        //getConnections
        superhero_grupo.setText(sh.getGrupo());
        superhero_relativos.setText(sh.getRelativos());

        //getImage
        Picasso.get().load(sh.getUrlimagem2()).resize(160, 160).into(superhero_imagem);
    }
}
