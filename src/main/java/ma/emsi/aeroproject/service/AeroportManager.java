package ma.emsi.aeroproject.service;

import ma.emsi.aeroproject.dao.entities.Aeroport;

import java.util.List;

public interface AeroportManager {
    Aeroport addAeroport(Aeroport aeroport);

    Aeroport updateAeroport(Aeroport aeroport);

    boolean deleteAeroport(Aeroport aeroport);

    boolean deleteAeroportByID(Integer id);

    Aeroport getAeroportById(Integer id);

    List<Aeroport> getAllAeroports();
}
