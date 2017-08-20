package io.egen.repository;

import io.egen.entity.Alerts;
import io.egen.entity.Readings;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AlertsRepoImpl implements AlertsRepo{
    @PersistenceContext
    private EntityManager em;

    @Override
    public void create(Alerts alerts) {
            em.persist(alerts);
    }

    @Override
    public List<Alerts> findAlerts(){
        TypedQuery<Alerts> query = em.createNamedQuery("Alerts.findAll", Alerts.class);
        List<Alerts> resultList = query.getResultList();
        if (resultList != null ) {
            return resultList;
        } else {
            return null;
        }
    }

    @Override
    public List<Alerts> findAlertsbyId(String vid) {
        TypedQuery<Alerts> query = em.createNamedQuery("Alerts.findById", Alerts.class);
        query.setParameter("vehicle_id", vid);
        List<Alerts> resultList = query.getResultList();
        if (resultList != null ) {
            return resultList;
        } else {
            return null;
        }
    }
}
