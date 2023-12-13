package guru.springframework.spring6restmvc.services;

import guru.springframework.spring6restmvc.model.Beer;

import java.util.List;
import java.util.UUID;

/**
 * @author Anna Ovcharenko
 */
public interface BeerService {

    List<Beer> listBeers();

    Beer getBeerById(UUID id);

    Beer addBeer(Beer beer);
}
