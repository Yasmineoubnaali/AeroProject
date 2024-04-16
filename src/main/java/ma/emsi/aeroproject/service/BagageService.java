package ma.emsi.aeroproject.service;

import ma.emsi.aeroproject.dao.entities.Bagage;
import ma.emsi.aeroproject.dao.repository.BagageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BagageService implements BagageManager {

    @Autowired
    BagageRepository bagageRepository;

    @Override
    public Bagage addBagage(Bagage bagage) {
        try {
            return bagageRepository.save(bagage);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return null;
        }
    }

    @Override
    public Bagage updateBagage(Bagage bagage) {
        try {
            return bagageRepository.save(bagage);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return null;
        }
    }

    @Override
    public boolean deleteBagage(Bagage bagage) {
        try {
            bagageRepository.delete(bagage);
            return true;
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return false;
        }
    }

    @Override
    public List<Bagage> getAllBagages() {
        return bagageRepository.findAll();
    }

    @Override
    public boolean deleteBagageByID(Integer id) {
        try {
            bagageRepository.deleteById(id);
            return true;
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return false;
        }
    }

    @Override
    public Bagage getBagageById(Integer id) {
        return bagageRepository.findById(id).orElse(null);
    }
}
