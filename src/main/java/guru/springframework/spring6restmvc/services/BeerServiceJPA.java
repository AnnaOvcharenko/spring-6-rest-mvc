package guru.springframework.spring6restmvc.services;

import guru.springframework.spring6restmvc.mappers.BeerMapper;
import guru.springframework.spring6restmvc.model.BeerDTO;
import guru.springframework.spring6restmvc.repositories.BeerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author Anna Ovcharenko
 */

@Service
@RequiredArgsConstructor
@Primary
public class BeerServiceJPA implements BeerService {

    private final BeerRepository repository;
    private final BeerMapper mapper;

    @Override
    public List<BeerDTO> listBeers() {
        return null;
    }

    @Override
    public Optional<BeerDTO> getBeerById(UUID id) {
        return Optional.empty();
    }

    @Override
    public BeerDTO addBeer(BeerDTO beer) {
        return null;
    }

    @Override
    public BeerDTO updateBeer(UUID id, BeerDTO beer) {
        return null;
    }

    @Override
    public void deleteBeer(UUID id) {

    }

    @Override
    public void patchBeer(UUID id, BeerDTO beer) {

    }
}
