package com.xworkz.StudentEnrollApp.repository;

import com.xworkz.StudentEnrollApp.entity.StudentEnrollEntity;

public interface StudentEnrollRepository {
boolean SaveToDb(StudentEnrollEntity enrollEntity);
}
