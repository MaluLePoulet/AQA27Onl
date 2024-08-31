package models;

import lombok.Builder;

import java.util.Objects;

@Builder(toBuilder = true)
public class TestCase {
    private String title;
    private String section;
    private String template;
    private String type;
    private String priority;
    private String preconditions;
    private String steps;
    private String expectedResults;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestCase testCase = (TestCase) o;
        return Objects.equals(title, testCase.title) && Objects.equals(section, testCase.section) && Objects.equals(template, testCase.template) && Objects.equals(type, testCase.type) && Objects.equals(priority, testCase.priority) && Objects.equals(preconditions, testCase.preconditions) && Objects.equals(steps, testCase.steps) && Objects.equals(expectedResults, testCase.expectedResults);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, section, template, type, priority, preconditions, steps, expectedResults);
    }

    public static class Director {
        public static TestCase getActualTestCase() {
            return new TestCaseBuilder()
                    .title("Test Case")
                    .section("Test Cases")
                    .template("Test Case(Steps)")
                    .type("Other")
                    .priority("Medium")
                    .preconditions("Preconditions")
                    .expectedResults("Expected results")
                    .build();
        }

        public static TestCase getExpectedTestCase() {
            return new TestCaseBuilder()
                    .title("Test Case")
                    .section("Test Cases")
                    .template("Test Case(Steps)")
                    .type("Other")
                    .priority("Medium")
                    .preconditions("Preconditions")
                    .expectedResults("Expected results")
                    .build();
        }
    }
}