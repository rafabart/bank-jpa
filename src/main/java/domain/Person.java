package domain;

import javax.persistence.*;

@Entity
@Table(name = "person")
public class Person extends IdAbstract<Long> {

    @Column(nullable = false)
    private String cpf;

    @Column(nullable = false)
    private String name;

    public Person(String cpf, String name) {
        this.cpf = cpf;
        this.name = name;
    }

    public Person() {
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Person{");
        sb.append(super.toString()).append('\'');
        sb.append(", cpf='").append(cpf).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
