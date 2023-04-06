package com.luv2code.springboot.cruddemo.dao;

import com.luv2code.springboot.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO{

    //define field for entitymanager
    private EntityManager  entityManager;

    //set up constructor injection
    @Autowired
    public EmployeeDAOJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {

        //create a query
        TypedQuery<Employee> typedQuery = entityManager.createQuery("FROM Employee ",Employee.class);

        //execute query and ggetresult list
        List<Employee> employees = typedQuery.getResultList();

        //return the result
        return employees;
    }

    @Override
    public Employee finfByID(int theId) {
        //get employee
        Employee theEmployee = entityManager.find(Employee.class,theId);

        //return employee
        return theEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {

        // save dbEmployee
        Employee dbEmployee = entityManager.merge(theEmployee); //if id ==0 save database, if id != 0 update id object

        //return dbEmployee
        return dbEmployee;
    }

    @Override
    public void deleteByID(int theId) {

        // find employee by id
        Employee theEmployee = entityManager.find(Employee.class,theId);

        // remove employee
        entityManager.remove(theEmployee);

    }
}
