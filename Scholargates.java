import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Scholargates {
    private static int age;
    private static String firstName;
    private static String middleName;
    private static String lastName;
    private static String gender;
    private static String academicInstitution;
    private static String email;
    private static String educationLevel;
    private static String country;
    private static String pronoun;

    // Getters and Setters
    public static int getAge() {
        return age;
    }

    public static void setAge(int age) {
        Scholargates.age = age;
    }

    public static String getFirstName() {
        return firstName;
    }

    public static void setFirstName(String firstName) {
        Scholargates.firstName = firstName;
    }

    public static String getMiddleName() {
        return middleName;
    }

    public static void setMiddleName(String middleName) {
        Scholargates.middleName = middleName;
    }

    public static String getLastName() {
        return lastName;
    }

    public static void setLastName(String lastName) {
        Scholargates.lastName = lastName;
    }

    public static String getGender() {
        return gender;
    }

    public static void setGender(String gender) {
        Scholargates.gender = gender;
    }

    public static String getAcademicInstitution() {
        return academicInstitution;
    }

    public static void setAcademicInstitution(String academicInstitution) {
        Scholargates.academicInstitution = academicInstitution;
    }

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        Scholargates.email = email;
    }

    public static String getEducationLevel() {
        return educationLevel;
    }

    public static void setEducationLevel(String educationLevel) {
        Scholargates.educationLevel = educationLevel;
    }

    public static String getCountry() {
        return country;
    }

    public static void setCountry(String country) {
        Scholargates.country = country;
    }

    public static String getPronoun() {
        return pronoun;
    }

    public static void setPronoun(String pronoun) {
        Scholargates.pronoun = pronoun;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = "SCHOLARGATE";
        String spacedText = text.replaceAll("(.)", "$1 ");
        String border = "*".repeat(spacedText.length() + 4);
        String paddedText = "* " + spacedText + "*";

        String greyText = "\u001B[37m";
        String blueText = "\u001B[34m";
        String resetText = "\u001B[0m";

        System.out.println("\n\n\t   " + greyText + border + resetText);
        System.out.println("\t   " + blueText + paddedText + resetText);
        System.out.println("\t   " + greyText + border + resetText);

        System.out.println("\n\n=== Scholarship Terms and Conditions ===\n");
        displayTermsAndConditions();

        while (true) {
            System.out.print("\nDo you accept these terms? (Y/N): ");
            String agreeInput = scanner.nextLine().trim().toLowerCase();
            if (agreeInput.length() == 0) continue;
            char agree = agreeInput.charAt(0);

            switch (agree) {
                case 'y' -> System.out.println("\nThank you for accepting the terms.");
                case 'n' -> {
                    System.out.println("\nYou did not accept the terms. Application cannot proceed.");
                    scanner.close();
                    System.exit(0);
                }
                default -> {
                    System.out.println("\nInvalid input. Please enter 'Y' for yes or 'N' for no.");
                    continue;
                }
            }

            while (true) {
                System.out.println("\nWhat would you like to do?");
                System.out.println("1. Submit a new application");
                System.out.println("2. Update an existing application");
                System.out.println("3. Withdraw an application");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1 -> {
                        infoDetails(scanner);
                        eligCriteria(scanner);
                    }
                    case 2 -> updateApplication(scanner);
                    case 3 -> deleteApplication(scanner);
                    case 4 -> {
                        System.out.println("\nExiting the application. Goodbye!");
                        System.exit(0);
                    }
                    default -> {
                        System.out.println("Invalid choice. Exiting.");
                        System.exit(0);
                    }
                }
            }
        }
    }

    public static void displayTermsAndConditions() {
        System.out.println("1. Eligibility");
        System.out.println("   - Applicants must be full-time students at an accredited institution,");
        System.out.println("     meet GPA requirements, fulfill residency and must be 16 and above.\n");

        System.out.println("2. Application Requirements");
        System.out.println("   - Applications, including all required documents, must be complete and");
        System.out.println("     submitted by the deadline. By applying, applicants confirm that all");
        System.out.println("     provided information is accurate.\n");

        System.out.println("3. Selection Process");
        System.out.println("   - Recipients are selected based on academic merit (You should have 2.5 or 85% and above GWA), \nfinancial need (Not exceeding 50,000 php of monthly income), or other");
        System.out.println("     stated criteria. All committee decisions are final.\n");

        System.out.println("4. Award Conditions");
        System.out.println("   - Scholarship funds must be used for educational expenses and are non-transferable.");
        System.out.println("     Recipients must maintain the required GPA.\n");

        System.out.println("5. Fund Disbursement");
        System.out.println("   - Funds are sent directly to the institution or as specified and may be disbursed");
        System.out.println("     in installments. Failure to meet academic standards may lead to termination of funds.\n");

        System.out.println("6. Recipient Responsibilities");
        System.out.println("   - Recipients may be asked to participate in promotional activities and must report");
        System.out.println("     any changes in academic status. Misrepresentation or misconduct may lead to revocation.\n");

        System.out.println("7. Privacy");
        System.out.println("   - Applicant information is used solely for scholarship administration and protected");
        System.out.println("     in line with privacy laws.\n");

        System.out.println("8. Acceptance");
        System.out.println("   - \"I have read and understood the scholarship terms and conditions outlined in the application. ");
        System.out.println("     I agree to abide by all requirements and responsibilities associated with this scholarship, ");
        System.out.println("     including maintaining the required GPA and using the funds for educational purposes only.\"");
    }

    public static void infoDetails(Scanner scanner) {
        int educationChoice;
        String gender;
        LocalDate birthDate;

        String border = "===================================================";
        String yellow = "\u001B[33m";
        String reset = "\u001B[0m";

        System.out.println("\n" + border);
        System.out.println(yellow + "             APPLICANT'S INFORMATION           " + reset);
        System.out.println(border + "\n");

        System.out.print("Enter your first name: ");
        firstName = scanner.nextLine();

        System.out.print("Enter your middle name (or press Enter to skip): ");
        middleName = scanner.nextLine();

        System.out.print("Enter your last name: ");
        lastName = scanner.nextLine();

        while (true) {
            System.out.print("Enter your birthdate (YYYY-MM-DD): ");
            String birthDateInput = scanner.nextLine();
            try {
                birthDate = LocalDate.parse(birthDateInput, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                age = calculateAge(birthDate);
                break;
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please enter the date in YYYY-MM-DD format.");
            }
        }

        while (true) {
            System.out.print("Enter your gender (M/F): ");
            String genderInput = scanner.nextLine().trim().toLowerCase();
            gender = switch (genderInput) {
                case "m" -> {
                    pronoun = "Mr. " + firstName;
                    yield "Male";
                }
                case "f" -> {
                    pronoun = "Ms. " + firstName;
                    yield "Female";
                }
                default -> null;
            };
            if (gender != null) break;
            System.out.println("Invalid input. Please enter M or F only.");
        }

        System.out.print("Enter your nationality: ");
        String nationality = scanner.nextLine();

        System.out.print("Enter your residential country: ");
        country = scanner.nextLine();

        System.out.print("Enter your state/province: ");
        String state = scanner.nextLine();

        System.out.print("Enter your city: ");
        String city = scanner.nextLine();

        System.out.print("Enter your postal code: ");
        String postalCode = scanner.nextLine();

        System.out.print("Enter your email address: ");
        email = scanner.nextLine();

        while (true) {
            System.out.println("Select your education level:");
            System.out.println("1. Senior High School");
            System.out.println("2. College");
            System.out.print("Enter your choice (1 or 2): ");
            educationChoice = scanner.nextInt();
            scanner.nextLine();
            educationLevel = switch (educationChoice) {
                case 1 -> "Senior High School";
                case 2 -> "College";
                default -> null;
            };
            if (educationLevel != null) break;
            System.out.println("Invalid choice. Please enter 1 or 2.");
        }

        System.out.print("Enter your current academic institution: ");
        academicInstitution = scanner.nextLine();

        System.out.print("Enter your extracurricular activities (or press Enter to skip): ");
        String extracurriculars = scanner.nextLine();

        String topBorder = "=====================================================";
        String bottomBorder = "=====================================================";
        String divider = "=====================================================";

        System.out.println("\n" + topBorder);
        System.out.println(yellow + "|               APPLICANT INFORMATION               |" + reset);
        System.out.println(bottomBorder);

        System.out.println(divider);
        System.out.printf("%-25s: %s\n", "Full Name", firstName + " " + (middleName.isEmpty() ? "" : middleName + " ") + lastName);
        System.out.printf("%-25s: %d\n", "Age", age);
        System.out.printf("%-25s: %s\n", "Gender", gender);
        System.out.printf("%-25s: %s\n", "Nationality", nationality);
        System.out.printf("%-25s: %s\n", "Address", city + ", " + state + ", " + country + " - " + postalCode);
        System.out.printf("%-25s: %s\n", "Email", email);
        System.out.printf("%-25s: %s\n", "Education Level", educationLevel);
        System.out.printf("%-25s: %s\n", "Academic Institution", academicInstitution);
        System.out.printf("%-25s: %s\n", "Extracurricular Activities", extracurriculars.isEmpty() ? "None" : extracurriculars);
        System.out.println(divider);

        while (true) {
            System.out.print("\nDo you confirm that the information provided is accurate? (Y/N): ");
            char confirmation = scanner.nextLine().charAt(0);
            if (Character.toLowerCase(confirmation) == 'y') break;
            if (Character.toLowerCase(confirmation) == 'n') {
                System.out.println("Please re-enter your details carefully.");
                infoDetails(scanner);
            } else {
                System.out.println("Invalid input. Please enter Y or N.");
            }
        }

    }

    public static void eligCriteria(Scanner scanner) {
        String red = "\u001B[31m";
        String green = "\u001B[32m";
        String reset = "\u001B[0m";

        System.out.print("Enter your GPA or Grade: ");
        double gpaOrGrade = scanner.nextDouble();

        // Check eligibility based on education level
        EligibilityCriteria eligibility;
        if (educationLevel.equals("Senior High School")) {
            eligibility = new SeniorHighSchoolEligibility();
        } else {
            eligibility = new CollegeEligibility();
        }

        boolean isQualified = eligibility.checkEligibility(age, gpaOrGrade, country);
        String decision = isQualified ? "QUALIFIED" : "Not Qualified";

        if (isQualified) {
            int newSerial = DatabaseConnection.getLatestSerialNumber();

            DatabaseConnection.saveQualifier(
                    lastName, firstName, middleName,
                    educationLevel, academicInstitution, email, newSerial
            );

            String serNum = String.format("%04d", newSerial);

            String border = "====================================================";
            System.out.println("\n" + border);
            System.out.println("             " + green + "*** CONGRATULATIONS! ***" + reset);
            System.out.println(border);
            System.out.println("\nStatus: " + decision);
            System.out.println("\nApplicant Number: " + serNum);
            System.out.println("\nDear " + pronoun + ",");
            System.out.println("You have successfully met the basic eligibility criteria for the scholarship!");
            System.out.println("\nNext Steps:");
            System.out.println("1. Please check your email for further instructions.");
            System.out.println("2. You will receive details on the required documents for the next stage.");
            System.out.println("\nPrompt submission of these documents will help finalize your qualification.");
            System.out.println("We wish you the best of luck in the selection process!");
            System.out.println(border + "\n\n");
        } else {
            String border = "****************************************************";
            System.out.println("\n" + border);
            System.out.println("           " + red + "*** SORRY, NOT QUALIFIED ***" + reset);
            System.out.println(border);
            System.out.println("\nStatus: " + decision);
            System.out.println("\nUnfortunately, you do not meet the basic eligibility criteria for the scholarship.");

            if (!eligibility.meetsGpaCriteria()) {
                System.out.println("\nReason: Your grade does not meet the required threshold.");
            }
            if (!eligibility.meetsAgeCriteria()) {
                System.out.println("\nReason: You did not meet the age requirement.");
            }
            if (!eligibility.meetsCountryCriteria()) {
                System.out.println("\nReason: You must be a resident of the Philippines.");
            }
            System.out.println(border + "\n");
        }

    }

    public static void updateApplication(Scanner scanner) {
        System.out.print("\nEnter your serial number: ");
        int serialNumber = scanner.nextInt();
        scanner.nextLine();

        System.out.println("\nChoose a field to update:");
        System.out.println("1. First Name");
        System.out.println("2. Middle Name");
        System.out.println("3. Last Name");
        System.out.println("4. Gender");
        System.out.println("5. Age");
        System.out.println("6. Email");
        System.out.println("7. Academic Institution");
        System.out.println("8. Education Level");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        String field;
        switch (choice) {
            case 1 -> field = "firstName";
            case 2 -> field = "middleName";
            case 3 -> field = "lastName";
            case 4 -> field = "gender";
            case 5 -> field = "age";
            case 6 -> field = "email";
            case 7 -> field = "academicInstitution";
            case 8 -> field = "educationLevel";
            default -> {
                System.out.println("Invalid choice. Exiting.");
                return;
            }
        }

        System.out.print("\nEnter the new value: ");
        String newValue = scanner.nextLine();

        try {
            DatabaseConnection.updateQualifier(serialNumber, field, newValue);
            System.out.println("\nYour application has been updated successfully.");
        } catch (Exception e) {
            System.out.println("\nError updating the application: " + e.getMessage());
        }
    }


    public static void deleteApplication(Scanner scanner) {
        System.out.print("Enter your serial number: ");
        int serialNumber = scanner.nextInt();

        System.out.print("Are you sure you want to delete your application? (Y/N): ");
        char confirmation = scanner.next().toLowerCase().charAt(0);

        if (confirmation == 'y') {
            DatabaseConnection.deleteQualifier(serialNumber);
            System.out.println("Your application has been successfully deleted.");
        } else {
            System.out.println("Application deletion canceled.");
        }
    }

    public static int calculateAge(LocalDate birthDate) {
        return Period.between(birthDate, LocalDate.now()).getYears();
    }
}
