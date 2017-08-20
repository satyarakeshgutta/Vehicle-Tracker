package io.egen.repository;

import io.egen.entity.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Repository
public class VehicleRepoImpl implements VehicleRepo {

    @PersistenceContext
    private EntityManager em1;

    @Override
    public void create(List<Vehicle> vehicle) {
            for (Vehicle v : vehicle) {
                em1.persist(v);
            }
    }

    @Override
    public void update(List<Vehicle> vehicle) {
            for (Vehicle v : vehicle) {
                em1.merge(v);
            }
    }

    @Override
    public List<Vehicle> findAll() {
        TypedQuery<Vehicle> query = em1.createNamedQuery("Vehicle.findAll", Vehicle.class);
        List<Vehicle> resultList = query.getResultList();
        if (resultList != null ) {
            return resultList;
        } else {
            return null;
        }
    }

    @Override
    public Vehicle findbyVin(String Vin) {
        TypedQuery<Vehicle> query = em1.createNamedQuery("Vehicle.findById", Vehicle.class);
        query.setParameter("vehicle_id", Vin);
        List<Vehicle> resultList = query.getResultList();

        if (resultList != null && resultList.size() == 1) {
            return resultList.get(0);
        } else {
            return null;
        }
    }
}
