package tn.esprit.tpfoyer.Service;

import tn.esprit.tpfoyer.entity.Bloc;
import java.util.List;

public interface BlocServiceI {
    Bloc addBloc(Bloc bloc);
    Bloc updateBloc(Bloc bloc);
    void deleteBloc(Long idBloc);
    Bloc getBlocById(Long idBloc);
    List<Bloc> getAllBlocs();
}

