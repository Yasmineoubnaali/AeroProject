package ma.emsi.aeroproject.service;

import ma.emsi.aeroproject.dao.entities.Aeroport;
import ma.emsi.aeroproject.dao.repository.AeroportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AeroportService implements AeroportManager {

    @Autowired
    AeroportRepository aeroportRepository;

    @Override
    public Aeroport addAeroport(Aeroport aeroport) {
        try {
            return aeroportRepository.save(aeroport);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return null;
        }
    }

    @Override
    public Aeroport updateAeroport(Aeroport aeroport) {
        try {
            return aeroportRepository.save(aeroport);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return null;
        }
    }

    @Override
    public boolean deleteAeroport(Aeroport aeroport) {
        try {
            aeroportRepository.delete(aeroport);
            return true;
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return false;
        }
    }

    @Override
    public List<Aeroport> getAllAeroports() {
        return aeroportRepository.findAll();
    }

    @Override
    public boolean deleteAeroportByID(Integer id) {
        try {
            aeroportRepository.deleteById(id);
            return true;
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return false;
        }
    }

    @Override
    public Aeroport getAeroportById(Integer id) {
        return aeroportRepository.findById(id).orElse(null);
    }
}
