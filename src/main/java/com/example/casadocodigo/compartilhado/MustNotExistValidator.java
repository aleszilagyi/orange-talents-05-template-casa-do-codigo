package com.example.casadocodigo.compartilhado;

import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class MustNotExistValidator implements ConstraintValidator<MustNotExist, Long> {
    private Class<?> domainClass;
    private String fieldName;

    @PersistenceContext
    private EntityManager manager;

    @Override
    public void initialize(MustNotExist constraintAnnotation) {
        domainClass = constraintAnnotation.domainClass();
        fieldName = constraintAnnotation.fieldName();
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        Query query = manager.createQuery("select 1 from " + domainClass.getName() + " where " + fieldName + "=:value");
        query.setParameter("value", value);
        List<?> list = query.getResultList();
        Assert.state(list.size() <= 1, "Foi encontrado(a) mais de um(a) " + domainClass + " com o atributo " + fieldName + " = " + value);

        return list.size() != 1;
    }
}
