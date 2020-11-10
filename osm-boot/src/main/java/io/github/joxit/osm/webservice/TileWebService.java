package io.github.joxit.osm.webservice;

import io.github.joxit.osm.model.Tile;
import io.github.joxit.osm.service.TileService;
import mil.nga.sf.geojson.GeoJsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * C'est le controlleur de l'application, il faut le déclarer comme tel et activer les CrossOrigin
 *
 * @author Jones Magloire @Joxit
 * @since 2019-11-03
 */
@RestController
@CrossOrigin
public class TileWebService {
@Autowired
 TileService Tileservice;

    /**
   * Cette méthode est le point d'entrée de l'API, il prend les requêtes au format `/{z}/{x}/{y}.png`.
   * Attetion, il doit renvoyer le header Content-Type image/png; voir les MediaType de Spring
   *
   * @param z zoom
   * @param x coordonée
   * @param y coordonée
   *
   * @return l'image au format PNG
   */
  @GetMapping("/{z}/{x}/{y}.png")
  public byte[] getTile(@PathVariable int z, @PathVariable int x, @PathVariable int y) {
    Tile t =new Tile (z,x,y,1,"png");

    return Tileservice.getTile(t);
  }

  /**
   * Cette méthode est le point d'entrée des préfectures, il prend les requêtes sur l'entrée `/prefectures.geojson`.
   * Attention, il doit renvoyer le header Content-Type application/json
   *
   * @return String representant le GeoJSON des prefectures
   */

    @GetMapping(value = "/prefectures", produces = "application/json")
    public String getPrefectures() throws IOException {
        return Tileservice.getPrefectures();
    }




  /**
   * Cette méthode est le point d'entrée de l'API POIs sous persistence, il prend les requêtes sur l'entrée `/pois.geojson`.
   * Attention, il doit renvoyer le header Content-Type application/json
   *
   * @return le geojson des POIs à renvoyer
   */

  @GetMapping("/pois.geojson")
  public GeoJsonObject getPOIs() {
    return null;
  }
}
