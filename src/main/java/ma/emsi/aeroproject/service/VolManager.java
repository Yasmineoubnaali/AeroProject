package ma.emsi.aeroproject.service;

import ma.emsi.aeroproject.dao.entities.Vol;

import java.util.List;

public interface VolManager {
    Vol addVol(Vol vol);

    Vol updateVol(Vol vol);

    boolean deleteVol(Vol vol);

    boolean deleteVolByID(Integer id);
    Vol getVolById(Integer id);

    List<Vol> getAllVols();
}
