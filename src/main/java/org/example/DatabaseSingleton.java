package org.example;

public class DatabaseSingleton {
    private String name;
    private int creds;

    private static DatabaseSingleton instance;

    private DatabaseSingleton(String name, int creds) {
        this.name = name;
        this.creds = creds;
    }

    public static DatabaseSingleton getInstance(String name, int creds){
        if (instance == null){
            instance = new DatabaseSingleton(name, creds);
        }
        return instance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCreds() {
        return creds;
    }

    public void setCreds(int creds) {
        this.creds = creds;
    }
}
