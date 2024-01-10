package guru.springframework.spring6restmvc.services;

import guru.springframework.spring6restmvc.entities.Beer;
import guru.springframework.spring6restmvc.mappers.BeerMapper;
import guru.springframework.spring6restmvc.model.BeerDTO;
import guru.springframework.spring6restmvc.repositories.BeerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

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
        return repository.findAll().stream()
                .map(mapper::beerToBeerDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<BeerDTO> getBeerById(UUID id) {
        return Optional.ofNullable(mapper.beerToBeerDto(repository.findById(id).orElse(null)));
    }

    @Override
    public BeerDTO addBeer(BeerDTO beer) {
        return mapper.beerToBeerDto(repository.save(mapper.beerDtoToBeer(beer)));
    }

    @Override
    public BeerDTO updateBeer(UUID id, BeerDTO beer) {
//        Beer updated = repository.findById(id);

        return null;
    }

    @Override
    public void deleteBeer(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public void patchBeer(UUID id, BeerDTO beer) {

    }
}
