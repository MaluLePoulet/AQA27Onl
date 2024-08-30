package tests;

import lombok.val;
import models.Project;
import models.ProjectBuilder;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class LombokTest {

    @Test
    public void simpleTest() {
        Project project = new Project();
        project.setId(10);
        project.setName("Test");
        project.setProjectType(3);

        System.out.println(project.toString());
    }

    @Test
    public void equalsAndHashCodeTest() {
        Project actualProject = new Project();
        actualProject.setId(4);
        actualProject.setName("Test");
        actualProject.setProjectType(3);

        Project expectedProject = new Project();
        expectedProject.setName("Test");
        expectedProject.setProjectType(3);

        System.out.println(actualProject.hashCode());
        System.out.println(expectedProject.hashCode());

        Assert.assertTrue(actualProject.equals(expectedProject));
    }

    @Test
    public void builderTest() {
        ProjectBuilder actualProject = ProjectBuilder.builder()
                .id(10)
                .name("Test")
                .projectType(2)
                .build();

        ProjectBuilder expectedProject = ProjectBuilder.builder()
                .id(10)
                .name("Test")
                .projectType(2)
                .build();

        System.out.println(actualProject.hashCode());
        System.out.println(expectedProject.hashCode());

        Assert.assertTrue(actualProject.equals(expectedProject));
    }

    @Test
    public void valTest() {

        val list2 = new ArrayList<>(); // Transfer to final variables

        list2.add("Test Value");
        list2.add(3);

        System.out.println(list2);

    }

    @Test
    public void varTest() {
        var list2 = new ArrayList<>();  // Transfer to final variables

        list2.add("Test Value");
        list2.add(3);

        System.out.println(list2);

    }
}