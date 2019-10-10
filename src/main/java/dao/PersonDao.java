package dao;

import domain.Person;

public class PersonDao extends GenericDao<Person, Long> {
    public PersonDao() {
        super(Person.class);
    }
}