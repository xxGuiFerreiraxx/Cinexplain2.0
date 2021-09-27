package com.example.appsorteio;

import java.io.Serializable;

public class obInternMemory implements Serializable {

    private String userName,senha;

    public obInternMemory(String userName,String senha)
    {
        this.userName = userName;
        this.senha = senha;
    }

    public String getUserName(){
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;

    }

    public String getSenha(){
        return senha;
    }

    public void setSenha(String senha)
    {
        this.senha = senha;

    }
}
