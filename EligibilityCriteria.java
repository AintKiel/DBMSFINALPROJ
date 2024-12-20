public interface EligibilityCriteria {
    boolean checkEligibility(int age, double gpaOrGrade, String country);
    boolean meetsAgeCriteria();
    boolean meetsCountryCriteria();
    boolean meetsGpaCriteria();
}
