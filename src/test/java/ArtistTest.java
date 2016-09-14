import org.junit.*;
import static org.junit.Assert.*;

public class ArtistTest {

  @Test
  public void artist_instantiatesCorrectly_true() {
    Artist testArtist = new Artist("Artist");
    assertEquals(true, testArtist instanceof Artist);
  }

  @Test
  public void getName_artistInstantiatesWithName_Artist() {
  Artist testArtist = new Artist("Artist");
  assertEquals("Artist", testArtist.getName());

  }
  @Test
  public void all_returnsAllInstancesOfArtist_true() {
    Artist firstArtist = new Artist("Artist");
    Artist secondArtist = new Artist("Artist 2");
    assertEquals(true, Artist.all().contains(firstArtist));
    assertEquals(true, Artist.all().contains(secondArtist));
  }

  @Test
  public void clear_emptiesAllArtistsFromList_0() {
    Artist testArtist = new Artist("Artist");
    Artist.clear();
    assertEquals(Artist.all().size(), 0);
  }

  @Test
  public void getId_artistsInstantiateWithAnId_1() {
    Artist testArtist = new Artist("Artist");
    assertEquals(1, testArtist.getId());
  }

  @Test
  public void find_returnsArtistWithSameId_secondArtist() {
    Artist.clear();
    Artist firstArtist = new Artist("Home");
    Artist secondArtist= new Artist("Work");
    assertEquals(Artist.find(secondArtist.getId()), secondArtist);
  }

  @Test
  public void getAlbum_initiallyReturnsEmptyList_ArrayList() {
  Artist.clear();
  Artist testArtist = new Artist("Home");
  assertEquals(0, testArtist.getAlbum().size());
}
}
