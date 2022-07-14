package pdm.carlos.android.superhero.activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import pdm.carlos.android.superhero.R;
import pdm.carlos.android.superhero.banco.BDSQLiteHelper;
import pdm.carlos.android.superhero.banco.SuperheroBancoDados;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class AdicionarSuperheroActivity extends AppCompatActivity {

    private BDSQLiteHelper bd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_superhero);
        Intent intent = getIntent();
        Integer tamanho = intent.getIntExtra("sizeidapi", 0);

        EditText editTextNome = (EditText) findViewById(R.id.editTextNomeadicionar);
        EditText editTextSlug = (EditText) findViewById(R.id.editTextSlugadicionar);
        EditText editTextinteligencia = (EditText) findViewById(R.id.editTextInteligenciaadicionar);
        EditText editTextforca = (EditText) findViewById(R.id.editTextForcaadicionar);
        EditText editTextvelocidade = (EditText) findViewById(R.id.editTextVelocidadeadicionar);
        EditText editTextdurabilidade = (EditText) findViewById(R.id.editTextDurabilidadeadicionar);
        EditText editTextpoder = (EditText) findViewById(R.id.editTextPoderadicionar);
        EditText editTextcombate = (EditText) findViewById(R.id.editTextCombateadicionar);
        EditText editTextsexo = (EditText) findViewById(R.id.editTextSexoadicionar);
        EditText editTextraca = (EditText) findViewById(R.id.editTextRacaadicionar);
        EditText editTextaltura1 = (EditText) findViewById(R.id.editTextAltura1adicionar);
        EditText editTextaltura2 = (EditText) findViewById(R.id.editTextAltura2adicionar);
        EditText editTextpeso1 = (EditText) findViewById(R.id.editTextPeso1adicionar);
        EditText editTextpeso2 = (EditText) findViewById(R.id.editTextPeso2adicionar);
        EditText editTextcorolhos = (EditText) findViewById(R.id.editTextCorOlhosadicionar);
        EditText editTextcorcabelo = (EditText) findViewById(R.id.editTextCorCabelosadicionar);
        EditText editTextnomecompleto = (EditText) findViewById(R.id.editTextNomeCompletoadicionar);
        EditText editTextalteregos = (EditText) findViewById(R.id.editTextAlterEgosadicionar);
        EditText editTextapelidos = (EditText) findViewById(R.id.editTextApelidosadicionar);
        EditText editTextlocalnascimento = (EditText) findViewById(R.id.editTextLocalNascimentoadicionar);
        EditText editTextprimeiraaparicao = (EditText) findViewById(R.id.editTextPrimeiraAparicaoadicionar);
        EditText editTexteditora = (EditText) findViewById(R.id.editTextEditoraadicionar);
        EditText editTextalinhamento = (EditText) findViewById(R.id.editTextAlinhamentoadicionar);
        EditText editTextocupacao = (EditText) findViewById(R.id.editTextOcupacaoadicionar);
        EditText editTextbase = (EditText) findViewById(R.id.editTextBaseadicionar);
        EditText editTextgrupo = (EditText) findViewById(R.id.editTextGrupoadicionar);
        EditText editTextrelativos = (EditText) findViewById(R.id.editTextRelativosadicionar);
        EditText editURL1 = (EditText) findViewById(R.id.editTextURLImagem1);
        EditText editURL2 = (EditText) findViewById(R.id.editTextURL2);
        EditText editURL3 = (EditText) findViewById(R.id.editTextURL3);
        EditText editURL4 = (EditText) findViewById(R.id.editTextURL4);

        Button buttonSalvar = (Button) findViewById(R.id.buttonSalvar);
        buttonSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bd = new BDSQLiteHelper(AdicionarSuperheroActivity.this);
                SuperheroBancoDados superhero = new SuperheroBancoDados();
                Integer idtemp;

                if (tamanho != 0) {
                    SuperheroBancoDados superheroaux = bd.getsuperhero(tamanho);
                    idtemp = Integer.parseInt(superheroaux.getIdapi());
                    idtemp = idtemp + 1;
                } else {
                    idtemp = 1;
                }

                superhero.setIdapi(idtemp.toString());//


                String aux = (String) editTextNome.getText().toString();
                superhero.setNome(aux);
                aux = (String) editTextSlug.getText().toString();
                superhero.setSlug(aux);
                aux = (String) editTextinteligencia.getText().toString();
                superhero.setInteligencia(aux);
                aux = (String) editTextforca.getText().toString();
                superhero.setForca(aux);
                aux = (String) editTextvelocidade.getText().toString();
                superhero.setVelocidade(aux);
                aux = (String) editTextdurabilidade.getText().toString();
                superhero.setDurabilidade(aux);
                aux = (String) editTextpoder.getText().toString();
                superhero.setPoder(aux);
                aux = (String) editTextcombate.getText().toString();
                superhero.setCombate(aux);
                aux = (String) editTextsexo.getText().toString();
                superhero.setSexo(aux);
                aux = (String) editTextraca.getText().toString();
                superhero.setRaca(aux);
                aux = (String) editTextaltura1.getText().toString();
                superhero.setAltura1(aux);
                aux = (String) editTextaltura2.getText().toString();
                superhero.setAltura2(aux);
                aux = (String) editTextpeso1.getText().toString();
                superhero.setPeso1(aux);
                aux = (String) editTextpeso2.getText().toString();
                superhero.setPeso2(aux);
                aux = (String) editTextcorolhos.getText().toString();
                superhero.setCorolhos(aux);
                aux = (String) editTextcorcabelo.getText().toString();
                superhero.setCorcabelos(aux);
                aux = (String) editTextnomecompleto.getText().toString();
                superhero.setNomecompleto(aux);
                aux = (String) editTextalteregos.getText().toString();
                superhero.setAlteregos(aux);
                aux = (String) editTextapelidos.getText().toString();
                superhero.setApelidos(aux);
                aux = (String) editTextlocalnascimento.getText().toString();
                superhero.setLocalnascimento(aux);
                aux = (String) editTextprimeiraaparicao.getText().toString();
                superhero.setPrimeiraaparicao(aux);
                aux = (String) editTexteditora.getText().toString();
                superhero.setEditora(aux);
                aux = (String) editTextalinhamento.getText().toString();
                superhero.setAlinhamento(aux);
                aux = (String) editTextocupacao.getText().toString();
                superhero.setOcupacao(aux);
                aux = (String) editTextbase.getText().toString();
                superhero.setBase(aux);
                aux = (String) editTextgrupo.getText().toString();
                superhero.setGrupo(aux);
                aux = (String) editTextrelativos.getText().toString();
                superhero.setRelativos(aux);
                aux = (String) editURL1.getText().toString();
                superhero.setUrlimagem1(aux);
                aux = (String) editURL2.getText().toString();
                superhero.setUrlimagem2(aux);
                aux = (String) editURL3.getText().toString();
                superhero.setUrlimagem3(aux);
                aux = (String) editURL4.getText().toString();
                superhero.setUrlimagem4(aux);

                bd.addsuperhero(superhero);

                finish();
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
    }
}