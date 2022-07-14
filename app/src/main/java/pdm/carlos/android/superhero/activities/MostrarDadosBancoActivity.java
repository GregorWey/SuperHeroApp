package pdm.carlos.android.superhero.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;
import java.util.List;

import pdm.carlos.android.superhero.R;
import pdm.carlos.android.superhero.adapter.ItemClickListener;
import pdm.carlos.android.superhero.adapter.SuperHeroListBancoAdapter;
import pdm.carlos.android.superhero.banco.BDSQLiteHelper;
import pdm.carlos.android.superhero.banco.SalvaBancoInicial;
import pdm.carlos.android.superhero.banco.SuperheroBancoDados;
import pdm.carlos.android.superhero.model.SuperHero;
import pdm.carlos.android.superhero.rest.ApiClient;
import pdm.carlos.android.superhero.rest.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MostrarDadosBancoActivity extends AppCompatActivity implements ItemClickListener {

    private BDSQLiteHelper bd;
    private RecyclerView recyclerView_superHero;
    private List<SuperheroBancoDados> lista_SuperHeroes_BD;//lista do banco de dados
    public List<SuperHero> lista_SuperHeroes_API = new ArrayList<>();//lista que virá do retrofit

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostra_dados_banco);

        bd = new BDSQLiteHelper(this);
        lista_SuperHeroes_BD = bd.getAllSuperheros();
        recyclerView_superHero = (RecyclerView) findViewById(R.id.reciclerView_mostraDadosBanco);
        recyclerView_superHero.setLayoutManager(new LinearLayoutManager(this));

        setaReciclerView();

        Button botao_ApagarDadosSQLite = (Button) findViewById(R.id.button_ApagarDadosSQLite);
        botao_ApagarDadosSQLite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bd.deleteTable();
                lista_SuperHeroes_BD = new ArrayList<SuperheroBancoDados>();
                setaReciclerView();
            }
        });

        Button botao_AdicionarSuperHero = (Button) findViewById(R.id.button_AdicionarSuperHero);
        botao_AdicionarSuperHero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AdicionarSuperheroActivity.class);
                int tamanho = lista_SuperHeroes_BD.size();
                intent.putExtra("sizeidapi", tamanho);
                startActivity(intent);
                //setaReciclerView();
            }
        });

        Button botao_MostrarDadosAPI = (Button) findViewById(R.id.button_MostrarDadosAPI);
        botao_MostrarDadosAPI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        EditText editText_campoDePesquisa = (EditText) findViewById(R.id.editText_CampoDePesquisa);

        Button botao_Pesquisar = (Button) findViewById(R.id.button_PesquisarSuperHeroBanco);
        botao_Pesquisar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String aux = (String) editText_campoDePesquisa.getText().toString();
                try {
                    if (!editText_campoDePesquisa.getText().toString().trim().equals("")) {
                        SuperheroBancoDados SuperHeroIDPesquisa = bd.getsuperhero(aux);
                        lista_SuperHeroes_BD = new ArrayList<SuperheroBancoDados>();
                        lista_SuperHeroes_BD.add(SuperHeroIDPesquisa);
                        if (SuperHeroIDPesquisa.getIdapi() != null) {
                            setaReciclerView();
                            editText_campoDePesquisa.setText("");
                        }
                    }
                } catch (Exception e) {
                    alerta(editText_campoDePesquisa);
                }
            }
        });

        Button botao_RecarregarLista = (Button) findViewById(R.id.button_RecarregarListaSuperHero);
        botao_RecarregarLista.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                lista_SuperHeroes_BD = new ArrayList<SuperheroBancoDados>();
                lista_SuperHeroes_BD = bd.getAllSuperheros();
                editText_campoDePesquisa.setText("");
                setaReciclerView();
            }
        });

        editText_campoDePesquisa.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                try {
                    if (event.getAction() == KeyEvent.ACTION_DOWN) {

                        if (keyCode == KeyEvent.KEYCODE_DPAD_CENTER || keyCode == KeyEvent.KEYCODE_ENTER) {
                            String aux = (String) editText_campoDePesquisa.getText().toString();

                            if (!editText_campoDePesquisa.getText().toString().trim().equals("")) {
                                SuperheroBancoDados SuperHeroIDPesquisa = bd.getsuperhero(aux);
                                lista_SuperHeroes_BD = new ArrayList<SuperheroBancoDados>();
                                lista_SuperHeroes_BD.add(SuperHeroIDPesquisa);
                                if (SuperHeroIDPesquisa.getIdapi() != null) {
                                    setaReciclerView();
                                    editText_campoDePesquisa.setText("");
                                }
                            }
                            return true;
                        }
                    }
                } catch (Exception e) {
                    alerta(editText_campoDePesquisa);
                    editText_campoDePesquisa.setText("");
                }
                return false;
            }
        });

        Button botao_ReconectarAPI = (Button) findViewById(R.id.button_ReconectarAPI);
        botao_ReconectarAPI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ApiInterface apiService = ApiClient.getSuperHero().create(ApiInterface.class);
                Call<List<SuperHero>> call = apiService.listSuperHeroes();
                call.enqueue(new Callback<List<SuperHero>>() {
                    @Override
                    public void onResponse(Call<List<SuperHero>> call, Response<List<SuperHero>> response) {
                        if (response.isSuccessful()) {
                            bd.deleteTable();//se ja existe algum dado no sqlite eu jogo esse dado fora e busco da api novamente
                            lista_SuperHeroes_BD = new ArrayList<SuperheroBancoDados>();
                            lista_SuperHeroes_API = response.body();
                            //converte do retrofit para um arraylist de objetos do tipo SuperheroBancoDados
                            SalvaBancoInicial a = new SalvaBancoInicial(lista_SuperHeroes_API);
                            lista_SuperHeroes_BD = a.salvaBancoInicial2();
                            bd = new BDSQLiteHelper(getApplicationContext());
                            for (SuperheroBancoDados superhero : lista_SuperHeroes_BD) {
                                bd.addsuperhero(superhero);
                            }
                            setaReciclerView();
                        }
                        new AlertDialog.Builder(MostrarDadosBancoActivity.this)
                                .setTitle("API conectada com Sucesso!")
                                .setMessage("Foram baixados " + new Integer(lista_SuperHeroes_API.size()).toString() + " registros.")
                                .setIcon(android.R.drawable.star_big_on)
                                .setNeutralButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int whichButton) {
                                    }
                                }).show();
                    }

                    @Override
                    public void onFailure(Call<List<SuperHero>> call, Throwable exception) {
                        exception.printStackTrace();
                        exception.printStackTrace();
                        new AlertDialog.Builder(MostrarDadosBancoActivity.this)
                                .setTitle("Sem acesso a Internet")
                                .setMessage("Não foi possível baixar dados da API. Por favor, verifique a sua conexão a internet e tente novamente.")
                                .setIcon(android.R.drawable.ic_dialog_alert)
                                .setNeutralButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int whichButton) {
                                    }
                                }).show();
                    }
                });
            }
        });
    }

    @Override
    public void onClick(View view, int position) {
        final SuperheroBancoDados sh = lista_SuperHeroes_BD.get(position);
        Intent i = new Intent(this, DetalhesSuperHeroBancoActivity.class);
        i.putExtra("ID", sh.getId());
        startActivity(i);
    }

    private void setaReciclerView() {
        SuperHeroListBancoAdapter adapter = new SuperHeroListBancoAdapter(lista_SuperHeroes_BD, R.layout.layout_superhero, getApplicationContext());
        recyclerView_superHero.setAdapter(adapter);
        adapter.setClickListener(MostrarDadosBancoActivity.this);
    }

    @Override
    public void onStart() {
        super.onStart();
        lista_SuperHeroes_BD = bd.getAllSuperheros();
        setaReciclerView();
    }

    private void alerta(EditText editText_campoDePesquisa) {
        new AlertDialog.Builder(MostrarDadosBancoActivity.this)
                .setTitle("Super Herói não encontrado!")
                .setMessage("Não foi encontrado super herói com o ID "
                        + editText_campoDePesquisa.getText().toString() + ".")
                .setIcon(android.R.drawable.btn_dialog)
                .setNeutralButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                    }
                }).show();
    }
}
