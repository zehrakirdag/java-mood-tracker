import java.time.LocalDate;
import java.time.LocalTime;

public class Mood {
    private String name;
    private LocalDate date;
    private LocalTime time;
    private String notes;

    public Mood(String name, LocalDate date, LocalTime time, String notes){
        this.name = name;
        this.date = date;
        this.time = time;
        this.notes= notes;
    }

    public String getName(){
        return name;
    }

    public LocalDate getDate(){
        return date;
    }

    public LocalTime getTime(){
        return time;
    }
    
    public String getNotes(){
        return notes;
    }

    public void setNotes(String newNote){
        this.notes = newNote;
    }

    @Override
    public String toString(){
        return(name + "-" + date + "-"+ time +"-" +notes);
    }

}