
import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class MoodTrack {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        MoodManager manager = new MoodManager();

        int choice = 0;

        DateTimeFormatter dateFormat =
                DateTimeFormatter.ofPattern("dd-MM-uuuu");

        DateTimeFormatter timeFormat =
                DateTimeFormatter.ofPattern("HH:mm");

        do {
            System.out.println("\n===== MOOD TRACKER =====");
            System.out.println("1. Add Mood");
            System.out.println("2. View All Moods");
            System.out.println("3. Search Moods by Date");
            System.out.println("4. Update Mood Note");
            System.out.println("5. Delete Mood");
            System.out.println("6. Exit");
            System.out.println("Please select a number from the menu!");

            if (!scanner.hasNextInt()) {
                System.out.println("Please enter a valid number!");
                scanner.nextLine();
                continue;
            }

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1: {
                    System.out.println("Please enter your mood:");
                    String name = scanner.nextLine();

                    System.out.println("Enter date (dd-MM-yyyy):");
                    String dateInput = scanner.nextLine();

                    System.out.println("Enter time (HH:mm):");
                    String timeInput = scanner.nextLine();

                    System.out.println("Enter your notes:");
                    String notes = scanner.nextLine();

                    try {
                        LocalDate date =
                                LocalDate.parse(dateInput, dateFormat);

                        LocalTime time =
                                LocalTime.parse(timeInput, timeFormat);

                        Mood newMood = new Mood(name, date, time, notes);

                        manager.addMood(newMood);

                        System.out.println("Mood added successfully!");

                    } catch (DateTimeParseException e) {
                        System.out.println("Invalid date or time!");
                    }

                    break;
                }

                case 2: {
                    System.out.println("===== ALL MOODS =====");

                    if (manager.getAllMoods().isEmpty()) {
                        System.out.println("No moods recorded yet!");
                    } else {
                        for (Mood mood : manager.getAllMoods()) {
                            System.out.println(mood);
                        }
                    }

                    break;
                }

                case 3: {
                    System.out.println("Enter date (dd-MM-yyyy):");
                    String dateInput = scanner.nextLine();

                    try {
                        LocalDate date =
                                LocalDate.parse(dateInput, dateFormat);

                        if (manager.findMoodsByDate(date).isEmpty()) {
                            System.out.println("No moods found!");
                        } else {
                            for (Mood mood : manager.findMoodsByDate(date)) {
                                System.out.println(mood);
                            }
                        }

                    } catch (DateTimeParseException e) {
                        System.out.println("Invalid date!");
                    }

                    break;
                }

                case 4: {
                    System.out.println("Enter date (dd-MM-yyyy):");
                    String dateInput = scanner.nextLine();

                    try {
                        LocalDate date = LocalDate.parse(dateInput, dateFormat);

                        System.out.println("Enter the mood name:");
                        String nameInput = scanner.nextLine();

                        System.out.println("Enter the new note:");
                        String newNoteInput = scanner.nextLine();

                        boolean updated = manager.updateMoodNote(
                            date, nameInput, newNoteInput
                        );

                        if (updated) {
                            System.out.println("Note updated successfully!");
                        } else {
                            System.out.println("Mood not found!");
                        }

                    } catch (DateTimeParseException e) {
                        System.out.println("Invalid date!");
                    }

                    break;
                }

                case 5: {
                System.out.println("Enter the date of the mood (dd-MM-yyyy):");
                String dateInput = scanner.nextLine();

                System.out.println("Enter the time of the mood (HH:mm):");
                String timeInput = scanner.nextLine();

                try {
                    LocalDate date = LocalDate.parse(dateInput, dateFormat);
                    LocalTime time = LocalTime.parse(timeInput, timeFormat);

                    boolean deleted = false;

                    for (Mood mood : manager.findMoodsByDate(date)) {

                        if (mood.getTime().equals(time)) {
                            deleted = manager.deleteMood(mood);
                            break;
                        }
                    }

                    if (deleted) {
                        System.out.println("Mood deleted successfully!");
                    } else {
                        System.out.println("Mood not found!");
                    }

                } catch (DateTimeParseException e) {
                    System.out.println("Invalid date or time format!");
                }

                break;
              }
                            

                case 6: {
                    System.out.println("Goodbye! Take care!");
                    break;
                }

                default: {
                    System.out.println("Invalid option! Choose 1-6.");
                    break;
                }
            }

        } while (choice != 6);

        scanner.close();
    }
}
