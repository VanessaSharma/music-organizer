import org.junit.*;
import static org.junit.Assert.*;

public class MusicOrgTest {

  @Test
  public void MusicOrg_instatiatesCorrectly_true() {
    MusicOrg newMusic = new MusicOrg("Album Name");
    assertEquals(true, newMusic instanceof MusicOrg);
  }

  @Test
  public void MusicOrg_instatiatesWithAlbum_String() {
    MusicOrg newMusic = new MusicOrg("Album Name");
    assertEquals("Album Name", newMusic.getAlbum());
  }

  // @Test
  // public void MusicOrg_instatiatesWithArtist_String() {
  //   MusicOrg newMusic = new MusicOrg("Album Name");
  //   assertEquals("Artist Name", newMusic.getArtist());
  // }

  @Test
  public void all_returnsAllInstancesOfMusicOrg_true() {
    MusicOrg firstAlbum = new MusicOrg("Album 1");
    MusicOrg secondAlbum = new MusicOrg("Album 2");
    assertEquals(true, MusicOrg.all().contains(firstAlbum));
    assertEquals(true, MusicOrg.all().contains(secondAlbum));
  }

  @Test
  public void clear_emptiesAllMusicOrgFromArrayList_0() {
    MusicOrg firstAlbum = new MusicOrg("Album 1");
    MusicOrg.clear();
    assertEquals(MusicOrg.all().size(), 0);
  }

  @Test
  public void getId_musicOrgInstantiateWithAnID_1() {
    MusicOrg.clear();
    MusicOrg firstAlbum = new MusicOrg("Album 1");
    assertEquals(1, firstAlbum.getId());
  }

  @Test
  public void find_returnsMusicOrgWithSameId_secondAlbum() {
    MusicOrg firstAlbum = new MusicOrg("Album 1");
    MusicOrg secondAlbum = new MusicOrg("Album 2");
    assertEquals(MusicOrg.find(secondAlbum.getId()), secondAlbum);
  }
}
