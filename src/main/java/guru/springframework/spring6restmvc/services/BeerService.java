package guru.springframework.spring6restmvc.services;

import guru.springframework.spring6restmvc.model.BeerDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author Anna Ovcharenko
 */
public interface BeerService {

    List<BeerDTO> listBeers();

    Optional<BeerDTO> getBeerById(UUID id);

    BeerDTO addBeer(BeerDTO beer);

    BeerDTO updateBeer(UUID id, BeerDTO beer);

    void deleteBeer(UUID id);

    void patchBeer(UUID id, BeerDTO beer);
}
