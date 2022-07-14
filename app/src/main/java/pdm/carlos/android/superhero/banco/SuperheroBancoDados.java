package pdm.carlos.android.superhero.banco;

import java.io.Serializable;

public class SuperheroBancoDados implements Serializable {

    private int id;
    private String idapi;
    private String nome;
    private String slug;
    private String inteligencia;
    private String forca;
    private String velocidade;
    private String durabilidade;
    private String poder;
    private String combate;
    private String sexo;
    private String raca;
    private String altura1;
    private String altura2;
    private String peso1;
    private String peso2;
    private String corolhos;
    private String corcabelos;
    private String nomecompleto;
    private String alteregos;
    private String apelidos;
    private String localnascimento;
    private String primeiraaparicao;
    private String editora;
    private String alinhamento;
    private String ocupacao;
    private String base;
    private String grupo;
    private String relativos;
    private String urlimagem1;
    private String urlimagem2;
    private String urlimagem3;
    private String urlimagem4;


    public SuperheroBancoDados() {
    }

    public SuperheroBancoDados(String idapi, String nome, String slug, String inteligencia, String forca, String velocidade, String durabilidade,
                               String poder, String combate, String sexo, String raca, String altura1, String altura2, String peso1, String peso2,
                               String corolhos, String corcabelos, String nomecompleto, String alteregos, String apelidos, String localnascimento,
                               String primeiraaparicao, String editora, String alinhamento, String ocupacao, String base, String grupo, String relativos,
                               String urlimagem1, String urlimagem2, String urlimagem3, String urlimagem4) {


        super();
        this.idapi = idapi;
        this.nome = nome;
        this.slug = slug;
        this.inteligencia = inteligencia;
        this.forca = forca;
        this.velocidade = velocidade;
        this.durabilidade = durabilidade;
        this.poder = poder;
        this.combate = combate;
        this.sexo = sexo;
        this.raca = raca;
        this.altura1 = altura1;
        this.altura2 = altura2;
        this.peso1 = peso1;
        this.peso2 = peso2;
        this.corolhos = corolhos;
        this.corcabelos = corcabelos;
        this.nomecompleto = nomecompleto;
        this.alteregos = alteregos;
        this.apelidos = apelidos;
        this.localnascimento = localnascimento;
        this.primeiraaparicao = primeiraaparicao;
        this.editora = editora;
        this.alinhamento = alinhamento;
        this.ocupacao = ocupacao;
        this.base = base;
        this.grupo = grupo;
        this.relativos = relativos;
        this.urlimagem1 = urlimagem1;
        this.urlimagem2 = urlimagem2;
        this.urlimagem3 = urlimagem3;
        this.urlimagem4 = urlimagem4;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdapi() {
        return idapi;
    }

    public void setIdapi(String idapi) {
        this.idapi = idapi;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getInteligencia() {
        return inteligencia;
    }

    public void setInteligencia(String inteligencia) {
        this.inteligencia = inteligencia;
    }

    public String getForca() {
        return forca;
    }

    public void setForca(String forca) {
        this.forca = forca;
    }

    public String getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(String velocidade) {
        this.velocidade = velocidade;
    }

    public String getDurabilidade() {
        return durabilidade;
    }

    public void setDurabilidade(String durabilidade) {
        this.durabilidade = durabilidade;
    }

    public String getPoder() {
        return poder;
    }

    public void setPoder(String poder) {
        this.poder = poder;
    }

    public String getCombate() {
        return combate;
    }

    public void setCombate(String combate) {
        this.combate = combate;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getAltura1() {
        return altura1;
    }

    public void setAltura1(String altura1) {
        this.altura1 = altura1;
    }

    public String getAltura2() {
        return altura2;
    }

    public void setAltura2(String altura2) {
        this.altura2 = altura2;
    }

    public String getPeso1() {
        return peso1;
    }

    public void setPeso1(String peso1) {
        this.peso1 = peso1;
    }

    public String getPeso2() {
        return peso2;
    }

    public void setPeso2(String peso2) {
        this.peso2 = peso2;
    }

    public String getCorolhos() {
        return corolhos;
    }

    public void setCorolhos(String corolhos) {
        this.corolhos = corolhos;
    }

    public String getCorcabelos() {
        return corcabelos;
    }

    public void setCorcabelos(String corcabelos) {
        this.corcabelos = corcabelos;
    }

    public String getNomecompleto() {
        return nomecompleto;
    }

    public void setNomecompleto(String nomecompleto) {
        this.nomecompleto = nomecompleto;
    }

    public String getAlteregos() {
        return alteregos;
    }

    public void setAlteregos(String alteregos) {
        this.alteregos = alteregos;
    }

    public String getApelidos() {
        return apelidos;
    }

    public void setApelidos(String apelidos) {
        this.apelidos = apelidos;
    }

    public String getLocalnascimento() {
        return localnascimento;
    }

    public void setLocalnascimento(String localnascimento) {
        this.localnascimento = localnascimento;
    }

    public String getPrimeiraaparicao() {
        return primeiraaparicao;
    }

    public void setPrimeiraaparicao(String primeiraaparicao) {
        this.primeiraaparicao = primeiraaparicao;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getAlinhamento() {
        return alinhamento;
    }

    public void setAlinhamento(String alinhamento) {
        this.alinhamento = alinhamento;
    }

    public String getOcupacao() {
        return ocupacao;
    }

    public void setOcupacao(String ocupacao) {
        this.ocupacao = ocupacao;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getRelativos() {
        return relativos;
    }

    public void setRelativos(String relativos) {
        this.relativos = relativos;
    }

    public String getUrlimagem1() {
        return urlimagem1;
    }

    public void setUrlimagem1(String urlimagem1) {
        this.urlimagem1 = urlimagem1;
    }

    public String getUrlimagem2() {
        return urlimagem2;
    }

    public void setUrlimagem2(String urlimagem2) {
        this.urlimagem2 = urlimagem2;
    }

    public String getUrlimagem3() {
        return urlimagem3;
    }

    public void setUrlimagem3(String urlimagem3) {
        this.urlimagem3 = urlimagem3;
    }

    public String getUrlimagem4() {
        return urlimagem4;
    }

    public void setUrlimagem4(String urlimagem4) {
        this.urlimagem4 = urlimagem4;
    }
}

