package ma.emsi.aeroproject.service;

import ma.emsi.aeroproject.dao.entities.Vol;
import ma.emsi.aeroproject.dao.repository.VolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VolService implements VolManager {

    @Autowired
    VolRepository volRepository;

    @Override
    public Vol addVol(Vol vol) {
        try {
            return volRepository.save(vol);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return null;
        }
    }

    @Override
    public Vol updateVol(Vol vol) {
        try {
            return volRepository.save(vol);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return null;
        }
    }

    @Override
    public boolean deleteVol(Vol vol) {
        try {
            volRepository.delete(vol);
            return true;
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return false;
        }
    }

    @Override
    public List<Vol> getAllVols() {
        return volRepository.findAll();
    }

    @Override
    public boolean deleteVolByID(Integer id) {
        try {
            volRepository.deleteById(id);
            return true;
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return false;
        }
    }
    @Override
    public Vol getVolById(Integer id) {
        return volRepository.findById(id).orElse(null);
    }
}
