package boekOpdrachten.H03_Opdracht04_V1.DAO;

import java.util.List;

public interface GuestBookDao {

   public List<GuestBookBean> getGuestBookItems();
   public void addGuestBookItem(GuestBookBean item);

}