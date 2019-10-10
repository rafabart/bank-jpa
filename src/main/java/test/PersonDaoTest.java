package test;

import dao.PersonDao;
import domain.Person;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class PersonDaoTest {

    final PersonDao personDao = new PersonDao();

    Person person1 = new Person("111.222.333-11", "Rafael");
    Person person2 = new Person("444.555.666-77", "Marinho");
    Person person3 = new Person("888.999.111-22", "Mola");

    @Before
    public void beforeAll() {

        System.out.println("Executando testes da Classe PersonDao...");
    }

    @Test
    public void insert() {

        System.out.println("Inserindo persons -------------------------------------------");

        personDao.insert(person1);
        personDao.insert(person2);
        personDao.insert(person3);

        System.out.println("Listando todos os persons -------------------------------------------");
        List<Person> persons = personDao.findAll();
        for (Person person : persons) {
            System.out.println(person);
        }

        Assert.assertEquals(3, persons.size());
    }

    @Test
    public void list() {

        System.out.println("Listando todos os persons -------------------------------------------");

        personDao.insert(person1);
        personDao.insert(person2);
        personDao.insert(person3);

        List<Person> persons = personDao.findAll();
        for (Person person : persons) {
            System.out.println(person);
        }

        Assert.assertEquals(persons.size(), 3);
    }

    @Test
    public void findById() {

        System.out.println("Buscado person de Id 2 -------------------------------------------");

        personDao.insert(person1);
        personDao.insert(person2);

        Person person = personDao.findById(2L).get();
        System.out.println(person);

        Assert.assertEquals("Marinho", person.getName());
    }

    @Test
    public void updateById() {

        System.out.println("Alterando o nome do person de Id 3 de 'Mola' para 'Xablau'---");

        personDao.insert(person1);
        personDao.insert(person2);
        personDao.insert(person3);


        Person person = personDao.findById(3L).get();
        System.out.println("Person antes da alteração-------------------------------------------");
        System.out.println(person);

        person.setName("Xablau");
        personDao.update(person);
        person = personDao.findById(3L).get();
        System.out.println("Person alterado--------- -------------------------------------------");
        System.out.println(person);

        Assert.assertEquals("Xablau", person.getName());
    }

    @Test
    public void deleteById() {

        personDao.insert(person1);
        personDao.insert(person2);
        personDao.insert(person3);

        System.out.println("Listando todos os persons -------------------------------------------");
        List<Person> persons = personDao.findAll();
        for (Person person : persons) {
            System.out.println(person);
        }

        System.out.println("Excluido person de Id 3 ------------------------------------------");
        personDao.deleteById(3L);

        System.out.println("Listando todos os persons -------------------------------------------");
        persons = personDao.findAll();
        for (Person person : persons) {
            System.out.println(person);
        }

        Assert.assertEquals(persons.size(), 2);
    }

    @After
    public void afterAll() {

        System.out.println("Finalizando testes da Classe PersonDao...");
    }
}
