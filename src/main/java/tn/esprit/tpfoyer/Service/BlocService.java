package tn.esprit.tpfoyer.Service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entity.Bloc;
import tn.esprit.tpfoyer.Repository.BlocRepository;
import tn.esprit.tpfoyer.Service.BlocService;

import java.util.List;
import java.util.Optional;
@Service
@AllArgsConstructor
public class BlocService implements BlocServiceI{

    private BlocRepository blocRepository;

    @Override
    public Bloc addBloc(Bloc bloc) {
        return blocRepository.save(bloc);
    }

    @Override
    public Bloc updateBloc(Bloc bloc) {
        if (blocRepository.existsById(bloc.getIdBloc())) {
            return blocRepository.save(bloc);
        }
        throw new RuntimeException("Bloc not found");
    }

    @Override
    public void deleteBloc(Long idBloc) {
        blocRepository.deleteById(idBloc);
    }

    @Override
    public Bloc getBlocById(Long idBloc) {
        Optional<Bloc> bloc = blocRepository.findById(idBloc);
        return bloc.orElseThrow(() -> new RuntimeException("Bloc not found"));
    }

    @Override
    public List<Bloc> getAllBlocs() {
        return blocRepository.findAll();
    }
}
