package co.com.calidad.screenplay.moduloCalidad.models;

import lombok.Data;
import java.util.List;
import java.util.Map;

/**
 * Represents a subject (course) in the academic system.
 * Contains details such as prerequisites, corequisites, credits, summary, useful resources, tips, and more.
 *
 * This class is used to represent the properties of a course in the system, including its resources,
 * prerequisites, and other relevant academic information.
 */
@Data
public class Subject {

    /**
     * The unique identifier for the subject.
     * Typically assigned by the system or database.
     */
    private String id;

    /**
     * The name of the subject (course).
     * For example: "Introduction to Systems Engineering".
     */
    private String name;

    /**
     * A list of prerequisites for this subject.
     * Contains the IDs or names of other subjects that must be completed before enrolling.
     */
    private List<String> prerequisites;

    /**
     * A list of corequisites for this subject.
     * Contains the IDs or names of other subjects that must be taken simultaneously.
     */
    private List<String> corequisites;

    /**
     * The number of credits awarded for completing this subject.
     * Usually determined by the number of contact hours or workload involved.
     */
    private int credits;

    /**
     * The level of the subject.
     * Typically ranges from 1 (beginner) to higher numbers (advanced courses).
     */
    private int level;

    /**
     * A brief description or summary of the subject.
     * Provides an overview of the course content and objectives.
     */
    private String summary;

    /**
     * The number of hours per week dedicated to this subject.
     * This could be a combination of lecture and lab hours.
     */
    private int hoursWeek;

    /**
     * A map of useful resources associated with the subject.
     * The key is the resource type (e.g., "Book", "article"), and the value is a list of resource descriptions or links.
     */
    private Map<String, List<String>> usefulResources;

    /**
     * A list of tips or advice related to the subject.
     * This could include study tips, exam tips, or general advice about the course.
     */
    private List<String> tips;

    /**
     * The academic area or category of the subject.
     * For example, "Mathematics", "Engineering", etc.
     */
    private String area;

    /**
     * Whether or not the subject is elective.
     * This is a Boolean value indicating whether the course is optional (true) or mandatory (false).
     * The value can also be null, meaning the information is not specified.
     */
    private Boolean electiva;

    /**
     * The state of the subject.
     * Represents whether the subject is active or not.
     * Typically used to denote whether the subject is currently offered (true) or not (false).
     */
    private Boolean state;

    /**
     * The version of the subject record.
     * Used for versioning purposes to track changes to the subject's information over time.
     */
    private int version;
}
