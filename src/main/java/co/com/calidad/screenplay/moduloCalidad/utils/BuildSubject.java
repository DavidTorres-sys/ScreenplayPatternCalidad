package co.com.calidad.screenplay.moduloCalidad.utils;

import co.com.calidad.screenplay.moduloCalidad.models.Subject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Utility class to build a Subject object.
 */
public class BuildSubject {

    /**
     * Builds a sample Subject object.
     *
     * @return a populated Subject object.
     */
    public static Subject build() {
        Subject subject = new Subject();
        subject.setId("TestId");
        subject.setName("test name");
        subject.setCredits(3);
        subject.setLevel(1);
        subject.setSummary("Test.");
        subject.setHoursWeek(5);
        subject.setArea("Engineering");
        subject.setPrerequisites(List.of("Basic Programming"));
        subject.setCorequisites(List.of("Test"));
        subject.setUsefulResources(buildUsefulResources());
        subject.setTips(List.of("Attend lectures regularly", "Start assignments early"));
        subject.setElectiva(false);
        subject.setState(true);
        subject.setVersion(1);
        return subject;
    }

    /**
     * Creates a map of useful resources for the subject.
     *
     * @return a map of useful resources.
     */
    private static Map<String, List<String>> buildUsefulResources() {
        Map<String, List<String>> resources = new HashMap<>();
        resources.put("Book", List.of("Software Engineering: A Practitioner's Approach"));
        return resources;
    }
}
