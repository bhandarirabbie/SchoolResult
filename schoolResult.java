import java.io.*;
import java.util.Scanner;

public class schoolResult {
    public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);
            System.out.println("Select your type: 'T' for Teacher and 'S' for Student.");


            String freeInput = scanner.nextLine();
            File file = new File("/home/rabin/Desktop/StudentResultInfo.ods");
            try {
                if (freeInput.equals("T")) {
                    String wantMore;
                    do {
                        System.out.println("Enter student ID: ");
                        String studentId = scanner.nextLine();
                        System.out.println("Enter student name: ");
                        String studentName = scanner.nextLine();
                        System.out.println("Enter Subject: ");
                        String subject = scanner.nextLine();
                        System.out.println("Enter Mark: ");
                        String mark = scanner.nextLine();
                        System.out.println("Do you want to enter another student's result? Type 'Y' for Yes and 'N' for No.");
                        wantMore = scanner.nextLine();

                        PrintWriter writer;
                        FileOutputStream out = new FileOutputStream(file, true);
                        writer = new PrintWriter(out);
                        writer.append(studentId).append(",").append(studentName).append(",").append(subject).append(",").append(mark).append("\n");
                        writer.flush();
                        writer.close();

                    } while (wantMore.equals("Y"));

                } else {
                    System.out.println("Enter your Id: ");
                    String studentId = scanner.nextLine();
                    FileReader fReader = new FileReader(file);
                    BufferedReader bReader = new BufferedReader(fReader);
                    String Line;
                        do {
                            Line = bReader.readLine();
                            String currentId = Line.split(",")[0];
                                if (currentId.equals(studentId)) {
                                System.out.println("Your mark is: " + Line.split(",")[3]);
                                break;
                        }
                        }while (Line != null);
                        fReader.close();
                        bReader.close();

                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }