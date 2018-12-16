package com.company;

public class Player {

    private String name;
    Mark playerMark;
    Mark active;

    public Player(String name, Mark playerMark, Mark active) {
        this.name = name;
        this.playerMark = playerMark;
        this.active = active;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
       this.name = name;
    }

    public Mark getPlayerMark(){
        return playerMark;
    }

    public Mark getActive(){
        return active;
    }
    public void setActive(Mark active){
        this.active = active;
    }


}
