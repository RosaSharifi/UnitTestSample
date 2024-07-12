package com.example.unittest.session5;

import com.example.unittest.session4.models.CollegeStudent;
import com.example.unittest.session4.models.StudentGrades;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class ApplicationServiceTest2 {

    @Autowired
    ApplicationContext context;

    @Autowired
    private CollegeStudent collegeStudent;

    @Autowired
    private StudentGrades studentGrades;

    @MockBean
    private ApplicationDao applicationDao;

    @Autowired
    private ApplicationService applicationService;


    @BeforeEach
    void setUp() {
        collegeStudent.setFirstname("Rosa");
        collegeStudent.setLastname("Sharifi");
        collegeStudent.setEmailAddress("rosa@gmail.com");
        collegeStudent.setStudentGrades(studentGrades);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void assertEqualsTestAddGrades() {
        when(applicationDao.addGradeResultsForSingleClass(studentGrades.getMathGradeResults())).thenReturn(100.00);

        double v = applicationService.addGradeResultsForSingleClass(collegeStudent.getStudentGrades().getMathGradeResults());

        assertEquals(100, v);

        verify(applicationDao).addGradeResultsForSingleClass(studentGrades.getMathGradeResults());
//        verify(applicationDao, times(3)).addGradeResultsForSingleClass(studentGrades.getMathGradeResults());
    }

    @Test
    public void assertEqualsTestFindGpa() {
        when(applicationDao.findGradePointAverage(studentGrades.getMathGradeResults())).thenReturn(88.31);

        double v = applicationService.findGradePointAverage(collegeStudent.getStudentGrades().getMathGradeResults());

        assertEquals(88.31, v);

        verify(applicationDao).findGradePointAverage(studentGrades.getMathGradeResults());
    }

    @Test
    public void testAssertNotNull() {
        when(applicationDao.checkNull(studentGrades.getMathGradeResults())).thenReturn(true);

        Object o = applicationService.checkNull(collegeStudent.getStudentGrades().getMathGradeResults());

        assertNotNull(o, "Object should not be null");
    }

    @Test
    public void throwAnException() {
        CollegeStudent nullStudent = (CollegeStudent) context.getBean("collegeStudent");

        when(applicationDao.checkNull(nullStudent)).thenThrow(new RuntimeException());

        assertThrows(RuntimeException.class, () -> applicationService.checkNull(nullStudent));
    }

    @Test
    public void stubbingConsecutiveCalls() {
        CollegeStudent nullStudent = (CollegeStudent) context.getBean("collegeStudent");

        when(applicationDao.checkNull(nullStudent))
                .thenThrow(new RuntimeException())
                .thenReturn("Its Ok Now");

        assertThrows(RuntimeException.class, () -> applicationService.checkNull(nullStudent));
        assertEquals("Its Ok Now", applicationService.checkNull(nullStudent));

        verify(applicationDao, times(2)).checkNull(nullStudent);
    }
}