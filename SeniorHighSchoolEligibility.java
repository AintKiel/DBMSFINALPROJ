public class SeniorHighSchoolEligibility extends Eligibility {

    @Override
    public boolean checkEligibility(int age, double gpaOrGrade, String country) {
        checkCommonCriteria(age, country);

        // GPA criteria for senior high school: 85 or higher
        gpaCriteria = gpaOrGrade >= 85;

        // All criteria must be met
        return gpaCriteria && ageCriteria && countryCriteria;
    }

    @Override
    public boolean meetsGpaCriteria() {
        return gpaCriteria;
    }
}
