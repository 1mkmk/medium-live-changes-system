package org.example.v1.configuration;
public class CredentialsConfiguration {
    private String username;
    private String password;

    public CredentialsConfiguration()
    {
        System.out.println("CredentialsConfiguration.CredentialsConfiguration()");
    }

    public String getUsername() {
        System.out.println("CredentialsConfiguration.getUsername()");
        return username;
    }

    public void setUsername(String username) {
        System.out.println("CredentialsConfiguration.setUsername()");
        this.username = username;
    }

    public String getPassword() {
        System.out.println("CredentialsConfiguration.getPassword()");
        return password;
    }

    public void setPassword(String password) {
        System.out.println("CredentialsConfiguration.setPassword()");
        this.password = password;
    }
}

