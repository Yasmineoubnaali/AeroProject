package ma.emsi.aeroproject.service;

import ma.emsi.aeroproject.dao.entities.Billet;
import ma.emsi.aeroproject.dao.repository.BilletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BilletService implements BilletManager {

    @Autowired
    BilletRepository billetRepository;

    @Override
    public Billet addBillet(Billet billet) {
        try {
            return billetRepository.save(billet);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return null;
        }
    }

    @Override
    public Billet updateBillet(Billet billet) {
        try {
            return billetRepository.save(billet);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return null;
        }
    }

    @Override
    public boolean deleteBillet(Billet billet) {
        try {
            billetRepository.delete(billet);
            return true;
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return false;
        }
    }

    @Override
    public List<Billet> getAllBillets() {
        return billetRepository.findAll();
    }

    @Override
    public boolean deleteBilletByID(Integer id) {
        try {
            billetRepository.deleteById(id);
            return true;
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return false;
        }
    }

    @Override
    public Billet getBilletById(Integer id) {
        return billetRepository.findById(id).orElse(null);
    }
}
