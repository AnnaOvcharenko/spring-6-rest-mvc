package guru.springframework.spring6restmvc.controllers;

import guru.springframework.spring6restmvc.model.BeerDTO;
import guru.springframework.spring6restmvc.services.BeerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * @author Anna Ovcharenko
 */
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {
    private final BeerService beerService;

    @PatchMapping("/{beerId}")
    public ResponseEntity patchBeer(@PathVariable("beerId") UUID id, @RequestBody BeerDTO beer) {
        log.debug("Patch beer - in controller");
        beerService.patchBeer(id, beer);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{beerId}")
    public ResponseEntity deleteBeer(@PathVariable("beerId") UUID id) {
        log.debug("Delete beer - in controller");
        beerService.deleteBeer(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{beerId}")
    public ResponseEntity updateBeer(@PathVariable("beerId") UUID id, @RequestBody BeerDTO beer) {
        log.debug("Update beer - in controller");
        BeerDTO updatedBeer = beerService.updateBeer(id, beer);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PostMapping
    public ResponseEntity addBeer(@RequestBody BeerDTO beer) {
        log.debug("Add beer - in controller");
        BeerDTO savedBeer = beerService.addBeer(beer);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/beer/" + savedBeer.getId().toString());
        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @GetMapping
    public List<BeerDTO> listBeers() {
        log.debug("List beer - in controller");
        return beerService.listBeers();
    }

    @GetMapping("/{beerId}")
    public BeerDTO getBeerById(@PathVariable("beerId") UUID id) {
        log.debug("Get Beer by ID - in controller. ID: " + id);
        return beerService.getBeerById(id).orElseThrow(NotFoundException::new);
    }
}
