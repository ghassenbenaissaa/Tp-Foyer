package tn.esprit.tpfoyer.Service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.Repository.FoyerRepository;
import tn.esprit.tpfoyer.entity.Bloc;
import tn.esprit.tpfoyer.Repository.BlocRepository;
import tn.esprit.tpfoyer.Service.BlocService;
import tn.esprit.tpfoyer.entity.Foyer;

import java.util.List;
import java.util.Optional;
@Service
@AllArgsConstructor
@Slf4j
public class BlocService implements BlocServiceI{

    private BlocRepository blocRepository;
    private FoyerRepository foyerRepository;

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
    @Scheduled(fixedRate = 60000)
    /*public List<Bloc> getAllBlocs() {
        return blocRepository.findAll();
    }*/
    public List<Bloc> getAllBlocs() {
        List<Bloc> listB = blocRepository.findAll();
        for (Bloc b: listB) {
            log.info("Bloc :" + b);
        }
        return listB;
    }
    @Override
    public Bloc addBlocAndFoyerlAndAssign(Bloc bloc){
        return blocRepository.save(bloc);
    }
    @Override
    public void assignBlocToFoyer(Long BlocId, Long FoyerId) {
        Bloc Bloc = blocRepository.findById(BlocId).get();
        Foyer foyer= foyerRepository.findById(FoyerId).get();
        Bloc.setFoyer(foyer);
        blocRepository.save(Bloc);
    }
    @Override
    public void desaffecterBlocFromFoyer(Long BlocId) {
        Bloc Bloc = blocRepository.findById(BlocId).get();
        Bloc.setFoyer(null);
        blocRepository.save(Bloc);
    }
    @Override
    //@Scheduled(fixedRate = 120000)
    public List<Bloc> getAllBlocsFoyerIsNull() {
        System.out.println("Method with fixed Rate");
        return blocRepository.findByFoyerIsNull();
    }
}
