package pdm.carlos.android.superhero.banco;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class BDSQLiteHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "SuperheroDB";
    private static final String TABELA_SUPERHEROS = "superheros";
    private static final String ID = "id";
    private static final String IDAPI = "idapi";
    private static final String NOME = "nome";
    private static final String SLUG = "slug";
    private static final String INTELIGENCIA = "inteligencia";
    private static final String FORCA = "forca";
    private static final String VELOCIDADE = "velocidade";
    private static final String DURABILIDADE = "durabilidade";
    private static final String PODER = "poder";
    private static final String COMBATE = "combate";
    private static final String SEXO = "sexo";
    private static final String RACA = "raca";
    private static final String ALTURA1 = "altura1";
    private static final String ALTURA2 = "altura2";
    private static final String PESO1 = "peso1";
    private static final String PESO2 = "peso2";
    private static final String COROLHOS = "corolhos";
    private static final String CORCABELOS = "corcabelos";
    private static final String NOMECOMPLETO = "nomecompleto";
    private static final String ALTEREGOS = "alteregos";
    private static final String APELIDOS = "apelidos";
    private static final String LOCALNASCIMENTO = "localnascimento";
    private static final String PRIMEIRAAPARICAO = "primeiraaparicao";
    private static final String EDITORA = "editora";
    private static final String ALINHAMENTO = "alinhamento";
    private static final String OCUPACAO = "ocupacao";
    private static final String BASE = "base";
    private static final String GRUPO = "grupo";
    private static final String RELATIVOS = "relativos";
    private static final String URLIMAGEM1 = "urlimagem1";
    private static final String URLIMAGEM2 = "urlimagem2";
    private static final String URLIMAGEM3 = "urlimagem3";
    private static final String URLIMAGEM4 = "urlimagem4";


    private static final String[] COLUNAS = {ID, IDAPI, NOME, SLUG, INTELIGENCIA, FORCA, VELOCIDADE, DURABILIDADE, PODER, COMBATE, SEXO, RACA, ALTURA1, ALTURA2, PESO1, PESO2,
            COROLHOS, CORCABELOS, NOMECOMPLETO, ALTEREGOS, APELIDOS, LOCALNASCIMENTO, PRIMEIRAAPARICAO, EDITORA, ALINHAMENTO, OCUPACAO, BASE, GRUPO, RELATIVOS, URLIMAGEM1, URLIMAGEM2, URLIMAGEM3, URLIMAGEM4};

    public BDSQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE superheros (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "idapi TEXT," +
                "nome TEXT," +
                "slug TEXT," +
                "inteligencia TEXT," +
                "forca TEXT," +
                "velocidade TEXT," +
                "durabilidade TEXT," +
                "poder TEXT," +
                "combate TEXT," +
                "sexo TEXT," +
                "raca TEXT," +
                "altura1 TEXT," +
                "altura2 TEXT," +
                "peso1 TEXT," +
                "peso2 TEXT," +
                "corolhos TEXT," +
                "corcabelos TEXT," +
                "nomecompleto TEXT," +
                "alteregos TEXT," +
                "apelidos TEXT," +
                "localnascimento TEXT," +
                "primeiraaparicao TEXT," +
                "editora TEXT," +
                "alinhamento TEXT," +
                "ocupacao TEXT," +
                "base TEXT," +
                "grupo TEXT," +
                "relativos TEXT," +
                "urlimagem1 TEXT," +
                "urlimagem2 TEXT," +
                "urlimagem3 TEXT," +
                "urlimagem4 TEXT)";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS superheros");
        this.onCreate(db);
    }

    public void addsuperhero(SuperheroBancoDados superhero) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(IDAPI, superhero.getIdapi());
        values.put(NOME, superhero.getNome());
        values.put(SLUG, superhero.getSlug());
        values.put(INTELIGENCIA, superhero.getInteligencia());
        values.put(FORCA, superhero.getForca());
        values.put(VELOCIDADE, superhero.getVelocidade());
        values.put(DURABILIDADE, superhero.getDurabilidade());
        values.put(PODER, superhero.getPoder());
        values.put(COMBATE, superhero.getCombate());
        values.put(SEXO, superhero.getSexo());
        values.put(RACA, superhero.getRaca());
        values.put(ALTURA1, superhero.getAltura1());
        values.put(ALTURA2, superhero.getAltura2());
        values.put(PESO1, superhero.getPeso1());
        values.put(PESO2, superhero.getPeso2());
        values.put(COROLHOS, superhero.getCorolhos());
        values.put(CORCABELOS, superhero.getCorcabelos());
        values.put(NOMECOMPLETO, superhero.getNomecompleto());
        values.put(ALTEREGOS, superhero.getAlteregos());
        values.put(APELIDOS, superhero.getApelidos());
        values.put(LOCALNASCIMENTO, superhero.getLocalnascimento());
        values.put(PRIMEIRAAPARICAO, superhero.getPrimeiraaparicao());
        values.put(EDITORA, superhero.getEditora());
        values.put(ALINHAMENTO, superhero.getAlinhamento());
        values.put(OCUPACAO, superhero.getOcupacao());
        values.put(BASE, superhero.getBase());
        values.put(GRUPO, superhero.getGrupo());
        values.put(RELATIVOS, superhero.getRelativos());
        values.put(URLIMAGEM1, superhero.getUrlimagem1());
        values.put(URLIMAGEM2, superhero.getUrlimagem2());
        values.put(URLIMAGEM3, superhero.getUrlimagem3());
        values.put(URLIMAGEM4, superhero.getUrlimagem4());


        db.insert(TABELA_SUPERHEROS, null, values);
        db.close();
    }

    public SuperheroBancoDados getsuperhero(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABELA_SUPERHEROS, // a. tabela
                COLUNAS, // b. colunas
                " id = ?", // c. colunas para comparar
                new String[]{String.valueOf(id)}, // d. parâmetros
                null, // e. group by
                null, // f. having
                null, // g. order by
                null); // h. limit
        if (cursor == null) {
            return null;
        } else {
            cursor.moveToFirst();
            SuperheroBancoDados superhero = cursorToSuperhero(cursor);
            return superhero;
        }
    }

    public SuperheroBancoDados getsuperhero(String umIDAPI) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABELA_SUPERHEROS, // a. tabela
                COLUNAS, // b. colunas
                " idapi = ?", // c. colunas para comparar
                new String[]{umIDAPI}, // d. parâmetros
                null, // e. group by
                null, // f. having
                null, // g. order by
                null); // h. limit
        if (cursor == null) {
            return null;
        } else {
            cursor.moveToFirst();
            SuperheroBancoDados superhero = cursorToSuperhero(cursor);
            return superhero;
        }
    }

    private SuperheroBancoDados cursorToSuperhero(Cursor cursor) {
        SuperheroBancoDados superhero = new SuperheroBancoDados();

        superhero.setId(Integer.parseInt(cursor.getString(0)));
        superhero.setIdapi(cursor.getString(1));
        superhero.setNome(cursor.getString(2));
        superhero.setSlug(cursor.getString(3));
        superhero.setInteligencia(cursor.getString(4));
        superhero.setForca(cursor.getString(5));
        superhero.setVelocidade(cursor.getString(6));
        superhero.setDurabilidade(cursor.getString(7));
        superhero.setPoder(cursor.getString(8));
        superhero.setCombate(cursor.getString(9));
        superhero.setSexo(cursor.getString(10));
        superhero.setRaca(cursor.getString(11));
        superhero.setAltura1(cursor.getString(12));
        superhero.setAltura2(cursor.getString(13));
        superhero.setPeso1(cursor.getString(14));
        superhero.setPeso2(cursor.getString(15));
        superhero.setCorolhos(cursor.getString(16));
        superhero.setCorcabelos(cursor.getString(17));
        superhero.setNomecompleto(cursor.getString(18));
        superhero.setAlteregos(cursor.getString(19));
        superhero.setApelidos(cursor.getString(20));
        superhero.setLocalnascimento(cursor.getString(21));
        superhero.setPrimeiraaparicao(cursor.getString(22));
        superhero.setEditora(cursor.getString(23));
        superhero.setAlinhamento(cursor.getString(24));
        superhero.setOcupacao(cursor.getString(25));
        superhero.setBase(cursor.getString(26));
        superhero.setGrupo(cursor.getString(27));
        superhero.setRelativos(cursor.getString(28));
        superhero.setUrlimagem1(cursor.getString(29));
        superhero.setUrlimagem2(cursor.getString(30));
        superhero.setUrlimagem3(cursor.getString(31));
        superhero.setUrlimagem4(cursor.getString(32));

        return superhero;
    }


    public ArrayList<SuperheroBancoDados> getAllSuperheros() {
        ArrayList<SuperheroBancoDados> listaSuperheros = new ArrayList<SuperheroBancoDados>();
        String query = "SELECT * FROM " + TABELA_SUPERHEROS + " ORDER BY " + ID;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                SuperheroBancoDados superhero = cursorToSuperhero(cursor);
                listaSuperheros.add(superhero);
            } while (cursor.moveToNext());
        }
        return listaSuperheros;
    }

    public int updateSuperhero(SuperheroBancoDados superhero) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(IDAPI, superhero.getIdapi());
        values.put(NOME, superhero.getNome());
        values.put(SLUG, superhero.getSlug());
        values.put(INTELIGENCIA, superhero.getInteligencia());
        values.put(FORCA, superhero.getForca());
        values.put(VELOCIDADE, superhero.getVelocidade());
        values.put(DURABILIDADE, superhero.getDurabilidade());
        values.put(PODER, superhero.getPoder());
        values.put(COMBATE, superhero.getCombate());
        values.put(SEXO, superhero.getSexo());
        values.put(RACA, superhero.getRaca());
        values.put(ALTURA1, superhero.getAltura1());
        values.put(ALTURA2, superhero.getAltura2());
        values.put(PESO1, superhero.getPeso1());
        values.put(PESO2, superhero.getPeso2());
        values.put(COROLHOS, superhero.getCorolhos());
        values.put(CORCABELOS, superhero.getCorcabelos());
        values.put(NOMECOMPLETO, superhero.getNomecompleto());
        values.put(ALTEREGOS, superhero.getAlteregos());
        values.put(APELIDOS, superhero.getApelidos());
        values.put(LOCALNASCIMENTO, superhero.getLocalnascimento());
        values.put(PRIMEIRAAPARICAO, superhero.getPrimeiraaparicao());
        values.put(EDITORA, superhero.getEditora());
        values.put(ALINHAMENTO, superhero.getAlinhamento());
        values.put(OCUPACAO, superhero.getOcupacao());
        values.put(BASE, superhero.getBase());
        values.put(GRUPO, superhero.getGrupo());
        values.put(RELATIVOS, superhero.getRelativos());
        values.put(URLIMAGEM1, superhero.getUrlimagem1());
        values.put(URLIMAGEM2, superhero.getUrlimagem2());
        values.put(URLIMAGEM3, superhero.getUrlimagem3());
        values.put(URLIMAGEM4, superhero.getUrlimagem4());

        int i = db.update(TABELA_SUPERHEROS, //tabela
                values, // valores
                ID + " = ?", // colunas para comparar
                new String[]{String.valueOf(superhero.getId())}); //parâmetros
        db.close();
        return i; // número de linhas modificadas
    }

    public int deleteSuperhero(SuperheroBancoDados superhero) {
        SQLiteDatabase db = this.getWritableDatabase();
        int i = db.delete(TABELA_SUPERHEROS, //tabela
                ID + " = ?", // colunas para comparar
                new String[]{String.valueOf(superhero.getId())});
        db.close();
        return i; // número de linhas excluídas
    }

    public void deleteTable() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS superheros");
        this.onCreate(db);
        db.close();
    }
}


