package by.todes.service;

import by.todes.entity.Resume;
import by.todes.service.implementation.EntitySqlBuilder;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

public class BuilderImplTest {



    @Test
    public void build() throws IllegalAccessException, SQLException, ClassNotFoundException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        Resume resume = new EntitySqlBuilder<>(new Resume()).selectQueryWithCondition()
                .equal("name", "Мария")
                .and()
                .equal("surname","Морская")
                .and()
                .equal("patronymic", "Васильевна")
                .getResult();

        print(resume.getId().toString());
        print(resume.getName());
        print(resume.getSurname());
    }

    private void print(String str){
        System.out.println(str);
    }

}