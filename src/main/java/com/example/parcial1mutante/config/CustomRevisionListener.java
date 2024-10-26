package com.example.parcial1mutante.config;

import com.example.parcial1mutante.Entities.audit.Revision;
import org.hibernate.envers.RevisionListener;
// Es el encargado de crear una revision cada vez que hagamos una nueva consulta
public class CustomRevisionListener implements RevisionListener {

    public void newRevision(Object revisionEntity) {final Revision revision = (Revision) revisionEntity;
    }
}
