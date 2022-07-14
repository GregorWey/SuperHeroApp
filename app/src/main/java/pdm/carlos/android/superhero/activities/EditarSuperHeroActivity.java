package pdm.carlos.android.superhero.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import pdm.carlos.android.superhero.R;
import pdm.carlos.android.superhero.banco.BDSQLiteHelper;
import pdm.carlos.android.superhero.banco.SuperheroBancoDados;

public class EditarSuperHeroActivity extends AppCompatActivity {

    private BDSQLiteHelper bd;
    private SuperheroBancoDados superhero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_superhero);

        Intent intent = getIntent();
        int id = intent.getIntExtra("ID", 0);

        bd = new BDSQLiteHelper(this);
        superhero = bd.getsuperhero(id);

        EditText editTextnome = (EditText) findViewById(R.id.editTextNomeadicionar);
        editTextnome.setText(superhero.getNome());
        EditText editTexslug = (EditText) findViewById(R.id.editTextSlugadicionar);
        editTexslug.setText(superhero.getSlug());
        EditText editTextinteligencia = (EditText) findViewById(R.id.editTextInteligenciaadicionar);
        editTextinteligencia.setText(superhero.getInteligencia());
        EditText editTextforca = (EditText) findViewById(R.id.editTextForcaadicionar);
        editTextforca.setText(superhero.getForca());
        EditText editTextvelocidade = (EditText) findViewById(R.id.editTextVelocidadeadicionar);
        editTextvelocidade.setText(superhero.getVelocidade());
        EditText editTextdurabilidade = (EditText) findViewById(R.id.editTextDurabilidadeadicionar);
        editTextdurabilidade.setText(superhero.getDurabilidade());
        EditText editTextpoder = (EditText) findViewById(R.id.editTextPoderadicionar);
        editTextpoder.setText(superhero.getPoder());
        EditText editTextcombate = (EditText) findViewById(R.id.editTextCombateadicionar);
        editTextcombate.setText(superhero.getCombate());
        EditText editTextsexo = (EditText) findViewById(R.id.editTextSexoadicionar);
        editTextsexo.setText(superhero.getSexo());
        EditText editTextraca = (EditText) findViewById(R.id.editTextRacaadicionar);
        editTextraca.setText(superhero.getRaca());
        EditText editTextaltura1 = (EditText) findViewById(R.id.editTextAltura1adicionar);
        editTextaltura1.setText(superhero.getAltura1());
        EditText editTextaltura2 = (EditText) findViewById(R.id.editTextAltura2adicionar);
        editTextaltura2.setText(superhero.getAltura2());
        EditText editTextpeso1 = (EditText) findViewById(R.id.editTextPeso1adicionar);
        editTextpeso1.setText(superhero.getPeso1());
        EditText editTextpeso2 = (EditText) findViewById(R.id.editTextPeso2adicionar);
        editTextpeso2.setText(superhero.getPeso2());
        EditText editTextcorolhos = (EditText) findViewById(R.id.editTextCorOlhosadicionar);
        editTextcorolhos.setText(superhero.getCorolhos());
        EditText editTextcorcabelo = (EditText) findViewById(R.id.editTextCorCabelosadicionar);
        editTextcorcabelo.setText(superhero.getCorcabelos());
        EditText editTextnomecompleto = (EditText) findViewById(R.id.editTextNomeCompletoadicionar);
        editTextnomecompleto.setText(superhero.getNomecompleto());
        EditText editTextalteregos = (EditText) findViewById(R.id.editTextAlterEgosadicionar);
        editTextalteregos.setText(superhero.getAlteregos());
        EditText editTextapelidos = (EditText) findViewById(R.id.editTextApelidosadicionar);
        editTextapelidos.setText(superhero.getApelidos());
        EditText editTextlocalnascimento = (EditText) findViewById(R.id.editTextLocalNascimentoadicionar);
        editTextlocalnascimento.setText(superhero.getLocalnascimento());
        EditText editTextprimeiraaparicao = (EditText) findViewById(R.id.editTextPrimeiraAparicaoadicionar);
        editTextprimeiraaparicao.setText(superhero.getPrimeiraaparicao());
        EditText editTexteditora = (EditText) findViewById(R.id.editTextEditoraadicionar);
        editTexteditora.setText(superhero.getEditora());
        EditText editTextalinhamento = (EditText) findViewById(R.id.editTextAlinhamentoadicionar);
        editTextalinhamento.setText(superhero.getAlinhamento());
        EditText editTextocupacao = (EditText) findViewById(R.id.editTextOcupacaoadicionar);
        editTextocupacao.setText(superhero.getOcupacao());
        EditText editTextbase = (EditText) findViewById(R.id.editTextBaseadicionar);
        editTextbase.setText(superhero.getBase());
        EditText editTextgrupo = (EditText) findViewById(R.id.editTextGrupoadicionar);
        editTextgrupo.setText(superhero.getGrupo());
        EditText editTextrelativos = (EditText) findViewById(R.id.editTextRelativosadicionar);
        editTextrelativos.setText(superhero.getRelativos());
        EditText editTexturlimagem1 = (EditText) findViewById(R.id.editTextURLImagem1);
        editTexturlimagem1.setText(superhero.getUrlimagem1());
        EditText editTexturlimagem2 = (EditText) findViewById(R.id.editTextURL2);
        editTexturlimagem2.setText(superhero.getUrlimagem2());
        EditText editTexturlimagem3 = (EditText) findViewById(R.id.editTextURL3);
        editTexturlimagem3.setText(superhero.getUrlimagem3());
        EditText editTexturlimagem4 = (EditText) findViewById(R.id.editTextURL4);
        editTexturlimagem4.setText(superhero.getUrlimagem4());

        Button salvar = (Button) findViewById(R.id.buttonSalvar);
        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                superhero.setNome(editTextnome.getText().toString());
                superhero.setSlug(editTexslug.getText().toString());
                superhero.setInteligencia(editTextinteligencia.getText().toString());
                superhero.setForca(editTextforca.getText().toString());
                superhero.setVelocidade(editTextvelocidade.getText().toString());
                superhero.setDurabilidade(editTextdurabilidade.getText().toString());
                superhero.setPoder(editTextpoder.getText().toString());
                superhero.setCombate(editTextcombate.getText().toString());
                superhero.setSexo(editTextsexo.getText().toString());
                superhero.setRaca(editTextraca.getText().toString());
                superhero.setAltura1(editTextaltura1.getText().toString());
                superhero.setAltura2(editTextaltura2.getText().toString());
                superhero.setPeso1(editTextpeso1.getText().toString());
                superhero.setPeso2(editTextpeso2.getText().toString());
                superhero.setCorolhos(editTextcorolhos.getText().toString());
                superhero.setCorcabelos(editTextcorcabelo.getText().toString());
                superhero.setNomecompleto(editTextnomecompleto.getText().toString());
                superhero.setAlteregos(editTextalteregos.getText().toString());
                superhero.setApelidos(editTextapelidos.getText().toString());
                superhero.setLocalnascimento(editTextlocalnascimento.getText().toString());
                superhero.setPrimeiraaparicao(editTextprimeiraaparicao.getText().toString());
                superhero.setEditora(editTexteditora.getText().toString());
                superhero.setAlinhamento(editTextalinhamento.getText().toString());
                superhero.setOcupacao(editTextocupacao.getText().toString());
                superhero.setBase(editTextbase.getText().toString());
                superhero.setGrupo(editTextgrupo.getText().toString());
                superhero.setRelativos(editTextrelativos.getText().toString());
                superhero.setUrlimagem1(editTexturlimagem1.getText().toString());
                superhero.setUrlimagem2(editTexturlimagem2.getText().toString());
                superhero.setUrlimagem3(editTexturlimagem3.getText().toString());
                superhero.setUrlimagem4(editTexturlimagem4.getText().toString());

                bd.updateSuperhero(superhero);

                finish();
            }
        });
    }

}