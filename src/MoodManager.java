import java.util.ArrayList;
import java.time.LocalDate;

public class MoodManager {

    //Mood kayıtlarını tutan liste
    private ArrayList<Mood> moods = new ArrayList<>();

    // Yeni mood kaydı eklemek için method
    public void addMood(Mood mood) {
        moods.add(mood);
    }

    // 2. Bütün kayıtları getirme
    public ArrayList<Mood> getAllMoods() {
        return new ArrayList<>(moods);
    }

    // 3. Tarihe göre kayıt arama
    public ArrayList<Mood> findMoodsByDate(LocalDate date) {

        ArrayList<Mood> results = new ArrayList<>();

        for (Mood mood : moods) {

            if (mood.getDate().equals(date)) {
                results.add(mood);
            }
        }

        return results;
    }

    // 4. Belirli bir kaydın notunu güncelleme
    public boolean updateMoodNote(
            LocalDate date,
            String name,
            String newNote) {

        for (Mood mood : moods) {

            if (mood.getDate().equals(date)
                    && mood.getName().equalsIgnoreCase(name)) {

                mood.setNotes(newNote);
                return true;
            }
        }

        return false;
    }

    // 5. Belirli bir kaydı silme
    public boolean deleteMood(Mood mood) {
        return moods.remove(mood);
    }

    // 6. Toplam kayıt sayısını öğrenme
    public int getMoodCount() {
        return moods.size();
    }
}