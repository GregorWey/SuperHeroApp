package pdm.carlos.android.superhero.banco;

import java.util.ArrayList;
import java.util.List;

import pdm.carlos.android.superhero.model.SuperHero;

public class SalvaBancoInicial {
    private List<SuperHero> superheros;
    private List<SuperheroBancoDados> meuBanco;
    private SuperheroBancoDados umSuperheroProntoParaOBanco;

    public SalvaBancoInicial() {
    }

    public SalvaBancoInicial(List<SuperHero> superHeroes) {
        this.superheros = superHeroes;
    }

    public List<SuperheroBancoDados> salvaBancoInicial2() {

        meuBanco = new ArrayList<SuperheroBancoDados>();


        for (SuperHero umSuperhero : superheros) {
            umSuperheroProntoParaOBanco = new SuperheroBancoDados();
            int id = umSuperhero.getId();
            Integer umInteiro = new Integer(id);
            String umaString = umInteiro.toString();
            umSuperheroProntoParaOBanco.setIdapi(umaString);//id que veio da api

            umaString = umSuperhero.getName();
            umSuperheroProntoParaOBanco.setNome(umaString);//nome

            umaString = umSuperhero.getSlug();
            umSuperheroProntoParaOBanco.setSlug(umaString);//slug

            umInteiro = new Integer(umSuperhero.getPowerstats().getIntelligence());
            umaString = umInteiro.toString();
            umSuperheroProntoParaOBanco.setInteligencia(umaString);//inteligencia

            umInteiro = new Integer(umSuperhero.getPowerstats().getStrength());
            umaString = umInteiro.toString();
            umSuperheroProntoParaOBanco.setForca(umaString);//forca
            //umSuperheroProntoParaOBanco.setForca("umaString");//forca

            umInteiro = new Integer(umSuperhero.getPowerstats().getSpeed());
            umaString = umInteiro.toString();
            umSuperheroProntoParaOBanco.setVelocidade(umaString);//velocidade

            umInteiro = new Integer(umSuperhero.getPowerstats().getDurability());
            umaString = umInteiro.toString();
            umSuperheroProntoParaOBanco.setDurabilidade(umaString);//durabilidade

            umInteiro = new Integer(umSuperhero.getPowerstats().getPower());
            umaString = umInteiro.toString();
            umSuperheroProntoParaOBanco.setPoder(umaString);//poder

            umInteiro = new Integer(umSuperhero.getPowerstats().getCombat());
            umaString = umInteiro.toString();
            umSuperheroProntoParaOBanco.setCombate(umaString);//combate

            umaString = umSuperhero.getAppearance().getGender();
            umSuperheroProntoParaOBanco.setSexo(umaString);//sexo

            umaString = umSuperhero.getAppearance().getRace();
            umSuperheroProntoParaOBanco.setRaca(umaString);//raça

            umaString = umSuperhero.getAppearance().getHeight().get(0);
            umSuperheroProntoParaOBanco.setAltura1(umaString);//altura 1

            umaString = umSuperhero.getAppearance().getHeight().get(1);
            umSuperheroProntoParaOBanco.setAltura1(umaString);//altura 2

            umaString = umSuperhero.getAppearance().getWeight().get(0);
            umSuperheroProntoParaOBanco.setPeso1(umaString);//peso1

            umaString = umSuperhero.getAppearance().getWeight().get(1);
            umSuperheroProntoParaOBanco.setPeso2(umaString);//peso 2

            umaString = umSuperhero.getAppearance().getEyeColor();
            umSuperheroProntoParaOBanco.setCorolhos(umaString);//cor olhos

            umaString = umSuperhero.getAppearance().getHairColor();
            umSuperheroProntoParaOBanco.setCorcabelos(umaString);//cor cabelos

            umaString = umSuperhero.getBiography().getFullName();
            umSuperheroProntoParaOBanco.setNomecompleto(umaString);//nome completo

            umaString = umSuperhero.getBiography().getAlterEgos();
            umSuperheroProntoParaOBanco.setAlteregos(umaString);//alteregos

            //junta numa unica String todas as Strings contidas no List Aliases(Apelidos)
            List aux = umSuperhero.getBiography().getAliases();
            int sizeList = aux.size();
            if (sizeList != 0) {
                umaString = (String) aux.get(0);
                sizeList--;
            }
            int contador = 1;
            while (sizeList != 0) {
                umaString = umaString + ", " + aux.get(contador);
                contador++;
                sizeList--;
            }
            umSuperheroProntoParaOBanco.setApelidos(umaString);//apelidos

            umaString = umSuperhero.getBiography().getPlaceOfBirth();
            umSuperheroProntoParaOBanco.setLocalnascimento(umaString);//localnascimento

            umaString = umSuperhero.getBiography().getFirstAppearance();
            umSuperheroProntoParaOBanco.setPrimeiraaparicao(umaString);//primeiraparicao

            umaString = umSuperhero.getBiography().getPublisher();
            umSuperheroProntoParaOBanco.setEditora(umaString);//editora

            umaString = umSuperhero.getBiography().getAlignment();
            umSuperheroProntoParaOBanco.setAlinhamento(umaString);//alinhamento

            umaString = umSuperhero.getWork().getOccupation();
            umSuperheroProntoParaOBanco.setOcupacao(umaString);//ocupacao

            umaString = umSuperhero.getWork().getBase();
            umSuperheroProntoParaOBanco.setBase(umaString);//base

            umaString = umSuperhero.getConnections().getGroupAffiliation();
            umSuperheroProntoParaOBanco.setGrupo(umaString);//grupo

            umaString = umSuperhero.getConnections().getRelatives();
            umSuperheroProntoParaOBanco.setRelativos(umaString);//relativos

            umaString = umSuperhero.getImages().getXs();
            umSuperheroProntoParaOBanco.setUrlimagem1(umaString);//imagem 1 xs super pequena

            umaString = umSuperhero.getImages().getSm();
            umSuperheroProntoParaOBanco.setUrlimagem2(umaString);

            umaString = umSuperhero.getImages().getMd();
            umSuperheroProntoParaOBanco.setUrlimagem3(umaString);

            umaString = umSuperhero.getImages().getLg();
            umSuperheroProntoParaOBanco.setUrlimagem4(umaString);//imagem 4 é a maior imagem

            meuBanco.add(umSuperheroProntoParaOBanco);
        }

        return (meuBanco);
    }
}
