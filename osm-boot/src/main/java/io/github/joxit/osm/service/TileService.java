package io.github.joxit.osm.service;

import io.github.joxit.osm.model.Tile;
import io.github.joxit.osm.utils.Svg;

import mil.nga.sf.geojson.GeoJsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Service pour retourner les tuiles.
 *
 * @author Jones Magloire @Joxit
 * @since 2019-11-03
 */
@Service
public class TileService {


  /**
   * Ici il faut prendre les coordonnées de la tuile et renvoyer la donnée PNG associée.
   * Vous pouvez y ajouter des fonctionnalités en plus pour améliorer les perfs.
   *
   * @param tile qu'il faut renvoyer
   *
   * @return le byte array au format png
   */
  public static byte[] getTile(Tile tile) {
    return Svg.getTile(tile);
  }

  /**
   * @return le contenu du fichier prefectures.geojson
   */

  public static String getPrefectures()  throws IOException {
    Resource prefectures = new ClassPathResource("prefectures.geojson");
    File file = prefectures.getFile();
    StringBuilder builder = new StringBuilder();
    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
      String line;
      while ((line = reader.readLine()) != null)
        builder.append(line);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return builder.toString();

  }
  /**
   * Il faudra créer votre DAO pour récuperer les données.
   * Utilisez ce que vous voulez pour faire le DAO.
   *
   * @return les éléments contenus dans la base de données
   */
  public GeoJsonObject getPOIs() {
    return null;
  }
}
