public class CollegeEligibility extends Eligibility {

    @Override
    public boolean checkEligibility(int age, double gpaOrGrade, String country) {
        checkCommonCriteria(age, country);

        // GPA criteria for college: less than or equal to 2.5
        gpaCriteria = gpaOrGrade <= 2.5;

        // All criteria must be met
        return gpaCriteria && ageCriteria && countryCriteria;
    }

    @Override
    public boolean meetsGpaCriteria() {
        return gpaCriteria;
    }
}
