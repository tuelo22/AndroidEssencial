package br.com.livroandroid.carros.domain;

import java.io.Serializable;

public class Carro implements Serializable {
    private static final long serialVersionUID = 660100676683247959L;
    public long id;
    public String tipo;
    public String nome;
    public String desc;
    public String urlFoto;
    public String urlInfo;
    public String urlVideo;
    public String latitude;
    public String longitude;

    @Override
    public String toString(){
        return "Carro {" + "nome='" + nome + '\''+'}';
    }
}
