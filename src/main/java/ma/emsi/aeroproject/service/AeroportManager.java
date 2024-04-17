package ma.emsi.aeroproject.service;

import ma.emsi.aeroproject.dao.entities.Aeroport;

import java.util.List;

public interface AeroportManager {
    Aeroport addAeroport(Aeroport aeroport);

    Aeroport updateAeroport(Aeroport aeroport);

    public boolean deleteAeroport(Aeroport aeroport);

    public boolean deleteAeroportByID(Integer id);

    Aeroport getAeroportById(Integer id);

    List<Aeroport> getAllAeroports();
}
