package tn.esprit.tpfoyer.Controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.Service.BlocServiceI;
import tn.esprit.tpfoyer.entity.Bloc;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/bloc")
public class BlocRestController {
    BlocServiceI blocService;
    @GetMapping("/retrieve-all-blocs")
    public List<Bloc> getBlocs() {
        List<Bloc> listBlocs = blocService.getAllBlocs();
        return listBlocs;
    }

    @GetMapping("/retrieve-bloc/{bloc-id}")
    public Bloc retrieveBloc(Long idBloc) {
        Bloc bloc = blocService.getBlocById(idBloc);
        return bloc;
    }


    @PostMapping("/add-bloc")
    public Bloc addBloc(Bloc b) {
        Bloc bloc = blocService.addBloc(b);
        return bloc;
    }

    @DeleteMapping("/remove-bloc/{bloc-id}")
    public void removeBloc(Long idBloc) {
        blocService.deleteBloc(idBloc);
    }

    @PutMapping("/modify-bloc")
    public Bloc modifyBloc(Bloc b) {
        Bloc bloc = blocService.updateBloc(b);
        return bloc;
    }
}
