import java.util.ArrayList;
import java.util.List;

public class MusicOrg {
  private String mAlbum;
  // private String mArtist;
  private static List<MusicOrg> instances = new ArrayList<MusicOrg>();
  private int mId;

  public MusicOrg (String album) {
    mAlbum = album;
    // mArtist = artist;
    instances.add(this);
    mId = instances.size();
  }

  public String getAlbum() {
    return mAlbum;
  }

  // public String getArtist() {
  //   return mArtist;
  // }

  public int getId() {
    return mId;
  }

  public static MusicOrg find(int id) {
    return instances.get(id - 1);
  }

  public static List<MusicOrg> all() {
    return instances;
  }

  public static void clear() {
    instances.clear();
  }
}
