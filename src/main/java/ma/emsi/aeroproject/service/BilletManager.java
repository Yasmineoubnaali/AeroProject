package ma.emsi.aeroproject.service;

import ma.emsi.aeroproject.dao.entities.Billet;

import java.util.List;

public interface BilletManager {
    Billet addBillet(Billet billet);

    Billet updateBillet(Billet billet);

    Billet getBilletById(Integer id);

    boolean deleteBillet(Billet billet);

    boolean deleteBilletByID(Integer id);

    List<Billet> getAllBillets();
}
