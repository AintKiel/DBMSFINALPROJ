public abstract class Eligibility implements EligibilityCriteria {
    protected boolean gpaCriteria;
    protected boolean ageCriteria;
    protected boolean countryCriteria;

    @Override
    public boolean meetsCountryCriteria() {
        return countryCriteria;
    }

    @Override
    public boolean meetsAgeCriteria() {
        return ageCriteria;
    }

    @Override
    public abstract boolean checkEligibility(int age, double gpaOrGrade, String country);

    protected void checkCommonCriteria(int age, String country) {
        if (country != null) {
            country = country.trim();
        }
        ageCriteria = age >= 16 && age <= 24; // Adjust as per eligibility rules
        countryCriteria = "Philippines".equalsIgnoreCase(country);
    }
}
