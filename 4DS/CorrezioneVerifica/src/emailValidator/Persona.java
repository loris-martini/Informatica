package emailValidator;

import org.apache.commons.validator.routines.EmailValidator;

public class Persona {
    private String nome;
    private String email;

    public Persona(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) throws Exception{
        EmailValidator e =  EmailValidator.getInstance();
        if(!e.isValid(email)){
            throw new Exception("Email invalida");
        }
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
