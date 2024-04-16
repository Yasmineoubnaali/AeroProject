package ma.emsi.aeroproject.service;

import ma.emsi.aeroproject.dao.entities.Bagage;

import java.util.List;

public interface BagageManager {
    public Bagage addBagage(Bagage bagage);

    public Bagage updateBagage(Bagage bagage);

    public boolean deleteBagage(Bagage bagage);

    public boolean deleteBagageByID(Integer id);
    public Bagage getBagageById(Integer id);

    List<Bagage> getAllBagages();
}
